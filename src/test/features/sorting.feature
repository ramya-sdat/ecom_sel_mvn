@sortingTest
Feature: Sorting
  As a customer
  I want to sort the searched product in an order
  So that I can get the result in required order

  Scenario Outline: Sort the searched product by selecting from the dropdown list
    Given I am on home page
    When I search for a product "<item>"
    Then  I should be able to view respective list of product
    And click dropdown to choose "Price: Low to High"
#    And Select dropdown to choose "<option>"
    Examples:
      | item |
      | puma |
      | nike |
#      | item        | option               |
#      | puma        | Price: Low to High   |
#      | nike        | Price: Low to High   |
#      | mobile      | Avg. Customer Review |
#      | card wallet | Newest Arrivals      |
#      | bag pack    | Price: Low to High   |
