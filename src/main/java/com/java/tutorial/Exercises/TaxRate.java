package com.java.tutorial.Exercises;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class TaxRate {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("What is your annual salary? :");
        String salary=input.nextLine();

        if (StringUtils.isNumeric(salary)){
            double salary1=Double.parseDouble(salary);
            System.out.println("What is your tax filing status? (Single or Married):");
            String status=input.nextLine();
            if (status.equalsIgnoreCase("single")){
                if (salary1>32000){
                    double tax=32000*0.1 + (salary1-32000)*0.25;
                    System.out.println("Your annual salary is :" +salary1+", Your tax filing status is "+status+"," +
                            " your tax percentage are 10% for 32000 and 25% for over 32000, your total tax is "+tax);
                }else{
                    double tax=salary1*0.1;
                    System.out.println("Your annual salary is :" +salary1+", Your tax filing status is "+status+"," +
                            " your tax percentage are 10%, your total tax is "+tax);
                }
            }else {
                if (status.equalsIgnoreCase("married")){
                    if (salary1>64000){
                        double tax=64000*0.1 + (salary1-64000)*0.25;
                        System.out.println("Your annual salary is :" +salary1+", Your tax filing status is "+status+"," +
                                " your tax percentage are 10% for 64000 and 25% for over 64000, your total tax is "+tax);
                    }else {
                        double tax=salary1*0.1;
                        System.out.println("Your annual salary is :" +salary1+", Your tax filing status is "+status+"," +
                                " your tax percentage are 10%, your total tax is "+tax);
                    }
                }
                else{
                    System.out.println("You should write single or married");
                }
            }
        }else
            System.out.println("You should enter valid numbers for your salary!!!");
    }
}
