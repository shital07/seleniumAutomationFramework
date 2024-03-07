package com.learn.constants;

import utility.ConfigReader;

public class FrameworkConstant {

    private FrameworkConstant() {
    }

    private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String EXTENDREPORTPATH = System.getProperty("user.dir") + "/extend-test-output/";
    private static String EXTENDREPORTFILE = "";

    public String getResourcePath() {
        return RESOURCEPATH;
    }

    public static String getExtendreportfile() {

        if (EXTENDREPORTFILE.isEmpty()) {
            EXTENDREPORTFILE = getExtendreportpath();
        }
        return EXTENDREPORTFILE;
    }

    private static String getExtendreportpath() {

        if (ConfigReader.getValue("OVERRIDEREPORT").equalsIgnoreCase("yes")) {
            return EXTENDREPORTPATH + "index.html";
        } else {
            return EXTENDREPORTPATH + System.currentTimeMillis() + "index.html";
        }
    }

}
