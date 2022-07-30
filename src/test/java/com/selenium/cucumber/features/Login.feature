@severity=blocker 
@issue=WFM-3425
@issue=WFM-5786
Feature: Feature to test valid and invalid Login functionality

  Background: I am on the login page
    Given I launch the Login page

 	@SmokeTest
  Scenario Outline: I login the website with invalid email and password
    When I enter invalid "sathia.s@xyz.com" and "12345678" to login
    Then I verify invalid "Invalid login" text displayed

  @SmokeTest
  Scenario Outline: I login the website with valid email and password
    When I enter credential to login
      | emailId               | password   |
      | coolamitece@gmail.com | Amit1234@# |
    Then I verify valid "Amit Kumar" text displayed on welcome page
