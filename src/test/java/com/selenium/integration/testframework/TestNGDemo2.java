package com.selenium.integration.testframework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    @Test(description = "add product test",invocationCount = 3,enabled = false)
    public void addProductTest(){
        System.out.println("This is a test for adding a product");
        Assert.assertTrue("Add product".contains("product"));
    }
    @Test(description = "category link test",invocationCount = 2)
    public void verifyCategoryLinkTest(){
        System.out.println("This is for category link verification");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(description = "verify inventory link test",invocationCount = 3)
    public void verifyInventoryLinkTest() {
        System.out.println("This is a test for inventory link verification");
        Assert.assertTrue("Link".length() > 3);
    }
}
