package homeworks.homework3.CodeFIsh_QA.tests;

import homeworks.homework3.CodeFIsh_QA.pages.CFCartPage;
import homeworks.homework3.CodeFIsh_QA.pages.CFLoginPage;
import homeworks.homework3.CodeFIsh_QA.pages.CFMainPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class CFCartTest extends CFTestBase {
    @Test
    public void validateAddToCard() throws InterruptedException {
        CFLoginPage cfLoginPage = new CFLoginPage(driver);
        cfLoginPage.loginFunctionality(ConfigReader.readProperty("QA_codeFishQA_userName"),ConfigReader.readProperty("QA_codeFishQA_password"));

        CFMainPage cfMainPage = new CFMainPage(driver);
        cfMainPage.addToCartFunctionality("vaccine","covid");

        CFCartPage cfCartPage = new CFCartPage(driver);
        cfCartPage.validateCartProducts("Pfizer","Sputnik");
    }
}
