Feature: As a user I want to be able to browse clothes catalog

  Scenario: test 1 - go to T-Shirt category
    Given User is on the automationpractice page
    When I click the "T-Shirts" button
    Then I can see the "T-Shirts" page header

  Scenario: test 2 - go to Dresses category
    Given User is on the automationpractice page
    When I click the "Dresses" button
    Then I can see the "Dresses" page header

  Scenario: test 3 - go to Women category
    Given User is on the automationpractice page
    When I click the "Women" button
    Then I can see the "Women" page header
