package com.java.tutorial.jsonfile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReadDemo {
    public static void main(String[] args) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            LoginUser loginUser=objectMapper.readValue(new File("docs//usersdata.json"), LoginUser.class);
            List<User> users=loginUser.getUsers();
            for (User user:users){
                System.out.println(user.getUsername()+","+user.getPassword()+","+user.getUsertype()+","+user.getAge());
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
