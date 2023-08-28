package com.selenium.integration.databasetest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class DatabaseTestRunner {
    static String dbUrl="132.148.43.243";
    static String dbPort="3306";
    static String username="testautomation";
    static String password="automation123!";
    static String defaultDatabase="i4296639_cc3";
    Connection connection=null;

    @BeforeClass
    public void setUp(){
        connection=ConnectionManager.connectToDatabaseServer(dbUrl,dbPort,defaultDatabase,
                username,password,ConnectionType.MYSQLServer);
    }
    @Test (description = "CubeCart inventory table should have expected products")
    public void verifyProductTest(){
        DataAccess dataAccess=new DataAccess();
        boolean isProductFound = dataAccess.getProduct("apple", connection);
        Assert.assertTrue(isProductFound);
    }
    @Test
    public void verifyCustomerTest(){
        DataAccess dataAccess=new DataAccess();
        boolean isCustomerFound = dataAccess.getCustomer("arslan@gmail.com102", connection);
        Assert.assertTrue(isCustomerFound);
    }
    @AfterClass
    public void tearDown(){
        ConnectionManager.closeDatabaseConnection(connection);
    }
}
