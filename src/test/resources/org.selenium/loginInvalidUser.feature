Feature: Login Form

  Scenario Outline: Verify login is unsuccessful for a valid user
    Given Chrome web browser
    When I login with "<user>" and "<password>" at "<url>"
    Then I should get an error message: "<output>"

    Examples:
      | user     | password       | url                                     | output                    |
      | tomsmith | abcdefghijkl   | http://the-internet.herokuapp.com/login | Your password is invalid! |