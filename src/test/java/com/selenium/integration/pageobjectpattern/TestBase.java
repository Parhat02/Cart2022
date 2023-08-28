package com.selenium.integration.pageobjectpattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public WebDriver driver;
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://cubecartuat.unitedcoderschool.com/admin_wehelc.php");
    }
    public void setUpBrowserInHeadlessMode(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200,1100");
        options.addArguments("disable-gpu");
        driver=new ChromeDriver(options);
        driver.get("http://cubecartuat.unitedcoderschool.com/admin_wehelc.php");
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
