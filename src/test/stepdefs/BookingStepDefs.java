package stepdefs;

import WebPages.FlightsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import WebPages.HomePage;
import Util.WaitUtil;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BookingStepDefs {
    /*
    **  Didn't created a WebDriverFactory to do this the proper way, so please comment the line to switch between the desired browsers
     */
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    FlightsPage flightsPage = new FlightsPage(driver);
    WaitUtil waitUtil = new WaitUtil();

    String current_url;

    @Before
    public void beforeHook() {
        driver.manage().window().maximize();
        driver.navigate().to(homePage.getHomePageUrl());
    }

    @Given("the homepage is opened")
    public void theHomePageIsOpened() {
        driver.get(homePage.getHomePageUrl());
        current_url = driver.getCurrentUrl();
        Assert.assertEquals(current_url, homePage.getHomePageUrl());
    }

    @When("the {string} is visible")
    public void theIsVisible(String element) {
        switch (element) {
            case "Cookie Modal":
                waitUtil.ElementIsVisible(driver, homePage.getCookieModal(), 10);
                break;
            case "Departure Field":
                waitUtil.ElementIsVisible(driver, homePage.getDepartureInput(), 10);
                break;
            case "Destination Field":
                waitUtil.ElementIsVisible(driver, homePage.getDestinationInput(), 10);
                break;
        }
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String button_name) {
        switch (button_name) {
            case "Yes, I Agree":
                waitUtil.ElementIsClickable(driver, homePage.getAcceptAllCookiesBtn(), 10);
                homePage.getAcceptAllCookiesBtn().click();
                break;
            case "Done":
                waitUtil.ElementIsClickable(driver, homePage.getPassengersDoneBtn(), 10);
                homePage.getPassengersDoneBtn().click();
                break;
            case "Search":
                waitUtil.ElementIsClickable(driver, homePage.getSearchFlightBtn(), 10);
                homePage.getSearchFlightBtn().click();
                break;
        }
    }

    @When("{string} is typed into the {string}")
    public void isTypedIntoThe(String text, String input) throws InterruptedException {
        switch (input) {
            case "Departure Field":
                waitUtil.ElementIsClickable(driver, homePage.getDepartureInput(), 10);
                homePage.getDepartureInput().click();
                homePage.getDepartureInput().clear();
                homePage.getDepartureInput().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
                homePage.getDepartureInput().sendKeys(text);
                break;
            case "Destination Field":
                waitUtil.ElementIsClickable(driver, homePage.getDestinationInput(), 10);;
                homePage.getDestinationInput().click();
                homePage.getDestinationInput().sendKeys(text);
                break;
        }
    }

    @And("the {string} airport is selected")
    public void theAirportIsSelected(String airport) {
        waitUtil.ElementContainText(driver, homePage.getAirportOption(), airport, 10);
        homePage.getAirportOption().click();
    }

    @When("{string} is selected as the desired month")
    public void isSelectedAsTheDesiredMonth(String month) {
        switch (month) {
            case "June":
                waitUtil.ElementIsClickable(driver, homePage.getNextMonthBtn(), 10);
                waitUtil.ElementIsVisible(driver, homePage.getNextMonthBtn(), 10);
                for (int i = 0; i < 2; i++) {
                    homePage.getNextMonthBtn().click();
                }
                break;
            case "October":
                waitUtil.ElementIsClickable(driver, homePage.getNextMonthBtn(), 10);
                for (int i = 0; i < 4; i++) {
                    homePage.getNextMonthBtn().click();
                }
                break;
        }

    }

    @And("the day {string} is selected")
    public void theDayIsSelected(String day) {
        switch (day) {
            case "6":
                waitUtil.ElementIsClickable(driver, homePage.getJuneSixDeparture(), 10);
                homePage.getJuneSixDeparture().click();
                break;
            case "30":
                waitUtil.ElementIsClickable(driver, homePage.getOctoberThirtyReturn(), 10);
                homePage.getOctoberThirtyReturn().click();
                break;
        }
    }

    @Then("the number of the {string} passenger is increased")
    public void theNumberOfThePassengerIsIncreased(String type) {
        switch (type) {
            case "Adult":
                waitUtil.ElementIsClickable(driver, homePage.getAdultIncrementBtn(), 10);
                homePage.getAdultIncrementBtn().click();
                break;
            case "Child":
                waitUtil.ElementIsClickable(driver, homePage.getChildIncrementBtn(), 10);
                homePage.getChildIncrementBtn().click();
                break;
        }
    }
/*
** I was not able to implement this carousel function because, most of the time, the date elements were stuck in a loading, preventing the click action.
 */
  /*  @When("the {string} flight date is changed")
    public void theFlightDateIsChangedTo(String flight) {
        switch (flight) {
            case "Depart":
                for (int i = 0; i < 1; i++) {
                    waitUtil.ElementIsVisible(driver, flightsPage.getDepartCarouselNext(), 10);
                    waitUtil.ElementIsClickable(driver, flightsPage.getDepartCarouselNext(), 10);
                    flightsPage.getDepartCarouselNext().click();
                }
                waitUtil.ElementIsVisible(driver, flightsPage.getNewDepartDate(), 10);
                waitUtil.ElementIsClickable(driver, flightsPage.getNewDepartDate(), 10);
                flightsPage.getNewDepartDate().click();
                break;
            case "Return":
                for (int i = 0; i < 1; i++) {
                    waitUtil.ElementIsVisible(driver, flightsPage.getDepartCarouselNext(), 10);
                    waitUtil.ElementIsClickable(driver, flightsPage.getDepartCarouselNext(), 10);
                    flightsPage.getReturnCarouselNext().click();
                }
                waitUtil.ElementIsVisible(driver, flightsPage.getNewReturnDate(), 10);
                waitUtil.ElementIsClickable(driver, flightsPage.getNewReturnDate(), 10);
                flightsPage.getNewReturnDate().click();
                break;
        }
    }

   */

    @Then("the {string} fare is selected")
    public void theFareIsSelected(String fare) {
        switch (fare) {
            case "Value":
                waitUtil.ElementIsVisible(driver, flightsPage.getFlightDepart(), 10);
                waitUtil.ElementIsClickable(driver, flightsPage.getFlightDepart(), 10);
                flightsPage.getFlightDepart().click();
                waitUtil.ElementIsVisible(driver, flightsPage.getValueFareBtn(), 10);
                waitUtil.ElementIsClickable(driver, flightsPage.getValueFareBtn(), 10);
                flightsPage.getValueFareBtn().click();
                waitUtil.ElementIsVisible(driver, flightsPage.getFlightReturn(), 10);
                waitUtil.ElementIsClickable(driver, flightsPage.getFlightReturn(), 10);
                flightsPage.getFlightReturn().click();
                waitUtil.ElementIsVisible(driver, flightsPage.getValueFareBtn(), 10);
                waitUtil.ElementIsClickable(driver, flightsPage.getValueFareBtn(), 10);
                flightsPage.getValueFareBtn().click();
                waitUtil.ElementIsVisible(driver, flightsPage.getLoginLaterBtn(), 10);
                waitUtil.ElementIsClickable(driver, flightsPage.getLoginLaterBtn(), 10);
                flightsPage.getLoginLaterBtn().click();
                break;
        }
    }

    @After
    public void afterHook() {
        //driver.quit();
    }


}

