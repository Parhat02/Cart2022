package com.java.tutorial.jsonfile;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class TestHelper {
    public static String getToday(){
        DateTime date=new DateTime();
        //use formatter to print the date time
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd");
        return date.toString(formatter);
    }
    public static String getCurrentTime(){
        DateTime date=new DateTime();
        //use formatter to print the date time
        DateTimeFormatter formatter= DateTimeFormat.forPattern("HH-mm-ss-SSS");
        return date.toString(formatter);
    }
    public static String getCurrentUser(){
        return System.getProperty("user.name");
    }
}
