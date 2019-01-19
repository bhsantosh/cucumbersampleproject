Feature: Book New Tours

  #  @ignore
  #  Scenario: Book Tours
  #    Given user tries to book tours
  #    #    Given user tries to book a tour in PHPtravels
  #    When user tries to enter cityName as "6 days around Thailand"
  #    And user selects date as "01/01/2019"
  #    And user selects number of guests as "1 Guests"
  #    And user selects tour type as "Private"
  #    And user clicks search button
  @done
  Scenario: Book Tours
    Given user tries to book tours
    When user selects following tour details
      | City Name              | Tour Date  | No Of Guests | Tour Type |
      | 6 days around Thailand | 01/01/2019 | 2 Guests     | Private   |
      | Pusa            | 01/02/2019 | 3 Guests     | Adventure |
