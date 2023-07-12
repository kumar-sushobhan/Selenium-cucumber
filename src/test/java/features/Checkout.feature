Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: Search experience for product search in both Home and Checkout page
    Given User is on GreenKart landing page
    When User searched with shortname <Name> and extracted actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in Checkout page
    And Verify user has ability to enter promo code and place the order
    Examples:
      | Name |
      | Tom  |