Feature: Checking availability and deliverable of product Feature

  Scenario: go to flipkart site from google result list
    Given user is on google page
    When user enter "Flipkart" in search text box
    And Print all the search options displayed in the console from google’s search field
    Then result should contain flipkart url
    Given user is on flipkart site
    And Click on TV & Appliances dropdown button and Navigate to AirConditioners > Window AC’s page
    And user select second third and sixth product and compare it
    And Print Name and price of all three products in the console




#  Scenario: check for product and it's delivery

