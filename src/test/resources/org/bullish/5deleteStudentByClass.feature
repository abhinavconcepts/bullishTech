@delete
Feature: Delete existing student in the Database

  Scenario Outline: Verify that a student gets deleted from the database
    Given Delete student with "<id>"
    When I submit a delete request
    Then I should be told Student deleted with student id : "<id>"

    Examples:
      | id   |
      | 1001 |
      | 1002 |