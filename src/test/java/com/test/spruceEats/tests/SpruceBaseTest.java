package com.test.spruceEats.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.DriverHelper;

public class SpruceBaseTest {
        public WebDriver driver;
    @BeforeMethod
    public void setUp() {
         driver = DriverHelper.getDriver();
        driver.get("https://www.thespruceeats.com/");


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.getScreenShot(driver,"SpruceEat");
       driver.quit();
    }
}
