package com.epam.automation.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static DriverFactory driverFactory;

    private DriverFactory() {
        driver.set(Setup.setWebDriver());
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get().manage().window().maximize();
    }

    public static DriverFactory getDriverFactory() {
        if (driverFactory == null) {
            driverFactory = new DriverFactory();
        }
        return driverFactory;
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
