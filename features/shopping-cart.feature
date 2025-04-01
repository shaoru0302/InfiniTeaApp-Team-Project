Feature: shopping cart
  As a user
  I want to view the listed products I have added to the cart
  So that I can edit the product, remove it from the list, and confirm my purchase

# S - Allow customers to view, edit, remove, and confirm the list of products they have selected in their shopping cart
# M - Customers should be able to remove, edit, and confirm the purchase within minutes 
# A - This can be achieved within a agile iteration (one week)
# R - Customers should be able to easily manage their cart, ensuring a smooth and hassle-free shopping experience
# T - To be implemented by the end of May 2025


Scenario: Veiw products in the shopping cart
   Given I am on the home screen
   When I click to the shopping cart button
   Then I should be taken to the "Shopping Cart" page
   Then I should see the product that were added to the shopping cart
   And if nothing is on the cart yet ,it will display Empty


Scenario: Edit products on the shopping cart
  Given I am on the shopping cart page
  When I click a product listed in the cart
  Then I will be redirected to the "My Orders" page with the pre-recorded details of the product
  And if I change the size from Large to Small and click the "Add to Cart" button
  Then the change will be immediately updated in the shopping cart
  But if I make the change but do not click the "Add to Cart" button and instead click the back arrow
  Then I will return to the shopping page without any changes being saved
    



Scenario: Remove a product from the list
  Given I am on the shopping cart
  When I click the "X" mark on the right-hand side of the product
  Then a confirm message will pop up and ask "Sure to remove?" 
  When click confirm button
  Then the product should be removed from the list
  And the update will be applie to the cart  
  And if click cancel button  
  Then not change were made


Scenario: Remove all products from the list
  Given I am on the shopping cart
  When I click the "Remove All" button
  Then a confirm message will pop up and ask "Sure to remove All"
  When user click confirm button
  Then all the products on the list will be removed
  And the change will be updated
  And the Remove All button and Order button will turn Dim indicate fucntion disable
    
Scenario: Confirm order
  Given I am on the shopping cart
  When I click the "Order" button
  Then a message will be pop out say "Order Confirm "
  Then i click the "confirm " button
  Then a "Successful" message will pop out
  Then the order placed
  Then i will be direct to a page that show the detail of the order 
  Then 10 secon later i will be automatically direct back to the Home page 
    
   






