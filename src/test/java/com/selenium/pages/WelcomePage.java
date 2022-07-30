package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import com.selenium.annotation.LazyComponent;

import lombok.SneakyThrows;

@LazyComponent
public class WelcomePage extends BasePage {
    
    public WelcomePage verifyWelcomePageWithXPath(String expectedText) {                
        String actualText = readText(By.xpath("//a[@class='adddoctab tab tabhighlight']"));
        
        assertThat(expectedText).isEqualTo(actualText);
        
        return this;
    }
    
    @SneakyThrows
    public WelcomePage clickMenu(String linkText) {
        jsClick(By.linkText(linkText));
        
        Thread.sleep(2000);
        
        return this;
    }
}
