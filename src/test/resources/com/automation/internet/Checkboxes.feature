Feature: Checkboxes pages.

  @done
  Scenario: User click on checkboxes with the value provided
    Given User open Internet page
    When User click on checkbox tab
    When user clicks checkbox 1
    And user clicks checkbox 2

  @ignore
  Scenario: User click on all the checkboxes available
    Given User open Internet page
    When User click on checkbox tab
    When user clicks all checkbox

    