package com.java.tutorial.configutility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class UiUtility {
    private int timeout=Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","timeout"));
    private WebDriver driver;

    public UiUtility(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForElementVisibility(WebElement element){
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void takeScreenShot(String filename){
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File screenShotFile=screenshot.getScreenshotAs(OutputType.FILE);
        String folder=ApplicationConfig.readConfigProperties("config.properties","imageFolder");
        File finalFile=new File(folder+File.separator+filename);
        try {
            FileUtils.copyFile(screenShotFile,finalFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
