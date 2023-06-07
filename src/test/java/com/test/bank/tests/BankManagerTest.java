package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest {
    @Test
    public void validateAddCustomerFunctionality() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality("Nazar","Fedyk","60101",driver,"ed successfully wit");

    }

    @Test
    public void validateOpenAccountFunctionality() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality("Nazar","Fedyk","60101",driver,"ed successfully wit");
        bankManagerPage.OpenAccountFunctionality("Nazar Fedyk","Dollar",driver,"ssfully with account Nu");

    }

    @Test
    public void validateCustomersFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality("Nazar","Fedyk","60101",driver,"ed successfully wit");
        bankManagerPage.OpenAccountFunctionality("Nazar Fedyk","Dollar",driver,"ssfully with account Nu");
        bankManagerPage.customerFunctionality("Nazar","Fedyk","60101");
        bankLoginPage.clickHomeBtn();


    }
}
