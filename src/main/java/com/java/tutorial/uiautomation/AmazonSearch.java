package com.java.tutorial.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) throws InterruptedException {
        //define driver--chromedriver
        WebDriverManager.chromedriver().setup();
        //define chrome driver object
        WebDriver driver=new ChromeDriver();
        //open amazon home page
        driver.get("https://www.google.com/");
        //driver.navigate().to("https://www.amazon.com/");
        //set browser size
        driver.manage().window().maximize();
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("AirPods"+ Keys.ENTER);
        WebElement resultStatus= driver.findElement(By.id("result-stats"));
        System.out.println("Result status displayed :" + resultStatus.isDisplayed());
        String resultText=resultStatus.getText();
        System.out.println(resultText);
        Thread.sleep(5000);
        driver.close();
    }
}
