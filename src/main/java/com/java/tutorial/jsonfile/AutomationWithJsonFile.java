package com.java.tutorial.jsonfile;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutomationWithJsonFile {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");
        //define TestResult object
        TestResult testResult=new TestResult();
        //getting the start time
//        String testStartTime=new Date().toString();
//        testResult.setTestStartTime(testStartTime);
        testResult.setTestStartTime(TestHelper.getToday()+" "+TestHelper.getCurrentTime());
        testResult.setTestExecutedBy(TestHelper.getCurrentUser());

        ObjectMapper objectMapper = new ObjectMapper();
        LoginUser loginUser= null;
        try {
            loginUser = objectMapper.readValue(new File("docs//usersdata.json"), LoginUser.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //define a list to collect test result from every single test
        List<TestResultObject> testResultObjects=new ArrayList<>();

        List<User> users=loginUser.getUsers();
        for (User user:users){
            if (user.isActive()){
                TestResultObject testResultObject=new TestResultObject();
                testResultObject.setTestModule("Login");;
                testResultObject.setTestName("Login");
                testResultObject.setTestDate(TestHelper.getToday());
                testResultObject.setTestTime(TestHelper.getCurrentTime());

                driver.findElement(By.id("username")).sendKeys(user.getUsername());
                driver.findElement(By.id("password")).sendKeys(user.getPassword());
                driver.findElement(By.id("login")).click();
                WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
                if (dashBoard.isDisplayed()) {
                    System.out.println("Logged in successfully");
                    testResultObject.setTestStatus(true);
                } else {
                    System.out.println("Login failed");
                    testResultObject.setTestStatus(false);
                }
                driver.findElement(By.cssSelector("i.fa.fa-sign-out")).click();
                testResultObjects.add(testResultObject);//add single test result to list
            }
        }
        driver.close();
        driver.quit();
        testResult.setTestEndTime(new Date().toString());
        testResult.setTestResultObjects(testResultObjects);
        try {
            objectMapper.writeValue(new File("docs\\login-suite.json"),testResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
