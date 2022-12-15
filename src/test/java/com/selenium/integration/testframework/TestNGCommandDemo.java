package com.selenium.integration.testframework;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class TestNGCommandDemo {
    public static void main(String[] args){
        TestListenerAdapter testListenerAdapter=new TestListenerAdapter();
        TestNG testNG=new TestNG();
        testNG.setTestClasses(new Class[] {TestNGDemo.class});
        testNG.addListener(testListenerAdapter);
        testNG.run();
    }
}
