package com.learn.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager {

    private DriverManager() {

    }

    private static ThreadLocal<WebDriver> td = new ThreadLocal<>();

    public static WebDriver getDriver() {

        return td.get();

    }

    static void setDriver(WebDriver driver) {
        if (Objects.nonNull(driver))
            td.set(driver);

    }

    static void unload() {

        td.remove();

    }
}
