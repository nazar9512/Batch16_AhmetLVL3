package com.test.openchart.tests;

import com.test.bank.tests.BankTestBase;
import com.test.openchart.pages.CustomerPage;
import com.test.openchart.pages.MainPage;
import com.test.openchart.pages.OpenCharLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerPageTest extends OpenChartTestBase {

        @Test
    public void validateCustomerPageFunctionality() throws InterruptedException {
            OpenCharLoginPage openCharLoginPage = new OpenCharLoginPage(driver);
            openCharLoginPage.loginFunctionality("demo","demo");

            MainPage mainPage = new MainPage(driver);
            mainPage.mainPageFunctionality();

            CustomerPage customerPage = new CustomerPage(driver);
            customerPage.customerPageFunctionality("Nazar","Fedyk","nazar@gmail.com","1234","1234");

            Assert.assertEquals(customerPage.getWarningMsgText(),"Warning: You do not have permission to modify customers!");
        }

}
