package homeworks.homework3.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class MRSRegisterPatientPage {
    public MRSRegisterPatientPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(@id,'registerPatient')]")
    WebElement registerPatient;
    @FindBy(xpath = "//input[@name='givenName']")
    WebElement givenName;
    @FindBy(xpath = "//input[@name='familyName']")
    WebElement familyName;
    @FindBy(xpath = "//span[.='Gender']")
    WebElement genderLabel;
    @FindBy(css = "#gender-field")
    WebElement genderField;
    @FindBy(xpath = "//span[.='Birthdate']")
    WebElement birthdayLabel;
    @FindBy(css = "#birthdateDay-field")
    WebElement birthDay;
    @FindBy(css = "#birthdateMonth-field")
    WebElement birthMonth;
    @FindBy(css = "#birthdateYear-field")
    WebElement birthYear;
    @FindBy(xpath = "//span[.='Address']")
    WebElement addressLabel;
    @FindBy(css = "#address1")
    WebElement address;

    @FindBy(css = "#cityVillage")
    WebElement city;
    @FindBy(css = "#stateProvince")
    WebElement state;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#postalCode")
    WebElement postalCode;
    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneNumbLabel;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumber;
    @FindBy(xpath = "//span[.='Confirm']")
    WebElement confirmLabel;
    @FindBy(xpath = "//div[@id='dataCanvas']//p")
    List<WebElement>allCustomerInfo;
    @FindBy(css = "#submit")
    WebElement confirmBtn;
    @FindBy(tagName = "h1")
    WebElement newPatientHeader;
    @FindBy(xpath = "//div[@class='identifiers']//span")
    WebElement newPatientId;



    public void registerPatientFunctionality(String givenName,String familyName,String gender,String birthDay,
                                             String birthMonth,String birthYear,String address,
                                             String city,String state,String country,String postalCode,
                                             String phoneNumber) throws InterruptedException {

        registerPatient.click();
        Thread.sleep(1000);
        this.givenName.sendKeys(givenName);
        this.familyName.sendKeys(familyName);
        genderLabel.click();
        Thread.sleep(1000);
        BrowserUtils.selectBy(genderField,gender,"text");
        birthdayLabel.click();
        Thread.sleep(500);
        this.birthDay.sendKeys(birthDay);
        Thread.sleep(500);
        BrowserUtils.selectBy(this.birthMonth,birthMonth,"text");
        Thread.sleep(500);
        this.birthYear.sendKeys(birthYear);
        Thread.sleep(500);
        addressLabel.click();
        Thread.sleep(500);
       this. address.sendKeys(address);
        Thread.sleep(500);
       this. city.sendKeys(city);
        Thread.sleep(500);
       this. state.sendKeys(state);
        Thread.sleep(500);
       this. country.sendKeys(country);
        Thread.sleep(500);
       this. postalCode.sendKeys(postalCode);
        Thread.sleep(500);
       phoneNumbLabel.click();
        Thread.sleep(500);
        this.phoneNumber.sendKeys(phoneNumber);
        confirmLabel.click();
        Thread.sleep(500);

        List<String>expCustomerInfo = Arrays.asList("Name: "+givenName+", "+familyName,"Gender: "+gender,
                                                    "Birthdate: "+birthDay+", "+birthMonth+", "+birthYear,
                                                     "Address: "+address+", "+city+", "+state+", "+country+", "+postalCode,
                                                        "Phone Number: "+phoneNumber);
        Thread.sleep(500);
        for (int i=0;i<allCustomerInfo.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allCustomerInfo.get(i)),expCustomerInfo.get(i));
        }

        confirmBtn.click();
        Thread.sleep(500);
    }

    public void newPatientValidation(String givenName,String familyName) throws InterruptedException {

        Assert.assertTrue(BrowserUtils.getText(newPatientHeader).contains(givenName) &&
                                    BrowserUtils.getText(newPatientHeader).contains(familyName));
        Thread.sleep(500);
        Assert.assertTrue(newPatientId.isDisplayed());
    }

}


