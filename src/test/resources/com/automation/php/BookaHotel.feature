Feature: Book a Hotel room

  Background: 
    Given user tries to book a Hotel room in PHPtravels

  @done @smoke
  Scenario: Book a Hotel for a week
    When user selects follow data
      | City Name | Check In | Check out | no of guest       |
      | Baltimore | 9/1/2018 | 9/15/2018 | 5 Adults, 7 child |
    Then Click on Search tab

  @done
  Scenario Outline: Book multiple Hotel for a week
    When user select hotel name "<City Name>"
    And user select check in date "<Check In>"
    And user select check out date "<Check out>"
    And user select no of guest as "<no of guest>"
    Then Click on Search tab

    Examples: 
      | City Name | Check In | Check out | no of guest       |
      | Baltimore | 9/1/2018 | 9/15/2018 | 1 Adults, 1 child |
      | Baltimore | 9/1/2018 | 9/15/2018 | 2 Adults, 2 child |
      | Baltimore | 9/1/2018 | 9/15/2018 | 3 Adults, 3 child |
      | Baltimore | 9/1/2018 | 9/15/2018 | 4 Adults, 4 child |
