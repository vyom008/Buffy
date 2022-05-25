Feature: feature to login successfully and navigate to Home page

#Steps 2
Scenario: Validate user is able to login successfully and go to Home page

Given user is on the demo blaze website Log in page
When user enters username and password
Then user is navigated to demo blaze Home page