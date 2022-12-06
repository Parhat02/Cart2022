package com.java.tutorial.exceltutorial;

import com.java.tutorial.configutility.UiUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.List;

public class GoogleSearchWithCsvFile {
    public static void main(String[] args) throws InterruptedException{
        List<String> searchWords=CsvFileUtility.readCsvFile("docs"+ File.separator+"search_content.csv","search words");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        for (String word:searchWords){
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys(word+ Keys.ENTER);
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
