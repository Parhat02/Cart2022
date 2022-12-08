package com.selenium.integration.cubecartjunit;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitOrderDemo {
    @Test
    public void aTest(){
        Assert.assertTrue("United Coder".equalsIgnoreCase("united coder"));
    }
    @Test
    public void bTest(){
        Assert.assertEquals((long) Math.pow(10,2),100);
    }
    @Test
    public void dTest(){
        Assert.assertTrue(Math.sqrt(4)>0);
    }
    @Test
    public void clientAddTest(){
        Assert.assertTrue("Client is added".length()>10);
    }
}