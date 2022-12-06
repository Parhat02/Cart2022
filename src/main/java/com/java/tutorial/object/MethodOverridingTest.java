package com.java.tutorial.object;

public class MethodOverridingTest extends MethodOverriding{
    public void printTestInfo(){
        System.out.println("Test case Id: 2");
        System.out.println("Test case name: logout");
        System.out.println("Test case description: uses logout test");

    }
    public static void main(String[] args){
        MethodOverriding method=new MethodOverridingTest();
        method.printTestInfo();
        //use parent class
        MethodOverriding method1=new MethodOverriding();
        method1.printTestInfo();
    }
}
