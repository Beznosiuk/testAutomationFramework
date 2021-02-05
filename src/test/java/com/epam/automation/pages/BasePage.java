package com.epam.automation.pages;

import com.epam.automation.driver.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    SoftAssertions softAssertions = new SoftAssertions();

    public BasePage() {
        this.driver = Setup.driver;
    }
}
