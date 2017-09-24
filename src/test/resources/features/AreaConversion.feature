Feature: convert area metrics

  @AREA
  Scenario: Convert from Square Foot to Square Kilometer in Area bookmark
    Given User run browser Chrome
      And User go to tested page
    When User move to bookmark 'Area'
      And User put value '1000' in from field
      And User select 'Square Foot' in source metrics tab
      And User select 'Square Kilometer' in destination metrics tab
    Then Value '0.000092903'is displayed in to field
