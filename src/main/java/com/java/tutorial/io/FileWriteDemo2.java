package com.java.tutorial.io;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriteDemo2 {
    //Get current user name
    public static String getCurrentTestUserName(){
        return System.getProperty("usr.name");
    }
    //Get current host name
    public static String getCurrentTestHostName(){
        InetAddress localMachine=null;
        try {
            localMachine=InetAddress.getLocalHost();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        String hostName=localMachine.getHostName();
        return hostName;
    }
    //Get current system time
    public static String getCurrentTimeStamp(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS");
        Date now=new Date();
        String date= sdf.format(now);
        date=date.replace(":","_").replace("-","_");
        return date;
    }
    public static void writeToFile(String fileContent, String fileName, String fileExtension) throws IOException{
        String projectPath=System.getProperty("user.dir");
        String tempFile=projectPath+ File.separator+fileName+getCurrentTimeStamp()+fileExtension;
        File file=new File(tempFile);
        //if file does exist, then delete and create a new file
        System.out.println(file.exists());
        if (file.exists()){
            try {
                File newFileName=new File(projectPath+File.separator+fileName+"_backup3");
                file.renameTo(newFileName);
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream=new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();
    }


    public static void main(String[] args) throws IOException{
        String textContent="Content created on PC : "+getCurrentTestHostName();
        textContent=textContent+"\n Content created by : "+getCurrentTestUserName();
        textContent=textContent+"\n Hello Test";
        textContent=textContent+"\n This is a file creation example";
        writeToFile(textContent,"docs\\testfile",".txt");
    }
}
