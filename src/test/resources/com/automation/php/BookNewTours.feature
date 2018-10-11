Feature: Book New Tours

  @done
  Scenario: Book Tours
    Given user tries to book tours
#    Given user tries to book a tour in PHPtravels
    When user tries to enter cityName as "6 days around Thailand"
    And user selects date as "01/01/2019"
    And user selects number of guests as "2 Guests"
    And user selects tour type as "Private"
    And user clicks search button
