package com.learn.pages;

import com.learn.enums.WaitStrategy;
import com.learn.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "span.oxd-userdropdown-tab")
    private WebElement dropBoxWelcome;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement buttonLogout;

    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public HomePage clickWelcome() {
        click(dropBoxWelcome, WaitStrategy.CLICKABLE,"Welcome button");
        return this;
    }

    public LoginPage clickLogout() {
        click(buttonLogout,WaitStrategy.CLICKABLE,"Logout button");
        return new LoginPage();
    }
}
