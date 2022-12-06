package com.java.tutorial.io;

import java.io.*;

public class FileWriterDemo3 {
    public static void writeToFile(String fileContent, String fileName) throws IOException{
        String projectPath=System.getProperty("user.dir");
        String tempFile=projectPath+ File.separator+fileName;
        File file=new File(tempFile);
        if (file.exists()){
            try {
                File newFileName=new File(projectPath+File.separator+fileName+"_backup");
                file.renameTo(newFileName);
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        FileWriter fw=new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw=new BufferedWriter(fw);
        try {
            bw.write(fileContent);
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(fileContent);
    }

    public static void main(String[] args) throws IOException{
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Hello Test\n");
        stringBuilder.append("Selenium Master").append("\n");
        stringBuilder.append("Test passed\n");
        stringBuilder.append("End of file\n");
        writeToFile(stringBuilder.toString(),"docs\\testfile2022_30_10 13_30_53.613.txt");
    }
}
