Feature: Store inputting their menu

As a user of the app
I want to advertise my store in the app
So that I can improve sales and gain attraction.

S - I want to input the store's menu into the app so that it can be publicly viewed.
M - Stores can set up their shop within one session.
A - This can be achieved within a agile iteration (one week).
R - Allowing various stores to input their own menu into the app.
T - To be implemented by the end of May 2025.

Scenario: I want to put a store in the app
Given - I am on the home page
When - I tap the add store button
Then - I should be able to add store along with its information.

Scenario: I want to edit the store page.
Given - I am on the store's page
When - I click on the edit button
Then - I can modify the store's information.

Scenario: I want to remove the store from the app
Given -I am on the store's page
When - I click on the delete button
Then - I am given a verification button so such that when accepted, it will delete the store page.