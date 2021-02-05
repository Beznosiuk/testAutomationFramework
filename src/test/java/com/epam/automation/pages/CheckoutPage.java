package com.epam.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CheckoutPage extends BasePage {
    private final String ORDER_SUMMARY = "//div[@class='sidebar right']//dt/strong[contains(text(),'%s')]/../following-sibling::dd";
    private final String EMAIL_ADDRESS_INPUT = "//input[@name='emailAddress']";
    private final String SELECT_COUNTRY = "//select[@id='deliveryCountryDropdown']";
    private final String ENTER_ADDRESS_MANUALLY = "//button[@id='manualEntryDeliveryAddress']";
    private final String DELIVERY_ADDRESS_INPUT = "//div[@id='deliveryAddress']//label[contains(text(),'%s')]/../div/input";
    private final String DISABLED_SECTION = "//h2[contains(text(),'%s')]/../.";
    private final String SELECT_CARD_TYPE = "//select[@id='brandSelected']";
    private final String INPUT_CARD_NUMBER = "//p/input[@id='visacardNumber']";
    private final String INPUT_CARD_NAME = "//input[@id='visacardName']";
    private final String INPUT_CARD_CVV = "//input[@id='visacardCvv']";
    private final String SELECT_MONTH = "//select[@id='visacardValidToMonth']";
    private final String SELECT_YEAR = "//select[@id='visacardValidToYear']";


    public void verifyCheckoutOrderSummary(Map<String, String> orderSummary) {
        for (Map.Entry<String, String> entry : orderSummary.entrySet()) {
            softAssertions.assertThat(entry.getValue())
                    .isEqualTo(driver.findElement(By.xpath(String.format(ORDER_SUMMARY, entry.getKey()))).getText());
        }
        logger.info("Checkout order summary verified");
    }

    public void setEmailAddress(String email) {
        driver.findElement(By.xpath(EMAIL_ADDRESS_INPUT)).sendKeys(email);
    }

    public void selectCountry(String country) {
        Select selectCountry = new Select(driver.findElement(By.xpath(SELECT_COUNTRY)));
        selectCountry.selectByVisibleText(country);
    }

    public void clickEnterAddressManually() {
        driver.findElement(By.xpath(ENTER_ADDRESS_MANUALLY)).click();
    }

    public void setDeliveryAddress(Map<String, String> deliveryAddress) {
        for (Map.Entry<String, String> entry : deliveryAddress.entrySet()) {
            driver.findElement(By.xpath(String.format(DELIVERY_ADDRESS_INPUT, entry.getKey()))).sendKeys(entry.getValue());
        }
        logger.info("Delivery address set");
    }

    public void verifySectionIsDisabled(String section) {
        WebElement webElement = driver.findElement(By.xpath(String.format(DISABLED_SECTION, section)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        Assert.assertEquals("disabled-container", webElement.getAttribute("class"));
        logger.info("Section " + section + " Is Disabled");
    }

    public void setCardDetails(Map<String, String> cardDetails) {
        driver.switchTo().frame("chase");
        new Select( driver.findElement(By.xpath(SELECT_CARD_TYPE))).selectByVisibleText(cardDetails.get("Card Type"));
        new Select( driver.findElement(By.xpath(SELECT_MONTH))).selectByVisibleText(cardDetails.get("Expiry Month"));
        new Select( driver.findElement(By.xpath(SELECT_YEAR))).selectByVisibleText(cardDetails.get("Expiry Year"));
        driver.findElement(By.xpath(INPUT_CARD_NUMBER)).sendKeys(cardDetails.get("Card Number"));
        driver.findElement(By.xpath(INPUT_CARD_NAME)).sendKeys(cardDetails.get("Name On Card"));
        driver.findElement(By.xpath(INPUT_CARD_CVV)).sendKeys(cardDetails.get("Cvv"));
        logger.info("Card details set");
    }

}
