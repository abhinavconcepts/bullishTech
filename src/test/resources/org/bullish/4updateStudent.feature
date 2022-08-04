@update
Feature: Update existing student in the Database

  Scenario Outline: Verify that a student gets updated in the database
    Given Update student "<id>" with "<studentClass>"
    When I submit a put request
    Then I should be told Student data updated with id : "<id>"

    Examples:
      | id   | studentClass
      | 1001 | 1 B
      | 1002 | 2 B