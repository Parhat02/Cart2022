package com.java.tutorial.object;

public class MultiThread1 implements Runnable{
    //The Runnable interface defines a single method, run, meant to contain the code executed in the thread
    public void run(){
        System.out.println("Hello, this is a thread");
        System.out.println("Hi, This is a thread example");
    }

    public static void main(String[] args) {
        MultiThread1 demo=new MultiThread1();
        Thread thread=new Thread(demo);
        thread.start();

    }
}
