Feature: Toast Item Add
  Scenario: Menu Item Add
    Given kullanici API Demos sayfasina gider
    And  kullanici wiev sayfasina gider
    And kullanici pop-up menuyu tiklar
    And kullanici make pop-up tiklar ve pop-up acildi mi onaylar
    And kullanici add i tiklar
    Then kullanici tost mesajini "Clicked popup menu item Add" onaylar