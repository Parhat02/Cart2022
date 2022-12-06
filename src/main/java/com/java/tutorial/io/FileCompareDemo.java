package com.java.tutorial.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileCompareDemo {
    public static void main(String[] args) throws IOException {
        File file1=new File("docs"+File.separator+"testfile2022_30_10 13_30_53.613.txtbackup");
        File file2=new File("docs"+File.separator+"testfile2022_30_10 13_30_53.613.txt_backup");
        String file1Content= FileUtils.readFileToString(file1);
        String file2Content= FileUtils.readFileToString(file2);
        if (file1Content.equalsIgnoreCase(file2Content)){
            System.out.println("Files are the same");
        }else
            System.out.println("Files are different");
    }

}
