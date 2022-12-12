package com.java.tutorial.classtutorial;

import java.util.Date;

public class GreetingPrinting implements Runnable{
    private String message;
    public GreetingPrinting(String message){
        this.message=message;
    }

    public GreetingPrinting() {
    }

    @Override
    public void run() {
        for (int i=0;i<=5;i++){
            Date now=new Date();
            System.out.println(now+" "+message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
