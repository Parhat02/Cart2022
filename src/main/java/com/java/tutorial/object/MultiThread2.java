package com.java.tutorial.object;

public class MultiThread2 extends Thread{
    public void run(){
        System.out.println("Program is running ...");
    }

    public static void main(String[] args) {
        MultiThread2 thread1=new MultiThread2();
        MultiThread2 thread2=new MultiThread2();
        System.out.println("Thread1 name: "+thread1.getName());
        System.out.println("Thread2 name: "+thread2.getName());
        System.out.println("Thread1 Id: "+thread1.getId());
        System.out.println("Thread2 Id: "+thread2.getId());
        thread1.start();
        thread2.start();
    }
}
