package com.java.tutorial.Basic;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class HelloWorld {

    public static void main (String[] args)
    {
        System.out.println("Hello World");
        System.out.println("Welcome to Selenium Java Web driver Framework Crash Course");
        String n="Hello";
        String u=" World";
        System.out.println(n.substring(2,3));
        int i1=1000;
        long d=i1;
        System.out.println(d);
        long i2=10000;
        int i3=(int)i2;
        System.out.println(Integer.parseInt(""+i1));
        System.out.println(i1+n);
        System.out.println(n+u);

        int x=5;
        int y=9;
        if (x==5)
            System.out.println("llll");
        if (y==9)
            System.out.println("pppppp");
        else
            System.out.println("wwwwwwww");
        System.out.println(n+i2);
        int compare=n.compareTo(u);
        System.out.println(compare);
        System.out.println(u.substring(1));



        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String B="";
        for(int i=A.length()-1;i>=0;i--){
            B=B+A.charAt(i);
            System.out.println(B);
        }

        if(A.equalsIgnoreCase(B)){
            System.out.println("Yes");
        }else
            System.out.println("No");

        if (StringUtils.isNumeric(A)){
            int number=Integer.parseInt(A);
            System.out.println(number);
        }
        Random random=new Random();
        System.out.println(random.nextInt(20));
    }

}