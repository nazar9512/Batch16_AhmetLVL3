package homeworks.homework3.openMRS.tests;

import homeworks.homework3.openMRS.pages.MRSFindPatientPage;
import homeworks.homework3.openMRS.pages.MRSLoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MRSFindPatientTest extends MRSTestBase{
    @Parameters("newPatientName")
@Test
    public void validateNewPatientAdded(String newPatientName) throws InterruptedException {

    MRSLoginPage mrsLoginPage = new MRSLoginPage(driver);
    mrsLoginPage.loginFunctionality(ConfigReader.readProperty("QA_openMRS_userName"),ConfigReader.readProperty("QA_openMRS_password"));

    MRSFindPatientPage mrsFindPatientPage = new MRSFindPatientPage(driver);
    mrsFindPatientPage.findPatientRecordFunctionality(newPatientName);

}

}
