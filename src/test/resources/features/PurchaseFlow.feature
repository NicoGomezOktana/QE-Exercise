Feature: Testing the purchase flow

  Background:
    Given User navigates to https://www.saucedemo.com/
    And logs in as a Standard User


    Scenario Outline: User adds items to their cart
      Given User sorts the product from low to high price
      When User adds the <number_items> most expensive products to the cart
      Then The top right section displays the number <number_items>

      Examples:
      |number_items   |
      |4              |
      |6              |

    Scenario Outline: User buys the products
      Given User sorts the product from low to high price
      And User adds the 4 most expensive products to the cart
      When User goes to Shopping Cart
      And User goes to Checkout
      And User fills <first_name>, <last_name> and <zip_code>
      And User checks purchase and finishes the purchase
      Then A success message is displayed
      Examples:
        |first_name|last_name  |zip_code|
        |Juan      |Perez      |12345   |

  Scenario Outline: User enters wrong information
    Given User sorts the product from low to high price
    And User adds the 4 most expensive products to the cart
    When User goes to Shopping Cart
    And User goes to Checkout
    And User fills <first_name>, <last_name> and <zip_code>
    Then An error message is displayed
    Examples:
      |first_name|last_name  |zip_code|
      |     |Perez      |12345   |
      |Juan      |      |12345   |
      |Juan      |Perez      |   |