
@tag
Feature: Error validation
  I want to use this template for my feature file


  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When Logged in with eamil <email> and password <password>
    Then "Incorrect email or password." message is dislayed

    Examples: 
      | email                | password        |
      | bukashnsec@gmail.com | MyLearning@198 |
