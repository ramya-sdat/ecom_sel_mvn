@loginTest
Feature: Login to the Argos website
  As a customer
  I want to login to the Argos website
  So that I can do online shopping

  Scenario: Login to the Argos website
    Given I am on home page
    When I click on Account link in the Home page
    Then enter email address as "testemail@test.com"
    And enter password as "Fedcba091"
    And click on SIGN IN SECURELY button
    And I should be able to see a success screen