package com.java.tutorial.configutility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        String url;
        String configFile="config.properties";
        if(Integer.parseInt(ApplicationConfig.readConfigProperties(configFile,"qa"))==1){
            url=ApplicationConfig.readConfigProperties(configFile,"qaUrl");
        }else
            url=ApplicationConfig.readConfigProperties(configFile,"prodUrl");

        driver.get(url);

        String username=ApplicationConfig.readConfigProperties(configFile,"username");
        String password=ApplicationConfig.readConfigProperties(configFile,"password");
        UiUtility uiUtility=new UiUtility(driver);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        uiUtility.takeScreenShot("dashboard.png");
        WebElement logout=driver.findElement(By.linkText("Log Out"));
        uiUtility.waitForElementVisibility(logout);
        logout.click();
        uiUtility.takeScreenShot("loginpage.png");

    }
}
