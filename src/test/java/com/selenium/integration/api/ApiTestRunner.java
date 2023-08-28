package com.selenium.integration.api;

import com.java.tutorial.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTestRunner {
    private static String baseurl;
    private static int port;
    private static String username;
    private static String password;
    private static String configFile="config.properties";

    @BeforeClass
    public void setUp(){
        baseurl= ApplicationConfig.readConfigProperties(configFile,"api.baseurl");
        port=Integer.parseInt(ApplicationConfig.readConfigProperties(configFile,"api.port"));
        username=ApplicationConfig.readConfigProperties(configFile,"api.username");
        password=ApplicationConfig.readConfigProperties(configFile,"api.password");
    }
    @Test
    public void getAllCustomers(){
        ApiRequestHandler apiRequestHandler=new ApiRequestHandler();
        ApiResponseHandler apiResponseHandler= apiRequestHandler.getAllCustomer(username,password,baseurl,port,"Customers");
        Assert.assertTrue(apiResponseHandler.getResponseCode()==200);
    }
}
