package com.selenium.integration.cucumber;

import com.java.tutorial.configutility.ApplicationConfig;
import com.selenium.integration.pageobjectpattern.DashBoardPage;
import com.selenium.integration.pageobjectpattern.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cubecart-cucumber"},features = {"classpath:features/"}, //classpath:features
        tags = "@ApiTest"
)
public class CucumberTestRunner {
    final static String configFile="config.properties";
    final static String qaUrl= ApplicationConfig.readConfigProperties(configFile,"qaUrl");
    static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
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

    @AfterClass
    public static void tearDown(){
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.logout();
        driver.close();
        driver.quit();
    }
}
