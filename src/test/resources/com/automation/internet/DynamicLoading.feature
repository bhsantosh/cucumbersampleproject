Feature: Dynamic Loading

  @done
  Scenario: User verifies Dynamic Loading functionality
    Given User open Internet page
    When User goto Dynamic loading page
    And User click on example 1
    And User click on Start button
    Then User verifies message displayed

  @done
  Scenario: User verifies Dynamic Loading functionality
    Given User open Internet page
    When User goto Dynamic loading page
    And User click on example 2
    And User click on Start button
    Then User verifies message displayed
