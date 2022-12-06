package com.java.tutorial.exceltutorial;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class CsvFileReader {
    public static void main(String[] args) {
        //define a reader to read a csv file
        Reader inputFile= null;
        try {
            inputFile = new FileReader("docs"+ File.separator+"login.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Iterable<CSVRecord> records= null;
        try {
            records = CSVFormat.RFC4180.withHeader("username","password").parse(inputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord record:records){
            String username=record.get("username");
            String password=record.get("password");
            System.out.println(username+","+password);
        }
    }
}
