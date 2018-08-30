Feature: Book a Visa

	@done
  Scenario: Search for visa details
    Given user tries to book a visa in PHPtravels
    When user selects origin country as "Nepal"
#    And user select destination country as "United States"
#    Then user select Search tab