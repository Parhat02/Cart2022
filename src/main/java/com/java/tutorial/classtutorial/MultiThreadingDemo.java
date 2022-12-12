package com.java.tutorial.classtutorial;

public class MultiThreadingDemo {
    public static void main(String[] args) {
        //I want to print four messages on the screen in parallel
        GreetingPrinting g1=new GreetingPrinting("Hello Test Automation");
        GreetingPrinting g2=new GreetingPrinting("Java Multi Threading is fun");
        GreetingPrinting g3=new GreetingPrinting("United Coder SDET Learning");
        GreetingPrinting g4=new GreetingPrinting("We learn a lot about Java coding");
        //define thread
        Thread thread1=new Thread(g1);
        printThreadInfo(thread1);
        Thread thread2=new Thread(g2);
        printThreadInfo(thread2);
        Thread thread3=new Thread(g3);
        printThreadInfo(thread3);
        Thread thread4=new Thread(g4);
        printThreadInfo(thread4);
        //start the thread
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    public static void printThreadInfo(Thread thread){
        System.out.println("Thread ID: "+thread.getId());
        System.out.println("Thread Name: "+thread.getName());
    }

}
