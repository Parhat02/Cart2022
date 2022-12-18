package com.selenium.integration.testframework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo3 {
    @Test(description = "add customer test",groups = {"add customer"})
    public void addCustomerTest(){
        System.out.println("This is a test for adding a customer");
        Assert.assertTrue("Add customer".contains("customer"));
    }
    @Test(description = "delete customer test",dependsOnGroups = {"add customer"})
    public void verifyDeleteCustomerTest(){
        System.out.println("This is for delete customer verification");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(description = "update customer test",dependsOnGroups = {"add customer"})
    public void updateCustomerTest() {
        System.out.println("This is a test for update customer verification");
        Assert.assertTrue("Link".length() > 3);
    }
}
