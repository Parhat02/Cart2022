package com.java.tutorial.uiautomation;

import com.java.tutorial.configutility.UiUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearch2 {
    public static void main(String[] args) throws InterruptedException{
        String[] searchWords=new String[]{"Paris","london","Urumqi","Aksu", "Tokyo", "istanbul"};
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        UiUtility uiUtility=new UiUtility(driver);
        for (String word:searchWords){
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys(word+ Keys.ENTER);
            uiUtility.takeScreenShot(word+".png");
            try {
                WebElement result= driver.findElement(By.id("result-stats"));
                String text=result.getText();
                System.out.println("Result is displayed :" + result.isDisplayed());
                System.out.println("Result is : "+text);
            }catch (Exception result){
                System.out.println("Test failed once");
                driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
                WebElement result1= driver.findElement(By.id("result-stats"));
                String text1=result1.getText();
                System.out.println("Result is displayed :" +result1.isDisplayed());
                System.out.println("Result os : "+text1);
            }
            //Thread.sleep(2000);
            //driver.navigate().back();
            driver.switchTo().newWindow(WindowType.TAB);
        }
        driver.close();
        Thread.sleep(5000);
        //driver.quit();
    }
}
