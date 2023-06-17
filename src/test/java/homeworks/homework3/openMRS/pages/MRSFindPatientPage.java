package homeworks.homework3.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.*;

public class MRSFindPatientPage {
    public MRSFindPatientPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//i[@class='icon-home small']")
         WebElement homeBtn;
    @FindBy(css = ".icon-search")
    WebElement findPatientRecord;
    @FindBy(xpath = "//table[@id='patient-search-results-table']//td[2]")
    List<WebElement> allNames;
    @FindBy(xpath = "//table[@id='patient-search-results-table']//td[1]")
    List<WebElement>allId;



    public void findPatientRecordFunctionality(String patientFullName) throws InterruptedException {
        findPatientRecord.click();
        Thread.sleep(1000);
        Map<String,String> map = new HashMap<>();

        for (int i= 0; i < allId.size(); i++){

            String id = BrowserUtils.getText(allId.get(i));
            String name = BrowserUtils.getText(allNames.get(i));

            if (map.containsKey(id)){
                Assert.fail("Duplicate ID found: " + id);
            }else{
                map.put(id,name);
            }
        }
        Thread.sleep(1000);
        Assert.assertTrue(map.containsValue(patientFullName));

    }
}
