package com.selenium.integration.testframework;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGDemo {
//    @BeforeSuite: The annotated method will be run before all tests in this suite have run.
//    @AfterSuite: The annotated method will be run after all tests in this suite have run.
//    @BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
//    @AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
//    @BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.
//    @AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.
//    @BeforeClass: The annotated method will be run before the first test method in the current class is invoked.
//    @AfterClass: The annotated method will be run after all the test methods in the current class have been run.
//    @BeforeMethod: The annotated method will be run before each test method.
//    @AfterMethod: The annotated method will be run after each test method

    @BeforeClass
    public void setUp(){
        System.out.println("This code runs once the test class is instantiated");
    }
    @Test(priority =1)
    public void loginTest(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        Date date=new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("This is login test");
        Assert.assertEquals(10,10);
    }
    @Test(priority = 3)
    public void logoutTest(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        Date date=new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("This is logout test");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(groups={"dummy test"},priority = 2)
    public void ATest(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        Date date=new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("This is test A");
        Assert.assertTrue(Math.sqrt(9)==3);
    }
    @Test(dependsOnGroups = "dummy test",priority = 2)
    public void BTest(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        Date date=new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("This is test B");
        Assert.assertEquals("Selenium","Selenium");
    }
    @Test(dependsOnGroups = "dummy test",priority = 1)
    public void CTest(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        Date date=new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("This is test C");
        Assert.assertTrue(Math.max(10,15)==15);
    }
    @AfterClass
    public void tearDown(){
        System.out.println("This code runs only once after all tests have been run");
    }
}
