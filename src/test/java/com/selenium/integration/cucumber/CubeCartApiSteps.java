package com.selenium.integration.cucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.tutorial.configutility.ApplicationConfig;
import com.selenium.integration.api.CustomerPayload;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class CubeCartApiSteps {
    Scenario scenario;
    String configFile="config.properties";
    String userName;
    String password;
    String baseUrl;
    int port;
    String payload;
    @Before
    public void beforeStepInCucumber(Scenario scenario){
        this.scenario=scenario;
        userName= ApplicationConfig.readConfigProperties(configFile, "api.username");
        password= ApplicationConfig.readConfigProperties(configFile, "api.password");

    }

    @Given("a valid username and password")
    public void aValidUsernameAndPassword() {
        scenario.log("UserName: "+userName);
        scenario.log("Password: "+password);
    }

    @When("the user sends a get request to the customer end point")
    public void theUserSendsAGetRequestToTheCustomerEndPoint() {
        baseUrl=ApplicationConfig.readConfigProperties(configFile,"api.baseurl");
        port=Integer.parseInt(ApplicationConfig.readConfigProperties(configFile,"api.port"));
        Response response= RestAssured.given().auth().basic(userName,password).when().get(baseUrl+":"+port+"/customers");
        System.out.println(response.getBody().prettyPrint());
        ApiResponseHolder.setCustomerResponseCode(response.getStatusCode());
        ApiResponseHolder.setTotalCustomers(response.jsonPath().getList("id").size());
    }

    @Then("the api should return {int} response code")
    public void theApiShouldReturnResponseCode(int arg0) {
        arg0=200;
        Assert.assertTrue(ApiResponseHolder.getCustomerResponseCode()==arg0);
    }

    @And("the api should return more than one customer")
    public void theApiShouldReturnMoreThanOneCustomer() {
        Assert.assertTrue(ApiResponseHolder.getTotalCustomers()>1);
    }

    @When("the user sends a get request to the product end point")
    public void theUserSendsAGetRequestToTheProductEndPoint() {
        baseUrl=ApplicationConfig.readConfigProperties(configFile,"api.baseurl");
        port=Integer.parseInt(ApplicationConfig.readConfigProperties(configFile,"api.port"));
        Response response= RestAssured.given().auth().basic(userName,password).when().get(baseUrl+":"+port+"/products");
        System.out.println(response.getBody().prettyPrint());
        ApiResponseHolder.setProductResponseCode(response.getStatusCode());
        ApiResponseHolder.setTotalProducts(response.jsonPath().getList("id").size());
    }
    @And("the api should return more than one product")
    public void theApiShouldReturnMoreThanOneProduct() {
        Assert.assertTrue(ApiResponseHolder.getTotalProducts()>1);
    }
    @Given("{string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void andAndAndAndAndAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
        CustomerPayload customerPayload=new CustomerPayload(arg0,arg1,arg2,arg3,arg4,arg5,Integer.valueOf(arg6),arg7,arg8,Integer.valueOf(arg9));
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload= objectMapper.writeValueAsString(customerPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        scenario.log(payload);
    }

    @When("the user sends  post request to the customer endpoint with payload")
    public void theUserSendsPostRequestToTheCustomerEndpointWithPayload() {
        baseUrl=ApplicationConfig.readConfigProperties(configFile,"api.baseurl");
        port=Integer.parseInt(ApplicationConfig.readConfigProperties(configFile,"api.port"));
        Response response=RestAssured.given().headers("Content-Type","application/json").and().body(payload).auth().basic(userName,password).
                when().post(baseUrl+":"+port+"/customer").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        ApiResponseHolder.setNewCustomerId(response.jsonPath().getInt("id"));
        ApiResponseHolder.setAddCustomerResponseCode(response.getStatusCode());
        scenario.log(String.valueOf(response.jsonPath().getInt("id")));
    }

    @Then("the api should return {int} response code and create a new customer")
    public void theApiShouldReturnResponseCodeAndCreateANewCustomer(int arg0) {
        arg0=200;
        Assert.assertTrue(ApiResponseHolder.getAddCustomerResponseCode()==arg0);
        Assert.assertTrue(ApiResponseHolder.getNewCustomerId()>1);
    }


}
