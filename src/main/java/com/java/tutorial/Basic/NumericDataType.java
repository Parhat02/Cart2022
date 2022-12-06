package com.java.tutorial.Basic;

public class NumericDataType {
    public static void main(String[] args)
    {
        byte a=100;
        byte b=110;
        byte c= (byte) (a&b);
        byte d=(byte) (a|b);
        System.out.println("Byte 100 AND byte 110 is "+c);
        System.out.println("Byte 100 OR byte 110 is "+d);

        short s1=3500;
        short s2=6000;
        short s3= (short) (s1+s2);
        System.out.println(String.format("%d + %d = %d", s1, s2, s3));

        int i1=10000000;
        int i2=20000000;
        System.out.println(String.format("%d + %d = %d", i1, i2, i1+i2));

        long l1=123456789464l;
        long l2=976543215646l;
        long l3=l2-l1;
        System.out.println(l3);

        long l4=1000;
        long l5=2000;
        long l6=l5+l4;
        System.out.println(l6);

        float f1=3.56f;
        float f2=5.54f;
        System.out.println(String.format("%.2f + %.2f = %.2f" ,f1,f2,f1+f2));

        double d1=100.09;
        double d2=200.09;
        double d3=d1+d2;
        System.out.println(String.format("%.3f + %.3f = %.3f",d1,d2,d3));

        int width=20;
        int length=40;
        int area=width*length;
        System.out.println(area);

        double pow=Math.pow(11,3);
        System.out.println(pow);

        double square=Math.sqrt(100);
        System.out.println(square);

        int value1=10;
        int value2=9;
        System.out.println("value1=value2: "+(value1==value2));
        System.out.println("value1!=value2: "+(value1!=value2));
        System.out.println("value1>value2: "+(value1>value2));
        System.out.println("value1>=value2: "+(value1>=value2));

        int number1=5;
        int number2=10;
        System.out.println((number1==5)&&(number2==9));
        System.out.println((number1==5) || (number2==9));
        int number3=8;
        double number4=number3>0?Math.sqrt(number3):0;
        System.out.println(number4);

        String stringA="Wonderful";
        System.out.println(stringA instanceof String);

        byte byteA=60;
        byte byteB=13;
        System.out.println("60&13= "+(byteA&byteB));


        int a1=40;
        int b1=50+(a1++);
        int c1=a1++;
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);

        int a2=20;
        int b2=60+(++a2);
        int c2=++a2;
        System.out.println(a2);
        System.out.println(b2);
        System.out.println(c2);

        //Random range 0.0---0.999999999
        int randomNumber=(int)(Math.random()*11)+1;
        System.out.println(randomNumber);
    }
}
