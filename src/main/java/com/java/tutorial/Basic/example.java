package com.java.tutorial.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class example {
        public static void main(String[] args)
        {
            Scanner input=new Scanner(System.in);
            System.out.println("Enter a line of text: ");
            List listOfNames=new ArrayList<>();
            while (input.hasNext()){
                String a = input.next();
                listOfNames.add(a);
                System.out.println(a);
                System.out.println(listOfNames);
            }
            input.close();
            System.out.println(listOfNames);
        }

}
