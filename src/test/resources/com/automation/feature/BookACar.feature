@hotwire
Feature: Book a car

  @done
  Scenario: Boook a car for a week
    Given user tries to book a car in PHPtravels
    When user enter Pick-up location as "Manchester"
    When user enter drop-off location as "Petra"
    And user enter Pick-up date as "08/01/2018" at "15:00"
    And user enter Return-up date as "08/10/2018" at "15:00"
    And user select Search tab

    