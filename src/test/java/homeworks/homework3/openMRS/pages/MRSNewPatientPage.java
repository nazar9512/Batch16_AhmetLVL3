package homeworks.homework3.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class MRSNewPatientPage {
    private WebDriver driver;
    public MRSNewPatientPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".icon-search")
    WebElement findPatientRecord;
    @FindBy(xpath = "//td[.='Nazar Fedyk']")
    WebElement newPatientName;
    @FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
    WebElement deletePatientBtn;
    @FindBy(css = "#delete-reason")
    WebElement deleteReasonField;
    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']//button[.='Confirm']")
    WebElement deleteConfirmBtn;
    @FindBy(css = "#delete-reason-empty")
    WebElement deleteErrorMsg;
    @FindBy(xpath = "//table[@id='patient-search-results-table']//td[2]")
    List<WebElement> allNames;

    public void patientDeleteFunctionality(String expDeleteErrorMsg,String deleteReason) throws InterruptedException {

            findPatientRecord.click();
        Thread.sleep(500);
            newPatientName.click();
            Thread.sleep(500);
            deletePatientBtn.click();
        Thread.sleep(500);
        deleteConfirmBtn.click();
        Thread.sleep(500);

        Assert.assertEquals(BrowserUtils.getText(deleteErrorMsg),expDeleteErrorMsg);
        deleteReasonField.sendKeys(deleteReason);
        deleteConfirmBtn.click();
        Thread.sleep(500);
    }
    public void validatePatientIsDeleted(String newPatientName) throws InterruptedException {
        findPatientRecord.click();
        Thread.sleep(500);
        List<String> nameList = new ArrayList<>();
        for (WebElement name : allNames) {
            nameList.add(BrowserUtils.getText(name));
        }
        Thread.sleep(1000);
        Assert.assertTrue(!nameList.contains(newPatientName));
    }
}
