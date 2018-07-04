@hotwire
Feature: Book a car

  @done
  Scenario: Boook a car for a week
    Given user tries to book a car in PHPtravels
    When user enter Pick-up location as "Dallas,Tx"
    And user enter Pick-up date as "08/01/2018" at 3 PM
    And user enter Return-up date as "08/10/2018" AT 3 PM
    And user select Find a Car tab
