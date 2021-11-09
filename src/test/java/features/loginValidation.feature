Feature: Orange HRM - Scenario1

  @tag1
  Scenario: Scenarioo 1
    Given I navigate to Orange HRM page
    And I enter username "Admin"
    And I enter password "admin123"
    When I click on Login button
    Then I validate text "Dashboard" on homepage
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
