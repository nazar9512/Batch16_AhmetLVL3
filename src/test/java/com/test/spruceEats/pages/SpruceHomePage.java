package com.test.spruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceHomePage {
    public SpruceHomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='global-nav__list-item-link']//span[.='Ingredients']")
    WebElement topIngredients;
@FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishSeafood;

    public void findAndClickFishSeafood(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(topIngredients).perform();
        Thread.sleep(1000);
        fishSeafood.click();
        Thread.sleep(500);
    }
}
