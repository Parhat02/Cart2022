package com.java.tutorial.exceltutorial;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFromExcel {
    public static void main(String[] args) {
        String fileName="docs"+ File.separator+"TestAutomation.xlsx";
        ExcelUtility excel=new ExcelUtility();
        String userName=excel.readFromExcel(fileName,"Sheet1",1,0);
        String password=excel.readFromExcel(fileName,"Sheet1",1,1);
        excel.readFromMultipleRowCell(fileName,"Sheet1");
        List<String> content=new ArrayList<>();
        content.add("Student_ID,Student Name,Score");
        content.add("11,Tom,90");
        content.add("12,Mike,80");
        content.add("13,David,99");
        String fileName1="docs"+File.separator+"testReport1.xlsx";
        excel.writeToExcelCells(fileName1,"Random1",content);
    }
}
