package com.selenium.integration.cubecartjunit;

import com.google.errorprone.annotations.RestrictedApi;
import org.junit.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.rules.TestName;

import java.lang.annotation.Repeatable;

public class JunitTestDemo {
    @BeforeClass
    public static void setUp(){
        System.out.println("Before class will run only once in the JUnit framework before any test");
    }
    @Rule
    public TestName name=new TestName();
    @Before
    public void testBeginInformation(){
        System.out.println("Before annotation will execute before very test");
        System.out.println(name.getMethodName()+" started");
    }
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
    @RepeatedTest(3)
    @Test
    public void powerTest(){
        System.out.println("This is for testing a power of a number");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Ignore
    @Test
    public void additionTest(){
        System.out.println("This is addition test");
        Assert.assertTrue(2+3==6);
    }
    @After
    public void testEndInformation(){
        System.out.println("After annotation method will run after each test");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("After class will execute once only after all tests finished");
    }
}
