package com.selenium.integration.pageobjectpattern;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    int timeout=30;
    WebDriver driver;
    @FindBy(id="nav_categories")
    WebElement categoriesLink;
    @FindBy(linkText="Add Category")
    WebElement addCategoryLink;
    @FindBy(xpath="//img[@rel='#status']")
    WebElement status;
    @FindBy(xpath="//img[@rel=\"#visible\"]")
    WebElement visible;
    @FindBy(id="name")
    WebElement categoryName;
    @FindBy(id="cat_save")
    WebElement saveButton;
    @FindBy(css="div.success")
    WebElement confirmationMessage;
    @FindBy(xpath="//div[@id='categories']/table/tbody/tr/td/a/i[@class='fa fa-trash']")
    WebElement deleteIcon;

    FunctionPage functionPage;
    public CategoryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        functionPage=new FunctionPage(driver);
    }
    public void clickCategoriesLink(){
        functionPage.waitUntilElementPresent(categoriesLink, timeout);
        categoriesLink.click();
    }
    public void clickCategoryLink(){
        functionPage.waitUntilElementPresent(addCategoryLink, timeout);
        addCategoryLink.click();
    }
    public void checkStatus(){
        functionPage.waitUntilElementPresent(status, timeout);
        status.click();
    }
    public void checkVisible(){
        functionPage.waitUntilElementPresent(visible, timeout);
        visible.click();
    }
    public void enterCategoryName(String name){
        functionPage.waitUntilElementPresent(categoryName, timeout);
        categoryName.sendKeys(name);
    }
    public void clickSave(){
        functionPage.waitUntilElementPresent(saveButton, timeout);
        saveButton.click();
    }
    public boolean verifyNewCategory(){
        functionPage.waitUntilElementPresent(confirmationMessage, timeout);
        return confirmationMessage.isDisplayed();
    }
    public boolean deleteTopCategory(){
        clickCategoriesLink();
        functionPage.waitUntilElementPresent(deleteIcon, timeout);
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
    public boolean addNewCategory(String categoryName){
        clickCategoriesLink();
        clickCategoryLink();
        checkStatus();
        checkVisible();
        enterCategoryName(categoryName);
        clickSave();
        return verifyNewCategory();
    }
}
