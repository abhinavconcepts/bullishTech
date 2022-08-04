@add
Feature: Add new student to the database

  Scenario Outline: Verify that a new student gets added to the database
    Given New student "<id>" with "<firstName>", "<lastName>", "<studentClass>", "<nationality>"
    When I submit a post request
    Then I should be told New student enrolled with student id : "<id>"

    Examples:
      | id   | firstName | lastName | studentClass | nationality
      | 1001 | John      | Smith    | 1 A          | USA
      | 1002 | Jane      | Doe      | 2 A          | Canada