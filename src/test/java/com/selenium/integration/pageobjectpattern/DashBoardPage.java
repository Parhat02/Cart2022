package com.selenium.integration.pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage {
    int timeout=30;
    WebDriver driver;
    @FindBy(id="nav_products")
    WebElement productLink;
    @FindBy(linkText="Customer List")
    WebElement customerListLink;
    @FindBy(linkText="Log Out")
    WebElement signOutLink;

    @FindAll(
            {@FindBy(xpath = "//div[@id='navigation']//a")}
    )
    List<WebElement> allNavigationLinks;
    FunctionPage functionPage;
    //create a constructor to initialize the page
    public DashBoardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        functionPage=new FunctionPage(driver);
    }
    //define actions
    public boolean isProductLinkDisplayed(){
        functionPage.waitUntilElementPresent(productLink,timeout);
        return productLink.isDisplayed();
    }
    public void clickProductLink(){
        functionPage.waitUntilElementPresent(productLink,timeout);
        productLink.click();
    }
    public void clickCustomerListLink(){
        functionPage.waitUntilElementPresent(customerListLink, timeout);
        customerListLink.click();
    }
    public void logout(){
        functionPage.waitUntilElementPresent(signOutLink,timeout);
        signOutLink.click();
    }
    public boolean verifyNavigationLinks(){
        int totalLinks= allNavigationLinks.size();
        System.out.println("Total navigation links: "+totalLinks);
        if (totalLinks>=1){
            for (WebElement eachLink:allNavigationLinks){
                System.out.println(eachLink.getText());
            }
            return true;
        }else
            return false;
    }

}
