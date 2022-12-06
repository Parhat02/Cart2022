package com.java.tutorial.object;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExceptionsDemo {
    public static void main(String[] args) throws IOException {
        int a=10;
        int b=0;
        try{
            float c=a/b;
            System.out.println("Division value is :"+String.valueOf(c));
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("You cannot divide any number by 0");
            System.out.println("Continue");
        }
        System.out.println();
        writeList("TestFile2");
    }

    //this will return IndexOutOfBoundException
    private static void writeList(String fileName) throws IOException{
        //get current project path
        String filePath=System.getProperty("user.dir");
        //define file separator symbol1
        String fileSeparator= File.separator;
        //create a new file
        File file=new File(filePath+fileSeparator+fileName);
        //The FileWriter constructor throws IOException, which must be caught
        PrintWriter out=new PrintWriter(new FileWriter(file+".txt"));
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i=0;i<10;i++){
            //The get(int) method throws IndexOutOfBoundsException, which must be caught
            try{
                out.println("Value at: "+i+"="+list.get(i));
            }catch(IndexOutOfBoundsException e){
                e.printStackTrace();
            }finally {
                System.out.println("Continue....");
            }
        }
        out.close();
    }


}
