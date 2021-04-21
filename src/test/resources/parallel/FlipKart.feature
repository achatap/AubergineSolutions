Feature: Checking availability and deliverable of product Feature

  Scenario: go to flipkart site from google result list
    Given user is on google page
    When user enter "Flipkart" in search text box
    And Print all the search options displayed in the console from google’s search field
    And result should contain flipkart url
    And user is on flipkart site
    Then Click on TV & Appliances dropdown button and Navigate to AirConditioners > Window AC’s page
    And user select second third and sixth product and compare it
    And Print Name and price of all three products in the console
    And add all three product to the cart
    And Go to the cart and add your area Pincode "445304" and check the availability of the product delivery there
    And Print the message getting displayed for the availability delivery of the product in the console
    And Click the Deliver to input box, available to the top of the page, and add another pin code "411057" and check the availability of the product delivery there
    And Print the message getting displayed for the availability delivery of the product in the console

