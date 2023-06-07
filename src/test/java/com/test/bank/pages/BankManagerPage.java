package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {
    public BankManagerPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Cust')]")
    WebElement addCustomerBtn;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerBtn;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccBtn;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement process;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersBtn;

    @FindBy(tagName = "input")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement>allInformation;


    public void addCustomerFunctionality(String firstName,String lastName,String postCode, WebDriver driver,String expectedMsg){

        addCustomerBtn.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomerBtn.submit();

        Alert alert = driver.switchTo().alert();

        Assert.assertTrue(alert.getText().contains(expectedMsg));
        alert.accept();
    }

    public void OpenAccountFunctionality(String name, String currency,WebDriver driver,String expectedMsg){
        openAccBtn.click();

        BrowserUtils.selectBy(customerName,name,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");
        process.click();

        Alert alert = driver.switchTo().alert();

        Assert.assertTrue(alert.getText().contains(expectedMsg));
        alert.accept();

    }

    public  void customerFunctionality(String customerName,String lastName,String postCode) throws InterruptedException {
        customersBtn.click();

        searchBox.sendKeys(customerName);
        Thread.sleep(1000);
        List<String> expNames = Arrays.asList(customerName,lastName,postCode);

        for (int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expNames.get(i));
        }
    }


}
