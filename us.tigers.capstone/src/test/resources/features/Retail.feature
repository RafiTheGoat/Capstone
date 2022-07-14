@retail
Feature: Retail page

  Background: 
    And User click on MyAccount
    When User click on Login
    And User enter username 'jondoe8@gmail.com' and password 'abc123'
    And User click on Login button
    Then User should be logged in to MyAccount dashboard

  @retail
  Scenario: Register as an Affiliate user with Cheque Payment Method
    When User click on 'Register for an affiliate account' link
    And User fill affiliate form with below information
      | company | website     | taxID | paymentMethod |
      | maz     | johndoe.com | 09123 | Cheque        |
    And User click on Continue button
    Then User should see a success message

#	Scenario: Edit your affiliate information from Cheque payment method to Bank Transfer 
#	When User click on ‘Edit your affiliate informationlink
#	 And user click on Bank Transfer radio buttonAnd User fill Bank information with below information|bankName|abaNumber|swiftCode|accountName|accountNumber|
#	 And User click on Continue button
#	 Then User should see a success message 
	
  @retail
  Scenario: Edit your account information
    When User clicks on 'Edit your account information' link
    And User modify below information
      | firstName | lastName | email                | phone      |
      | joel      | does     | jondo221456@gmail.com | 9393939393 |
    And User click on continue button
    Then User should see a message 'Success: Your account has been successfully updated.'
