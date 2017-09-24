Feature: convert volume metrics

  @VOLUME
  Scenario: Convert from US Gallon to Cubic Meter in Volume bookmark
    Given User run browser Chrome
      And User go to tested page
    When User move to bookmark 'Volume'
      And User put value '500' in from field
      And User select 'US Gallon' in source metrics tab
      And User select 'Cubic Meter' in destination metrics tab
    Then Value '1.892705'is displayed in to field
