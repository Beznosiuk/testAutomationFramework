package com.epam.automation.steps;


import com.epam.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @And("login page is opened")
    public void userIsOnTheHomePage() {
        loginPage.open();
        loginPage.verifyHomePageIsOpened();
    }

    @When("user enter login and password")
    public void userEnterLoginAndPassword() {
        loginPage.enterLogin();
        loginPage.enterPassword();
    }

    @And("user click {string} button")
    public void userClickButton(String button) {
        loginPage.clickButton();
    }

    @Then("home page is opened")
    public void homePageIsOpened() {
    }

    @And("user logout")
    public void userLogout() {
        loginPage.logout();
    }
}
