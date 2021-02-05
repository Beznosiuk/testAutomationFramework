package com.epam.automation.steps;

import com.epam.automation.pages.BasketPage;
import io.cucumber.java.en.And;

import java.util.Map;

public class BasketPageSteps {

    private final BasketPage basketPage;

    public BasketPageSteps() {
        this.basketPage = new BasketPage();
    }

    @And("Basket page is opened")
    public void basketPageIsOpened() {
        basketPage.verifyBasketPageIsOpened();
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(Map<String, String> orderSummary) {
        basketPage.verifyBasketOrderSummary(orderSummary);
    }

    @And("user clicks {string} button on Basket page")
    public void userClicksCheckoutButtonOnBasketPage(String button) {
        basketPage.clickButtonByName(button);
    }
}
