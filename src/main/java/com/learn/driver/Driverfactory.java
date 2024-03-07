package com.learn.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utility.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public final class Driverfactory {
    private Driverfactory() {

    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;
        String checkRemote = ConfigReader.getValue("EXECUTION_MODE");
        if (browser.equalsIgnoreCase("chrome")) {
            if (checkRemote.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
            } else {
                driver = new ChromeDriver();
            }


        } else if (browser.equalsIgnoreCase("firefox")) {
            if (checkRemote.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
            } else {
                driver = new FirefoxDriver();
            }


        }

        return driver;
    }
}
