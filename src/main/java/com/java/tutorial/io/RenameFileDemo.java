package com.java.tutorial.io;

import java.io.File;
import java.io.IOException;

public class RenameFileDemo {
    //Rename an existing file and create a new file
    public static void createRenameFile(String fileName){
        //get current project path
        String projectPath=System.getProperty("user.dir");
        //create new file
        File file=new File(projectPath+File.separator+fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
                System.out.println("File is created");
            }else{
                String absolutePath=file.getAbsolutePath();//return file path(folder+filename)
                String filePath=absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));
                System.out.println(filePath);
                File backupFile=new File(filePath+File.separator+"backup_1"+file.getName());
                System.out.println("File is already exist and back up file is created");
                file.renameTo(backupFile);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createRenameFile("docs\\testfile.txt");
    }
}
