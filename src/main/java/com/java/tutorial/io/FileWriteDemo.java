package com.java.tutorial.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileWriteDemo {
    public static void writeToFile(String fileToText){
        String workingDir=System.getProperty("user.dir");

        try {
            RandomAccessFile file=new RandomAccessFile(workingDir+ File.separator+fileToText,"rw");
            String line;
            try{
                while ((line=file.readLine())!=null){
                    System.out.println(line);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            long point=file.getFilePointer();
            System.out.println(point);
            //move cursor to the last of the file
            file.seek(file.length());
            System.out.println(file.length());
            file.write("\n This is an example of random access file \n".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeToFile("docs\\test2022_16_06_11_16_003.txt");
    }
}
