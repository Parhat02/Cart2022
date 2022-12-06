package com.java.tutorial.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginAutomation {
    public static void main(String[] args) throws InterruptedException{
        String userName1="admin";
        String password="MaharaDemo";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.mahara.org/");
        WebElement userName= driver.findElement(By.id("login_login_username"));
        userName.sendKeys(userName1);
        driver.findElement(By.id("login_login_password")).sendKeys(password);
        WebElement loginButton= driver.findElement(By.id("login_submit"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement search=driver.findElement(By.name("query"));
        WebElement about= driver.findElement(By.id("messages"));
        if (search.isDisplayed())
            System.out.println("Login passed");
        else
            System.out.println("Login failed");
        driver.close();
        driver.quit();
    }
}
