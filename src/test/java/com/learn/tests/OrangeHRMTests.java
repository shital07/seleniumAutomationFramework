package com.learn.tests;

import com.learn.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.DataProviderUtils;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest{
    private OrangeHRMTests() {

    }

    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void loginLogoutWithData(Map<String,String> mp) {

        String title = new LoginPage().enterUserName(mp.get("Username")).enterPassWord(mp.get("Password")).clickLogin().clickWelcome().clickLogout().getPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void newTest(Map<String,String> mp) {


        String title = new LoginPage().enterUserName(mp.get("Username")).enterPassWord(mp.get("Password")).clickLogin().clickWelcome().clickLogout().getPageTitle();
        Assert.assertEquals(title, "OrangeHRM");

    }

}
