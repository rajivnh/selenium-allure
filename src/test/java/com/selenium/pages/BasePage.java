package com.selenium.pages;

import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.selenium.utils.JSWaiter;

import lombok.SneakyThrows;

public abstract class BasePage {
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected JavascriptExecutor javascriptExecutor;
    
    @Autowired
    JSWaiter jsWaiter;
    
    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
        
        jsWaiter.setDriver();
    }
    
    public <T> void waitElement(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
        }
    }

    public <T> void waitElements(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) elementAttr));
        }
    }

    public <T> void click(T elementAttr) {
        waitElement(elementAttr);
        
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    public void jsClick(By by) {
        javascriptExecutor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
        
        jsWaiter.waitAllRequest();
    }

    public <T> void writeText(T elementAttr, String text) {
        waitElement(elementAttr);
        
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttr));
            
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
            
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    @SneakyThrows
    public <T> String readText(T elementAttr) {
    	waitElement(elementAttr);
    	
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    public void handlePopup(By by) throws InterruptedException {
        waitElements(by);
        
        List<WebElement> popup = driver.findElements(by);
        
        if (!popup.isEmpty()) {
            popup.get(0).click();
            
            Thread.sleep(200);
        }
    }
}
