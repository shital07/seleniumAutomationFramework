package com.learn.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import utility.ConfigReader;
import utility.ScreenshotUtils;

public final class ExtendLogger {
    private ExtendLogger() {

    }

    public static void pass(String message) {
        ExtendReportManager.getExTest().pass(message);
    }

    public static void fail(String message) {
        ExtendReportManager.getExTest().fail(message);
    }

    public static void skip(String message) {
        ExtendReportManager.getExTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {

        if (ConfigReader.getValue("PASSTCSCREENSHOT").equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtendReportManager.getExTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            ExtendReportManager.getExTest().pass(message);
        }


    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        if (ConfigReader.getValue("FAILTCSCREENSHOT").equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtendReportManager.getExTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            ExtendReportManager.getExTest().fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) {
        if (ConfigReader.getValue("SKIPTCSCREENSHOT").equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtendReportManager.getExTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            ExtendReportManager.getExTest().fail(message);
        }
    }

}
