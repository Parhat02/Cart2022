package com.java.tutorial.io;

import java.io.*;
import java.net.URL;

public class FileReadFromURL {
    public static void main(String[] args) {
        String projectPath=System.getProperty("user.dir");
        String fileSeparator= File.separator;
        String filePath=projectPath+fileSeparator;
        InputStream in=null;
        try {
            URL testUrl=new URL("https://www.apache.org/");
            in=testUrl.openStream();
        }catch (IOException e){
            e.printStackTrace();
        }

        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        StringBuilder result=new StringBuilder();
        String line;
        try {
            while ((line= reader.readLine())!=null){
                result.append(line+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(result);

        //Use Output stream to create a file
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(filePath+"docs\\temp2.html");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //write output stream to file
        Writer writer=new OutputStreamWriter(outputStream);
        try {
            //write out to file
            writer.write(result.toString());
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
