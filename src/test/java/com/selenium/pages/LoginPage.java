package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import com.selenium.annotation.LazyComponent;
import com.selenium.annotation.TakeScreenshot;

import lombok.SneakyThrows;

@LazyComponent
public class LoginPage extends BasePage {
    @Value("${selenium.base.url}")
    private String baseURL;
    
    @SneakyThrows
    public LoginPage goToLoginPage() {
		Thread.sleep(2000);
                
        jsClick(By.linkText("Login"));
        
        return this;
    }
    
    @SneakyThrows
    public LoginPage login(String emailId, String password) {
        writeText(By.name("email"), emailId);
        writeText(By.name("password"), password);
        
		Thread.sleep(2000);
                
        jsClick(By.className("submit"));
        
        return this;
    }
    
    @SneakyThrows
    @TakeScreenshot
    public LoginPage iVerifyInvalidLoginMessage(String expectedText) {
        String actualText = readText(By.xpath("(//p[normalize-space()='Invalid login'])[1]"));
        
        assertThat(expectedText).isEqualTo(actualText);
        
        Thread.sleep(3000);
        
        return this;
    }
    
    @SneakyThrows
    @TakeScreenshot
    public LoginPage iVerifyValidLoginMessage(String expectedText) {
        String actualText = readText(By.xpath("(//span[@class='user-display'])[1]"));
        
        assertThat(expectedText).isEqualTo(actualText);
        
        Thread.sleep(3000);
        
        return this;
    }
}
