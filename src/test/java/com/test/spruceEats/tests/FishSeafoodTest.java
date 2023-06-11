package com.test.spruceEats.tests;

import com.test.spruceEats.pages.FishSeafoodPage;
import com.test.spruceEats.pages.SpruceHomePage;
import org.testng.annotations.Test;

public class FishSeafoodTest extends SpruceBaseTest{
    @Test
    public void validateFishFinder() throws InterruptedException {

        SpruceHomePage spruceHomePage = new SpruceHomePage(driver);
        FishSeafoodPage fishSeafoodPage = new FishSeafoodPage(driver);

        spruceHomePage.findAndClickFishSeafood(driver);
        fishSeafoodPage.fishFinder(driver,"Fish for dinner","6-Ingredient Roasted Salmon Fillets");

    }
}
