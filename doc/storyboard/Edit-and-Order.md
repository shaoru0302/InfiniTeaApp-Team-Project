# Storyboard: View edit and Order 


## **User Story**
As a customer,
I want to view the listed products I have added to the cart,
So that I can edit the product, remove it from the list and confirm my purchase.
[User Story](../../features/shopping-cart.feature)



## **Scenario: view product in shopping cart**
- The client opens the app and taps  **"Shopping Cart"** from the homepage.

![Menu Page](../images/classic-drink/order_homescreen.png)

-The user should see listed of product that were added by the user and with detail for each product .

![ product on cart](../images/Shopping-cart/Shopping-cart-with-product.png)

-If no product were add to the cart , it will display Empty in the list

![Empty Cart](../images/Shopping-cart/Empty-Shopping-cart.png)



---


## **Scenario: Edit products through the shopping cart**

-I am on the shopping cart page

-I click a product listed in the cart

![ product on cart](../images/Shopping-cart/Shopping-cart-with-product.png)

-Then I will be redirected to the "My Orders" page with the pre-recorded details of the product

![Detail on Edit](../images/Shopping-cart/Edit-product.png)

-Then if I change the size from Large to Small and click the "Add to Cart" button
 
![Change were made](../images/Shopping-cart/Change-detail.png)

-Then the change will be immediately updated in the shopping cart

![Update the change](../images/Shopping-cart/Update-after-edit.png)

- But if I make the change but do not click the "Add to Cart" button and instead click the back arrow

![change denied](../images/Shopping-cart/Edit-product.png)



---



## **Scenario: Remove a product from the list**

-I'm on the Shopping cart

-I click the "X" mark on the right-hand side of the product

![Remove with X](../images/Shopping-cart/Click-X-Mark.png)

-A confirm message will pop up and ask "Sure to remove?"

-Then I click confirm button

![Remove with X confirm message](../images/Shopping-cart/Remove-from-x-mark-message-confirm.png)

-Then the product should be removed from the list

-And the update will be applied to the cart  


![Remove with X Update](../images/Shopping-cart/Removed-From-X-Mark.png)

-And if click cancel button  

-Then not change were made

![cancel confirm](../images/Shopping-cart/Shopping-cart-with-product.png)

---

## **Scenario: Remove All product at one click **


-I am on the shopping cart

-When I click the "Remove All" button

![Remove All](../images/Shopping-cart/Click-remove-all.png)

-Then a confirm message will pop up and ask **"Sure to Remove All"**
-When user click confirm button

![Remove All message ](../images/Shopping-cart/Remove-All.png)

-Then all the products on the list will be removed

-And the change will be updated

![Remove All confirmed](../images/Shopping-cart/Empty-Shopping-cart.png)


---


## **Scenario: Confirm order **

-I am on the shopping cart

-When I click the **"Order"** button

![click order button](../images/Shopping-cart/Click-Order.png)

-Then a message will be pop out say "Order Confirm "

- i click the "confirm " button

![click confirm button for order](../images/Shopping-cart/Order-confirm-message.png)

-Then a "Successful" message will pop out
 
![order successful](../images/Shopping-cart/Successful-order.png)

-Then i will be direct to a page that show the detail of the order 

![Detail page](../images/Shopping-cart/Order-detail.png)

-Then 10 second later i will be automatically direct back to the Home page

