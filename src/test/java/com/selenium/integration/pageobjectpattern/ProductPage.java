package com.selenium.integration.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    int timeout=30;
    WebDriver driver;
    @FindBy(linkText="Add Product")
    WebElement addProductLink;
    @FindBy(id="name")
    WebElement productNameFiled;
    @FindBy(id="condition")
    WebElement productConditionSelect;
    @FindBy(xpath="//input[@value='Save']")
    WebElement saveButton;
    @FindBy(css="div.success")
    WebElement confirmationMessage;
    FunctionPage functionPage;
    //create a constructor ro initialize the page
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        functionPage=new FunctionPage(driver);
    }
    //define actions
    public void clickAddProduct(){
        functionPage.waitUntilElementPresent(addProductLink,timeout);
        addProductLink.click();
    }
    public void enterProductName(String productName){
        functionPage.waitUntilElementPresent(productNameFiled,timeout);
        productNameFiled.sendKeys(productName);
    }
    public void selectProductCondition(String condition){
        functionPage.waitUntilElementPresent(productConditionSelect,timeout);
        Select productCondition=new Select(productConditionSelect);
        productCondition.selectByVisibleText(condition);
    }
    public void clickSaveButton(){
        saveButton.click();
    }
    public boolean isConfirmationDisplayed(){
        functionPage.waitUntilElementPresent(confirmationMessage,timeout);
        return confirmationMessage.isDisplayed();
    }
    public  boolean addNewProduct(String productName, String condition){
        clickAddProduct();
        enterProductName(productName);
        selectProductCondition(condition);
        clickSaveButton();
        return isConfirmationDisplayed();
    }

}
