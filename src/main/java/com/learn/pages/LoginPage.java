package com.learn.pages;

import com.learn.driver.DriverManager;
import com.learn.enums.WaitStrategy;
import com.learn.reports.ExtendLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement textboxUsername;
    @FindBy(name = "password")
    private WebElement textboxPasword;
    @FindBy(xpath = "//button[text()=' Login ']")
    private WebElement buttonLogin;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public LoginPage enterUserName(String userName) {
        sendKeys(textboxUsername, userName, WaitStrategy.CLICKABLE,"username");
        return this;
    }

    public LoginPage enterPassWord(String password) {
        sendKeys(textboxPasword, password, WaitStrategy.CLICKABLE,"password");
        return this;
    }

    public HomePage clickLogin() {
        click(buttonLogin, WaitStrategy.CLICKABLE, "Login button");
        return new HomePage();
    }

    public String getPageTitle() {

        return getTitle();

    }
}
