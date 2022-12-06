package com.java.tutorial.automationproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void loginSite(String username, String password){
        driver.get("https://demo.mahara.org/");
        driver.findElement(By.id("login_login_username")).sendKeys(username);
        driver.findElement(By.id("login_login_password")).sendKeys(password);
        driver.findElement(By.id("login_submit")).click();
    }
}
