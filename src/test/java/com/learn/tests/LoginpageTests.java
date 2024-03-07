package com.learn.tests;

import com.learn.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class LoginpageTests extends BaseTest {
    private LoginpageTests() {

    }

    // @Test
    public void loginLogout() {


        String title = new LoginPage().enterUserName("Admin").enterPassWord("admin123").clickLogin().clickWelcome().clickLogout().getPageTitle();
        Assert.assertEquals(title, "OrangeHRM");

    }

    @Test(dataProvider = "getData")
    public void loginLogoutWithData(String username, String passwod) {

        String title = new LoginPage().enterUserName(username).enterPassWord(passwod).clickLogin().clickWelcome().clickLogout().getPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @DataProvider(parallel = true)
    public Object[][] getData() {

        return new Object[][]{
                   {"Admin", "admin123"},
               // {"Admin123", "admin123"},
                //  {"Admin", "admin123"}
        };
    }


}
