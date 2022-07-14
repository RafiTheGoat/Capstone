Feature: Home Page

  Background: user is on retail web page
    Given User is on Retail website

  @Home
  Scenario: User verify currency values change
    When User clicks on Currency
    And User Chooses Euro from dropdown
    Then Currency Value should change to Euro

  @Home
  Scenario: User empties Shopping cart message displays
    When User Cliks on shopping cart
    Then "Your shopping cart is empty!" message should be displayed
