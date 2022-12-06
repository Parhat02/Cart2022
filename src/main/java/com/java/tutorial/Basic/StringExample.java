package com.java.tutorial.Basic;

import org.apache.commons.lang3.StringUtils;

public class StringExample {

    public static void main(String[] args)
    {
        //define a string variable
        String greeting="Hello, Selenium Master";
        //get string length
        int i=greeting.length();
        System.out.println("The string length is " +i);
        //convert to upper case
        String greetingUpper=greeting.toUpperCase();
        System.out.println("Upper case of the string greeting is "+greetingUpper);
        //convert to lower case
        String greetingLower=greeting.toLowerCase();
        System.out.println("Lower case of the string greeting is "+greetingLower);
        //concatenate strings
        String a=greeting.concat(" Java Webdriver Crash Course");
        System.out.println(a);
        //replace string
        String testPlan="Login Test";
        String t=testPlan.replace("Test", "Plan");
        System.out.println(t);
        //get sub string
        String g=greeting.substring(0,5);
        System.out.println(g);
        //remove space in the beginning and end
        String country="     USA       ";
        System.out.println("Country is " +country);
        System.out.println("Country is " +country.trim());
        //check the first occurrence of the specified character in a string
        String x="abcdef";
        char y='f';
        int location=x.indexOf(y);
        System.out.println(String.format("The location of %s in %s is %d",y,x,location));
        //check the sequence of characters in this string
        String testCase="Login Test";
        String subString="Login";
        System.out.println(String.format("Test case : %s contains %s : %b",testCase,subString,testCase.contains(subString)));

        String result="About 18.760.000.000 results";
        System.out.println(result.replaceAll("u","o"));
        System.out.println(result.replaceAll("[^0-9]",""));
        System.out.println(result.replace("About ", "").replace(" results", ""));
        result=result.replace("About ", "").replace(" results", "");
        System.out.println(result);

        //compare concatenation
        String s1="Java";
        String s2="java job jelly";
        System.out.println(s1.equals(s2));

        System.out.println(s1.indexOf("a",2));
        System.out.println(s2.indexOf("jelly"));
        System.out.println(s2.indexOf("elly"));
        System.out.println(greeting.lastIndexOf("e"));

        System.out.println(StringUtils.reverse(s2));
        System.out.println(StringUtils.reverseDelimited(s2,' '));
        System.out.println(s2.substring(0,3));

        String name="Abdullah2022-11-06T11:50:50.627+03:00";
        System.out.println(name.replaceAll("[^A-z]",""));
        System.out.println(name.replaceAll("[0-9]",""));
        System.out.println(name.replaceAll("[^0-9]",""));
        System.out.println(name.replaceAll("0","1"));
        System.out.println(name.replace("0","m"));

    }
}
