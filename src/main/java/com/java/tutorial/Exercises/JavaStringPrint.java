package com.java.tutorial.Exercises;

public class JavaStringPrint {
    public static void main(String[] args) {
        String name="Parhat ", address="Fatih ", zipcode="34";
        String schoolFullAddress=(name+address+zipcode);
        System.out.println(name.toUpperCase());
        System.out.println(address.toLowerCase());
        System.out.println(schoolFullAddress.substring(13,15));
        System.out.println(schoolFullAddress.length());
        System.out.println(name.equals("University"));
        System.out.println(name.contains("S"));
        String n1="University";
        System.out.println(schoolFullAddress==n1);
        char s='h';
        String s1="S";
        int loc=name.indexOf(s);
        System.out.println(name.contains(s1));
        System.out.println(loc);
        System.out.println(schoolFullAddress);
        int i1=name.indexOf("a");
        System.out.println(i1);
        System.out.println(name.indexOf("a",2));
    }
}
