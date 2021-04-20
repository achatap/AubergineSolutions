Feature: Checking availability and deliverable of product Feature

  Scenario: go to flipkart site from google result list
    Given user is on google page
    When user enter "Flipkart" in search text box
    And Print all the search options displayed in the console from google’s search field
    Then result should contain flipkart url


