package com.java.tutorial.Exercises;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class ExerciseIf {
    public static void main(String[] args) {
   /*     Scanner input=new Scanner(System.in);
        System.out.println("Enter a number :");
        String number=input.nextLine();
        if (StringUtils.isNumeric(number)){
            int a=Integer.parseInt(number);
            if (a%3==0 && a%5==0){
                System.out.println("BUZZ, FIZZ");
            } else if (a%5==0) {
                System.out.println("FIZZ");
            } else if (a%3==0) {
                System.out.println("BUZZ");
            }
            else
                System.out.println(a);
        }
        else
            System.out.println("You should enter a number!");*/
/*
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d=scan.nextDouble();
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        input.close();
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);*/
/*        int a=2;
        int b=3;
        double c=Math.pow(a,b);
        int d=(int)c;
        System.out.println(d);
        String e=new String("java");
        String f=new String("java");
        System.out.println(e==f);

        int x=900;
        int y=100;
        int value=x;
        System.out.println(x);
        System.out.println(y);
        x=y;
        System.out.println(x);
        y=value;
        System.out.println(y);*/


        String s1=String.format("%d",101);
        String s2=String.format("|%10d|",101);//Specifying length of integer.
        String s3=String.format("|%-10d|",101);//Left-justifying within the specified width.
        String s4=String.format("|% d|",101);
        String s5=String.format("|%010d|",101);//Filling with zeroes.
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s6=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s %03d\n", s6, x);
        }
        System.out.println("================================");
    }
}
