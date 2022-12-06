package com.java.tutorial.Exercises;

public class DataType {
    public static void main(String[] args)
    {
        int k1=34, k2=5;
        int k3=k1+k2;
        System.out.println(String.format("%d + %d = %d",k1,k2,k3));
        int k4= k1-k2;
        System.out.println(String.format("%d - %d = %d",k1,k2,k4));
        //int k5=k1*k2;
        System.out.println(String.format("%d * %d = %d",k1,k2,k1*k2));
        System.out.println(String.format("%d / %d = %d",k1,k2,k1/k2));
        int k6=Math.abs(k1-k2);
        System.out.println(String.format("Absolute value of %d - %d = %d",k1,k2,k6));
        int k7= -7;
        System.out.println(k7);
        System.out.println(Math.abs(k7));
        int k8=Math.max(k1,k2);
        System.out.println(String.format("The maximum number in %d and %d is %d",k1,k2,k8));
        System.out.println(String.format("The minimum number in %d and %d is %d",k1,k2,Math.min(k1,k2)));
        System.out.println(k1>k2);
        System.out.println(k1<k2);
        if (k1>k2){
            System.out.println(String.format("%d is greater than %d", k1,k2));
        }
        else{
            System.out.println(String.format("%d is greater than %d",k2,k1));
        }

    }
}
