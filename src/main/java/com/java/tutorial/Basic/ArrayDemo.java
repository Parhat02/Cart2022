package com.java.tutorial.Basic;

import org.openqa.selenium.json.JsonOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {

        //An array is a sequence of values of the same type
        int[] numberArrayE1=new int[10];//all elements are initialized with zero
        numberArrayE1[1]=1;
        numberArrayE1[2]=2;
        numberArrayE1[3]=3;
        numberArrayE1[4]=4;
        numberArrayE1[6]=10;
        System.out.println("The number of items in the array numbers :"+numberArrayE1.length);
        for (int number:numberArrayE1){
            System.out.print(number+",");
        }

        System.out.println("");
        System.out.println("----String array example----");
        String[] stringArrayE1=new String[4];//all elements are initialized with null
        stringArrayE1[0]="Mike";
        stringArrayE1[1]="Robert";
        stringArrayE1[2]="Smith";
        System.out.println("The number of items in the array names :"+stringArrayE1.length);
        for (String name:stringArrayE1){
            System.out.print(name+",");
        }
        System.out.println("");
        //Initialize arrays with initial values
        int[] numberArrayE2=new int[]{1,3,5,7,9};
        System.out.println("The number of items in the array numbers :"+numberArrayE2.length);
        for (int number:numberArrayE2){
            System.out.print(number+",");
        }
        System.out.println("");
        String[] stringArrayE2=new String[]{"A","B","C","D"};
        System.out.println("The number of items in the array string :"+stringArrayE2.length);
        for (String name : stringArrayE2){
            System.out.print(name+",");
        }

        //Two dimensional arrays
        System.out.println("");
        int row=3;
        int colum=4;
        String[][] seats=new String[row][colum];
        seats[0][0]="Mike";
        seats[0][1]="Bob";
        seats[0][2]="Emily";
        seats[0][3]="Jake";
        for (int r=0;r<row;r++){
            for (int c=0;c<colum;c++){
                if (seats[r][c]==null){
                    seats[r][c]="unassigned";
                }
                System.out.println("Row :"+(r+1)+" Colum :"+(c+1)+" Assigned :"+seats[r][c]);
            }
        }

        int[][] array8={
                {1,2,3,4},
                {5,6,7,8,9},
                {9,23,45,56,67},
                {34,54,62,72,41,99,}
        };
        System.out.println(array8.length);
        System.out.println(array8[2].length);
        int sum=0;
        for (int i=0;i< array8.length;i++){
            int sum1=0;
            for (int j=0;j<array8[i].length;j++){
                sum1+=array8[i][j];
                System.out.print(array8[i][j]+" ");
            }
            System.out.println("Sum of the row: "+sum1);
            sum+=sum1;
        }
        System.out.println("Total sum of the array8 : "+sum);

        int[] arr1={33,98,67,44,23,10};
        int[] arr2={55,78,90,34,80,45};
        int[] arr3={33,98,67,44,23,10};
        boolean result1= Arrays.equals(arr1,arr2);
        boolean result2= Arrays.equals(arr1,arr3);
        System.out.println(result1);
        System.out.println(result2);

        Arrays.fill(arr1,20);
        System.out.println(Arrays.toString(arr1));
        int[] arr4=Arrays.copyOf(arr2,6);
        System.out.println(Arrays.toString(arr4));

        int max=arr3[0];
        for (int e=1;e<arr3.length;e++){
            if (arr3[e]>max)
                max=arr3[e];
        }
        System.out.println(max);

        String school="United_Coder";
        String s="Hello,World";
        String[] array1=school.split("_");
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println(Arrays.toString(array1));
        String[] array2=s.split(",");
        for (String i:array2){
            System.out.println(i);
        }

        char[] c=new char[s.length()];
        for (int i=0;i<s.length();i++){
            c[i]=s.charAt(i);
        }
        System.out.println(Arrays.toString(c));

        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter the length of an Array :");
        int arrLength=scan.nextInt();
        int[] array=new int[arrLength];
        int minValue=0;
        for (int i=0;i<arrLength;i++){
            array[i]=(int)(Math.random()*100+1);
            if (i==0)
                minValue=array[0];
            if (array[i]<minValue)
                minValue=array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println("The min value is : "+minValue);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for (int i=arrLength-1;i>=0;i--){
            System.out.print(array[i]+" ");
        }
        System.out.println();

        int[] array5=new int[10];
        for (int i=0;i<10;i++){
            array5[i]=(int)(Math.random()*100+1);
        }
        System.out.println(Arrays.toString(array5));
        //bubble sort
        for (int e=0;e<array5.length-1;e++){
            for (int j=0;j<array5.length-1-e;j++){
                if (array5[j]>array5[j+1]){
                    int tempValue=array5[j];
                    array5[j]=array5[j+1];
                    array5[j+1]=tempValue;
                }
            }
        }
        System.out.println(Arrays.toString(array5));
        //selection sort
        int[] array6=new int[10];
        for (int i=0;i<10;i++){
            array6[i]=(int)(Math.random()*100+1);
        }
        System.out.println(Arrays.toString(array6));
        for (int e=0;e<10;e++){
            int minIndex=e;
            for (int j=e+1;j<10;j++){
                if (array6[j]<array6[minIndex]){
                    minIndex=j;
                }
            }
            int tempValue=array6[minIndex];
            array6[minIndex]=array6[e];
            array6[e]=tempValue;
        }
        System.out.println(Arrays.toString(array6));

        int[] array7=Arrays.copyOf(array6,11);
        array7[10]=99;
        System.out.println(Arrays.toString(array7));
    }
}
