package com.learn.tests;

import com.learn.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public final class HomepageTest extends BaseTest {
    private HomepageTest() {


    }

    @Test
    public void test3() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
        String titile = DriverManager.getDriver().getTitle();
        Assert.assertTrue(Objects.nonNull(titile), "Title is null");
        Assert.assertTrue(titile.toLowerCase().contains("google search"));
        Assert.assertTrue(titile.length() > 15);
        Assert.assertTrue(titile.length() < 100);
        List<WebElement> ele = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
        Assert.assertEquals(ele.size(), 10);

        boolean isElementPresent = false;
        for (WebElement element : ele) {
            if (element.getText().equalsIgnoreCase("Testing mini bytes - Youtube")) {
                isElementPresent = true;
            }
        }

        Assert.assertTrue(isElementPresent, "Testing mini bytes - Youtube not found");
    }
}
