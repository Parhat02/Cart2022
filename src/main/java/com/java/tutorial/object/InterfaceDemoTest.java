package com.java.tutorial.object;

public class InterfaceDemoTest implements InterfaceDemo, ScientificCalculator{
    @Override
    public double addTowNumbers(double a, double b) {
        double c=a+b;
        System.out.println("Sum the two numbers is: "+c);
        return c;
    }

    @Override
    public double multiplyTowNumbers(double a, double b) {
        double c=a*b;
        return c;
    }

    @Override
    public float divideTwoNumbers(double a, double b) {
        if(b==0){
            System.out.println("Denominator cannot be zero");
            return 0;
        }else {
            float c=(float) (a/b);
            return c;
        }
    }

    @Override
    public double subtractTowNumbers(double a, double b) {
        double c=a-b;
        return c;
    }

    @Override
    public double calculatePower(int base, int power) {
        return Math.pow(base,power);
    }

    @Override
    public double calculateSquareRoot(long l1) {
        return Math.sqrt(l1);
    }

    @Override
    public double calculateAbsoluteValue(int x) {
        return Math.abs(x);
    }

    @Override
    public void printInfo(String info) {
        System.out.println(info);
    }

    public static void main(String[] args){
        InterfaceDemoTest demo=new InterfaceDemoTest();
        System.out.println(demo.divideTwoNumbers(10,2));
        System.out.println(demo.addTowNumbers(5,6));
        System.out.println(demo.multiplyTowNumbers(10,30));
        System.out.println(demo.subtractTowNumbers(100,200));
        System.out.println(demo.calculatePower(3,3));
        System.out.println(demo.calculateAbsoluteValue(-7));
        System.out.println(demo.calculateSquareRoot(81));
        demo.printInfo(version);
    }
}
