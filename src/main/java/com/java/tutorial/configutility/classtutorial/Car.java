package com.java.tutorial.configutility.classtutorial;

import org.checkerframework.checker.units.qual.C;

public class Car {
    //brand, type, color, engine, make, model,year, mileAge, bodyType, price
    private String brand;
    private String type;
    private String color;
    private String engine;
    private String make;
    private String model;
    private int year;
    private long mileAge;
    private String bodyType;
    private double price;

    //setter and getter

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getMileAge() {
        return mileAge;
    }

    public void setMileAge(long mileAge) {
        this.mileAge = mileAge;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileAge=" + mileAge +
                ", bodyType='" + bodyType + '\'' +
                ", price=" + price +
                '}';
    }

    public Car() {
    }

    public Car(String brand, String type, String color, String engine, String make, String model, int year, long mileAge, String bodyType, double price) {
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.engine = engine;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileAge = mileAge;
        this.bodyType = bodyType;
        this.price = price;
    }

    public Car(String brand, String color, String bodyType) {
        this.brand = brand;
        this.color = color;
        this.bodyType = bodyType;
    }

//    public void carInfo(Car car){
//        System.out.println(car.getBrand());
//        System.out.println(car.getYear());
//        System.out.println(car.getMake());
//        System.out.println(car.getPrice());
//    }
//
//    public static void main(String[] args) {
//        Car car=new Car("BMW","Blue","X6");
//        car.carInfo(car);
//    }
}
