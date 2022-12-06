package com.java.tutorial.Exercises;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MathGame {
    public static void main(String[] args) {
        List<String> questions=new ArrayList<>();
        questions.add("x=10, y=10, What is the sum of x and y? ");
        questions.add("x=15, y=20, What is the sum of x and y? ");
        questions.add("x=25, y=30, What is the sum of x and y? ");
        int point=0;
        Scanner ans=new Scanner(System.in);
        for (String question:questions){
            System.out.println(question);
            StopWatch watch=new StopWatch();
            watch.start();
            System.out.println("What is your answer :");
            int answer= ans.nextInt();
            if (watch.getTime(TimeUnit.SECONDS)<=10 && answer==20){
                point++;
                System.out.println("You answered right");
            } else if (watch.getTime(TimeUnit.SECONDS)<=10 && answer==35) {
                point++;
                System.out.println("You answered right");
            } else if (watch.getTime(TimeUnit.SECONDS)<=10 && answer==55) {
                point++;
                System.out.println("You answered right");
            }else {
                point--;
                System.out.println("You answered wrong");
            }
        }
        System.out.println("Total points : " +point);
        if (point>=2){
            System.out.println("You win the game");
        }else
            System.out.println("You lost the game");
    }
}
