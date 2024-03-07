package com.learn.pages;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DynamicXpathutils;

import java.time.Duration;

public final class AmazonHamburgerMenuPage extends BasePage {


    @FindBy(xpath = "//div[text()='Echo & Alexa']/parent::a")
    private WebElement linkEchoandAlexa;

    @FindBy(xpath = "//a[text()='Echo Pop']")
    private WebElement linkEchoPop;

    private String linkSubMenu = "//a[text()='%s']";

    public AmazonHamburgerMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);

    }

    public AmazonHamburgerMenuPage clickEchoandAlexaLink() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(linkEchoandAlexa, WaitStrategy.CLICKABLE, "Echo and Alexa");

        return this;
    }

    public AmazonEchoPopPage clickSubmenu(String target) {

        String newPath = DynamicXpathutils.getXpath(linkSubMenu, target);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement echo = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath(newPath)));

        JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", echo);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(DriverManager.getDriver().getTitle());

        //  echo.click();


       /* WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
        driver.findElement(By.id("Login")).click();*/




      /*  WebElement element = driver.findElement(By.id("Login"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript(“arguments[0].click();”, element);*/
        /*ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE,element);
        click(DriverManager.getDriver().findElement(By.xpath(newPath)), WaitStrategy.CLICKABLE, target);*/

        if (target.equalsIgnoreCase("Echo Pop")) {
            return new AmazonEchoPopPage();
        }
        return null;
    }
}
