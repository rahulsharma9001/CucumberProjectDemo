Feature: LoggIN User View
  @login
  Scenario: Validate User is Able to See view After Login
    Given User navigates the Login page
    When user successfully enters the log in details
    Then User should be able to view the product category page