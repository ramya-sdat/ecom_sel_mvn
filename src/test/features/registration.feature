@registrationTest
Feature: Registration
  As a new customer
  I want to register with Argos website
  So that I can do online shopping at Argos

  Scenario: Register for online shopping
    Given I am on home page
      And Customer should have existing email id
    When I click on Account link on top right of the menu
      And I click on Register link at the bottom
      And I enter the email id as "testemail@test.com"
      And I click on Continue button
      And I select Title as "Ms"
      And I enter First name as "firstName"
      And I enter Last name as "lastName"
      And I enter Mobile number as "01234567890"
      And I enter Postcode as "e16 2ds"
      And I click on SAVE AND CONTINUE button
      And Enter the password "Fedcba091"
      And then re-type the password "Fedcba091"
      And I click on Save and Continue button
    Then Customer should be able to successfully register

