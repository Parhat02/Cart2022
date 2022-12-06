package com.java.tutorial.io;

import java.io.File;

public class DirectoryDemo {
    //define a static method to create a folder(directory)
    public static void createDirectory(String parentFolder, String directoryName){
        //project directory
        String workingDirectory=System.getProperty("user.dir");
        //define a folder path
        String dir=workingDirectory+ File.separator+parentFolder+File.separator+directoryName;
        System.out.println("Final file directory : "+dir);
        //create a directory in the path
        File file=new File(dir);
        if (!file.exists()){
            boolean fileCreated=file.mkdir();
            System.out.println("Directory is created!: "+fileCreated);
        }else{
            //file.delete();
            System.out.println("Directory is already exist!");
        }
    }
public static void main(String[] args){
        createDirectory("docs","textdir2");
}
}
