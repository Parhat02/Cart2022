package com.java.tutorial.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDemo4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();

        try{
            driver.navigate().to(new URL("https://demo.mahara.org/"));
        }catch (MalformedURLException e){
            e.printStackTrace();
        }finally {
            System.out.println("This is for verifying links on the site");
        }
        //find all links on the site
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        int totalLink=allLinks.size();
        System.out.println("Total links: "+totalLink);
        List<String> urls=new ArrayList<>();
        for (WebElement link:allLinks){
            System.out.println(link.getText());
            String url=link.getAttribute("href");//get url from the link
            System.out.println(url);
            urls.add(url);
        }
        //open each link and verify
        for (String url:urls){
            System.out.println("Current url: "+url);
            if (url!=null){
                driver.navigate().to(url);
            }
            Thread.sleep(2000);
        }
        driver.close();
        driver.quit();
    }
}
