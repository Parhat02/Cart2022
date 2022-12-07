package com.java.tutorial.configutility.classtutorial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleMultiThreadSearch implements Runnable{
    private String keyWord;

    public GoogleMultiThreadSearch(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public void run() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(keyWord+ Keys.ENTER);
        WebElement searchResult= driver.findElement(By.id("result-stats"));
        System.out.println("Result displayed for key word? : "+keyWord+ ": " + searchResult.isDisplayed());
        String resultText= searchResult.getText();
        System.out.println(resultText);
        int endPosition=resultText.indexOf("(");
        resultText=resultText.substring(0,endPosition-1);
        System.out.println(resultText);
        long searchCounts=Long.parseLong(resultText.replaceAll("[^0-9]",""));
        if (searchCounts>10000){
            System.out.println("Search count: "+searchCounts);
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.close();
        driver.quit();
    }
}
