package com.java.tutorial.automationproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //we will define common function to use
    //dynamic wait, implicit wait, explicit wait, fluent wait
    //sleep

    WebDriver driver;
    int waitTime=30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    //explicit wait
    public void waitUntilElementVisible(WebElement webElement){
        WebDriverWait driverWait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
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
