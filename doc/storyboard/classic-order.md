# Storyboard: Order menu item

## **User Story**
As a customer,  
I want to order a classic drink/s online,    
So that I can avoid long wait times and recieve my menu drink within 5mins.  
[User Story](../../features/classic-order.feature)

## **Scenario: Ordering menu drink**
- The user opens the app and taps on **"My Orders"** from the homepage.  
![Menu Page](../images/classic-drink/order_homescreen.png)

- The user sees a list of **classic drink items on the menu**.  
![List of Drinks](../images/classic-drink/order_start-order.png)

- The user sees a **description** of their selected drink. Additionally they can select options such as **size** of drink, the amount of **sugar** and **ice**.   
![Select Drink Options](../images/classic-drink/order_click-drink.png)

- The user clicks **add to Cart** then their drink appears on the **Shopping Cart**
![Shopping Cart](../images/classic-drink/order_add-cart.png)

---

## **Scenario: Didn't choose drink option**
- if the user clicks **add to Cart** without selecting a **drink option** 
![<Drink Option: None>](../images/classic-drink/order_no-option.png)

- if the user clicks **add to Cart** without selecting a drink **size** 
![<Drink Option: Size>](../images/classic-drink/order_no-size.png)

- if the user clicks **add to Cart** without selecting the amount of **sugar** 
![<Drink Option: Sugar](../images/classic-drink/order_no-sugar.png)

- if the user clicks **add to Cart** without selecting the amount **ice** 
![<Drink Option: Ice](../images/classic-drink/order_no-ice.png)

---

## **Scenario: Order Confirmation**
- The user is in **shopping cart**.
![Shopping Cart](../images/classic-drink/order_shopping-cart.png)

- The user clicks **place order**, then a pop-up appears asking users if they are sure.
![Order Confirmation](../images/classic-drink/order_order-confirmation.png)

- The user sees a **Green Success** screen.
![Success](../images/classic-drink/order_order-success.png)

-The user sees their **Order Details**.
![Order Details](../images/classic-drink/order_order-details.png)

