Feature: Fetch all students from a class

  Scenario Outline: Verify that all students are returned for a given class
    Given Student class to fetch: "<studentClass>"
    When I submit a get request
    Then I should see all students that belong to class : "<studentClass>"

    Examples:
      | studentClass |
      | 1 A |