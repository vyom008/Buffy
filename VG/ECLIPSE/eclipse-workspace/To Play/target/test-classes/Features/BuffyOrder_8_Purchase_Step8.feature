Feature: feature to place order and note details page successfully

#Steps8
Scenario: User is able check Purchase Success message and note down details such as Id and Amount

Given user is on the place order page
And user enters all the details such as Name, Country, City, Credit Card Number and expiry month/ year
When user clicks on clicks Purchase on the page
Then Purchase Success message will be displayed and details will be noted
