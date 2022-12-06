package com.java.tutorial.Exercises;

import java.util.*;

public class CollectionData {
    public static void main(String[] args) {
        //List exercise
        List<Integer> randomNumbers=new ArrayList<Integer>();
        Random random=new Random();
        int evenN=0;
        int oddN=0;
        int divided3=0;
        for (int i=0;i<30;i++){
            int randomNumber= random.nextInt(100);
            randomNumbers.add(randomNumber);
            if (randomNumber%2==0)
                evenN++;
            if (randomNumber%2!=0)
                oddN++;
            if (randomNumber%3==0)
                divided3++;
        }
        System.out.println(randomNumbers.toString());
        System.out.println("Total count of even numbers : " +evenN);
        System.out.println("Total count of odd numbers : " +oddN);
        System.out.println("Total count of numbers which are divided by 3 : " +divided3);
        int sum=0;
        for (int e:randomNumbers){
            sum=sum+e;
        }
        int average=sum/randomNumbers.size();
        System.out.println("Sum of the numbers : "+sum+", Average of the numbers : "+average);
        Collections.sort(randomNumbers);
        System.out.println(randomNumbers.toString());
        Collections.sort(randomNumbers,Collections.reverseOrder());
        System.out.println(randomNumbers);
        Collections.reverse(randomNumbers);
        System.out.println(randomNumbers.toString());

        //Map exercise
        Map<String,String> states=new HashMap<>();
        states.put("MD", "Maryland");
        states.put("VA", "Virginia");
        states.put("NY", "New York");
        System.out.println(states.size());
        Set<String> keys=states.keySet();
        for (String key:keys){
            System.out.println("Key is : "+key+", Value is : "+states.get(key));
        }
        //Collection Demo
        int[] numbers=new int[]{3,2,5,6,3,6,10,20,1,25,30,50};
        Set<Integer> set1=new TreeSet<Integer>();
        for (int i=0;i<numbers.length;i++){
            set1.add(numbers[i]);
        }
        System.out.println("Min value is "+Collections.min(set1));
        System.out.println("Max value is "+Collections.max(set1));
        //use collection to sort string
        String[] students=new String[]{"Mike", "Jason","Bob","Emily","Adam"};
        Set<String> set2=new TreeSet<String>();
        for (String student:students){
            set2.add(student);
        }
        System.out.println("Min alphabet name is "+Collections.min(set2,String.CASE_INSENSITIVE_ORDER));
        System.out.println("Max alphabet name is "+Collections.max(set2,String.CASE_INSENSITIVE_ORDER));
    }
}
