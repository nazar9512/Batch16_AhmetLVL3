package homeworks.homework3.openMRS.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class MRSTestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_openMRS_url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
