package com.java.tutorial.jsonfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaDemo1 {
    public static void main(String[] args) {
        List<Integer> n=new ArrayList<>();
        for (int i=0;i<100;i++){
            Random random=new Random();
            n.add(random.nextInt(100));
        }
        //use lambda expression
        List<Integer> evenNumbers=n.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<Integer> myNumber= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        myNumber.forEach(x->{
            if (x%2==0) System.out.print(x+" ");
        });

    }
}
