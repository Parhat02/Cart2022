package com.java.tutorial.exceltutorial;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteWithArray {
    public static void main(String[] args) {
        Object[][] student={{"Student_ID","Student Name","Score"},
                {123,"Tom1",93},
                {456,"Mike1",87},
                {789,"David1",98}
        };
        File file=new File("docs"+File.separator+"testReport2.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Random2");
        int rowNumber=student.length;
        for (int r=0;r<rowNumber;r++){
            XSSFRow row= sheet.createRow(r);
            int cellNumber=student[1].length;
            for (int c=0;c<cellNumber;c++){
                XSSFCell cell=row.createCell(c);
                Object content=student[r][c];
                if (content instanceof String){
                    cell.setCellValue((String)content);
                }if (content instanceof Integer){
                    cell.setCellValue((Integer)content);
                }
            }
        }
        FileOutputStream outputStream= null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
