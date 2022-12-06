package com.java.tutorial.Basic;

import java.util.*;

public class SetsDemo {
    public static void main(String[] args) {
        //Set is unordered collection
        //Set models the mathematical set abstraction
        //A set is Collection that cannot contain duplicate elements
        //Set has its implementation in various classes like HashSet, TreeSet, LinkedHashSet
        Set<String> states=new HashSet<String>();//A HashSet is a set where the elements are not sorted or ordered.
        states.add("Maryland");
        states.add("Washington");
        states.add("Virginia");
        states.add("Ohio");
        states.add("New York");
        boolean s=states.add("New York");
        System.out.println(s);
        String[] array=states.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
        System.out.println("Set size is "+states.size());
        //iterate set
        Iterator<String> iterator= states.iterator();
        while (iterator.hasNext()){
            String state= iterator.next();
            System.out.println(state);
        }
        System.out.println("----For loop to print-----");
        //using for loop to print
        for (String state:states){
            System.out.println(state);
        }

        //ArrayList, sets are collections
        //use collections to find min and max numbers
        int[] numbers=new int[]{3,2,5,3,6,10,7,11,8,4,9,20,32,27,5,45,50,37};
        Set<Integer> set1=new TreeSet<Integer>();//A TreeSet is a set where the elements are sorted.
        for (int i=0;i< numbers.length;i++){
            set1.add(numbers[i]);
        }
        for (int i:set1){
            System.out.print(i+",");
        }
        System.out.println("");
        System.out.println("Min value is "+ Collections.min(set1));
        System.out.println("Max value is "+ Collections.max(set1));

        //use collections to sort string
        String[] students=new String[]{"Mike","Jason","Bob","Emily","Adam"};
        Set<String> set2=new TreeSet<String>();
        for (int i=0;i<students.length;++i){
            set2.add(students[i]);
        }
        Iterator<String> iterator1= set2.iterator();
        while (iterator1.hasNext()){
            String name=iterator1.next();
            System.out.print(name+",");
        }
        System.out.println("");
        System.out.println("Min alphabet name is "+Collections.min(set2,String.CASE_INSENSITIVE_ORDER));
        System.out.println("Max alphabet name is "+Collections.max(set2,String.CASE_INSENSITIVE_ORDER));


        //Vector implements a dynamic array
        Vector<String> fruits=new Vector<String>(3);//Initial Capacity
        //adding elements to a vector
        fruits.addElement("Apple");
        fruits.addElement("Peach");
        fruits.addElement("Mango");
        System.out.println("Size is "+fruits.size());
        System.out.println("Capacity is "+fruits.capacity());
        //add more element
        fruits.addElement("Fruits4");
        fruits.addElement("Fruits5");
        fruits.addElement("Fruits6");
        fruits.remove(3);
        System.out.println("Size is "+fruits.size());
        System.out.println("The Capacity is "+fruits.capacity());
        //display vector elements with enumeration
        Enumeration fruit=fruits.elements();
        System.out.println("Fruits :");
        while (fruit.hasMoreElements()){//This look through elements to access each element in the vector
            System.out.println(fruit.nextElement());
        }


        //A map(dictionary) is a datatype that keeps association between keys and values
        //construct a Map(Dictionary)
        Map<String,String> sites=new HashMap<String,String>();
        sites.put("yahoo","www.yahoo.com");
        sites.put("google", "www.google.com");
        sites.put("youtube", "www.youtube.com");
        sites.put("cnn", "www.cnn.com");
        //print the size of the dictionary
        System.out.println("Total sites in the dictionary is "+sites.size());
        //print all keys
        Set<String> setKeys=sites.keySet();
        for (String i:setKeys){
            String url=sites.get(i);
            System.out.println("Site: "+i+" URL: "+url);
        }

    }
}
