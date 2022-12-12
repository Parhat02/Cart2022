package com.java.tutorial.classtutorial;

public class Shape {
    private double length;
    private double width;


    public Shape() {
    }

    public Shape(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double getArea(){
        return length*width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
