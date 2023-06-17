package homeworks.homework3.openMRS.tests;

import homeworks.homework3.openMRS.pages.MRSLoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MRSLoginTest extends MRSTestBase {
    @Parameters("excLaboratoryHeader")
    @Test
    public void validateLoginFunctionality(String excLaboratoryHeader) throws InterruptedException {
        MRSLoginPage MRSLoginPage = new MRSLoginPage(driver);
        MRSLoginPage.loginFunctionality(ConfigReader.readProperty("QA_openMRS_userName"),ConfigReader.readProperty("QA_openMRS_password"));
        Assert.assertEquals(MRSLoginPage.getLaboratoryHeader(),excLaboratoryHeader);
    }


}
