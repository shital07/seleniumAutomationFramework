package com.learn.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactoryWithSupplier {

    private DriverFactoryWithSupplier() {

    }

    private static final Supplier<WebDriver> CHROME = () -> {

        return new ChromeDriver();
    };
    private static final Supplier<WebDriver> FIREFOX = () -> {

        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> mp = new HashMap<>();

    static {
        mp.put("CHROME", CHROME);
        mp.put("FIREFOX", FIREFOX);

    }

    public static WebDriver getDriver(String browser) {
        return mp.get(browser.toUpperCase()).get();
    }

}
