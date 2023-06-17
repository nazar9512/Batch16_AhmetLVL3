package homeworks.homework3.CodeFIsh_QA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class CFMainPage {
    public CFMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".card-title")
    List<WebElement>allCardTitles;
    @FindBy(xpath = "//p[1]")
    List<WebElement>productDescriptions;
    @FindBy(xpath = "//div[@class='card-body']//button")
    List<WebElement> allAddToCartBtn;

    public void addToCartFunctionality(String productCategory,String productType) throws InterruptedException {

              for (int i=0;i<allCardTitles.size();i++){

                  if (BrowserUtils.getText(allCardTitles.get(i)).toLowerCase().contains(productCategory) &&
                        BrowserUtils.getText(productDescriptions.get(i)).toLowerCase().contains(productType)){
                        allAddToCartBtn.get(i).click();
                      Thread.sleep(200);
                  }
              }
    }

}
