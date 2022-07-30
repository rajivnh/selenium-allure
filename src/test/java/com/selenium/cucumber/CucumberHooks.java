package com.selenium.cucumber;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import com.selenium.annotation.LazyAutowired;
import com.selenium.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    @LazyAutowired
    ApplicationContext applicationContext;

    @LazyAutowired
    ScreenshotUtil screenshotUtil;
    
    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
        	screenshotUtil.takeScreenShot("Failed - " + scenario.getName());
        }
    }
    
    @After
    public void afterScenario() {
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
