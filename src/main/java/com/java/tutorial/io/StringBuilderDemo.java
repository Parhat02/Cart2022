package com.java.tutorial.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("This is String Builder example").append("\n");
        stringBuilder.append("Line1").append("\n");
        stringBuilder.append("Line2").append("\n").append("Line3").append("\n");
        stringBuilder.append("Line4").append("\n");
        stringBuilder.append("Final line").append("\n");
        System.out.println(stringBuilder.toString());
        int[] myNumbers=new int[]{10,14,51,203,230,430,99,89};
        for (int i:myNumbers){
            stringBuilder.append(i).append(",");
        }
        System.out.println(stringBuilder);

        File file=new File("docs"+File.separator+"TestReport.txt");
        try {
            FileUtils.writeStringToFile(file,stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
