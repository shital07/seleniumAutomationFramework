package com.learn.listeners;

import com.learn.annotations.FrameworkAnnotation;
import com.learn.constants.FrameworkConstant;
import com.learn.reports.ExtendLogger;
import com.learn.reports.ExtendReport;
import org.testng.*;
import utility.TestDataForELK;


import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        ExtendReport.initReport(FrameworkConstant.getExtendreportfile());
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtendReport.flushReport(FrameworkConstant.getExtendreportfile());
    }


    public void onTestStart(ITestResult result) {
        ExtendReport.createTest(result.getMethod().getMethodName());
        ExtendReport.getAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtendReport.getCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendLogger.pass("Testcase is passed : " + result.getMethod().getMethodName());
        TestDataForELK.sendDetailstoELK(result.getMethod().getMethodName(),"pass","");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendLogger.fail("Testcase is failed : " + result.getMethod().getMethodName(),true);
        ExtendLogger.fail(result.getThrowable().toString());
        ExtendLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        TestDataForELK.sendDetailstoELK(result.getMethod().getMethodName(),"fail",result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtendLogger.skip("Testcase is skipped : " + result.getMethod().getMethodName(),true);
        TestDataForELK.sendDetailstoELK(result.getMethod().getMethodName(),"skip","");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
