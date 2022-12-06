package com.java.tutorial.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StopWatchDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<String,String> sites=new HashMap<String,String>();
        sites.put("Yahoo","https://www.yahoo.com/");
        sites.put("Google", "https://www.google.com/");
        sites.put("YouTube", "https://www.youtube.com/");
        sites.put("CNN", "https://www.cnn.com");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        Set<String> webSites=sites.keySet();
        for (String site:webSites){
            StopWatch watch=new StopWatch();
            watch.start();
            driver.get(sites.get(site));
            if (driver.getTitle().contains(site)){
                watch.stop();
                System.out.println(site+" opened in "+watch.getTime(TimeUnit.MICROSECONDS));
            }
            Thread.sleep(3000);
            driver.switchTo().newWindow(WindowType.TAB);
        }
        driver.close();
        Thread.sleep(5000);
        driver.quit();

    }
}
