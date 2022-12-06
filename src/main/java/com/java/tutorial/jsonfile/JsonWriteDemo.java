package com.java.tutorial.jsonfile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JsonWriteDemo {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("testautomation");
        user.setPassword("automation123!");
        user.setAge(25);
        user.setUsertype("inventory admin");
        user.setActive(true);
        ObjectMapper objectMapper=new ObjectMapper();
        String userInfo=null;
        try {
            userInfo= objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(userInfo);
        try {
            FileUtils.writeStringToFile(new File("docs\\userdata.json"),userInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
