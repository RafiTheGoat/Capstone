@laptopnote
Feature: laptop & Notebooks

  Background: user is on retail, clicks on laptops and notebooks option
    When User clicks on Laptop & Notebook option
    And User clicks on Show all Laptop & Notebook option

  @laptopnote
  Scenario: Add and Remove a Macbook from the cart
    And User clicks on MackBook item
    And User click add to cart button
    Then User should see a success message for macbook "Success: You have added MacBook to your shopping cart!"
    And User should see '1 item(s) - $602.00' displayed from the cart
    And User clicks on cart option
    And User clicks on red X button to remove the item from the cart
    Then item should be removed and cart should show '0 item(s) - $0.00'

  @laptopnote
  Scenario: Product comparison
    And User clicks on product comparison icon on 'MacBook'
    And User clicks on product comparison icon on a 'MacBook Air'
    Then User should see a success message 'Success: You have added MacBook to your product comparison!'
    And User clicks on comparison link
    Then User should see product comparison chart
	@laptopnote
  Scenario: Adding an item to wish list
    And User clciks on heart icon to add Sony Vaio laptop to wish list
    Then User should get a message 'You must login or create an account to save Sony VAIO to your wish list!'
    
  @laptopnote  
  Scenario: Validate price of Macbook Pro
   And User click on 'MacBook Pro' item
   Then User should see  '$2,000.00' price tag is present on UI.  
