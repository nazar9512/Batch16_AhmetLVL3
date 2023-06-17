package homeworks.homework3.openMRS.tests;

import homeworks.homework3.openMRS.pages.MRSFindPatientPage;
import homeworks.homework3.openMRS.pages.MRSLaboratoryPage;
import homeworks.homework3.openMRS.pages.MRSLoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MRSLaboratoryTest extends MRSTestBase {
    @Parameters({"expPharmacyHeader","existingPatientName"})
    @Test
    public void validateUniquePatientID(String expPharmacyHeader,String existingPatientName) throws InterruptedException {
        MRSLoginPage mrsLoginPage = new MRSLoginPage(driver);
        mrsLoginPage.loginFunctionality(ConfigReader.readProperty("QA_openMRS_userName"),ConfigReader.readProperty("QA_openMRS_password"));

        MRSLaboratoryPage mrsLaboratoryPage = new MRSLaboratoryPage(driver);
        mrsLaboratoryPage.changeLocationFunctionality(expPharmacyHeader);

        MRSFindPatientPage mrsFindPatientPage =new MRSFindPatientPage(driver);
        mrsFindPatientPage.findPatientRecordFunctionality(existingPatientName);



    }
}
