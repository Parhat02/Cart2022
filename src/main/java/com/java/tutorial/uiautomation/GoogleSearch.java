package com.java.tutorial.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        for (String word:args){
            driver.get("https://www.google.com/");
            WebElement searchBox= driver.findElement(By.name("q"));
            searchBox.sendKeys(word + Keys.ENTER);
            try {
                WebElement result= driver.findElement(By.id("result-stats"));
                String text=result.getText();
                System.out.println("Result Displayed :" + result.isDisplayed());
                System.out.println("Result is : "+text);
            }
            catch(Exception result){
                WebElement searchBox1= driver.findElement(By.name("q"));
                searchBox1.sendKeys(Keys.ENTER);
                WebElement result1= driver.findElement(By.id("result-stats"));
                String text1=result1.getText();
                System.out.println("Result Displayed :" + result1.isDisplayed());
                System.out.println("Result is : "+text1);
            }

            Thread.sleep(3000);
            //driver.navigate().back();
            driver.switchTo().newWindow(WindowType.TAB);
        }
        driver.close();
        //driver.quit();
    }
}
