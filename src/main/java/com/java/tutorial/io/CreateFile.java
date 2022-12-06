package com.java.tutorial.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFile {
    //create a file
    public static void createFile(String folder,String fileName, String fileExtension){
        //get current project path
        String filePath=System.getProperty("user.dir");
        //get current date time stamp
        Date currentDate=new Date();
        String pattern="yyyy-mm-dd-hh-mm-sss";
        SimpleDateFormat format=new SimpleDateFormat(pattern);
        String timeStamp= format.format(currentDate).replace("-","_");

        //create a new file object instance
        File file=new File("C:\\Users\\parha\\IdeaProjects\\CubeCart"+"\\"+folder+"\\"+fileName+timeStamp+fileExtension);
        try {
            if (!file.exists()){
                file.createNewFile();
                System.out.println("File is created");
                System.out.println("File name: "+file);
            }else
                System.out.println("File is already exist");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createFile("docs","test",".txt");
    }
}
