Feature: Orange HRM - Assign Leave functionality

  Scenario: Validate Assign Leave Functionality
    Given I navigate to Orange HRM page
    And I enter username "Admin"
    And I enter password "admin123"
    When I click on Login button
    Then I validate text "Dashboard" on homepage
    And I click on Assign leave tile
    And I select value "Jasmine Morgan" from Employee name auto suggest dropdown in assign leave page
    And I select value "CAN - Bereavement" from leave type dropdown in assign leave page
    And I click on view details link and validate pop up data in assign leave page
    And I select date from From Date date picker in assign leave page
    And I select date from To Date date picker in assign leave page
    And I click on assign button in assign leave page
