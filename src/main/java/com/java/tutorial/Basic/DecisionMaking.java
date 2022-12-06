package com.java.tutorial.Basic;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class DecisionMaking {
    public static void main(String[] args){
/*        //if else-if else statement
        Scanner scoreValue=new Scanner(System.in);
        System.out.println("Enter your score :");
        int score=scoreValue.nextInt();
        if (score>=90)
            System.out.println("Your grade is A");
        else if (score>=80&&score<90)
            System.out.println("Your grade is B");
        else if (score>=70&&score<80)
            System.out.println("Your grade is C");
        else if (score>=60&&score<70) {
            System.out.println("Your grade is D");
        }
        else
            System.out.println("Your grade is F, and You failed");

        //switch statement
        Scanner inputMonth=new Scanner(System.in);
        System.out.println("Enter a month :");
        int month=inputMonth.nextInt();
        String monthString;
        switch(month){
            case 1: monthString ="January";
                break;
            case 2: monthString="February";
                break;
            case 3: monthString="March";
                break;
            case 4: monthString="April";
                break;
            case 5: monthString="May";
                break;
            case 6: monthString="June";
                break;
            case 7: monthString="July";
                break;
            case 8: monthString="August";
                break;
            case 9: monthString="September";
                break;
            case 10: monthString="October";
                break;
            case 11: monthString="November";
                break;
            case 12: monthString="December";
                break;
            default: monthString="Invalid month";
                break;
        }
        System.out.println("It is "+monthString);


        Scanner inputGrade=new Scanner(System.in);
        System.out.println("Enter your grade letter :");
        char gradeLetter=inputGrade.next().charAt(0);
        System.out.println("You entered :"+gradeLetter);
        gradeLetter=Character.toUpperCase(gradeLetter);
        switch(gradeLetter){
            case 'A':
                System.out.println("Your score is between 90 - 100");
                break;
            case 'B':
                System.out.println("Your score is between 80 - 90");
                break;
            case 'C':
                System.out.println("Your score is between 70 - 80");
                break;
            case 'D':
                System.out.println("Your score is between 60 - 70");
                break;
            case 'F':
                System.out.println("Your score is lower than 60");
                break;
            default:
                System.out.println("Please enter a proper grade letter : A B C D F");
                break;
        }

        switch (gradeLetter){
            case 'A':
            case 'B':
            case 'C':
                System.out.println("well done!");
                System.out.println("You have a passing score");
                break;
            case 'D':
                System.out.println("You barely passed, you should work harder");
                break;
            case 'F':
                System.out.println("Your grade is less than 60");
                System.out.println("You failed !");
                break;
            default:
                System.out.println("Please enter a proper grade letter : A B C D F");
                break;
        }

        //Nested if statement
        Boolean a=true;
        while(a){
            Scanner inputNumber=new Scanner(System.in);
            System.out.println("Enter a number :");
            String number=inputNumber.nextLine();
            if (StringUtils.isNumeric(number)){
                int n=Integer.parseInt(number);
                if (n>0){
                    if (n%2==0){
                        System.out.println("it is an even number");
                    }
                    else{
                        System.out.println("It is an odd number");
                    }
                    System.out.printf("You entered %d",n);
                    a=false;
                }
                else{
                    System.out.println("Please enter a number greater than 0.");
                }
            }
            else{
                System.out.println("You should enter a Number.");
            }

        }*/

        //Pin number
        int pin=1234;
        int balance3=5000000;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter you pin number :");
        String pinNumber=input.nextLine();
        if (StringUtils.isNumeric(pinNumber) && String.valueOf(pin).length()==4){
            int pinNumber1=Integer.parseInt(pinNumber);
            if (pinNumber1==pin){
                System.out.println("Select the the menu: Transfer money, withdraw money, deposit money ");
                String selectMenu=input.nextLine();
                if (selectMenu.equalsIgnoreCase("withdraw money")){
                    System.out.println("Enter the withdraw amount");
                    int withdrawAmount=input.nextInt();
                    if (withdrawAmount<=balance3){
                        System.out.println("Take your money");
                        System.out.println("Your current balance is "+(balance3-withdrawAmount));
                    }
                    else{
                        System.out.println("Insufficient amount");
                        System.out.println("Withdraw amount is greater than your balance.");
                    }
                }
                else if (selectMenu.equalsIgnoreCase("deposit money")){
                    System.out.println("Put your money into the machine: ");
                    int money=input.nextInt();
                    System.out.printf("You have deposited %d amount", money);
                    System.out.printf("Your current balance is %d",balance3+money);
                } else if (selectMenu.equalsIgnoreCase("Transfer money")) {
                    System.out.println("You cannot transfer money right now");
                }
                else {
                    System.out.println("Select from the menu.");
                }
            }
            else{
                System.out.println("You Entered wrong pin!!!");
                System.out.println("Try again");
            }
        }
        else {
            System.out.println("You should enter four digit number!!!");
        }
    }
}
