
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on ecommerce page
    When Loged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                     | password  | 
      | tejaramesh2000@gmail.com | Teja@123 | 
    