package com.epam.automation.pages;

import com.epam.automation.driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver = DriverFactory.getDriverFactory().getDriver();
    protected final Logger logger = LogManager.getRootLogger();
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    SoftAssertions softAssertions = new SoftAssertions();

}
