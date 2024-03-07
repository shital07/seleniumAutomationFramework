package com.learn.pages;

import com.learn.enums.WaitStrategy;
import com.learn.driver.DriverManager;
import com.learn.factories.ExplicitWaitFactory;
import com.learn.reports.ExtendLogger;
import com.learn.reports.ExtendReport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected void click(WebElement element, WaitStrategy strategy, String elementName) {


        ExplicitWaitFactory.performExplicitWait(strategy,element);
        element.click();
        ExtendLogger.pass("Clicked the element : " + elementName,true);

    }
    protected void sendKeys(WebElement element,String value,WaitStrategy strategy, String elementName ) {
        ExplicitWaitFactory.performExplicitWait(strategy,element);
        element.sendKeys(value);
        ExtendLogger.pass(value +" is entered in the field : " + elementName,true);
    }

    protected String getTitle() {
        waitForPageTobeLoaded();
       return DriverManager.getDriver().getTitle();
    }

    private void waitForElementToBeClickable(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));

    }
    private void waitForPageTobeLoaded(){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                .until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

    }
}
