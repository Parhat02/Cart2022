package com.java.tutorial.Exercises;

import java.util.Scanner;

public class Address {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name? :");
        String name = input.nextLine();
        System.out.println("What is your house street address? :");
        String address = input.nextLine();
        System.out.println("What is the name of the city? :");
        String city = input.nextLine();
        System.out.println("What is the state? :");
        String state = input.nextLine();
        String fullAddress = name + " " + address + " " + city + " " + state;
        System.out.println(fullAddress);

    }
}
