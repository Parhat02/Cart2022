package com.selenium.integration.cubecartjunit;

import org.apache.commons.io.FileUtils;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.File;
import java.io.IOException;

public class JUnitConsole {
 //run Junit test using JUnit Core package
 public static void main(String[] args) {
     //we can define a string builder to create a report file
     StringBuilder testLog=new StringBuilder();
     testLog.append("<html><head><title>CubeCart Report </title></head><body>");
     testLog.append("<p>Test executed by: ").append(System.getProperty("user.name")).append("</p>");
     testLog.append("<p>Test executed on: ").append(System.getProperty("os.name")).append("</p>");
     //add  table
     testLog.append("<table border=1>");
     //add header row
     testLog.append("<tr><td>Total Test</td><td>Total Passed</td><td>Total Failed</td></tr>");
     //add result row

     Result testResult= JUnitCore.runClasses(JUnitCubeCartFramework.class);
     int totalFailures=testResult.getFailureCount();
     int totalIgnored=testResult.getIgnoreCount();
     int totalPassed=testResult.getRunCount()-totalFailures;
     if (totalFailures==0){
         testLog.append("<tr bgcolor='#33cc33'>");
         System.out.println("All tests passed");
     }
     else{
         System.out.println(totalFailures+" cases failed");
         testLog.append("<tr bgcolor='#ffff00'>");
         for (Failure failure:testResult.getFailures()){
             testLog.append("<p> Failed test: ").append(failure.getDescription().getMethodName());
         }
     }

     testLog.append("<td>").append(testResult.getRunCount()).append("</td>");
     testLog.append("<td>").append(totalPassed).append("</td>");
     testLog.append("<td>").append(totalFailures).append("</td>");
     testLog.append("</tr></table></body></html>");
     try {
         String fileName="docs\\smoketest.html"+System.currentTimeMillis()+".html";
         FileUtils.writeStringToFile(new File(fileName),testLog.toString());
     } catch (IOException e) {
         throw new RuntimeException("File cannot be saved");
     }
 }
}
