package com.epam.automation.pages;

import com.epam.automation.util.BrowserService;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchPage extends BasePage {

    private final BrowserService browserService = new BrowserService();

    private final String SEARCH_RESULTS_HEADER = "//div/h1[contains(text(),'Search results')]";
    private final String SEARCH_RESULTS = "//h3[@class='title']/a";
    private final String FILTER_SELECT = "//label[contains(text(), '%s')]/../select";
    private final String ADD_TO_BASKET = "//a[contains(text(),'%s')]/../../..//div/a[contains(text(),'Add to basket')]/parent::div";
    private final String BASKET_POP_UP = "//a[contains(text(),'%s')]";

    public void verifySearchPageIsOpened() {
        Assert.assertTrue(driver.findElement(By.xpath(SEARCH_RESULTS_HEADER)).isDisplayed());
        logger.info("Search page opened");
    }

    public void verifySearchResult(List<String> expectedBooks) {
        List<String> actualBooks = driver.findElements(By.xpath(SEARCH_RESULTS))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        softAssertions.assertThat(actualBooks).containsAll(expectedBooks);
        logger.info("Search result verified");
    }

    public void applySearchFilters(Map<String, String> searchFilters) {
        for (Map.Entry<String, String> entry : searchFilters.entrySet()) {
            new Select(driver.findElement(By.xpath(String.format(FILTER_SELECT, entry.getKey()))))
                    .selectByVisibleText(entry.getValue());
        }
        logger.info("Search filters applied");
    }

    public void verifySearchResultAfterFiltering(List<String> expectedBooks) {
        List<String> actualBooks = driver.findElements(By.xpath(SEARCH_RESULTS))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        softAssertions.assertThat(actualBooks).isEqualTo(expectedBooks);
        logger.info("Search result after filtering verified");
    }

    public void addBookToBasket(String bookName) {
        WebElement element = driver.findElement(By.xpath(String.format(ADD_TO_BASKET, bookName)));
        element.click();
        logger.info("Book added to basket");
    }

    public void selectBasketPopUp(String basketPopUp) {
        WebElement popUp = driver.findElement(By.xpath(String.format(BASKET_POP_UP, basketPopUp)));
        browserService.clickJS(popUp);
        logger.info("Basket/Checkout selected");
    }
}
