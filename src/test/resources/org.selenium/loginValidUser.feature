Feature: Login Form

  Scenario Outline: Verify login is successful for a valid user
    Given Chrome web browser
    When I login with "<user>" and "<password>" at "<url>"
    Then I should be told "<output>"

    Examples:
      | user     | password             | url                                     | output                                                            |
      | tomsmith | SuperSecretPassword! | http://the-internet.herokuapp.com/login | Welcome to the Secure Area. When you are done click logout below. |