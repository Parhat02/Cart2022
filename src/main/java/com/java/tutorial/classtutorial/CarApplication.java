package com.java.tutorial.classtutorial;

import com.java.tutorial.object.FunctionDemo;

import java.util.ArrayList;
import java.util.List;

public class CarApplication {
    public static void main(String[] args) {

        //define car1
        Car car1=new Car();  //car1 is an instance of the Car object
        car1.setBrand("Toyota");
        car1.setColor("Silver");
        car1.setEngine("V2.6");
        car1.setMake("Toyota");
        car1.setBodyType("SUV");
        car1.setModel("RAV4");
        car1.setPrice(35000);
        car1.setYear(2022);
        car1.setMileAge(10);
        //define car2
        Car car2=new Car();
        car2.setBrand("Benz");
        car2.setYear(2021);
        car2.setColor("Blue");
        car2.setMake("Benz");
        car2.setBodyType("SUV");
        car2.setPrice(80000);
        car2.setMileAge(10000);
        car2.setEngine("V3");
        car2.setModel("Benz3");
        //define car3
        Car car3=new Car();
        car3.setBrand("Honda");
        car3.setModel("Civic");
        car3.setMileAge(25000);
        car3.setPrice(35000);
        car3.setBodyType("SUV");
        car3.setYear(2020);
        car3.setEngine("V2.4");
        car3.setMake("Honda");
        //add the cars to list
        List<Car> carList=new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        //print car information
        for (Car car:carList){
            System.out.println(car.getBrand()+", "+car.getColor()+", "+car.getBodyType()+", "+car.getEngine()
            +", "+car.getMake()+", "+car.getMileAge()+", "+car.getModel()+", "+car.getPrice()+", "+car.getYear());
            System.out.println();
        }

        System.out.println(car1.toString());
        Car car4=new Car("BMW","Blue","X6");
        System.out.println(car4);

        FunctionDemo car5=new FunctionDemo();
        car5.carInfo(car4);
        car5.carInfo(car3);
    }
}
