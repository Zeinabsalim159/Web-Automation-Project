@smoke
Feature:  Currencies Feature
  Scenario: verify Euro Symbol (€) is shown on the 4 products displayed in Home page
  // Given User should open1 browser and navigate to the website
    When User Select Euro currency from the dropdown list on the top left of home page
    Then  Euro Symbol (€) is shown on the 4 products displayed in Home page