package com.java.tutorial.Basic;

import java.text.NumberFormat;
import java.util.Locale;

public class TypeConversion {
    public static void main(String[] args){

        int x1=100;
        long l1=x1;
        float f3=l1;
        System.out.println("Int value is "+x1);
        System.out.println("Long value is "+l1);
        System.out.println("Float value is "+f3);

        double d3=15.78;
        long l3=(long)d3;
        System.out.println("integer value is "+d3);
        System.out.println("Long value is "+l3);

        int i1=15;
        int i2=8;
        double i3=i1/i2;
        float i4=(float) i1/i2;
        System.out.println(String.format("%d divided by %d equals %f",i1, i2, i3));
        System.out.println(i1+" divided by "+i2+" equals "+i4);

        String s1="1234";
        int i=1234;
        System.out.println(s1+" "+i);
        System.out.println(Integer.parseInt(s1) +i);

        String s2="1234567.8901";
        System.out.println("Double value of "+s2+" "+Double.valueOf(s2));
        System.out.println("long value of "+s2+" is "+Long.valueOf((long) Double.parseDouble(s2)));

        String s3="123456789";
        int i5=Integer.valueOf(s3);
        System.out.println(i5);
        String s4="9878645.67134";
        double d1=Double.parseDouble(s4);
        double d2=Double.valueOf(s4);
        float f1=Float.valueOf(s4);
        Float f2=Float.parseFloat(s4);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(f1);
        System.out.println(f2);

        char c1='A';
        char c2='c';
        int value1=c1;
        int value2=c2;
        System.out.println(value1);
        System.out.println(value2);
        char c3=66;
        System.out.println(c3);

        System.out.println(Math.round(3.56));

        String s9="12456poi";
        s9=s9.substring(0,5);
        System.out.println(s9);
        int i9=Integer.parseInt(s9);
        System.out.println(s9);

        int kk=12345555;
        String pp=String.valueOf(kk);
        String ss="0" + pp;
        System.out.println(ss);
        System.out.println(pp);

    }
}
