package com.java.tutorial.uiautomation;

import com.java.tutorial.Exercises.Customer;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerInfo {

    public static String phoneNumber(){
        Random random=new Random();
        String c="";
        for (int i=0;i<11;i++){
            c=c+String.valueOf(random.nextInt(10));
        }
        return c;
    }
    Date time=new Date();
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-hh-mm-sss");
    String date= format.format(time);
    Random random=new Random();
    Customer customer1=new Customer("Mr","Abdullah"+System.currentTimeMillis(),"Karluk"+System.currentTimeMillis(),
            "abdullah"+random.nextInt(100)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
            "Registered Customer","Yes");
    Customer customer2=new Customer("Mr","Abdullah"+System.currentTimeMillis(),"Karluk"+System.currentTimeMillis(),
            "abdullah"+random.nextInt(100)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
            "Registered Customer","Yes");
    Customer customer3=new Customer("Mr","Abdullah"+time,"Karluk"+date,
            "abdullah"+random.nextInt(100)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
            "Registered Customer","Yes");
    Customer customer4=new Customer("Mr","Abdullah"+time,"Karluk"+date,
            "abdullah"+random.nextInt(100)+"@gmail.com",phoneNumber(),"1122334455","1122334455",null,
            "Registered Customer","No");

    List<Customer> customers=new ArrayList<>(Arrays.asList(customer1,customer2,customer3,customer4));

}
