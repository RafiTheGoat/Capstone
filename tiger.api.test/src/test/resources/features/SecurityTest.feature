Feature: Security test. Token generation

  Background: 
    Given url "https://tek-insurance-api.azurewebsites.net"
    And path "/api/token"

  Scenario: generate token with valid username and password
    And request {"username": "supervisor","password": "tek_supervisor"}
    When method post
    Then status 200
    And print response

  Scenario: Invalid username
    And request {"username": "superwvisor","password": "tek_supervisor"}
    When method post
    Then status 404
    And print response
    * def errorMessage = response.errorMessage
    And assert errorMessage == "USER_NOT_FOUND"
