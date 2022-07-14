@desktop
Feature: Desktops page

  Background: on retail website, clicks desktops tab
    When User clicks on Desktops tab
    And User clicks on Show all desktops

  @desktop
  Scenario: User verify all items are present in Desktops tab
    Then User should see all items are present in Desktop page

  @desktop
  Scenario: User add HP LP 3065 from Desktops tab to the cart
    And User clicks ADD TO CART option on HP LP3065 item
    And User selects quantity 1
    And User clicks add to Cart button
    Then User should see a success message "Success: You have added HP LP3065 to your shopping cart!"

  @desktop
  Scenario: User add Canon EOS 5D from Desktops tab to the cart
    And User clicks ADD TO CART option on EOS 5D item
    And User selects quantity 1
    And User clicks add to Cart button
    Then User should see a success message "Success: You have added Canon EOS 5D Camera to your shopping cart!"

  @desktop
  Scenario: User add a review to Canon EOS 5D item in Desktops tab
    And User click on Canon EOS 5D item
    And User click on write a review link
    And User fill the review information with below information
      | yourname | review                            | Rating |
      | mazyar   | very nice product i really am happy with the quality |      1 |
    And User clicks on Continue button
    Then User should see a message with "Thank you for your review. It has been submitted to the webmaster for approval."
