package com.epam.automation.steps;

import com.epam.automation.pages.SearchPage;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class SearchPageSteps {

    private final SearchPage searchPage;

    public SearchPageSteps() {
        this.searchPage = new SearchPage();
    }

    @And("Search page is opened")
    public void searchPageIsOpened() {
        searchPage.verifySearchPageIsOpened();
    }

    @And("search results contain the following products:")
    public void searchResultsContainTheFollowingProducts(List<String> expectedBooks) {
        searchPage.verifySearchResult(expectedBooks);
    }

    @And("user applies the following search filters:")
    public void userAppliesTheFollowingSearchFilters(Map<String, String> searchFilters) {
        searchPage.applySearchFilters(searchFilters);
    }

    @And("Search results contain only the following products:")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> expectedBooks) {
        searchPage.verifySearchResultAfterFiltering(expectedBooks);
    }

    @And("user clicks 'Add to basket' button for product with name {string}")
    public void userClicksAddToBasketButtonForProductWithName(String bookName) {
        searchPage.addBookToBasket(bookName);
    }

    @And("selects {string} in basket pop-up")
    public void selectsBasketCheckoutInBasketPopUp(String basketPopUp) {
        searchPage.selectBasketPopUp(basketPopUp);
    }
}
