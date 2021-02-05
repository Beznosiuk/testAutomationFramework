package com.epam.automation.pages;

import com.epam.automation.util.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CommonPage extends BasePage {

    BrowserService browserService = new BrowserService();

    private final String BUTTON_BY_TEXT = "//button[contains(text(), '%s')]";

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
        logger.info("All cookies were deleted");
    }

    public void clickButtonByText(String button) {
        WebElement buttonToClick = driver.findElement(By.xpath(String.format(BUTTON_BY_TEXT, button)));
        browserService.clickJS(buttonToClick);
    }
}
