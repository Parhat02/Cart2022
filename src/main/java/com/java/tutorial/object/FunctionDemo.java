package com.java.tutorial.object;

import com.java.tutorial.classtutorial.Car;

public class FunctionDemo {
    //void function does not return any value
    public void printInfo(){
        System.out.println("Hello, Selenium Master"+System.currentTimeMillis());
        System.out.println("Hello, This is test 1");
    }
    //return a value
    public int getArea(int length, int width){
        return length*width;
    }

    class Person{
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    //return a class
    public Person getPerson(String firstName, String lastName){
        Person p=new Person(firstName, lastName);
        System.out.println("First name: "+p.getFirstName());
        System.out.println("Last name: "+p.getLastName());
        return new Person(firstName, lastName);
    }
    public static void main(String[] args){
        FunctionDemo f=new FunctionDemo();
        f.printInfo();
        int area=f.getArea(5,6);
        System.out.println("Rectangle area is: "+area);
        f.getPerson("Selenium","Master");
        Person p1=f.getPerson("Perfect","Cube");
        System.out.println(p1.getFirstName());
        System.out.println(p1.getLastName());
    }

    public void carInfo(Car car){
        System.out.println(car.getBrand());
        System.out.println(car.getYear());
        System.out.println(car.getMake());
        System.out.println(car.getPrice());
    }

}
