package com.selenium.integration.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    int timeout=30;
    WebDriver driver;
    @FindBy(id="username")
    WebElement usernameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login")
    WebElement loginButton;

    FunctionPage functionPage;
    //create constructor to initialize the page
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    //define action
    public void enterUsername(String username){
        functionPage.waitUntilElementPresent(usernameField,timeout);
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password){
        functionPage.waitUntilElementPresent(passwordField,timeout);
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        functionPage.waitUntilElementPresent(loginButton,timeout);
        loginButton.click();
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    public boolean multiLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        boolean verifyLogin=dashBoardPage.isProductLinkDisplayed();
        dashBoardPage.logout();
        return verifyLogin;
    }
}
