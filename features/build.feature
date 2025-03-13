Feature: Customizing the order
 As a customer,
 I want to customize my own drink,
 So that I can build my favorite drink within 5 minutes.

S - Allowing the customer to create their own drink.
M - The user can build and order their drink within 5 minutes.
A - This can be completed within an agile iteration.
R - Allowing the customer to have their perfect drink.
T - To be completed by the end of May 2025.

Scenario: I want to go to -Build your own- page
  Given I am on the home screen
  When I press the "Start Order" button
  Then I will go to the "Order" page
  When I press the "Build your own" button
  Then I will go to "Build your own" page

Scenario: I want to have multiple toppings
  Given I'm on the "Build your own" screen,  
  When I select the toppings that I want,
  Then It will appear in the "Selected" section.

Scenario: I want to only have 50% ice in my drink
  Given I'm on the "Build your own" screen,
  When I click on the 50% ice amount option,
  Then The drink will contain that amount of ice.

Scenario: I want to order my drink.
  Given I'm on the "Build your own" screen,
  When I add the drink to my cart,
  Then I will be taken to the "Shopping Cart" screen.
