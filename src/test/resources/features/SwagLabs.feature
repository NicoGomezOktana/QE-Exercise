Feature: Testing the store

  Background:
    Given User navigates to https://www.saucedemo.com/
    And logs in as a Standard User

    Scenario: User goes to About Page and Returns
      Given User goes to About Page
      Then User goes back to Product Page

    Scenario Outline: User adds items to their cart
      Given User sorts the product from low to high price
      And User adds the <number_items> most expensive products to the cart
      Then The top right section displays the number <number_items>

      Examples:
      |number_items   |
      |4              |
      |6              |

    Scenario: User buys the products
      Given User sorts the product from low to high price
      And User adds the 4 most expensive products to the cart
      And User goes to Shopping Cart
      And User Goes to Checkout
      And User fills personal data
      And User checks purchase and finishes the purchase
      Then A success message is displayed

