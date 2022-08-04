Feature: Add an existing student to the database

  Scenario Outline: Verify that an existing student cannot be re-added to the database
    Given New student "<id>" with "<firstName>", "<lastName>", "<studentClass>", "<nationality>"
    When I submit a post request
    Then I should be told Exception occurred while adding new student: Student already exists with student id: "<id>"

    Examples:
      | id   | firstName | lastName | studentClass | nationality
      | 1001 | John      | Smith    | 1 A          | USA
      | 1002 | Jane      | Doe      | 2 A          | Canada