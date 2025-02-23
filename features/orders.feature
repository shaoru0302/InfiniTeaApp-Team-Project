Feature: Placing an Order
  As a user
  I want to place my order online 
  So that I can avoid long wait times and recieve my drink within 5mins

S - Reduces in-store wait time by ordering online  
M - You get your drink within 5 minutes
A - Can be completed in one agile iteration
R - Goal is to improve the user experience via shorter wait times
T - To be implemented by the end of May 2025

Scenario: Build Your own
    Given I am on the -Order page-
    When I choose my drink size
    Then I click Build your own
    Then I can go to the -Build your own- page

Scenario: Classic Drink
    Given I am on the -Order page-
    When I pick a Classic drink
    Then I choose the drink size
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