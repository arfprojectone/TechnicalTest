Feature: Search Feature

  Scenario: User see No rows found
    Given User go to https://demoqa.com/books
    When User in Book Store page
    And User search book qa engineer
    Then User see No rows found

  Scenario: User see Git Pocket Guide
    Given User go to https://demoqa.com/books
    When User in Book Store page
    And User search book Git Pocket Guide
    And User click book Git Pocket Guide
    Then User see Git Pocket Guide
