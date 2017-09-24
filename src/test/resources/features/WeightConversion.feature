Feature: convert weight metrics

  @WEIGHT
  Scenario: Convert from Pound to Kilogram in Weight bookmark
    Given User run browser Chrome
      And User go to tested page
    When User move to bookmark 'Weight'
      And User put value '200' in from field
      And User select 'Pound' in source metrics tab
      And User select 'Kilogram' in destination metrics tab
    Then Value '90.7184'is displayed in to field
