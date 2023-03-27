
@tag
Feature: Purchase the order from Ecommerce Website

Background:
Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with eamil <email> and password <password>
    When I add product <productName> to cart
    And Checkout <Productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | email                | password            | Productname  |
      | bukashnsec@gmail.com | MyLearning@1989     | ZARA COAT 3  |
