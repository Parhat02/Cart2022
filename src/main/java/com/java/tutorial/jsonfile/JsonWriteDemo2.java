package com.java.tutorial.jsonfile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonWriteDemo2 {
    public static void main(String[] args) {
        User user1=new User("testautomation1","automation123!","admin",30,true);
        User user2=new User("testautomation2","automation123!","admin",25,true);
        User user3=new User("testautomation3","automation123!","admin",27,true);
        User user4=new User("testautomation4","automation123!","admin",28,true);
        List<User> users=new ArrayList<>();
        users.addAll(Arrays.asList(user1,user2,user3,user4));
        LoginUser loginUser=new LoginUser(users,"CubeCart");//initialize the loginUser object
        ObjectMapper objectMapper=new ObjectMapper();
        String loginUserString=null;
        try {
            loginUserString= objectMapper.writeValueAsString(loginUser);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            FileUtils.writeStringToFile(new File("docs\\usersdata.json"),loginUserString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
