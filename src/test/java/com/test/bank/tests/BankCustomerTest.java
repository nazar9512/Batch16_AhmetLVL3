package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest extends BankTestBase{

    @Test
    public void validateCustomerPageFunctionality()  throws InterruptedException {

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality("Nazar","Fedyk","60101",driver,"ed successfully wit");
        bankManagerPage.OpenAccountFunctionality("Nazar Fedyk","Dollar",driver,"ssfully with account Nu");
        bankManagerPage.customerFunctionality("Nazar","Fedyk","60101");
        bankLoginPage.clickHomeBtn();
        bankLoginPage.clickCustomerLoginBtn();

        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankCustomerPage.loginFunctionality("Nazar Fedyk","Welcome Nazar Fedyk !!");
        bankCustomerPage.depositFunctionality("500","Deposit Successful");
        bankCustomerPage.withdrawnFunctionality("300","Transaction successful");
        bankCustomerPage.transactionsFunctionality();

    }
}
