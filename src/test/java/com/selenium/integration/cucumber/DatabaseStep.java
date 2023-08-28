package com.selenium.integration.cucumber;

import com.selenium.integration.databasetest.ConnectionManager;
import com.selenium.integration.databasetest.ConnectionType;
import com.selenium.integration.databasetest.DataAccess;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;

public class DatabaseStep {
    static String dbUrl="132.148.43.243";
    static String dbPort="3306";
    static String username="testautomation";
    static String password="automation123!";
    static String defaultDatabase="i4296639_cc3";
    Connection connection=null;
    boolean isProductExist=false;
    long currentTime=0;
    private Scenario scenario=null;
    @Given("a user has read access to the cc_CubeCart_inventory table")
    public void aUserHasReadAccessToTheCc_CubeCart_inventoryTable() {
        connection= ConnectionManager.connectToDatabaseServer(dbUrl,dbPort,defaultDatabase,
                username,password, ConnectionType.MYSQLServer);
    }

    @When("the user query the cc_CubeCart_inventory table")
    public void theUserQueryTheCc_CubeCart_inventoryTable() {
        DataAccess dataAccess=new DataAccess();
        String productToSearch="Airpods";
        isProductExist= dataAccess.getProduct(productToSearch,connection);
    }

    @Then("the user should see the product info")
    public void theUserShouldSeeTheProductInfo() {
        Assert.assertTrue(isProductExist);
    }
}
