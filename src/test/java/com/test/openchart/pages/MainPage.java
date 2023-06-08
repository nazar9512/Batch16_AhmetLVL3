package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

        @FindBy(css = ".btn-close")
    WebElement xBtn;

    @FindBy(linkText = "Customers")
    WebElement customersDropDown;
    @FindBy(xpath = "//ul[@id='collapse-5']//a[.='Customers']")
    WebElement customersBtn;


    public void mainPageFunctionality() throws InterruptedException {

        xBtn.click();
        Thread.sleep(500);
        customersDropDown.click();
        Thread.sleep(500);
    customersBtn.click();
        Thread.sleep(500);


    }

}
