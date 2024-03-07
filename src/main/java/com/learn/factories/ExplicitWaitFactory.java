package com.learn.factories;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

    public static void performExplicitWait(WaitStrategy strategy,WebElement element){

        if(strategy == WaitStrategy.CLICKABLE){
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                    .withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));

        }else if(strategy == WaitStrategy.PRESENCE){

            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                    .withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));

        }else if(strategy == WaitStrategy.VISIBLE){
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                    .withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));

        }else if(strategy== WaitStrategy.NONE){


        }
    }

}
