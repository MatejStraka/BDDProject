Feature: Calculator
  As a user
  I want to use a calculator to divide numbers
  So that I don't need to calculate it manually

  @success
  Scenario: Divide two numbers 6 & 2
    Given I have a calculator
    When I divide 6 by 3
    Then the result should be 2

  @fail
  Scenario: Divide two numbers 6 & 0
    Given I have a calculator
    When I divide 6 by 0
    Then the error message should be "cannot divide by 0!"

  @success
  Scenario Outline: Divide two numbers <num1> & <num2>
    Given I have a calculator
    When I divide <num1> by <num2>
    Then the result should be <result>

    Examples:
      | num1 | num2 | result |
      | 10   | 2    | 5      |
      |50    |10    |5       |
      |99    |11    |9       |
      |-10   |-1    |10      |