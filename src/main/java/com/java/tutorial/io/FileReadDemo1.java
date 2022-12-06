package com.java.tutorial.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileReadDemo1 {
    public static void main(String[] args) {
        File file=new File("docs"+File.separator+"testfile2022_30_10 13_30_53.613.txtbackup");
        String fileContent= null;
        try {
            fileContent = FileUtils.readFileToString(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(fileContent);
    }
}
