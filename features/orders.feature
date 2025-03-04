Feature: Order menu item
  As a customer,
  I want to order a classic drink online 
  So that I can avoid long wait times and recieve my menu drink within 5mins

S - Reduces in-store wait time by ordering online  
M - You get your drink within 5 minutes
A - Can be completed in one agile iteration
R - Goal is to improve the user experience via shorter wait times
T - To be implemented by the end of May 2025

Scenario: Ordering drink
    Given I am on the -Home Screen-
    When I click Start Order
    Then I am on the -Order Page-
    Then I choose a Classic Drink from the options avaliable
    Then I choose the size of my drink
    Then I chose the amount of sugar
    Then I chose the amount of ice
    Then I click Add to Cart
    Then my drink should be shown on the -Shopping Cart- page

Scenario: Click Left-Pointing-Arrow
    Given I am on the -Order page-
    When I click the arrow pointing left
    Then I should go to previous page that I was on

Scenario: Didn't choose drink size - Build your own
    Given I am on the -Order page-
    When I click Build your own before picking a drink size
    Then a pop up will appear that asks the user to pick a drink size

Scenario: Didn't choose drink size - Add to Cart
    Given I am on the -Order page-
    When I click Add to Cart before picking a drink size
    Then a pop up will appear that asks the user to pick a drink size