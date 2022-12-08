package com.selenium.integration.cubecartjunit;

import com.google.errorprone.annotations.InlineMeValidationDisabled;
import com.java.tutorial.configutility.ApplicationConfig;
import com.selenium.integration.cubecartjunit.FunctionLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JUnitCubeCartFramework {
    static WebDriver driver;
    static String configFile="config.properties";
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(ApplicationConfig.readConfigProperties(configFile,"qaUrl"));
        //login
        String userName= ApplicationConfig.readConfigProperties(configFile,"username");
        String password= ApplicationConfig.readConfigProperties(configFile,"password");
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        WebElement dashBoard= driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
        FunctionLibrary functionLibrary=new FunctionLibrary(driver);
        functionLibrary.waitUntilElementVisible(dashBoard);
        if(dashBoard.isDisplayed()){
            System.out.println("Login successfully");
        }else{
            System.out.println("Login failed");
        }
    }
    @Test
    public void viewCustomerTest(){

    }
    @Test
    public void addProductTest(){

    }
    @Test
    public void addProductCategoryTest(){

    }
    @AfterClass
    public static void tearDown(){
        driver.findElement(By.linkText("Log Out")).click();
        driver.close();
        driver.quit();
    }
}