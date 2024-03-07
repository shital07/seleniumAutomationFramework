package com.learn.tests;

import com.learn.annotations.FrameworkAnnotation;
import com.learn.pages.AmazonHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.DataProviderUtils;

import java.util.Map;

public final class AmazonHomeTest extends BaseTest{
    private AmazonHomeTest(){

    }

    @FrameworkAnnotation(author = {"shital","malviya"}, category = {"smoke"})
    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void amazonTest(Map<String,String> data){

        System.out.println(data.get("Menu"));
        for(Map.Entry<String,String> e:data.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
        String title = new AmazonHomePage().clickHumburger().clickEchoandAlexaLink().clickSubmenu(data.get("Menu")).getPageTitle();
        Assert.assertTrue(title.contains("Echo Pop"),"Title doesnot match");
    }

}
