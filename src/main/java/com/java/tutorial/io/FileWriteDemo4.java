package com.java.tutorial.io;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;

public class FileWriteDemo4 {
    public static void main(String[] args) {
        String content="Google Search test passed";
        //define a new time stamp for the file
        DateTime time=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-mm-ss-SSS");
        String timeStamp= time.toString(formatter);
        String fileName="google_search_"+timeStamp+".txt";
        File file=new File("docs"+File.separator+fileName);
        try {
            FileUtils.writeStringToFile(file, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
