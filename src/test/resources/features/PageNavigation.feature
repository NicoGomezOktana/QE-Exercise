Feature: Swag Labs Page navigation

  Scenario: User goes to About Page and come back to Main page
    Given User navigates to https://www.saucedemo.com/
    And logs in as a Standard User
    When User goes to About Page
    And User goes back to Product Page
    Then User sees the Page correctly

