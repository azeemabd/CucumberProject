Feature: To Validate the Login Funtionality in Facebook Application
Scenario: User Should be enter Valid email and Invalid Password
Given User Should be launch the browser through ChromeBrowser
When User Should be enter Valid email and Invalid Password 
And User Should be click the login button 
And User check the Title and print the Title
Then User Should be in Invalid Credential Page


Scenario: User Should be enter Invalid email and Invalid Password
Given User Should be launch the browser through ChromeBrowser
When User Should be enter Invalid email and Invalid Password 
And User Should be click the login button 
And User check the Title and print the Title
Then User Should be in Invalid Credential Page