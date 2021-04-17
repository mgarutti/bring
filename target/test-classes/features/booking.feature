Feature: RYANAIR booking
  Make sure that it is possible to book flights at the RYANAIR site.

  #Background: Cookies are accepted at the Home Page
   # Given the homepage is opened
   # When the "Cookies Modal" is visible
   # And the "Yes, I Agree" button is clicked
   # Then the "Departure Field" is visible

  Scenario: Flight from Lisbon to Paris Beauvais is booked
    Given the homepage is opened
    When the "Cookies Modal" is visible
    And the "Yes, I Agree" button is clicked
    Then the "Departure Field" is visible
    When "Lisbon" is typed into the "Departure Field"
    And the "Lisbon" airport is selected
    When "Paris Beauvais" is typed into the "Destination Field"
    And the "Paris Beauvais" airport is selected
    When "June" is selected as the desired month
    And the day "6" is selected
    When "October" is selected as the desired month
    And the day "30" is selected
    Then the number of the "Adult" passenger is increased
    And the number of the "Child" passenger is increased
    Then the "Done" button is clicked
    And the "Search" button is clicked


