package com.java.tutorial.jsonfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import static javax.json.Json.createObjectBuilder;

public class WriteJsonFile {
    public static void createJson(String fileName){
        String workingDir=System.getProperty("user.dir");
        String filePath=workingDir+ File.separator+fileName;
        JsonObject jsonObject= createObjectBuilder()
                .add("TestName", "Login")
                .add("TestModule", "Dashboard")
                .add("TestType", "Regression")
                .add("TestSteps", Json.createArrayBuilder()
                        .add(createObjectBuilder().add("Id",1).add("Step", "Open browser"))
                        .add(createObjectBuilder().add("Id",2).add("Step", "Enter user name"))
                        .add(createObjectBuilder().add("Id",3).add("Step", "Enter user password"))
                        .add(createObjectBuilder().add("Id",4).add("Step", "Click on login button")))
                .add("Verification", "Logout link should display")
                .add("Note", "Login test note")
                .build();
        System.out.println(jsonObject.toString());
        try {
            JsonWriter writer= Json.createWriter(new FileOutputStream((new File(filePath))));
            writer.writeObject(jsonObject);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        createJson("docs"+File.separator+"testcase.json");
    }
}
