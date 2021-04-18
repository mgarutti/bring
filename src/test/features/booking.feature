Feature: RYANAIR booking
  Make sure that it is possible to book flights at the RYANAIR site.

  Scenario: Flight from Lisbon to Paris Beauvais is booked
    Given the homepage is opened
    When the "Cookies Modal" is visible
    And the "Yes, I Agree" button is clicked
    Then the "Departure Field" is visible
    When "Lisbon" is typed into the "Departure Field"
    And the "Lisbon" airport is selected
    When "Paris Beauvais" is typed into the "Destination Field"
    And the "Paris Beauvais" airport is selected
    When "2021-06-06" is selected as "Depart" date
    And "2021-10-30" is selected as "Return" date
    Then the number of the "Adult" passenger is increased
    And the number of the "Child" passenger is increased
    When the "Done" button is clicked
    And the "Search" button is clicked
    When the "Depart" flight date is changed to "2021-08-06"
    Then the "Depart" flight is selected
    And the "Value" fare is selected for the flight
    When the "Return" flight date is changed to "2021-12-12"
    And the "Return" flight is selected
    Then the "Value" fare is selected for the flight
    And the "Login later" button is clicked
    When the title for passenger "1" is selected as "Mrs"
    And the first name for passenger "1" is "Sónia"
    And the last name for passenger "1" is "Pereira"
    When the title for passenger "2" is selected as "Mr"
    And the first name for passenger "2" is "Diogo"
    And the last name for passenger "2" is "Bettencourt"
    And the first name for passenger "3" is "Inês"
    And the last name for passenger "3" is "Marçal"
    When the "Continue" button is clicked
    Then the "Family Seating" is visible
    And the "Okay, got it" button is clicked
    And the seats are selected for 3 passengers
    Then the "Next flight" button is clicked
    And the "Pick the same return seats" button is clicked
    And the "No, thanks" button is clicked
    When the "Small bag" cabin bag is selected
    Then the "Continue" button is clicked
    And the "Continue (to checkout)" button is clicked
    Then the "Basket modal" is visible




