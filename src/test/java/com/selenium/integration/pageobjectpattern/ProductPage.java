package com.selenium.integration.pageobjectpattern;

import org.openqa.selenium.*;
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
    @FindBy(xpath = "//div[@id=\"general\"]/table/tbody/tr/td/a/i[@class=\"fa fa-trash\"]")
    WebElement deleteIcon;
    @FindBy(linkText = "View All")
    WebElement viewAllLink;
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
    public boolean deleteTopProduct(){
        deleteIcon.click();
        functionPage.waitUntilAlertIsPresent(timeout);
        try {
            Alert alert=driver.switchTo().alert();
            alert.accept();
        }catch (NoAlertPresentException e){
            System.out.println(e.getMessage());
        }
        WebElement deleteConfirmation= driver.findElement(By.cssSelector("div.success"));
        functionPage.waitUntilElementPresent(deleteConfirmation, timeout);
        String confirmationMessage= deleteConfirmation.getText();
        return confirmationMessage.contains("deleted");
    }
    public boolean deleteProduct(String productName){
        functionPage.waitUntilElementPresent(viewAllLink, timeout);
        viewAllLink.click();
        String productXpathToDelete=String.format("//tr/td/a[text()=\"%s\"]/following::td/a/i[@class=\"fa fa-trash\"]",productName);
        WebElement productToDelete= driver.findElement(By.xpath(productXpathToDelete));
        productToDelete.click();
        functionPage.waitUntilAlertIsPresent(timeout);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement deleteConfirmation= driver.findElement(By.cssSelector("div.success"));
        functionPage.waitUntilElementPresent(deleteConfirmation, timeout);
        String confirmationMessage= deleteConfirmation.getText();
        return confirmationMessage.contains("deleted");
    }
}
