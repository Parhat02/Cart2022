package com.java.tutorial.classtutorial;

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

public class GoogleSearch3 {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        List<SearchWord> searchWords=new ArrayList<>();
        SearchWord word1=new SearchWord();
        word1.setWord("New York");
        SearchWord word2=new SearchWord();
        word2.setWord("Washington DC");
        SearchWord word3=new SearchWord();
        word3.setWord("Istanbul");
        SearchWord word4=new SearchWord();
        word4.setWord("Amsterdam");
        searchWords.addAll(Arrays.asList(word1,word2,word3,word4));

        for (SearchWord word:searchWords){
            System.out.println("Searching word: "+word.getWord());
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys(word.getWord()+ Keys.ENTER);
            try {
                WebElement searchResult= driver.findElement(By.id("result-stats"));
                System.out.println("Result displayed? : " + searchResult.isDisplayed());
            }catch (Exception result){
                driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
                WebElement searchResult= driver.findElement(By.id("result-stats"));
                System.out.println("Result displayed? : " + searchResult.isDisplayed());
            }
            Thread.sleep(2000);
        }
        driver.close();
        driver.quit();
    }
}
