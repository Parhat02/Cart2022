package com.java.tutorial.configutility.classtutorial;

public class Circle extends Shape{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    //method overriding
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter(){
        return Math.PI*2*radius;
    }

    public static void main(String[] args) {
        Shape demo=new Circle(5);
        System.out.println(demo.getArea());

        Circle demo1=new Circle(5);
        System.out.println(demo1.getPerimeter());
    }
}
