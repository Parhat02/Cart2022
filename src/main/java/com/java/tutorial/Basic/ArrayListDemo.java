package com.java.tutorial.Basic;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        //Create a new array list
        ArrayList<String> names=new ArrayList<String>();
        //add items
        names.add("Bob");
        names.add("Smith");
        names.add("Mike");
        names.add("Jordan");
        names.add(0,"lllll");
        names.add(2,"mmmmm");
        System.out.println(names.toString());
        //set 2nd item
        names.set(1,"Emily");
        //get total size
        System.out.println("Total items :"+names.size());
        //loop through items and print
        for (String name:names){
            System.out.println(name);
        }
        //remove first item and print
        names.remove(0);
        for (String name:names){
            System.out.println(name);
        }
        System.out.println(names.toString());
        //get specific item
        System.out.println("The second item is "+names.get(1));
        //Using iterator to print
        Iterator<String> namesIterator= names.iterator();
        while (namesIterator.hasNext()){
            System.out.println(namesIterator.next());
        }
        //convert array to array list
        Integer[] evenNumbers=new Integer[]{2,4,6,8,10,12};
        List<Integer> numberArrayList=new ArrayList<Integer>();
        numberArrayList= Arrays.asList(evenNumbers);
        for (int number:numberArrayList){
            System.out.println(number);
        }

        //Array list Advanced
        //Array list can grow and shrink as needed
        //to find sum and average of an array list
        Integer[] evenNumber1=new Integer[]{2,4,12,6,8,16,8,8,10,12,14};
        ArrayList<Integer> numberArrayList1=new ArrayList<Integer>();
        Collections.addAll(numberArrayList1,evenNumber1);//adds all elements of evenNumber1 to numberArrayList1
        double total=0;
        for (int number:numberArrayList1){
            total=total+number;
        }
        System.out.println("Total number sum is :"+total);
        System.out.println("Total items are :"+numberArrayList1.size());
        System.out.println("Average number is :"+total/numberArrayList1.size());
        //find match
        System.out.println("---find match example---");
        int i=8;
        int match=0;
        for (int number:numberArrayList1){
            if(number==i){
                match=++match;
            }
        }
        System.out.println("Total match is :"+match);
        if (match==0){
            System.out.println("No item is found with the value "+i);
        }
        //find max and min number
        System.out.println("----print max number----");
        int maxNumber=numberArrayList1.get(0);
        for (int j=1;j<numberArrayList1.size();++j)
        {
            int nextNumber=numberArrayList1.get(j);
            if (nextNumber>maxNumber)
                maxNumber=nextNumber;
        }
        System.out.println("Max number is "+maxNumber);
        System.out.println("---print min number---");
        int minNumber=numberArrayList1.get(0);
        for (int j=1;j<numberArrayList1.size();j++){
            int nextNumber=numberArrayList1.get(j);
            if (nextNumber<minNumber){
                minNumber=nextNumber;
            }
        }
        System.out.println("Min number is "+minNumber);
        //print array list
        System.out.println(numberArrayList1.toString());

        //Dividing a list
        List<Integer> numberList1=numberArrayList1.subList(0,5);
        List<Integer> numberList2=numberArrayList1.subList(5,numberArrayList1.size());
        System.out.println(numberList1.toString());
        System.out.println(numberList2.toString());
        System.out.println(numberList1);
    }
}
