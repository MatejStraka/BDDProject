Feature: Wikipedia
  Scenario: Search info about BDD
    Given I am on the Wikipedia search page
    When I search for "BDD"
    Then the page title should start with "BDD"

  Scenario: Search info about BDD
    Given I am on the Wikipedia search page
    When I search for "     BDD"
    Then the page title should start with "BDD"

  Scenario: Search empty info
    Given I am on the Wikipedia search page
    When I search for ""
    Then the page title should start with "Search"

  Scenario: Search empty info
    Given I am on the Wikipedia search page
    When I search for "      "
    Then the page title should start with "Search results"
