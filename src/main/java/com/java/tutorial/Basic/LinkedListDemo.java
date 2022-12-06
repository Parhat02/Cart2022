package com.java.tutorial.Basic;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class LinkedListDemo {
    public static void main(String[] args) {
        //A linked list is a leaner data structure where element is a separate object.
        LinkedList<String> employees=new LinkedList<String>();
        //The method creates a node and prepends it at the beginning of the list.
        employees.addFirst("Mike");
        employees.addFirst("Sam");
        employees.addLast("James");
        employees.addLast("Carol");
        employees.add("Mikal");
        employees.addFirst("Jam");
        //loop linked list
        for (String employee:employees){
            System.out.println(employee);
        }
        System.out.println("Number of the nodes  are "+employees.size());
        System.out.println("----use iterator for linked list----");
        ListIterator iterator=employees.listIterator();
        if (iterator.next().equals("Sam")){
            iterator.remove();
        }
        iterator.add("Selenium");
        iterator.add("Master");
        iterator=employees.listIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
        System.out.println();
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous()+",");
        }
        System.out.println();

        //Queue - First in first out logic
        //The LinkedList class implements the Queue interface
        Queue<Integer> customers=new LinkedList<Integer>();
        customers.add(1);
        customers.add(2);
        customers.add(3);
        //print queue
        System.out.println(customers.toString());
        //remove head
        customers.remove();
        System.out.println(customers.toString());
        //add another customer
        customers.add(4);
        System.out.println(customers.toString());
        //Get the head of the queue without removing it
        System.out.println(customers.peek());
        System.out.println(customers.toString());
        //Retrieves and removes the head of this queue
        System.out.println(customers.poll());
        //print final queue
        System.out.println(customers.toString());

        //Queue = String
        Queue<String> students=new LinkedList<String>();
        students.add("Salam");
        students.add("Amina");
        students.add("Mahire");
        students.add("Ali");
        students.add("Aynur");
        for (String student:students){
            System.out.println(student);
        }
        System.out.println(students.toString());
        students.remove();//automatically removes the first element in the queue
        System.out.println(students.toString());
        System.out.println(students.peek());
        System.out.println(students.toString());
        System.out.println(students.poll());
        System.out.println(students.toString());

        //Stack - last in first out logic
        Stack<String> bookStack=new Stack<String>();
        //add items\ to the stack
        bookStack.push("book1");
        bookStack.push("book2");
        bookStack.push("book3");
        //print stack
        System.out.println(bookStack.toString());
        //remove the top of the stack
        String top=bookStack.pop();
        System.out.println("The top book in the stack is: "+top);
        System.out.println(bookStack.toString());
        //get the top of the stack without removing it.
        String head=bookStack.peek();
        System.out.println("Current top book in the stack is: "+head);
        System.out.println(bookStack.toString());
        bookStack.push("new book");
        String topBook=bookStack.peek();
        System.out.println("The top book in the stack is: "+topBook);
        System.out.println(bookStack.search("book1"));
    }
}
