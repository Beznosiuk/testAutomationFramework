package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class BasketPage extends BasePage {
    private final String BASKET_PAGE_HEADER = "//div[@class='basket-page ']";
    private final String BASKET_DETAILS = "//dt[contains(text(),'%s')]/following-sibling::dd";
    private final String BUTTON = "//div[@class='checkout-btns-wrap']/a[contains(text(),'%s')]";

    public void verifyBasketPageIsOpened() {
        softAssertions.assertThat(driver.findElement(By.xpath(BASKET_PAGE_HEADER)).isDisplayed());
    }

    public void verifyBasketOrderSummary(Map<String, String> orderSummary) {
        for (Map.Entry<String, String> entry : orderSummary.entrySet()) {
            softAssertions.assertThat(entry.getValue())
                    .isEqualTo(driver.findElement(By.xpath(String.format(BASKET_DETAILS, entry.getKey()))).getText());
        }
    }

    public void clickButtonByName(String button) {
        WebElement webElement = driver.findElement(By.xpath(String.format(BUTTON, button)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.click();
    }
}
