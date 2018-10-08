Feature: Book a Visa

  @ignore
  Scenario: Search for visa details
    Given user tries to book a visa in PHPtravels
    When user selects origin country as "City"
    And user select destination country as "United States"
    And user select Search in visa tab

  @multiple_countries @ignore
  Scenario: Selecting countries from data provided
    Given user tries to book a visa in PHPtravels
    When user selects following visa details
      | Origin Country | Destination Country |
      | Nepal          | United States       |
      | India          | United States       |
      | China          | United States       |

  @done
  Scenario Outline: Selecting countries from data provided
    Given user tries to book a visa in PHPtravels
    When user selects origin country "<Origin Country>"
    And user selects destination country "<Destination Country>"
    And user select Search in visa tab

    Examples: 
      | Origin Country | Destination Country |
      | Nepal          | United States       |
      | India          | United States       |
      | China          | United States       |
