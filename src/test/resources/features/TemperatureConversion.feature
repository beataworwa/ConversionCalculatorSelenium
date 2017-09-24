Feature: convert temperature metrics

  @TEMPERATURE
  Scenario: Convert from Celsius to Kelvin in Temperature bookmark
    Given User run browser Chrome
      And User go to tested page
    When User move to bookmark 'Temperature'
      And User put value '20' in from field
      And User select 'Celsius' in source metrics tab
      And User select 'Kelvin' in destination metrics tab
    Then Value '293.15'is displayed in to field
