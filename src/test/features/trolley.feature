@trolleyTest
Feature: Adding product to trolley in Argos website
  As a Customer
  I want to add product to trolley
  So that I can pay to buy product/s

  Scenario: To add the product to Trolley in Argos website by logging in first
    Given I am on home page
    When I search for a product "<prod>"
    Then I should be able to view respective list of product
    And I choose the product randomly by clicking on Add to trolley button
    And click on Go to Trolley button
    And enter post code to check stock availability
    And then click enter key in the keyboard to get feedback on stock
    And then click on Delivery button
    And click on CONTINUE WITH DELIVERY button

