package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {
    private final String PAGE_URL = "";
    private final String LOGOUT_PAGE = "";

    private final String LOGIN_INPUT = "";
    private final String PASSWORD_INPUT = "";
    private final String SIGN_IN_BUTTON = "";

    public void open() {
        driver.navigate().to(PAGE_URL);
    }

    public void verifyHomePageIsOpened() {
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(PAGE_URL);
        logger.info("Login page opened");
    }

    public void enterLogin() {
        WebElement loginInput = driver.findElement(By.xpath(LOGIN_INPUT));
        new Actions(driver).moveToElement(loginInput).sendKeys(loginInput, "").perform();
    }

    public void enterPassword() {
        WebElement passwordInput = driver.findElement(By.xpath(PASSWORD_INPUT));
        new Actions(driver).moveToElement(passwordInput).sendKeys(passwordInput, "").perform();
    }

    public void clickButton() {
        driver.findElement(By.xpath(SIGN_IN_BUTTON)).click();
    }

    public void logout() {
        driver.navigate().to(LOGOUT_PAGE);
    }
}
