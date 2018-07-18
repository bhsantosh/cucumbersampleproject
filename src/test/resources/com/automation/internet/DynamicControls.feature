Feature: Dynamic Controls

  @done
  Scenario: User verified Dynamic Control functionality
    Given User open Internet page
    When User goto Dynamic Controls page
    And User removes the checkbox
    Then user verifies checkbox is removed
    When User Add back the checbox
    Then user verifies checkbox is added back
