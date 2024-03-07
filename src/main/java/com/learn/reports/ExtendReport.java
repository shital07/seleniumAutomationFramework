package com.learn.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learn.constants.FrameworkConstant;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtendReport {

    private static ExtentReports extendReport;

    private ExtendReport() {

    }


    public static void initReport(String path) {

        if (Objects.isNull(extendReport)) {
            extendReport = new ExtentReports();
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setReportName("Test Extend Report");
            extendReport.setSystemInfo("Host Name", System.getProperty("user.name"));
            extendReport.setSystemInfo("Environment", "QA");
            extendReport.setSystemInfo("User Name", "Shital Malviya");
            extendReport.attachReporter(htmlReporter);

        }


    }

    public static void flushReport(String path) {
        try {
            if (Objects.nonNull(extendReport)) {
                extendReport.flush();

            }
            ExtendReportManager.unlockExTest();
            Desktop.getDesktop().browse(new File(FrameworkConstant.getExtendreportfile()).toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createTest(String testCaseName) {

        ExtentTest extentTest = extendReport.createTest(testCaseName);
        ExtendReportManager.setExtest(extentTest);
    }

    public static void getAuthor(String[] authors) {

        for (String author : authors) {

            ExtendReportManager.getExTest().assignAuthor(author);
        }
    }

    public static void getCategory(String[] authors) {

        for (String author : authors) {

            ExtendReportManager.getExTest().assignCategory(author);
        }
    }


}
