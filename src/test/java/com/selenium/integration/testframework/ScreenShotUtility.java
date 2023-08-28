package com.selenium.integration.testframework;

import com.java.tutorial.configutility.ApplicationConfig;
import com.selenium.integration.pageobjectpattern.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility {
    public void takeScreenShot(String filename, WebDriver driver){
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File screenShotFile=screenshot.getScreenshotAs(OutputType.FILE);
        //File imageFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String folder= ApplicationConfig.readConfigProperties("config.properties","imageFolder");
        File finalFile=new File(folder+File.separator+filename+".png");
        try {
            FileUtils.copyFile(screenShotFile,finalFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
