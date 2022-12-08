package com.selenium.integration.cubecartjunit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FunctionLibrary {
    WebDriver driver;
    int waitTime=30;

    public FunctionLibrary(WebDriver driver) {
        this.driver = driver;
    }
    //explicit wait
    public void waitUntilElementVisible(WebElement webElement){
        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    //sleep
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
