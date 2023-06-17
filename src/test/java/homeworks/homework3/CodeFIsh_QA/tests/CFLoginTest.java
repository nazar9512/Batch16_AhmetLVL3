package homeworks.homework3.CodeFIsh_QA.tests;

import homeworks.homework3.CodeFIsh_QA.pages.CFLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class CFLoginTest extends CFTestBase{

    @Test
    public void registerAndLoginValidation() throws InterruptedException {
        CFLoginPage cfLoginPage = new CFLoginPage(driver);
        cfLoginPage.registerFunctionality(ConfigReader.readProperty("QA_codeFishQA_userName"),ConfigReader.readProperty("QA_codeFishQA_password"));
        cfLoginPage.loginFunctionality(ConfigReader.readProperty("QA_codeFishQA_userName"),ConfigReader.readProperty("QA_codeFishQA_password"));
        Assert.assertEquals(driver.getCurrentUrl(),"http://codefish-io-qa.s3-website-ap-northeast-1.amazonaws.com/home");
    }
}
