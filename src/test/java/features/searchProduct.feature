Feature: Search and place the order for Products

  @Offers
  Scenario Outline: Search experience for product search in both Home and Offers page
    Given User is on GreenKart landing page
    When User searched with shortname <Name> and extracted actual name of product
    Then User searched for <Name> shortname in Offers page
    And Validate product name in Offers page matches with Home page
    Examples:
      | Name |
      | Tom  |
      | Beet |