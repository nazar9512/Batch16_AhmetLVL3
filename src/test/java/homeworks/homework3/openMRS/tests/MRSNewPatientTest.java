package homeworks.homework3.openMRS.tests;

import homeworks.homework3.openMRS.pages.MRSLoginPage;
import homeworks.homework3.openMRS.pages.MRSNewPatientPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MRSNewPatientTest extends MRSTestBase{
    @Parameters({"expDeleteErrorMsg","deleteReason","newPatientName"})
    @Test(priority = 1)
    public void validateDeletePatientFunctionality(String expDeleteErrorMsg,String deleteReason,String newPatientName) throws InterruptedException {

        MRSLoginPage mrsLoginPage = new MRSLoginPage(driver);
        mrsLoginPage.loginFunctionality(ConfigReader.readProperty("QA_openMRS_userName"),ConfigReader.readProperty("QA_openMRS_password"));

        MRSNewPatientPage mrsNewPatientPage = new MRSNewPatientPage(driver);
        mrsNewPatientPage.patientDeleteFunctionality(expDeleteErrorMsg,deleteReason);
    }
    @Parameters("newPatientName")
    @Test(priority = 2)
    public void patientIsDeletedTest(String newPatientName) throws InterruptedException {
        MRSLoginPage mrsLoginPage = new MRSLoginPage(driver);
        mrsLoginPage.loginFunctionality(ConfigReader.readProperty("QA_openMRS_userName"),ConfigReader.readProperty("QA_openMRS_password"));

        MRSNewPatientPage mrsNewPatientPage = new MRSNewPatientPage(driver);
        mrsNewPatientPage.validatePatientIsDeleted(newPatientName);
    }
}
