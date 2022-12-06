package com.java.tutorial.io;

import java.io.File;

public class DeleteFile {
    public static void deleteFile(String fileName){
        String filePath=System.getProperty("user.dir");
        String folderSeparator=File.separator;
        File file=new File(filePath+folderSeparator+fileName);
        if (!file.exists()){
            System.out.println("File is not found");
        }else{
            System.out.println("File already exist, deleting the file...");
            file.delete();
        }
    }

    public static void main(String[] args) {
        deleteFile("docs\\test2022_17_06_11_17_029.txt");
    }

}
