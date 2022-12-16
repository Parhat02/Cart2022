package com.selenium.integration.pageobjectpattern;

import com.java.tutorial.configutility.ApplicationConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitTestRunner {
    static WebDriver driver;
    final static String configFile="config.properties";
    final static String qaUrl= ApplicationConfig.readConfigProperties(configFile,"qaUrl");

    @BeforeClass
    public static void setUp(){
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

    @Test
    public void addProductTest(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.clickProductLink();
        ProductPage productPage=new ProductPage(driver);
        Assert.assertTrue(productPage.addNewProduct("Apple"+System.currentTimeMillis(),"New"));
    }
    @Test
    public void deleteProductTest(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.clickProductLink();
        ProductPage productPage=new ProductPage(driver);
        Assert.assertTrue(productPage.deleteTopProduct());
    }
    @Test
    public void addCategoryTest(){
        CategoryPage categoryPage=new CategoryPage(driver);
        Assert.assertTrue(categoryPage.addNewCategory("Imac"+System.currentTimeMillis()));
    }

    @Test
    public void deleteTopCategoryTest(){
        CategoryPage categoryPage=new CategoryPage(driver);
        Assert.assertTrue(categoryPage.deleteTopCategory());
    }

    @Test
    public void verifyAllLinks(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        Assert.assertTrue(dashBoardPage.verifyNavigationLinks());
    }
    @AfterClass
    public static void tearDown(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.logout();
        driver.close();
        driver.quit();
    }
}
