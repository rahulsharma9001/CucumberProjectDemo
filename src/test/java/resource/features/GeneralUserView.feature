Feature: LoggIN User View
  Scenario: Validate general user is able to view products without logging in
    Given User navigates the Online products page
    When user clicks on Formal shoes drop down
    Then User should be able to view the products