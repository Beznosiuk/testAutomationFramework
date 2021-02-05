package com.epam.automation.steps;

import com.epam.automation.pages.CommonPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonSteps {

    private final CommonPage commonPage;

    public CommonSteps() {
        this.commonPage = new CommonPage();
    }

    @Given("an anonymous user clears cookies")
    public void anAnonymousUserClearsCookies() {
        commonPage.deleteAllCookies();
    }

    @And("click {string} button")
    public void clickButton(String button) {
        commonPage.clickButtonByText(button);
    }
}
