Feature: Book a Tours

  @done
  Scenario: Search for Tours details
  Given user tries to book tours 
   When user selects City name as "6 days around Thailand"
   And user selects startdate as "01/01/2019" 
   And user selects guests as "2 Guests"
And user selects tour type as "Private"
And user selects search in Tours page 