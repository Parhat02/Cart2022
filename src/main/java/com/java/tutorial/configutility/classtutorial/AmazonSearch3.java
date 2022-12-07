package com.java.tutorial.configutility.classtutorial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonSearch3 {
    public static void main(String[] args) throws InterruptedException{
        List<Product> products=new ArrayList<>();
        Product product1=new Product();
        product1.setName("Iphone 14");
        product1.setColor("Red");
        Product product2=new Product();
        product2.setName("Ipad pro");
        product2.setColor("White");
        Product product3=new Product();
        product3.setName("Samsung Galaxy");
        product3.setColor("Silver");
        products.addAll(Arrays.asList(product1,product2,product3));
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        int resultCount=0;
        for (Product product:products){
            driver.get("https://www.amazon.com/");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product.getName()+" "+product.getColor() + Keys.ENTER);
            WebElement searchResult= driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

            if (searchResult.isDisplayed()){
                resultCount++;
            }
            driver.navigate().back();
            Thread.sleep(2000);
        }
        if (products.size()==resultCount)
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
        driver.close();
        driver.quit();
    }
}
