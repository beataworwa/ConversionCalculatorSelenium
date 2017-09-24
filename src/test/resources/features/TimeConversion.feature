Feature: convert time metrics

  @TIME
  Scenario: Convert from Week to Second in Time bookmark
    Given User run browser Chrome
      And User go to tested page
    When User move to bookmark 'Time'
      And User put value '4' in from field
      And User select 'Week' in source metrics tab
      And User select 'Second' in destination metrics tab
    Then Value '2419200'is displayed in to field
