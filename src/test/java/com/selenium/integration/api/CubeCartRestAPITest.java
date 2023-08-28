package com.selenium.integration.api;

import com.java.tutorial.configutility.ApplicationConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeCartRestAPITest {
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
    @Test(description = "Authorized user should be able to get all customers")
    public void getAllCustomersTest(){
        //send request -- get response
        Response response= RestAssured.given().auth().basic(username,password).when().get(baseurl+":"+port+"/customers");
        System.out.println(response.getBody().prettyPrint());
        int statusCode= response.statusCode();
        Assert.assertTrue(statusCode==200);
    }
    @Test(description = "Authorized user should be able to get all products")
    public void getAllProductsTest(){
        //send request -- get response
        Response response= RestAssured.given().auth().basic(username,password).when().get(baseurl+":"+port+"/products");
        System.out.println(response.getBody().prettyPrint());
        int statusCode= response.statusCode();
        Assert.assertTrue(statusCode==200);
    }
    @Test(description = "Authorized user should be able to add customer")
    public void addCustomerTest(){
        Response response=RestAssured.given().header("Content-Type","application/json")
                .and().body(PayLoadUtility.getCustomerPayLoad()).auth().basic(username,password)
                .when().post(baseurl+":"+port+"/customer").then().extract().response();
        //check the response code and respond body
        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.jsonPath().getString("firstName").contains("Abdullah"));
    }
    @Test(description = "Authorized user should be able to update a customer")
    public void updateCustomerTest(){

    }
}
