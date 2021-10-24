Feature: Bank account

  Scenario: Withdraw money available in a user account
    Given Bank account with 1000 GBP
    When A user withdraw 500 GBP
    Then the withdraw operation should be possible
    And The account balance should be 500 GBP

  Scenario: Withdraw money available in a user account
    Given Bank account with 1000 GBP
    When A user withdraw 1500 GBP
    Then the withdraw operation should not be possible
    And The account balance should be 1000 GBP


  Scenario: Withdraw money available in a user account
    Given Bank account with 1000 GBP
    When A user withdraw 1000 GBP
    And A user transfer 2000 GBP
    And A user withdraw 500 GBP
    Then the withdraw operation should be possible
    And The account balance should be 1500 GBP

  Scenario: Withdraw money available in a user account
    Given Bank account with 2000 GBP
    When A user withdraw 1500 GBP
    And A user withdraw 1500 GBP
    Then the withdraw operation should not be possible
    And The account balance should be 500 GBP
