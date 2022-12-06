package com.java.tutorial.jsonfile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultUtility {
    public static void main(String[] args) {
        TestResultObject test1=new TestResultObject("Login","Login","2020-08-22",
                "10:14 AM",true);
        TestResultObject test2=new TestResultObject("Inventory","Add product","2020-08-14",
                "10:15 AM",true);
        List<TestResultObject> testResultObjects=new ArrayList<>();
        testResultObjects.add(test1);
        testResultObjects.add(test2);
        TestResult testResult=new TestResult(testResultObjects,"10:14 AM","10:17 AM",
                "Selenium Master");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            objectMapper.writeValue(new File("docs\\result.json"),testResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
