package com.java.tutorial.configutility.classtutorial;

public class GoogleMultiBrowserDemo {
    public static void main(String[] args) {
        GoogleMultiThreadSearch browser1=new GoogleMultiThreadSearch("NewYork");
        GoogleMultiThreadSearch browser2=new GoogleMultiThreadSearch("Washington");
        GoogleMultiThreadSearch browser3=new GoogleMultiThreadSearch("Boston");
        //define each thread
        Thread thread1=new Thread(browser1);
        Thread thread2=new Thread(browser2);
        Thread thread3=new Thread(browser3);
        //start the thread
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
