package com.java.tutorial.configutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    //write a method to read a specific key value pair from config file
    public static String readConfigProperties(String filename, String key){
        Properties properties=new Properties();
        String value;
        String workingDir=System.getProperty("user.dir");
        //read config file
        try {
            properties.load(new FileInputStream(workingDir+ File.separator+filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        value=properties.getProperty(key);
        System.out.println(key+"="+value);
        return value;
    }
}
