package com.selenium.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.selenium.annotation.LazyComponent;

import io.qameta.allure.Allure;

@LazyComponent
public class ScreenshotUtil {
    @Autowired
    private ApplicationContext ctx;

    public void takeScreenShot(String testName) throws IOException {
        byte[] bytes = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
        
        Allure.addAttachment(testName, new ByteArrayInputStream(bytes));
    }

    public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
