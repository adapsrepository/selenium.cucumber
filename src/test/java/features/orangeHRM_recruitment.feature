Feature: Orange HRM - Recruitment

  Background: 
    Given I navigate to Orange HRM page
    And I enter username "Admin"
    And I enter password "admin123"
    When I click on Login button
    Then I validate text "Dashboard" on homepage
    And I click on Recruitment tab

  Scenario: Validate blank search
    And I click on Search button in recruitment page
    Then I validate search results retreive "10" records in recruitment page

  Scenario Outline: Validate specific search
    And I select value <jobtitle> from job title dropdown in recruitment page
    And I select value <vacancy> from vacancy dropdown in recruitment page
    And I select value <hiringmanager> from hiring manager dropdown in recruitment page
    When I click on Search button in recruitment page
    Then I validate search results retreive <records> records for specific search in recruitment page

    Examples: 
      | jobtitle          | vacancy              | hiringmanager | records |
      | IT Manager        | Associate IT Manager | Odis Adalwin  |       1 |
      | Software Engineer | Software Engineer    | Odis Adalwin  |       1 |
