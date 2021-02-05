package com.epam.automation.steps;

import com.epam.automation.pages.HomePage;
import io.cucumber.java.en.And;

public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @And("Home page is opened")
    public void userIsOnTheHomePage() {
        homePage.open();
        homePage.verifyHomePageIsOpened();
    }

    @And("user searches for {string} book")
    public void userSearchesForBook(String bookName) {
        homePage.searchBookByName(bookName);
    }
}
