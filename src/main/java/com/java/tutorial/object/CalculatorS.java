package com.java.tutorial.object;

public class CalculatorS implements ScientificCalculator{
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

    }
}
