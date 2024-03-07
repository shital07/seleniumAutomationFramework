package com.learn.tests;

import com.learn.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    private static long startTime;
    private static long endTime;
    public static long executionTime;
    protected BaseTest() {

    }


    @BeforeMethod
    protected static void setup(Object[] data) {
        startTime = System.currentTimeMillis();
        Map<String,String> mp= (Map<String,String>)data[0];
        Driver.initDriver(mp.get("Browser"));
    }

    @AfterMethod
    protected static void tearDown() {
         endTime = System.currentTimeMillis();
         executionTime = (endTime - startTime)/1000;
        System.out.println(executionTime + " in after");

        Driver.quitDriver();
    }

    public static long getExecutionTime(){

        return executionTime = (endTime - startTime)/1000;
    }


}
