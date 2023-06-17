package homeworks.homework3.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MRSLaboratoryPage {
    public MRSLaboratoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#selected-location")
    WebElement selectLocationBtn;
    @FindBy(xpath = "//li[@locationname='Pharmacy']")
    WebElement pharmacyLocation;
    @FindBy(xpath = "//div[@class='logo']")
    WebElement logoMRS;
    @FindBy(tagName = "h4")
    WebElement locationHeader;

    public void changeLocationFunctionality(String expPharmacyHeader) throws InterruptedException {
        selectLocationBtn.click();
        Thread.sleep(500);
        pharmacyLocation.click();
        Thread.sleep(500);
        logoMRS.click();
        Thread.sleep(500);
        Assert.assertEquals(BrowserUtils.getText(locationHeader),expPharmacyHeader);
    }

}
