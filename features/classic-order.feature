Feature: Order menu item
  As a customer,
  I want to order a classic drink online 
  So that I can avoid long wait times and recieve my menu drink within 5mins

S - Reduces in-store wait time by ordering online  
M - You get your drink within 5 minutes
A - Can be completed in one agile iteration
R - Goal is to improve the user experience via shorter wait times
T - To be implemented by the end of May 2025

Scenario: Ordering menu drink
    Given I am on the -Home Screen-
    When I click Start Order
    Then I am on the -Menu- page
    Then I choose a Classic Drink from the options avaliable
    Then I am on the chosen drink's page
    Then I choose my <Drink Options>
    Then I click "Add to Cart"
    Then my drink should be shown on the -Shopping Cart- page
    Then I click "Place Order"
    Then I click "Yes"
    Then I see "Sucess"
    Then I see my order details

Scenario: Didn't choose drink option 
    Given I am on a -Specifc Drink-
    When I click Add to Cart before picking a <Drink Option>
    Then a pop-up will appear that asks the user to pick a <Drink Option>

Scenario: Order Confirmation
  Given I have successfully added a drink to the cart
  And I am on the -Shopping Cart- page
  When I click "Place Order"
  Then a pop up will appear that asks to user if they are sure
  Then I should see an order confirmation screen with a green circle with "Sucess and THANK YOU"
  And my order details should be displayed
