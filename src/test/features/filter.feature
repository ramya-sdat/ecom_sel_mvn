@filterTest
Feature: Filter products by Customer Rating and Price Range
  As a customer
  I want to search the product upon customers rating
  So that it helps me to buy a good product

#  Background: I am on home page

  Scenario Outline: Filter the product by Customer Rating
    Given I am on home page
    When I search for a product "<prod>"
    Then I should be able to view respective list of product
#    And scroll down to the customer ratings element on the page
    And I will choose the option "5or more"
    And then I should get list as per selected Customers Rating
    Examples:
      | prod   |
      | laptop |
      | mobile |

#  Scenario Outline: Filter the product by Price Range
#    Given I am on home page
#    When I search for a product "<prod>"
#    Then I should be able to view respective list of product
#    And I will choose the Price Range "£15 - £20"
#    And then I should get list as per selected Price Range
#    Examples:
#      | prod   |
#      | laptop |
#      | tv     |