package com.java.tutorial.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static String readToString(String fileToText) {
        String workingDir = System.getProperty("user.dir");
        StringBuilder fileContent = new StringBuilder();
        File file = new File(workingDir + File.separator);
        System.out.println(file);
        try {
            FileReader fr = new FileReader(file + File.separator + fileToText);
            BufferedReader br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                fileContent.append(sCurrentLine).append("\n");
            }
//            sCurrentLine= br.readLine();
//            fileContent.append(sCurrentLine).append("\n");
//            fileContent.append(br.readLine()).append("\n");
//            fileContent.append(br.readLine()).append("\n");
//            fileContent.append(br.readLine()).append("\n");
        } catch (IOException e) {
            System.out.println("Cannot read the text file");
        }
        return fileContent.toString();
    }

    public static void main(String[] args) {
        System.out.println(readToString("docs\\test2022_16_06_11_16_003.txt"));
    }
}
