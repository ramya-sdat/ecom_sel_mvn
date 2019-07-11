Feature: Search
  As a customer
  I want to search for a product
  So that i can view respective product list

  Scenario: Search for a product
    Given I am on home page
    When I search for a product puma
    Then I should be able to view respective list of product

  Scenario: Search for a product
    Given I am on home page
    When I search for a product "pen drive"
    Then I should be able to view respective list of product

  Scenario Outline: Search for a product
    Given I am on home page
    When I search for a product "<item>"
    Then I should be able to view respective list of product
    Examples:
      | item      |
      | nike      |
      | ear phone |
