package com.learn.pages;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class AmazonHomePage extends BasePage {

    @FindBy(css = "a#nav-hamburger-menu")
    private WebElement linkHamburger;

    @FindBy(css = "a#nav-bb-logo")
    private WebElement logo;

    public AmazonHomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AmazonHomePage clickLogo() {

        click(logo, WaitStrategy.CLICKABLE, "Amazon Logo");
        return new AmazonHomePage();
    }

    public AmazonHamburgerMenuPage clickHumburger() {

        click(linkHamburger, WaitStrategy.CLICKABLE, "Humburger link");
        return new AmazonHamburgerMenuPage();
    }
}
