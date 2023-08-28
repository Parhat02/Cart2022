package com.selenium.integration.testframework;

import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomResultListener extends TestListenerAdapter {
    static List<ITestNGMethod> passedTests=new ArrayList<>();
    static List<ITestNGMethod> failedTests=new ArrayList<>();
    static List<ITestNGMethod> skippedTests=new ArrayList<>();

    public void onTestSuccess(ITestResult result){
        passedTests.add(result.getMethod());
        ScreenShotUtility screenShot=new ScreenShotUtility();
        screenShot.takeScreenShot(result.getMethod().getMethodName()+"Passed",
                (WebDriver)result.getTestContext().getAttribute("driver"));
    }
    public void onTestFailure(ITestResult result){
        failedTests.add(result.getMethod());
        ScreenShotUtility screenShot=new ScreenShotUtility();
        screenShot.takeScreenShot(result.getMethod().getMethodName()+"Failed",
                (WebDriver)result.getTestContext().getAttribute("driver"));
    }
    public void onTestSkipped(ITestResult result){
        skippedTests.add(result.getMethod());
    }
}
