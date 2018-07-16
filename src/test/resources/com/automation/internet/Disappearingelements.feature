Feature: Disappearing elements
 
  @done
  Scenario: User tests desappering elements
    Given User open Internet page
    When User goto disappering elements
    Then User verifies Gallery tab is not visible
#    When User reloads the page
    Then User verifies Gallery tab is visible  after reload