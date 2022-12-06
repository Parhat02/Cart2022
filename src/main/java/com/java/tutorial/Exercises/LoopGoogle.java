package com.java.tutorial.Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoopGoogle {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        for (int i=0;i<3;i++){
            Thread.sleep(1000);
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            //driver.navigate().back();
        }
        driver.close();

    }
}
