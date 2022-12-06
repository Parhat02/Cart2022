package com.java.tutorial.io;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class FileDeleteDemo {
    public static void main(String[] args) {
        //delete an existing file
        boolean fileDeleted=FileUtils.deleteQuietly(new File("docs"+File.separator+"test2022_28_12_12_28_024.txt"));
        System.out.println("File deleted? : "+fileDeleted);
    }
}
