Feature: To Validate the multiple functionality login data

  Scenario Outline:
User Should Validate Multiple data User Id and Password

    Given User Should be launch the browser through ChromeBrowser
    When User Should be enter "<userName>" and "<password>"
    And User Should be click the login button
    And User check the Title and print the Title
    Then User Should be in Invalid Credential Page

    Examples:
      | userName              | passWord   |
      | Java123@gmail.com     | Java@123   |
      | Selenium123@gmail.com | sel@123    |
      | Python123@gmail.com   | python@123 |
      | Maven123@gmail.com    | maven@123  |
