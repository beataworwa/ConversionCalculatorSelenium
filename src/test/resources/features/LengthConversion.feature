Feature: convert length metrics

  @LENGTH
  Scenario: Convert from Kilometer to Centimeter in Length bookmark
    Given User run browser Chrome
     And User go to tested page
    When User move to bookmark 'Length'
      And User put value '100' in from field
      And User select 'Kilometer' in source metrics tab
      And User select 'Centimeter' in destination metrics tab
    Then Value '10000000'is displayed in to field
