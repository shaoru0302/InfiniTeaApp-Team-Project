# Storyboard: View and Reorder Past Orders  

## **User Story**

As a customer using the App,  
I want to access my past orders from the homepage and reorder drinks,  
So that I can quickly track my purchases and effortlessly reorder my favorite drinks.

## **Step 1: Access the My Orders Page**
- The user opens the app and taps on **"My Orders"** from the homepage.  
![My Orders Page](../images/home-page.jpg)



As a customer using the App,  
I want to access my past orders from the homepage and reorder drinks,  
So that I can quickly track my purchases and effortlessly reorder my favorite drinks.
[User Story](../../features/past-order.feature)


## **Step 2: View Past Orders**
- The user sees a list of their **past orders**.  
![Past Orders List](../images/past-orders-list.jpg)

- If no past orders exist, an **empty list** is displayed.  
![Past Orders List](../images/no-orders-list.jpg)


## **Scenario: Access past orders from the homepage**


- I open the app, and I am on the homepage, When I tap on **"My Orders"** button.
   
![My Orders Page](../images/past-order/home-page.jpg)


## **Step 3: Search for a Past Order**
- The user enters an **order number** in the search bar to find a specific past order.  
![Search Order](../images/search-order.jpg)

- The user should see only the matching order displayed
![Search Order](../images/order-match.jpg)
  
- if the order number does not exist, the user should see the message "Order not found" 
![Search Order](../images/order-not-found.jpg)

- I should be taken to the **"My Orders" page**
- I should see a list of my **past orders**, if the orders exsit.
  
![Past Orders List](../images/past-order/past-orders-list.jpg)


- If no past orders exist, then an **empty list** is displayed.
  
![Past Orders List](../images/past-order/no-orders-list.jpg)


## **Step 4: Select an Order for Reordering**
- The user selects a **previously placed order** they want to reorder, also tap the "Reorder" button  
![Select Past Order](../images/selected-past-orders.jpg)

- The system checks the **availability of all items**.  
- The user should see a confirmation message "Your drinks have been added to the cart!" 
![Order Added to Cart](../images/order-added.jpg)


---


## **Step 5: Handle Out-of-Stock Items**
- If an item is **out of stock**, the system shows a warning message - "items are out of stock".  
- The user can **proceed with available items** or **unselect the items to cancel the reorder**.  
![Out of Stock Warning](../images/out-of-stock-warning.jpg)

---

## **Step 6: Order Successfully Added to Cart**
- The user taps the "Reorder" button again, and the order is successfully **added to the shopping cart**.  
- The user sees a confirmation message **"Your updated order has been added to the cart!"**  
![Order Added to Cart](../images/order-updated.jpg)

## **Scenario: Search and filter my past orders by order number**

- I am on the "My Orders" page, when I enter an **order number** in the search bar to find a specific past order.
  
![Search Order](../images/past-order/search-order.jpg)

- I should see the matching order displayed only
  
![Search Order](../images/past-order/order-match.jpg)
  
- if the order number does not exist, I should see the message "Order not found"
  
![Search Order](../images/past-order/order-not-found.jpg)


---


## **Scenario: Select a Past Order for Reordering**

- I am on the "My Orders" page, When I select a **previously placed order** in the list that I want to reorder, then I tap the "Reorder" button
  
![Select Past Order](../images/past-order/selected-past-orders.jpg)

- The system checks the **availability of all items**, then the same drinks with the same customizations should be added to my shopping cart, and I should see a confirmation message - "Your drinks have been added to the cart!"
  
![Order Added to Cart](../images/past-order/order-added.jpg)


---


## **Scenario: Handle Out-of-Stock Items**

- I am on the "My Orders" page, when I select my favorite drink from the list, if an item is **out of stock**, the system should show a warning message - "items are out of stock".  Then I can choose to **unselect the drinks to cancel the reorder** or **proceed with available items by tapping the reorder button**.
  
![Out of Stock Warning](../images/past-order/out-of-stock-warning.jpg)

- When I tap the "Reorder" button, and the order is successfully **added to the shopping cart**. I should see a confirmation message - **"Your updated order has been added to the cart!"**
  
![Order Added to Cart](../images/past-order/order-updated.jpg)

