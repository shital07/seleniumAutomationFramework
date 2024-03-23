package com.learn.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtendReportManager {

    private ExtendReportManager() {

    }

    private static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

     static ExtentTest getExTest() {

         return threadLocal.get();
    }

     static void setExtest(ExtentTest extentTest) {
        if(Objects.nonNull(extentTest))
         threadLocal.set(extentTest);
    }

     static void unlockExTest() {
        threadLocal.remove();
    }
}
