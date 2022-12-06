package com.java.tutorial.object;

public class PolymorphismClassY extends PolymorphismClassX{
    public void methodA(){
        System.out.println("This is method A of class Y");
    }

    public void methodB(){
        System.out.println("This is method B of class Y ");
    }
    String surName;
    public PolymorphismClassY() {
    }

    public PolymorphismClassY(String name) {
        super(name);
    }

    public PolymorphismClassY(String name, String surName) {
        super(name);
        this.surName = surName;
    }


    public static void main(String[] args) {
        PolymorphismClassX demo=new PolymorphismClassX("Ferhat");
        System.out.println(demo.name);
        PolymorphismClassX demo1=new PolymorphismClassY("Abduhabir","karluk");
        System.out.println(demo1.name);
        PolymorphismClassY demo2=new PolymorphismClassY("Nijat");
        System.out.println(demo2.name);
    }

}
