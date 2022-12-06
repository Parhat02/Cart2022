package com.java.tutorial.uiautomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductInfo {

    public static String productCode(){
        Random random=new Random();
        String c="";
        for(int i=0;i<4;i++){
            c=c+String.valueOf(random.nextInt(10));
        }
        return c;

    }

    ProductObject product1=new ProductObject("Ipad2222","Apple","New",productCode(),
            "500","20","15","1","50","5","1500","Standard Tax");
    ProductObject product2=new ProductObject("Iphone142222","Apple","New",productCode(),
            "300","15","10","1","50","5","1400","Standard Tax");
    ProductObject product3=new ProductObject("EarBuds2222","Dreamhouse","New",productCode(),
            "100","3","2","1","50","5","400","Standard Tax");
    ProductObject product4=new ProductObject("PowerBank2222","Kadirdan","New",productCode(),
            "800","20","8","2","50","5","100","Standard Tax");

    List<ProductObject> products=new ArrayList<>(Arrays.asList(product1,product2,product3,product4));
}
