package com.java.tutorial.Exercises;

public class ObjectInfo {
    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setTitle("Mr"); customer.setFirstName("Ferhat"); customer.setLastName("Dursun");
        customer.setPhoneNumber("536056593599");
        Category category=new Category();
        category.setName("Cap"); category.setStatus("new"); category.setVisible(true);

        System.out.println(customer);
        System.out.println(category);
    }

}
