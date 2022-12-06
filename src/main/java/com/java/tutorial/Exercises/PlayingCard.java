package com.java.tutorial.Exercises;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class PlayingCard {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the notation of your card :");
        String n= input.nextLine();
        if (StringUtils.isNumeric(n)){
            switch (Integer.parseInt(n)){
                case 2 : case 3 : case 4: case 5: case 6: case 7: case 8: case 9: case 10:
                    System.out.println("Card Value");
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }else{
            n=n.toUpperCase();
            //char b=n.charAt(0);
            switch (n){
                case "A":
                    System.out.println("Ace");
                    break;
                case "J":
                    System.out.println("Jack");
                    break;
                case "Q":
                    System.out.println("Queen");
                    break;
                case "K":
                    System.out.println("King");
                    break;
                case "D":
                    System.out.println("Diamond");
                    break;
                case"H":
                    System.out.println("Heart");
                    break;
                case"S":
                    System.out.println("Spade");
                    break;
                case"C":
                    System.out.println("Cube");
                    break;
                default:
                    System.out.println("Invalid Character");
            }
        }
    }
}
