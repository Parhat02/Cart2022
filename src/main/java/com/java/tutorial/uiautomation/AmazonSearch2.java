package com.java.tutorial.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearch2 {
    public static void main(String[] args) throws InterruptedException{
        List<String> products=new ArrayList<String>();
        products.add("java tutorial");
        products.add("Iphone14");
        products.add("iphone14 case");
        products.add("11234567899990");
        products.add("airpods");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();

        for (String product:products){
            driver.get("https://www.amazon.com/");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
            driver.findElement(By.cssSelector("input[value='Go']")).click();
            WebElement searchResult= driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
            if (searchResult.isDisplayed()){
                System.out.println("Test Passed");
                String text= searchResult.getText();
                System.out.println("Search result : "+text+" "+product);
            }
            else {
                System.out.println("Test failed!");
            }
            //driver.navigate().back();
            Thread.sleep(3000);
            driver.switchTo().newWindow(WindowType.TAB);
        }
        driver.close();
        Thread.sleep(5000);
        driver.quit();
    }
}
