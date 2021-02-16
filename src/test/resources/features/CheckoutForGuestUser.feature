@smoke
Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as guest user
    Given an anonymous user clears cookies
    And Home page is opened
    And user searches for "Thinking in Java" book
    And Search page is opened
    And search results contain the following products:
      | Thinking in Java               |
      | Think Java                     |
      | Thinking Recursively with Java |
    And user applies the following search filters:
      | Price range  | 30 € +         |
      | Availability | In Stock (6)   |
      | Language     | English (16)   |
      | Format       | Paperback (21) |
    And click "Refine results" button
#    And Search results contain only the following products:
#      | Thinking in Java                                                      |
#      | Think Java                                                            |
#      | Thinking Recursively with Java                                        |
#      | Java and Algorithmic Thinking for the Complete Beginner (2nd Edition) |
#    And user clicks 'Add to basket' button for product with name "Thinking in Java"
#    And selects 'Basket / Checkout' in basket pop-up
#    And Basket page is opened
#    And Basket order summary is as following:
#      | Delivery cost | FREE    |
#      | Total         | 65,17 € |
#    And user clicks 'Checkout' button on Basket page
#    And Checkout order summary is as following:
#      | Sub-total | 65,17 € |
#      | Delivery  | FREE    |
#      | VAT       | 0,00 €  |
#      | Total     | 65,17 € |
#    And user sets email address as 'test@user.com'
#    And selects 'Delivery country' as 'Ukraine'
#    And user fills delivery address information manually:
#      | Full name      | John             |
#      | Address line 1 | Random address 1 |
#      | Address line 2 | Random address 2 |
#      | Town/City      | Kyiv             |
#      | County/State   | Random State     |
#      | Postcode       | 001              |
#    And 'Payment' section is disabled for editing
#    When click "Continue to payment" button
#    And user enters card details:
#      | Card Type    | Visa             |
#      | Card Number  | 4111111111111111 |
#      | Name On Card | RandomName       |
#      | Expiry Year  | 2022             |
#      | Expiry Month | 03               |
#      | Cvv          | 123              |