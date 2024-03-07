package com.learn.driver;

import com.learn.exceptions.BrowserInvocationException;
import utility.ConfigReader;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {
    private Driver() {

    }

    public static void initDriver(String browser) {

        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(Driverfactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationException("Problem in invoking browser please check the capabilities", e);
            }
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(ConfigReader.getValue("URL2"));
            System.out.println(Thread.currentThread().getId());
        }


    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            //driver = null;
            DriverManager.unload();
        }


    }

}
