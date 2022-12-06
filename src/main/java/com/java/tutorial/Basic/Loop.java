package com.java.tutorial.Basic;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args){
        //Example 1
        /*Scanner inputBalance=new Scanner(System.in);
        System.out.println("What is your current balance :");
        double balance=inputBalance.nextInt();
        Scanner inputSalary=new Scanner(System.in);
        System.out.println("What is your annual salary :");
        double salary=inputSalary.nextInt();
        Scanner inputTarget=new Scanner(System.in);
        System.out.println("What is your target balance :");
        double targetBalance=inputTarget.nextInt();
        int years=0;
        int rate=5;
        while (balance<targetBalance){
            years ++;
            double interest=balance*rate/100;
            balance=balance + salary + interest;
            System.out.println("Year "+years+" your balance is "+balance);
        }
        int d=(int)balance;
        System.out.println("Final balance is "+d);
        System.out.println("Total years is "+years);

        //Example 2
        int i=0;
        int sum=0;
        while (i<10){
            i++;
            sum=sum+i;
            System.out.println("i="+i+" sum="+sum);
        }
        System.out.println("Sum of number 0 to 10 is " +sum);

        //do while loop example 1
        double balance1=1000;
        double targetBalance1=2000;
        int year1=0;
        int rate1=5;
        do {
            year1++;
            double interest1=balance1*rate/100;
            balance1=balance1 + interest1;
            System.out.println("Years: "+year1+"balance: "+balance1);
        }
        while (balance1<targetBalance1);
        System.out.println("Final balance is :"+balance1);
        System.out.println("Total years : "+year1);

        //do while loop example 2
        int i2=100;
        int n=0;
        int j=0;
        do {
            n++;
            i2=i2/2;
            j=i2;
            System.out.println("j="+j);
        }
        while (j>1);
        System.out.println(String.format("Divide number 100 by %d times until the number is less then or equal to 1",n));
*/

        //for loop
/*        int sum1=0;
        for (int i3=0;i3<=10;i3++){
            sum1=sum1+i3;
            if (i3<7)
                continue;
            System.out.println("i3="+i3+" sum1="+sum1);
        }

        int rate3=5;
        double balance3=1000;
        int year3=10;
        for (int i4=1;i4<=year3;i4++){
            double interest3=balance3*rate3/100;
            balance3=balance3 + interest3;
        }
        System.out.println("Final balance is "+balance3);

        //Nested for loop
        for (int a=1;a<=4;a++){
            for(int b=1;b<=a;b++){
                System.out.print("*");
            }
            System.out.println("K");
        }

        for (int c=1;c<=3;c++){
            for (int d=1;d<=3;d++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        for (int e=4;e>=1;e--){
            for (int f=1;f<=e;f++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        //infinite loop
        Scanner inputLevel=new Scanner(System.in);
        System.out.println("Enter the number of the level :");
        int level=inputLevel.nextInt();
        for(int g=1;;g++){
            for(int h=1;h<=g;h++){
                System.out.print("*");
            }
            System.out.println(" ");
            if (g==level){
                break;
            }
        }*/

        //Diamond shape
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a number :");
        int a=input.nextInt();
        for (int e=0;e<a;e++) {
            for (int i = e; i < a; i++)
                System.out.print("  ");
            for (int j =0; j <=e*2; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
        for (int e=0;e<=a*2;e++)
            System.out.print("* ");
        System.out.println("");
        for (int e=a;e>0;e--){
            for (int i =a; i>e-1; i--)
                System.out.print("  ");
            for (int j =e*2; j >=2; j--){
                System.out.print("* ");
            }
            System.out.println("");
        }
        System.out.println("0000000000000000000000000");
        int b=0;
        for (int e=a;e>=0;e-=2){
            for (int i=0;i<=e;i++)
                System.out.print(" ");
            for (int k=0;k<=b*2;k++)
                System.out.print("* ");
            b++;
            System.out.println("");
        }
        int c=a-1;
        int d=a-2;
        for(int e=0;e<=a;e+=2){
            for (int i=e+2;i>=0;i--)
                System.out.print(" ");
            if (a%2==0){
                for (int k=c;k>0;k--)
                    System.out.print("* ");
                System.out.println("");
                c-=2;
            }
            else{
                for (int k=d;k>0;k--)
                    System.out.print(" *");
                System.out.println("");
                d-=2;
            }
        }
        System.out.println("0000000000000000000000000");
        int count=0;
        for (int e=0;e<=2*a;e++){
            for (int i=count;i<=a-1;i++){
                System.out.print("  ");
            }
            for (int j=0;j<=count*2;j++){
                System.out.print("* ");
            }
            System.out.println("");
            if (e<a)
                count++;
            else
                count--;
        }

    }
}
