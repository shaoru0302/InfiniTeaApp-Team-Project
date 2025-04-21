Feature: View and Reorder Past Orders
 As a customer using the App,
 I want to access my past orders from the homepage and reorder drinks,
 So that I can quickly track my purchases and effortlessly reorder my favorite drinks.

S - Users should be able to click "My Orders" from the homepage, view past orders, and reorder in one tap.
M - Users should reach their order history within 2 seconds and reorder in 1 tap.
A - This feature can be implemented within one agile iteration.
R - It enhances user convenience by making order tracking and reordering seamless.
T - This feature will be completed and tested by the end of May 2025.

Scenario: Access past orders from the homepage  
   Given I am on the homepage  
   When I click the "My Orders" button  
   Then I should be taken to the "My Orders" page  
   And I should see a list of my past orders
   And if there no order exists yet, I should see a empty list

Scenario: Search and filter my past orders by order number  
   Given I am on the "My Orders" page  
   When I enter an order number in the search bar  
   Then I should see only the matching order displayed  
   And if the order number does not exist, I should see a message "Order not found"  

Scenario: Reorder a past order 
   Given I am on the "My Orders" page
   And I see the favorite drink on the list   
   When I select some items, also tap the "Reorder" button
   Then the same drinks with the same customizations should be added to my shopping cart  
   And I should see a confirmation message "Your drinks have been added to the cart!" 
   And items in the cart and the total price should be updated accordingly 
  
Scenario: Reorder a past order when an item is out of stock  
   Given I am on the "My Orders" page  
   And I find my favorite drink on the list  
   When I select some items, also tap the "Reorder" button  
   Then the system should check if all items in the order are available  
   And if one or more items are out of stock, I should see the message "Some items are out of stock" 
   And only the available items should be added to my shopping cart
   When I tap the "Reorder" button again
   Then I should see a confirmation message "Your updated order has been added to the cart!"  
   And items in the cart and the total price should be updated accordingly
