package com.test.spruceEats.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class FishSeafoodPage {
    public FishSeafoodPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#search-form-input")
    WebElement searchBar;
    @FindBy(css = "#starRating_score_4Star")
    WebElement rating4star;

    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorChoice;

    @FindBy(css = ".card__title")
    WebElement fishTitle;

        public void fishFinder(WebDriver driver,String searchInput,String expFishTitle) throws InterruptedException {
            BrowserUtils.clickWithJS(driver,searchBar);
            searchBar.sendKeys(searchInput,Keys.ENTER);
            BrowserUtils.clickWithJS(driver,rating4star);
            Thread.sleep(500);

            if (editorChoice.isDisplayed() && editorChoice.isEnabled() && !editorChoice.isSelected()){
                editorChoice.click();
                Thread.sleep(500);
            }

            Assert.assertEquals(BrowserUtils.getText(fishTitle),expFishTitle);
        }
}
