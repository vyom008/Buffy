Feature: feature to open website and naviagte to login page successfully

#Steps 1
Scenario: Validate user is able to open demoblaze website and able to navigate to login page successfully

Given chrome browser is open
And selects to open demo blaze website and is on the home page
When user clicks on Log in
Then user is navigated to Log in page