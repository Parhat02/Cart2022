package com.java.tutorial.classtutorial;

public class Rectangle extends Shape{

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        super(length, width);
    }

    public static void main(String[] args) {
        Shape demo=new Shape(10,20);
        System.out.println(demo.getArea());

        Rectangle demo1=new Rectangle(30,20);
        System.out.println(demo1.getArea());

        Shape demo2=new Shape(20,30);
        System.out.println(demo2.getArea());
        System.out.println(demo2.getLength());

        Shape demo3=new Shape();
        demo3.setLength(15);
        demo3.setWidth(25);
        System.out.println(demo3.getLength());
        System.out.println(demo3.getArea());
    }
}
