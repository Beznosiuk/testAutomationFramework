package com.epam.automation.steps;

import com.epam.automation.pages.CheckoutPage;
import io.cucumber.java.en.And;

import java.util.Map;

public class CheckoutPageSteps {

    private final CheckoutPage checkoutPage;

    public CheckoutPageSteps() {
        this.checkoutPage = new CheckoutPage();
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(Map<String, String> orderSummary) {
        checkoutPage.verifyCheckoutOrderSummary(orderSummary);
    }

    @And("user fills delivery address information manually:")
    public void userFillsDeliveryAddressInformationManually(Map<String, String> deliveryAddress) {
        checkoutPage.clickEnterAddressManually();
        checkoutPage.setDeliveryAddress(deliveryAddress);
    }

    @And("user sets email address as {string}")
    public void userSetsEmailAddress(String email) {
        checkoutPage.setEmailAddress(email);
    }

    @And("selects 'Delivery country' as {string}")
    public void selectsDeliveryCountryAsUkraine(String country) {
        checkoutPage.selectCountry(country);
    }

    @And("{string} section is disabled for editing")
    public void sectionIsDisabledForEditing(String section) {
        checkoutPage.verifySectionIsDisabled(section);

    }

    @And("user enters card details:")
    public void userEntersCardDetails(Map<String, String> cardDetails) {
        checkoutPage.setCardDetails(cardDetails);
    }
}
