package com.java.tutorial.exceltutorial;

import com.java.tutorial.configutility.classtutorial.UserLogin;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    //method to read from Excel cell
    public String readFromExcel(String fileName, String sheetName,int rowNumber, int cellNumber){
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook= null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet=workbook.getSheet(sheetName);
        XSSFRow row=sheet.getRow(rowNumber);
        String cellValue=null;
        if (row==null){
            System.out.println("Empty row");
        }else{
            XSSFCell cell=row.getCell(cellNumber);
            CellType cellType=cell.getCellType();
            switch (cellType){
                case NUMERIC:
                    cellValue=String.valueOf(cell.getNumericCellValue());
                    System.out.println(cellValue);
                    break;
                case STRING:
                    cellValue=cell.getStringCellValue();
                    System.out.println(cellValue);
                    break;
                case BOOLEAN:
                    cellValue=String.valueOf(cell.getBooleanCellValue());
                    System.out.println(cellValue);
                    break;
            }
        }
        return cellValue;
    }

    public void readFromMultipleRowCell(String fileName,String sheetName){
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook= null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet=workbook.getSheet(sheetName);
        int rowCount=sheet.getLastRowNum();
        System.out.println(rowCount);
        for (int r=0;r<=rowCount;r++){
            XSSFRow row= sheet.getRow(r);
            int cellCount=sheet.getRow(0).getLastCellNum();
            System.out.println(cellCount);
            for (int c=0;c<cellCount;c++){
                XSSFCell cell=row.getCell(c);
                switch (cell.getCellType()){
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public List<UserLogin> readExcelMultipleCell(String fileName, String sheetName, int startRow){
        List<UserLogin> userLogins=new ArrayList<>();
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook= null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet=workbook.getSheet(sheetName);
        int rowNumber=sheet.getLastRowNum();
        for (int r=startRow;r<rowNumber;r++){
            XSSFRow row=sheet.getRow(r);
            if (row==null){
                System.out.println("Empty row, no data in the cell");
            }else {
                XSSFCell userName=row.getCell(0);
                XSSFCell password=row.getCell(1);
                userLogins.add(new UserLogin(userName.getStringCellValue(),password.getStringCellValue()));
            }
        }
        System.out.println(userLogins.toString());
        return userLogins;
    }

    public void writeToExcelCells(String fileName, String sheetName, List<String> content){
        //define a workbook
        XSSFWorkbook workbook=new XSSFWorkbook();
        //create a sheet
        XSSFSheet sheet=workbook.createSheet(sheetName);
        int rowNumber=content.size();
        for (int r=0;r<rowNumber;r++){
            //adding row to sheet
            XSSFRow row=sheet.createRow(r);
            String[] rowContent=content.get(r).split(",");
            int cellNumber=rowContent.length;//total cells
            for (int c=0;c<cellNumber;c++){
                XSSFCell cell=row.createCell(c);//adding cell to the row
                cell.setCellValue(rowContent[c]);//adding content to the cell
            }
        }
        FileOutputStream outputStream= null;
        try {
            outputStream = new FileOutputStream(fileName);
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
