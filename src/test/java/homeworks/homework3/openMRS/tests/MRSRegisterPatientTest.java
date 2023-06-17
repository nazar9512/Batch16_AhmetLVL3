package homeworks.homework3.openMRS.tests;

import homeworks.homework3.openMRS.pages.MRSLoginPage;
import homeworks.homework3.openMRS.pages.MRSRegisterPatientPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MRSRegisterPatientTest extends MRSTestBase {
    @Parameters({"givenName","familyName","gender","birthDay","birthMonth","birthYear","address","city","state","country","postalCode","phoneNum"})
    @Test
    public void validateRegisterPatient(String givenName,String familyName,String gender,String birthDay, String birthMonth,
                                        String birthYear,String address,String city,String state,String country,
                                           String postalCode,String phoneNum ) throws InterruptedException {

        MRSLoginPage mrsLoginPage = new MRSLoginPage(driver);
        mrsLoginPage.loginFunctionality(ConfigReader.readProperty("QA_openMRS_userName"),ConfigReader.readProperty("QA_openMRS_password"));

        MRSRegisterPatientPage mrsRegisterPatientPage = new MRSRegisterPatientPage(driver);
        mrsRegisterPatientPage.registerPatientFunctionality(givenName,familyName,gender,birthDay,birthMonth,birthYear,
                                                            address,city,state,country,postalCode,phoneNum );

        mrsRegisterPatientPage.newPatientValidation(givenName,familyName);
    }
}
