package homeworks.homework3.CodeFIsh_QA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CFLoginPage {
    public CFLoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginBtn;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement registerBtn;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement registerSubmitBtn;

        public void registerFunctionality(String userName,String password) throws InterruptedException {
            userNameField.clear();
            Thread.sleep(1500);
            passwordField.clear();
            Thread.sleep(1500);
            registerBtn.click();
            Thread.sleep(1500);
            userNameField.sendKeys(userName);
            Thread.sleep(1500);
            passwordField.sendKeys(password);
            Thread.sleep(1500);
            registerSubmitBtn.click();
            Thread.sleep(1500);
        }

        public void loginFunctionality(String userName,String password) throws InterruptedException {
            userNameField.clear();
            Thread.sleep(1500);
            userNameField.sendKeys(userName);
            Thread.sleep(1500);
            passwordField.clear();
            Thread.sleep(1500);
            passwordField.sendKeys(password);
            Thread.sleep(1500);
            loginBtn.click();
            Thread.sleep(2500);

        }
}
