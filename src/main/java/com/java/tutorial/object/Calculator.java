package com.java.tutorial.object;

public class Calculator {
    //method for adding two numbers
    public int addTwoNumbers(int i1, int i2){
        int sum=i1+i2;
        System.out.println(i1+"+"+i2+"="+sum);
        return sum;
    }
    //add many numbers
    public long addNumbers(long... numbers){ //"..." means multiple arguments
        long total=0;
        for (long number:numbers){
            total=total+number;
        }
        System.out.println("Total sum :"+total);
        return total;
    }
    //subtract two numbers
    public long subtractNumbers(long l1, long l2){
        long result=l1-l2;
        System.out.println(l1+"-"+l2+"="+result);
        return result;
    }
    //divide two numbers
    public double divideNumbers(double numerator, double denominator){
        if (denominator==0){
            System.out.println("You cannot divide a number by zero!");
            return 0;
        }else{
            double result=numerator/denominator;
            System.out.println(numerator+"/"+denominator+"="+result);
            return result;
        }
    }
    //multiply two numbers
    public long multiplyTwoNumbers(long x, long y){
        long z=x*y;
        System.out.println(x+"*"+y+"="+z);
        return z;
    }
    public void printInfo(){
        System.out.println("Thanks for using the simple calculator");
        System.out.println("Hope you enjoy using it");
    }
    public void printSquareRoot(double number){
        double sqr=Math.sqrt(number);
        System.out.println("Square root of "+number+" is "+sqr);
    }

    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        calculator.addNumbers(9,10,3,6,89,45,22);
        calculator.divideNumbers(45,3);
        calculator.addTwoNumbers(65,23);
        System.out.println(calculator.multiplyTwoNumbers(15,7));
        calculator.subtractNumbers(98,23);
        calculator.printSquareRoot(81);

        long s=calculator.multiplyTwoNumbers(5,6);
        System.out.println(s);
    }
}
