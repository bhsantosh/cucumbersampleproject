@hotwire @PHPtravels
Feature: Book a flight

  @done @smoke
  Scenario: Book a Round trip flight
    Given User opens PHPtravels page and tried to book a fight
    When User select round trip
    And user select Flight class as "FIRST"
    And User enter fligth originating City or Airport as "IAD"
    And User enter destination city or Airport name as "JFK"
    And User enter Departing date as "9/1/2018"
    And User enter Returning date as "9/20/2018"
    And User enter no of Guest as 2 Adults, 2 Childs and 1 infant
    Then Click on search Tab

  @ignore
  Scenario: Book a Round trip flight
    Given User opens PHPtravels page and tried to book a fight
    When User select round trip
    And user enter following details
      | Fight class | City Name | Destination City | Departing date | Returning date | No of guests                 |
      | Business    | JFK       | ALB              | 10/1/2018      | 10/20/2018     | 3 adults, 2 childs, 1 infant |
    Then Click on search Tab

  @ignore
  Scenario Outline: Book a Round trip flight
    Given User opens PHPtravels page and tried to book a fight
    When User select round trip
    And user select Flight class  "<Fight class>"
    And User enter fligth originating City or Airport "<City Name>"
    And User enter destination city or Airport name "<Destination City>"
    And User enter Departing date "<Departing date>"
    And User enter Returning date "<Returning date>"
    And User enter no of Guest as 2 Adults, 2 Childs and 1 infant"<No of guests>"
    Then Click on search Tab

    Examples: 
      | Fight class | City Name | Destination City | Departing date | Returning date | No of guests                 |
      | Business    | JFK       | ALB              | 8/1/2018       | 8/20/2018      | 3 adults, 2 childs, 1 infant |
      | First       | IAD       | TPA              | 10/1/2018      | 10/20/2018     | 1 adult, 2 childs, 2 infants |
      | Economy     | TPA       | MSP              | 9/1/2018       | 9/20/2018      | 2 adults, 1 child, 0 infant  |
      | Business    | TIA       | IAD              | 11/1/2018      | 11/20/2018     | 1 adult, 2 childs, 1 infant  |
