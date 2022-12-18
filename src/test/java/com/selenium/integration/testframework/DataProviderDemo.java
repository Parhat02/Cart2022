package com.selenium.integration.testframework;

import com.selenium.integration.pageobjectpattern.DashBoardPage;
import com.selenium.integration.pageobjectpattern.LoginPage;
import com.selenium.integration.pageobjectpattern.TestBase;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo extends TestBase{

    @BeforeClass
    public void setUp(){
        setUpBrowser();
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password){
        LoginPage loginPage=new LoginPage(driver);
        Assert.assertTrue(loginPage.multiLogin(username, password));
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
    @DataProvider
    public Object[][] loginData() {
        Object[][] data = new Object[][]{
                {"testautomation1", "automation123!"},
               {"testautomation2", "automation123!"}
        };
        return data;
    }
}
