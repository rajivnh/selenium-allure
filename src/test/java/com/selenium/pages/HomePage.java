package com.selenium.pages;

import org.springframework.beans.factory.annotation.Value;

import com.selenium.annotation.LazyComponent;

@LazyComponent
public class HomePage extends BasePage {
    @Value("${selenium.base.url}")
    private String baseURL;

    public HomePage goToHomePage() {
        driver.get(baseURL);
        
        return this;
    }
}
