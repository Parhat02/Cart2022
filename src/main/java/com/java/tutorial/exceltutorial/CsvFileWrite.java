package com.java.tutorial.exceltutorial;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CsvFileWrite {
    public static void main(String[] args) {
        StringBuilder testResult=new StringBuilder();
        testResult.append("TestID, TestModule, TestType, TestResult\n");
        testResult.append("1, Login, Regression, Pass\n");
        testResult.append("2, Logout, Regression, Fail");
        File csvFile=new File("docs"+File.separator+"test_result.csv");
        try {
            FileUtils.writeStringToFile(csvFile,testResult.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
