package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this); // it does same logic of driver.findElement

    }

    @FindBy(css = ".mainHeading")
    WebElement header;

    @FindBy(xpath = "//button[.='Customer Login']")

    WebElement customerLogin;

    @FindBy(xpath = "//button[.='Bank Manager Login']")

    WebElement managerLogin;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeBtn;

    public void LoginPageComponentValidation(String expectedHeader){

        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed() && customerLogin.isEnabled());
        Assert.assertTrue(managerLogin.isDisplayed() && managerLogin.isEnabled());
    }

    public void clickManagerButton(){
        managerLogin.click();
    }

    public void clickCustomerLoginBtn(){
        customerLogin.click();
    }

    public void clickHomeBtn(){
        homeBtn.click();
    }


}












