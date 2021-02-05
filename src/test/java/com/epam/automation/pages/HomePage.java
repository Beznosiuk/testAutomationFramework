package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private final String PAGE_URL = "https://www.bookdepository.com/";
    private final String SEARCH_INPUT = "//input[@name='searchTerm']";
    private final String SEARCH_BUTTON = "//button/span[text()='Search']";

    public void open() {
        driver.navigate().to(PAGE_URL);
    }

    public void verifyHomePageIsOpened() {
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(PAGE_URL);
        logger.info("Home page opened");
    }

    public void searchBookByName(String bookName) {
        WebElement searchBookInput = driver.findElement(By.xpath(SEARCH_INPUT));
        WebElement searchBookButton = driver.findElement(By.xpath(SEARCH_BUTTON));

        new Actions(driver).moveToElement(searchBookInput).sendKeys(searchBookInput, bookName).perform();
        new Actions(driver).moveToElement(searchBookButton).click(searchBookButton).perform();
        logger.info("Search page opened");
    }
}
