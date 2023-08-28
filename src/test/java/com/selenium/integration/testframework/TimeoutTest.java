package com.selenium.integration.testframework;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TimeoutTest {
    @Test(timeOut = 7000)
    public void timeoutTest(){
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        do{
            System.out.println("Time elapsed: "+stopWatch.getTime(TimeUnit.SECONDS));
            if (stopWatch.getTime(TimeUnit.SECONDS)>5){
                System.out.println("Time is already more than 5 seconds");
            }
        }while (stopWatch.getTime(TimeUnit.SECONDS)<5);
        Assert.assertTrue(Math.sqrt(9)==3);
    }
}
