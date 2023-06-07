package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class BankCustomerPage {
    public BankCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


        @FindBy(css = "#userSelect")
        WebElement yourNameBox;

        @FindBy(xpath = "//button[@type='submit']")
        WebElement loginBtn;

        @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
        WebElement welcomeHeader;

        @FindBy(xpath = "//button[@ng-class='btnClass2']")
        WebElement depositBtn;

        @FindBy(xpath = "//button[@ng-class='btnClass3']")
        WebElement withdrawnBtn;

        @FindBy(xpath = "//input[@type='number']")
        WebElement amountBox;

        @FindBy(xpath = "//button[@type='submit']")
        WebElement depositSubmitBtn;

         @FindBy(xpath = "//button[@type='submit']")
         WebElement withdrawnSubmitBtn;

         @FindBy(xpath = "//span[contains(text(),'Deposit')]")
         WebElement depositSuccessMsg;

         @FindBy(xpath = "//span[contains(text(),'Transaction')]")
         WebElement withdrawnSuccessMsg;

         @FindBy(xpath = "//strong[.='200']")
         WebElement balanceAmount;

         @FindBy(xpath = "//button[contains(text(),'Trans')]")
         WebElement transactionsBtn;

         @FindBy(xpath = "//td[.='500']")
         WebElement creditAmount;

         @FindBy(xpath = "//td[.='300']")
         WebElement debitAmount;

         @FindBy(xpath = "//button[.='Back']")
         WebElement backBtn;

    public void yourNameFunctionality(String name,String expHeader) throws InterruptedException {

        BrowserUtils.selectBy(yourNameBox,name,"text");
        loginBtn.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(welcomeHeader),expHeader);
    }

    public void depositFunctionality(String depositAmount,String exdDepositMsg) throws InterruptedException {

            depositBtn.click();
            Thread.sleep(1000);
            amountBox.sendKeys(depositAmount);
            depositSubmitBtn.submit();
            Assert.assertEquals(BrowserUtils.getText(depositSuccessMsg),exdDepositMsg);

    }

    public void withdrawnFunctionality(String withdrawAmount,String expWithdrawnMsg) throws InterruptedException {

            withdrawnBtn.click();
        Thread.sleep(1000);
            amountBox.sendKeys(withdrawAmount);
            withdrawnSubmitBtn.submit();
        Thread.sleep(1000);
            Assert.assertEquals(BrowserUtils.getText(withdrawnSuccessMsg),expWithdrawnMsg);

    }

    public void transactionsFunctionality() throws InterruptedException {
                transactionsBtn.click();
             Thread.sleep(1000);
                int remainBalance = Integer.parseInt(BrowserUtils.getText(creditAmount)) - Integer.parseInt(BrowserUtils.getText(debitAmount));
                backBtn.click();
                Thread.sleep(1000);
                Assert.assertEquals(remainBalance,Integer.parseInt(BrowserUtils.getText(balanceAmount)));




    }



}
