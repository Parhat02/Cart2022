package com.java.tutorial.exceltutorial;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFileUtility {
    public static List<String> readCsvFile(String filePath, String headerName) {
        //define a reader to read a csv file
        List<String> keywords=new ArrayList<>();
        Reader inputFile= null;
        try {
            inputFile = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Iterable<CSVRecord> records= null;
        try {
            records = CSVFormat.RFC4180.withHeader(headerName).parse(inputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CSVRecord record:records){
            String keyword=record.get(headerName);
            keywords.add(keyword);
        }
        return keywords;
    }
}
