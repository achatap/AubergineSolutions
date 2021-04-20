Feature: Checking availability and deliverable of product Feature

  Scenario: go to flipkart site from google result list
    Given user is on google page
    When user enter "Flipkart" in search text box
    Then result should contain flipkart url


