package com.selenium.integration.advancedaction;

import com.selenium.integration.pageobjectpattern.FunctionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavascriptExecutionTest {
    WebDriver driver;
    FunctionPage functionPage;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        functionPage=new FunctionPage(driver);
    }
    @Test
    public void javascriptExecutionTest(){
        driver.get("https://jqueryui.com/");
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        String url=(String) javascriptExecutor.executeScript("window.location");
        System.out.println(url);
        for (int i=0;i<10;i++){
            javascriptExecutor.executeScript("window.scrollBy(0,100)");
            functionPage.sleep(2);
        }
        WebElement widgetLink= driver.findElement(By.linkText("Widget Factory"));
        Assert.assertTrue(widgetLink.isDisplayed());
    }
    @Test
    public void maharaTest(){
        driver.get("https://mahara.org/");
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.location");
        javascriptExecutor.executeScript("window.scrollBy(0,300)");
        functionPage.sleep(2);
        javascriptExecutor.executeScript("window.scrollBy(0,700)");
        functionPage.sleep(2);
        for (int i=0;i<5;i++){
            javascriptExecutor.executeScript("window.scrollBy(0,1000)");
            functionPage.sleep(2);
        }
        WebElement legal= driver.findElement(By.linkText("Legal"));
        functionPage.waitUntilElementPresent(legal,30);
        legal.click();
        String urlName=driver.getCurrentUrl();
        System.out.println(urlName);
        WebElement legalHeading= driver.findElement(By.cssSelector(".section-heading"));
        String text=legalHeading.getText();
        System.out.println(text);
        Assert.assertTrue(legalHeading.isDisplayed());
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
