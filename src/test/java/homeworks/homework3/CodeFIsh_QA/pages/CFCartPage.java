package homeworks.homework3.CodeFIsh_QA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class CFCartPage {
    public CFCartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartBtn;
        @FindBy(xpath = "//tr//td[2]")
    List<WebElement>productNames;

    public void validateCartProducts(String vaccine1,String vaccine2) throws InterruptedException {

        cartBtn.click();
        Thread.sleep(1000);
        for (WebElement product : productNames){
              String productText = BrowserUtils.getText(product).toLowerCase();
            System.out.println(BrowserUtils.getText(product));

            Assert.assertTrue(productText.contains(vaccine1) && productText.contains(vaccine2));
        }

    }
}
