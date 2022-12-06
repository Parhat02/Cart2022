package com.java.tutorial.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileWriteDemo5 {
    public static void main(String[] args) {
        String content="\nTest Passed";
        File file=new File("docs"+File.separator+"google_search.txt");
        try {
            FileUtils.writeStringToFile(file,content, Charset.defaultCharset(),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
