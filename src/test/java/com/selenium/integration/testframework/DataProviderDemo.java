package com.selenium.integration.testframework;

import com.selenium.integration.pageobjectpattern.LoginPage;
import com.selenium.integration.pageobjectpattern.TestBase;
import org.junit.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(CustomResultListener.class)
public class DataProviderDemo extends TestBase{
    @BeforeClass
    public void setUp(ITestContext context){

        setUpBrowser();
        context.setAttribute("driver", driver);
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password){
        LoginPage loginPage=new LoginPage(driver);
        Assert.assertTrue(loginPage.multiLogin(username, password));
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
        System.out.println("Total passed : "+CustomResultListener.passedTests.size());
        System.out.println("Total failed : "+CustomResultListener.failedTests.size());
        System.out.println("Total ignored : "+CustomResultListener.skippedTests.size());
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
