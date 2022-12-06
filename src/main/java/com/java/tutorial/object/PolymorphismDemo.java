package com.java.tutorial.object;

public class PolymorphismDemo {
    public static void main(String[] args){
        PolymorphismClassX classX=new PolymorphismClassX();//This only can access to the methods from parent class
        PolymorphismClassY classY=new PolymorphismClassY();//This can access to all methods from parent and child class
        classX.methodA();
        classY.methodA();
        classY.methodB();

        PolymorphismClassX classX1=new PolymorphismClassX();
        PolymorphismClassX classY1=new PolymorphismClassY();//This only can access to the methods which are common to parent and child, and all methods from parent
        classX1.methodA();
        classY1.methodA();
    }
}
