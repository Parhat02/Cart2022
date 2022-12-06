package com.java.tutorial.uiautomation;

import com.java.tutorial.Exercises.Customer;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.java.tutorial.uiautomation.CustomerInfo.phoneNumber;

public class CubeCartDemo extends CubeCartAutoMethod{
    public static void main(String[] args) {
        openBrowser();
        login();
        CustomerInfo customerInfo=new CustomerInfo();
//        for (Customer customer: customerInfo.customers){
//            addCustomer(customer);
//        }
//        for (Customer customer: customerInfo.customers){
//            deleteCustomer(customer);
//        }
        //updateCustomer(customerInfo.customer4);
        //logout();

//        for (int i=0;i<5;i++){
//            addCustomer(customerInfo.customer3);
//        }
//        Random random=new Random();
//        DateTime time=new DateTime();
//        Customer customer1=new Customer("Mr","Abdullah"+System.currentTimeMillis(),"Karluk"+System.currentTimeMillis(),
//                "abdullah"+random.nextInt(20)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
//                "Registered Customer","Yes");
//        Customer customer2=new Customer("Mr","Abdullah"+System.currentTimeMillis(),"Karluk"+System.currentTimeMillis(),
//                "abdullah"+random.nextInt(20)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
//                "Registered Customer","Yes");
//        Customer customer3=new Customer("Mr","Abdullah"+time,"Karluk"+time,
//                "abdullah"+random.nextInt(20)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
//                "Registered Customer","Yes");
//        Customer customer4=new Customer("Mr","Abdullah"+time,"Karluk"+time,
//                "abdullah"+random.nextInt(20)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
//                "Registered Customer","Yes");
//        List<Customer> customers=new ArrayList<>(Arrays.asList(customer1,customer2,customer3,customer4));
//        for (Customer customer:customers){
//            addCustomer(customer);
//        }
    }
}
