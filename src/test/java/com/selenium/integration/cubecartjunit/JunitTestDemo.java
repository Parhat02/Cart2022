package com.selenium.integration.cubecartjunit;

import org.junit.Assert;
import org.junit.Test;

public class JunitTestDemo {
    @Test
    public void squareRootTest(){
        System.out.println("This is for testing a square root");
        Assert.assertTrue(Math.sqrt(9)==3);
    }
    @Test
    public void compareStringTest(){
        System.out.println("This is for comparing two strings");
        String s1="Selenium";
        String s2="Selenium";
        Assert.assertEquals(s1,s2);
    }

}
