Feature: Navigation from Home Screen

As a customer using the InfiniTea App,
I want to easily navigate from the home screen to different parts of the app,
So that I can quickly start an order, check my cart, or review my past orders without any hassle.

S - The home screen should have buttons that let users quickly access the order page, shopping cart, and order history with a single tap.
M - Users should be able to reach any of these three pages within one tap and under 2 seconds.
A - This feature can be completed within one agile iteration (1 week).
R - Easy navigation helps users quickly place orders and check their cart or order history.
T - This feature will be completed and tested by the end of May 2025.

Scenarios for the Home Screen

Scenario 1: Starting a New Order
Given I’m on the Home Screen,
When I tap the Start Order button,
Then I should be taken to the Order Page, where I can begin choosing my drinks.

Scenario 2: Checking my Shopping Cart
Given I’m on the Home Screen,
When I tap the Shopping Cart button,
Then I should be taken to the Shopping Cart Page, where I can see the drinks I’ve added.
And if there are no items in the cart, a pop-up message should appear saying, "Your cart is empty."

Scenario 3: Viewing My Past Orders
Given I’m on the Home Screen,
When I tap the My Order button,
Then I should be taken to the Order History Page, where I can check the details of my past orders.
