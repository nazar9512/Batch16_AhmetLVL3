package com.test.openchart.pages;

import com.test.openchart.tests.OpenChartTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OpenCharLoginPage {
    public OpenCharLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(tagName = "button")
    WebElement loginBtn;

    @FindBy(xpath = "//div[contains(text(),'No match')]")
    WebElement errorMsg;

    public void loginFunctionality(String userName, String password) throws InterruptedException {

       this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginBtn.click();
        Thread.sleep(1000);
    }

    public String errorMsg() {

        return BrowserUtils.getText(errorMsg);
    }

}
