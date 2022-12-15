package com.selenium.integration.pageobjectpattern;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FunctionPage {
    WebDriver driver;
    public FunctionPage(WebDriver driver){
        this.driver=driver;
    }
    //wait until element is present
    public void waitUntilElementPresent(WebElement element,int timeout){
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    //add sleep time
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitUntilAlertIsPresent(int timeout){
        try {
            WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
            webDriverWait.until(ExpectedConditions.alertIsPresent());
        }catch (NoAlertPresentException e){
            System.out.println("No Alert Displayed");
        }
    }
}
