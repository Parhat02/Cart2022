package com.java.tutorial.object;

public class InnerClass {
    //Inner classes are defined inside the body of another class(known as outer class)
    private String variable="Test Automation";

    //define inner class
    //inner classes can be abstract, final, public protected, private, static
    class InnerClassA{
        public void method1(){
            System.out.println("This is method of Inner Class A");
        }
    }

    public void innerInstance(){
        InnerClassA innerClassA=new InnerClassA();
        innerClassA.method1();
    }
    //define a static inner class
    static class InnerClassB{
        public void method3(){
            System.out.println("This is method of static inner class B");
        }
    }

    public static void main(String[] args) {
        InnerClass demo=new InnerClass();
        System.out.println(demo.variable);
        demo.innerInstance();
        //A static nested class can be instantiated like this
        InnerClass.InnerClassB classB=new InnerClass.InnerClassB();
        classB.method3();
        InnerClassB innerClassB=new InnerClassB();
        innerClassB.method3();
        InnerClass.InnerClassA classA=new InnerClass().new InnerClassA();
        classA.method1();
    }
}
