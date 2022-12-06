package com.java.tutorial.io;

import java.io.*;

public class InputStreamFileReaderDemo {
    public static String readToString(String fileToText) throws IOException {
        //you can read all different types of data form all different types of sources.
        StringBuilder contents = new StringBuilder();
        //current project folder
        String workingDir = System.getProperty("user.dir");
        //define a file object variable
        File filePath = new File(workingDir + File.separator);
        System.out.println(filePath);
        Reader reader = null;
        try {
            InputStream inputStream = new FileInputStream(filePath + File.separator + fileToText);
            reader = new InputStreamReader(inputStream);
            int data = reader.read();
            while (data != -1) {
                char theChar = (char) data;//Convert byte to text
                data = reader.read();
                contents.append(theChar);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } try {
            reader.close();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return contents.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readToString("docs\\test2022_16_06_11_16_003.txt"));
    }
}
