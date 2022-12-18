package com.selenium.integration.testframework;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo1 {
    @BeforeClass
    public void setUp(){
        System.out.println("The method in Before Class in TestNG runs only once before test");
    }
    @BeforeMethod
    public void printTestInfo(){
        System.out.println("In testNG Before method runs before every test");
    }
    @Test(description = "add product test",groups = {"Smoke", "Regression"},priority = 1)
    public void addProductTest(){
        System.out.println("This is a test for adding a product");
        Assert.assertTrue("Add product".contains("product"));
    }
    @Test(description = "category link test",groups = "Smoke",priority = 2)
    public void verifyCategoryLinkTest(){
        System.out.println("This is for category link verification");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(description = "verify inventory link test",groups = "Regression",priority = 3)
    public void verifyInventoryLinkTest() {
        System.out.println("This is a test for inventory link verification");
        Assert.assertTrue("Link".length() > 3);
    }
    @AfterMethod
    public void printTestInfoAfter(){
        System.out.println("In testNG this method runs after each test");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("After Class in testNG runs after all tests are completed");
    }
}
