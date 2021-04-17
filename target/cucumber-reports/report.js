$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/booking.feature");
formatter.feature({
  "name": "RYANAIR booking",
  "description": "  Make sure that it is possible to book flights at the RYANAIR site.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Flight from Lisbon to Paris Beauvais is booked",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the homepage is opened",
  "keyword": "Given "
});
formatter.match({
  "location": "BookingStepDefs.theHomePageIsOpened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Cookies Modal\" is visible",
  "keyword": "When "
});
formatter.match({
  "location": "BookingStepDefs.theIsVisible(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Yes, I Agree\" button is clicked",
  "keyword": "And "
});
formatter.match({
  "location": "BookingStepDefs.theButtonIsClicked(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Departure Field\" is visible",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingStepDefs.theIsVisible(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Lisbon\" is typed into the \"Departure Field\"",
  "keyword": "When "
});
formatter.match({
  "location": "BookingStepDefs.isTypedIntoThe(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Lisbon\" airport is selected",
  "keyword": "And "
});
formatter.match({
  "location": "BookingStepDefs.theAirportIsSelected(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Paris Beauvais\" is typed into the \"Destination Field\"",
  "keyword": "When "
});
formatter.match({
  "location": "BookingStepDefs.isTypedIntoThe(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Paris Beauvais\" airport is selected",
  "keyword": "And "
});
formatter.match({
  "location": "BookingStepDefs.theAirportIsSelected(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"June\" is selected as the desired month",
  "keyword": "When "
});
formatter.match({
  "location": "BookingStepDefs.isSelectedAsTheDesiredMonth(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the day \"6\" is selected",
  "keyword": "And "
});
formatter.match({
  "location": "BookingStepDefs.theDayIsSelected(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"October\" is selected as the desired month",
  "keyword": "When "
});
formatter.match({
  "location": "BookingStepDefs.isSelectedAsTheDesiredMonth(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the day \"30\" is selected",
  "keyword": "And "
});
formatter.match({
  "location": "BookingStepDefs.theDayIsSelected(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the number of the \"Adult\" passenger is increased",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingStepDefs.theNumberOfThePassengerIsIncreased(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the number of the \"Child\" passenger is increased",
  "keyword": "And "
});
formatter.match({
  "location": "BookingStepDefs.theNumberOfThePassengerIsIncreased(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Done\" button is clicked",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingStepDefs.theButtonIsClicked(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Search\" button is clicked",
  "keyword": "And "
});
formatter.match({
  "location": "BookingStepDefs.theButtonIsClicked(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});