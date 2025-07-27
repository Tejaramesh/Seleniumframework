
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

Background:
Given I landed on ecommerce page


  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Loged in with username <name> and password <password>
    When I add product <productName> to cart 
    And checkout <productName> and submit the order 
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmationpage

    Examples: 
      | name                     | password  | productName|
      | tejaramesh2000@gmail.com | Teja@1234 | ZARA COAT 3|
    
