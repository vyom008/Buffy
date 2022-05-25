Feature: feature to test google search fuctionality

Scenario: Validate google search is working

Given browser is open
And user is on google search page
When user enters a text in search box page
And hits enter
Then user is navigated to search results
