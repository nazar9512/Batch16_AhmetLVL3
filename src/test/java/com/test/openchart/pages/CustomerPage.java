package com.test.openchart.pages;

import com.test.bank.tests.BankTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CustomerPage {

    public CustomerPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='float-end']//a")
    WebElement plusBtn;
    @FindBy(css = "#input-firstname")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;
    @FindBy(css = "#input-email")
    WebElement email;
    @FindBy(css = "#input-password")
    WebElement password;
    @FindBy(css = "#input-confirm")
    WebElement confirmPsw;
    @FindBy(css = "#input-newsletter")
    WebElement newsletterInput;
    @FindBy(css = "#input-safe")
    WebElement safeInput;
    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@id='alert']")
    WebElement  warningMsg;



    public void customerPageFunctionality(String firstName,String lastName,String email,String password,String confirmPsw) throws InterruptedException {
        plusBtn.click();
        Thread.sleep(500);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPsw.sendKeys(confirmPsw);
        newsletterInput.click();
        Thread.sleep(500);
        safeInput.click();
        Thread.sleep(500);
        saveBtn.click();
        Thread.sleep(500);
    }

    public String getWarningMsgText(){
        return BrowserUtils.getText(warningMsg);
    }
}
