Feature: feature to go to cart and verify selected laptop displayed successfully

#Steps 6
Scenario: User is able to go to cart and verify Item is visible in cart with expected details

Given user is successfully able to add Laptop in the cart and is on the Laptop page
When user selects Cart button on the page
Then user is presented with product they have selected
