package com.java.tutorial.Exercises;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a number :");
        String a= input.nextLine();
        if (StringUtils.isNumeric(a)){
            int b=Integer.parseInt(a);
            System.out.print("2 ");
            for (int i=2;i<=b;i++){
                for (int j=2;j<i;j++){
                    if (i%j==0)
                        break;
                    if ((j+1)==i)
                        System.out.print(i+" ");
                }
            }
        }else
            System.out.println("You should only enter numbers...");

        System.out.println("");

        for (int i=1;i<=4;i++){
            double e=Math.pow(2,i);
            for (int j=0;j<e;j++){
                System.out.print("[]");
            }
            System.out.println("");
        }


        double p=1000;
        int r=5;
        int t=1;
        int y=5;
        while (t<=y){
            p=p+p*r/100;
            t++;
        }
        System.out.println(p);

        System.out.println("");

        int d3=0;
        int d5=0;
        int d15=0;
        String numbersD3=" ";
        String numbersD5=" ";
        List<Integer> numbersD15=new ArrayList<Integer>();
        for(int i=1;i<=500;i++){
            if (i%3==0){
                d3++;
                numbersD3=numbersD3+i+" ";
            }
            if (i%5==0){
                d5++;
                numbersD5=numbersD5+i+" ";

            }
            if (i%15==0){
                d15++;
                numbersD15.add(i);
            }
        }
        System.out.println(d3);
        System.out.println("Numbers that can be divided by 3 :\n" +numbersD3);
        System.out.println(d5);
        System.out.println("Numbers that can be divided by 5 :\n" +numbersD5);
        System.out.println(d15);
        System.out.println("Numbers that can be divided by 15 :\n" +numbersD15.toString());
        System.out.println("Numbers that can be divided by 15 :");
        for(int i=1;i<=500;i++) {
            if (i % 15 == 0)
                System.out.print(i + ",");
        }

        System.out.println("");
        for (int i=2;i<=20;i+=2){
            System.out.println(i+" "+i*i);
        }


        Random random=new Random();
        int sum=0;
        for (int i=0;i<5;i++){
            int r1= random.nextInt(51); //0-50
            sum=sum+r1;
            System.out.print(r1+" ");
        }
        System.out.println("");
        System.out.println("Sum of the numbers :"+sum);
        double average=(double)sum/5;
        System.out.println("The average of the 5 numbers :"+average);


        int rest=5;
        int minute=0;
        for (int e=1;e<=25;e++){
            minute=minute+15+rest;
        }
        System.out.println(minute-rest);

        double mo=Math.random();
        System.out.println(mo*11);
        System.out.println(mo*10);
    }
}
