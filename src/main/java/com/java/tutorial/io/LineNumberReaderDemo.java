package com.java.tutorial.io;

import java.io.*;

public class LineNumberReaderDemo {
    //
    public static void readToString(String fileToRead) throws IOException{
        String workingDir=System.getProperty("user.dir");
        File file=new File(workingDir+File.separator+fileToRead);
        System.out.println(file);
        //define lineNumberReader instance
        LineNumberReader reader=new LineNumberReader(new FileReader(file));
        //define buffered reader instance
        BufferedReader br=new BufferedReader(new FileReader(file));
        String s="";
        try {
            while (reader.readLine()!=null){
                int lineNumber= reader.getLineNumber();
                s=br.readLine();
                System.out.println("Line number: "+lineNumber+" Content :"+s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        readToString("docs\\test2022_16_06_11_16_003.txt");
    }
}
