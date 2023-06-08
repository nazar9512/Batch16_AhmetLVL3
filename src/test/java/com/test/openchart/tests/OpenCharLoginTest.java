package com.test.openchart.tests;

import com.test.openchart.pages.OpenCharLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCharLoginTest extends OpenChartTestBase{


    @Test
    public void positiveLoginTest() throws InterruptedException {
        OpenCharLoginPage openCharLoginPage = new OpenCharLoginPage(driver);
        openCharLoginPage.loginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        OpenCharLoginPage openCharLoginPage = new OpenCharLoginPage(driver);
        openCharLoginPage.loginFunctionality("wrong","wrong");
        Assert.assertEquals(openCharLoginPage.errorMsg(),"No match for Username and/or Password.");
    }

}
