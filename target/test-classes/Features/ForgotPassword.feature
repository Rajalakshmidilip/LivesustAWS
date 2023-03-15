Feature: Verify the ForgotPassword Functionality

  Background: ForgotPasswordPage
    Given user is on forgotpassword screen
    
  @forgot
  Scenario Outline: Verify user reset the password successfully
    When user enter the valid forgotpassword email <email>
    Then user click on continue button
    And assert the success message

    Examples: 
      | email                      |
      | liveautomation@yopmail.com |
