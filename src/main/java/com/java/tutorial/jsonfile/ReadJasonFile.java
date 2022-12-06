package com.java.tutorial.jsonfile;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;

public class ReadJasonFile {
    public static void readJason(String fileName){
        String workingDir=System.getProperty("user.dir");
        String filePath=workingDir+ File.separator+fileName;
        InputStream inputStream= null;
        JsonReader jsonReader=null;
        JsonObject jsonObject=null;
        try {
            inputStream = new FileInputStream(filePath);
            jsonReader= Json.createReader(inputStream);
            jsonObject=jsonReader.readObject();
            System.out.println(jsonObject.toString());
            System.out.println(jsonObject.get("TestName"));
            JsonArray testSteps=jsonObject.getJsonArray("TestSteps");
            int steps=testSteps.size();
            for (int i=0;i<steps;i++){
                JsonObject eachStep=testSteps.getJsonObject(i);
                System.out.println("Id : "+eachStep.get("Id")+" Step : "+eachStep.get("Step"));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                inputStream.close();
                jsonReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        readJason("docs"+File.separator+"testcase.json");
    }
}
