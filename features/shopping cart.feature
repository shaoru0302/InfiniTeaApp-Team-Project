Feature: shopping cart
  As a user
  I want to view the listed products I have added to the cart
  So that I can edit the product, remove it from the list, and confirm my purchase

S - Allow customers to view, edit, remove, and confirm the list of products they have selected in their shopping cart
M - Customers should be able to remove, edit, and confirm the purchase within minutes 
A - This can be achieved within a agile iteration (one week)
R - Customers should be able to easily manage their cart, ensuring a smooth and hassle-free shopping experience
T - To be implemented by the end of May 2025


Scenario: edit a product in the shopping cart
   Given: I am on the home screen
   when I am on the shopping cart page
   then I click a product shown in the cart list
   Then I will be taken back to the order page, I should be able to modify product details
   And the changes should be updated in the cart


Scenario: Remove all products from the list
    Given I am on the shopping cart
    When I click the "Remove All" button
    Then all the products on the list will be removed
  

Scenario: Confirm order
    Given I am on the shopping cart
    When I click the "Order" button
    Then the order will be placed
    And if the cart is empty, the order button will be disabled
   

Scenario: Remove a product from the list
    Given I am on the shopping cart
    When I click the "X" mark on the right-hand side of the product
    Then a comfirm message will pop up and ask "Sure to remove items?" 
    When click confirm button
    Then the product should be removed from the list
    And the total price will be updated





