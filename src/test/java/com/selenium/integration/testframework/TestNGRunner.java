package com.selenium.integration.testframework;

import com.java.tutorial.configutility.ApplicationConfig;
import com.selenium.integration.pageobjectpattern.CategoryPage;
import com.selenium.integration.pageobjectpattern.DashBoardPage;
import com.selenium.integration.pageobjectpattern.LoginPage;
import com.selenium.integration.pageobjectpattern.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class TestNGRunner {
    WebDriver driver;
    final String configFile="config.properties";
    final String qaUrl= ApplicationConfig.readConfigProperties(configFile,"qaUrl");
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        //open the testing site
        driver.get(qaUrl);
        LoginPage loginPage=new LoginPage(driver);
        String userName= ApplicationConfig.readConfigProperties(configFile,"username");
        String password= ApplicationConfig.readConfigProperties(configFile,"password");
        loginPage.login(userName,password);
    }
    @Test(description = "admin user should be able to add a product",groups ="add product")
    public void addProductTest(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.clickProductLink();
        ProductPage productPage=new ProductPage(driver);
        Random random=new Random();
        Assert.assertTrue(productPage.addNewProduct("Book"+random.nextInt(1000),"New"));
    }
    @Test(description = "admin user should be able to delete a product",dependsOnGroups = "add product")
    public void deleteProductTest(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.clickProductLink();
        ProductPage productPage=new ProductPage(driver);
        Assert.assertTrue(productPage.deleteTopProduct());
    }
    @Test(description = "admin user should be able to add a category",groups = "add category")
    public void addCategoryTest(){
        CategoryPage categoryPage=new CategoryPage(driver);
        Random random=new Random();
        Assert.assertTrue(categoryPage.addNewCategory("Books"+random.nextInt(1000)));
    }
    @Test(description = "admin user should be able to view customers",dependsOnGroups = "add category")
    public void deleteCategoryTest(){
        CategoryPage categoryPage=new CategoryPage(driver);
        Assert.assertTrue(categoryPage.deleteTopCategory());
    }
    @AfterClass
    public void tearDown(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.logout();
        driver.close();
        driver.quit();
    }
}
