  Feature: Challenging DOM page.
  
  
  @done
  Scenario: Add table
    Given user logs into the internet
    When user goes to Challenging DOM
    Then user should verify address
      | Lorem    | Ipsum     | Dolor     | Sit         | Amet          | Diceret   |
      | Iuvaret0 | Apeirian0 | Adipisci0 | Definiebas0 | Consequuntur0 | Phaedrum0 |
      | Iuvaret1 | Apeirian1 | Adipisci1 | Definiebas1 | Consequuntur1 | Phaedrum1 |
      | Iuvaret2 | Apeirian2 | Adipisci2 | Definiebas2 | Consequuntur2 | Phaedrum2 |
      | Iuvaret3 | Apeirian3 | Adipisci3 | Definiebas3 | Consequuntur3 | Phaedrum3 |
      | Iuvaret4 | Apeirian4 | Adipisci4 | Definiebas4 | Consequuntur4 | Phaedrum4 |
    And user Edits address for
      | Lorem    |
      | Iuvaret0 |
      | Iuvaret4 |
    And user delete address for
      | Lorem    |
      | Iuvaret4 |
      | Iuvaret3 |