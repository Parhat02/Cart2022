package com.selenium.integration.cucumber;

import com.selenium.integration.pageobjectpattern.DashBoardPage;
import com.selenium.integration.pageobjectpattern.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;

public class ProductStepDefinition {
    WebDriver driver=CucumberTestRunner.getDriver(); //we read the driver from the test runner (This how we link them)
    ProductPage productPage;
    DashBoardPage dashBoardPage;
    boolean isProductAdded;
    boolean isProductDeleted;
    String productName;
    @Given("admin user is on the dashboard page")
    public void adminUserIsOnTheDashboardPage() {
        dashBoardPage=new DashBoardPage(driver);
        Assert.assertTrue(dashBoardPage.isProductLinkDisplayed());
    }

    @When("the user fills out a new product form")
    public void theUserFillsOutANewProductForm() {
        dashBoardPage.clickProductLink();
        productPage=new ProductPage(driver);
        Random random=new Random();
        productName="Cucumber"+random.nextInt(1000);
        isProductAdded=productPage.addNewProduct(productName,"New");
    }

    @Then("a new product should be created")
    public void aNewProductShouldBeCreated() {
        Assert.assertTrue(isProductAdded);
    }

    @When("the user tries to delete an existing product")
    public void theUserTriesToDeleteAnExistingProduct() {
        dashBoardPage.clickProductLink();
        isProductDeleted=productPage.deleteProduct(productName);
    }

    @Then("the product should be deleted")
    public void theProductShouldBeDeleted() {
        Assert.assertTrue(isProductDeleted);
    }
}
