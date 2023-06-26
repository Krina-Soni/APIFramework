Feature: Testing APIs

  Scenario: verify user can retrieve booking
    Given user set up request for "/booking"
    And user set header "Content-Type" to "application/json"
    When user perform the GET request
    Then verify status code is 200

  Scenario: verify user can retrieve token
    Given user set up request for "/auth"
    And user set body for auth request
    When user perform the POST request
    Then verify status code is 200

  Scenario: verify user can update existing booking
    Given user set up request for "/auth"
    And user set body for auth request
    And user set header "Content-Type" to "application/json"
    When user perform the POST request
    Then verify status code is 200
    And save token value from response
    When user set up request for "/booking"
    And user perform the GET request
    Then verify status code is 200
    And save bookingid value from response
    When user set up request for "/booking/booking_id"
    And user set body for update request
    And user set header token
    When user perform the PUT request
    Then verify status code is 200
