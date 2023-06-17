package homeworks.homework3.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class MRSLoginPage {
        public MRSLoginPage(WebDriver driver) {
                PageFactory.initElements(driver,this);
        }
        @FindBy(css = "#username")
        WebElement userNameField;
        @FindBy(css = "#password")
        WebElement passwordField;
        @FindBy(css = "#Laboratory")
        WebElement laboratory;
        @FindBy(css = "#loginButton")
        WebElement loginBtn;
        @FindBy(tagName = "h4")
        WebElement laboratoryHeader;

        public void loginFunctionality(String userName,String password) throws InterruptedException {

                userNameField.sendKeys(userName);
                Thread.sleep(500);
                passwordField.sendKeys(password);
                laboratory.click();
                Thread.sleep(500);
                loginBtn.click();
                Thread.sleep(500);
        }
        public String getLaboratoryHeader(){
                return BrowserUtils.getText(laboratoryHeader);
        }
}
