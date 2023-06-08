package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import org.testng.annotations.Test;

public class BankLoginTest extends BankTestBase{

    @Test
    public void validatePageComponents(){


        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.LoginPageComponentValidation("XYZ Bank");

    }
}












