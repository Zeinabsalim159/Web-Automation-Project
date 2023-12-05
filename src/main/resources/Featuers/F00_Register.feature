@smoke
Feature: Registrations
  Scenario: valid registrations
    Given navigate to url website
    When clicks registration button to go to register page
    And user select gender type
    And user enter first name "automation" and last name "tester"
    And  user enter date of birth
    And user enter email "test@example.com" field
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And user clicks on register button
    Then success message is displayed