Feature: Book a Tours in PHPTravels

  @done
  Scenario: Book a private tour
    Given user tries to book a private tour in PHPtravels
    When user select the city as "Egypt"
    And user select the date as "12/01/2018"
    And user select no of Guests as "3 Guests"
    And user select tour type as "Private"
    And user select Search in tours tab
    
    
    @done
    Scenario:Book a tour from data provided
        Given user tries to book a private tour in PHPtravels
        When user select below tour details
        |City Name|Date|no of guest|tour type|
        |Egypt|12/20/2018|2|Join-in|
        |pusa|11/01/2018|4|Adventure|
        |

