package com.learn.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {


    int count=0;
    int limit=2;
    @Override
    public boolean retry(ITestResult iTestResult) {

        boolean check = count<limit;
        count++;
        return check;
    }
}
