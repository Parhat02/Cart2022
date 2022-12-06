package com.java.tutorial.Basic;

import java.util.Scanner;

public class InputExample {
    public static void main(String[] args)
    {
        //define a scanner object
        Scanner inputName=new Scanner(System.in);
        System.out.println("What is your name?: ");
        String nameValue=inputName.nextLine();
        System.out.println("Your name is "+nameValue);
        System.out.println(String.format("Your name is %s",nameValue));

        //define another scanner object
        System.out.println("What is the value of the expression 5*4 ? :");
        Scanner inputValue=new Scanner(System.in);
        int value=inputValue.nextInt();
        System.out.println("The value of 5*4 is "+value);

        System.out.println("What is your age?: ");
        Scanner input=new Scanner(System.in);
        int age=input.nextInt();
        System.out.println(String.format("Your name is %s and You are %s years old.",nameValue,age));

        System.out.println("Example 1 for conditional statement.");
        Scanner inputAmount=new Scanner(System.in);
        System.out.println("Enter the amount to withdraw :");
        int withdrawAmount=inputAmount.nextInt();
        System.out.println("You entered : " +withdrawAmount);
        int accountBalance=10000;
        if (accountBalance>withdrawAmount) {
            accountBalance = accountBalance - withdrawAmount;
            System.out.println("Your current account balance is :" + accountBalance);
        } else{
            System.out.println("Please enter an amount less than your account balance");
            System.out.println("Your account balance is " +accountBalance);
        }

        System.out.println("Example 2 for conditional statement.");
        int accountBalance2=100000;
        System.out.println("Your account balance is :"+accountBalance2);
        Scanner inputAmount2=new Scanner(System.in);
        System.out.println("Enter an amount to withdraw :");
        int withdrawAmount2=inputAmount2.nextInt();
        System.out.println("You entered : "+withdrawAmount2);
        int finalBalance=accountBalance2-withdrawAmount2;
        accountBalance2=withdrawAmount2<accountBalance2? finalBalance:accountBalance2;
        System.out.println("Your account balance is :"+accountBalance2);

        //Input Example3
        Scanner input1=new Scanner(System.in);
        System.out.println("What is your name: ");
        String name1=input1.next();
        System.out.println("What is your age : ");
        int age1=input1.nextInt();
        System.out.println("Your name is "+name1);
        System.out.println("Your age is "+age1);
    }
}
