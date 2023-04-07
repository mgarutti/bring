package stepdefs;

import Util.*;
import WebPages.FlightsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import WebPages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class BookingStepDefs {
    /*
    **  Didn't created a WebDriverFactory to do this the proper way, so please comment the line to switch between the desired browsers
     */
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    FlightsPage flightsPage = new FlightsPage(driver);
    WaitUtil waitUtil = new WaitUtil();
    SeleniumUtil seleniumUtil = new SeleniumUtil();
    JavascriptExecutor executor = (JavascriptExecutor)driver;

    String current_url;

    @Before
    public void beforeHook() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
                waitUtil.elementIsVisible(driver, homePage.getCookieModal(), 5);
                break;
            case "Departure Field":
                waitUtil.elementIsVisible(driver, homePage.getDepartureInput(), 5);
                break;
            case "Destination Field":
                waitUtil.elementIsVisible(driver, homePage.getDestinationInput(), 5);
                break;
            case "Family Seating":
                waitUtil.elementIsVisible(driver, flightsPage.getFamilySeatsModalTitle(), 5);
                break;
            case "Basket modal":
                waitUtil.elementIsVisible(driver, flightsPage.getBasket_tooltip(), 5);
                break;
        }
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String button_name) {
        switch (button_name) {
            case "Yes, I Agree":
                waitUtil.elementIsClickable(driver, homePage.getAcceptAllCookiesBtn(), 5);
                homePage.getAcceptAllCookiesBtn().click();
                break;
            case "Done":
                waitUtil.elementIsClickable(driver, homePage.getPassengersDoneBtn(), 5);
                homePage.getPassengersDoneBtn().click();
                break;
            case "Search":
                waitUtil.elementIsClickable(driver, homePage.getSearchFlightBtn(), 5);
                homePage.getSearchFlightBtn().click();
                break;
            case "Login later":
                waitUtil.elementIsClickable(driver, flightsPage.getLoginLaterBtn(), 5);
                flightsPage.getLoginLaterBtn().click();
                break;
            case "Continue":
                waitUtil.elementIsClickable(driver, flightsPage.getContinueFlowBtn(), 5);
                flightsPage.getContinueFlowBtn().click();
                break;
            case "Okay, got it":
                waitUtil.elementIsClickable(driver, flightsPage.getOkayGotItBtn(), 5);
                flightsPage.getOkayGotItBtn().click();
                break;
            case "Next flight":
                waitUtil.elementIsClickable(driver, flightsPage.getNextFlightBtn(), 5);
                flightsPage.getNextFlightBtn().click();
                break;
            case "No, thanks":
                waitUtil.elementIsClickable(driver, flightsPage.getDismissFastTrackBtn(), 5);
                flightsPage.getDismissFastTrackBtn().click();
                break;
            case "Continue (to checkout)":
                waitUtil.elementIsClickable(driver, flightsPage.getContinueToCheckoutBtn(), 5);
                flightsPage.getContinueToCheckoutBtn().click();
                break;
            case "Pick the same return seats":
                waitUtil.elementIsClickable(driver, flightsPage.getPickSameReturnSeats(), 5);
                flightsPage.getPickSameReturnSeats().click();
                //executor.executeScript("arguments[0].click();", flightsPage.getPickSameReturnSeats());
                break;
        }
    }

    @When("{string} is typed into the {string}")
    public void isTypedIntoThe(String text, String input) throws InterruptedException {
        switch (input) {
            case "Departure Field":
                waitUtil.elementIsClickable(driver, homePage.getDepartureInput(), 5);
                homePage.getDepartureInput().click();
                homePage.getDepartureInput().clear();
                homePage.getDepartureInput().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
                homePage.getDepartureInput().sendKeys(text);
                break;
            case "Destination Field":
                waitUtil.elementIsClickable(driver, homePage.getDestinationInput(), 5);;
                homePage.getDestinationInput().click();
                homePage.getDestinationInput().sendKeys(text);
                break;
        }
    }

    @And("the {string} airport is selected")
    public void theAirportIsSelected(String airport) {
        waitUtil.elementContainText(driver, homePage.getAirportOption(), airport, 5);
        homePage.getAirportOption().click();
    }

    @When("{string} is selected as {string} date")
    public void isSelectedAsDate(String date, String flight) {
                while (!waitUtil.elementIsClickable(driver, seleniumUtil.findElementByDataId(driver, date), 10)) {
                    waitUtil.elementIsClickable(driver, homePage.getNextMonthBtn(), 10);
                    homePage.getNextMonthBtn().click();
                }
                waitUtil.elementIsClickable(driver, seleniumUtil.findElementByDataId(driver, date), 10);
                seleniumUtil.findElementByDataId(driver, date).click();
    }

    @Then("the number of the {string} passenger is increased")
    public void theNumberOfThePassengerIsIncreased(String type) {
        switch (type) {
            case "Adult":
                waitUtil.elementIsClickable(driver, homePage.getAdultIncrementBtn(), 5);
                homePage.getAdultIncrementBtn().click();
                break;
            case "Child":
                waitUtil.elementIsClickable(driver, homePage.getChildIncrementBtn(), 5);
                homePage.getChildIncrementBtn().click();
                break;
        }
    }

    @When("the {string} flight date is changed to {string}")
    public void theFlightDateIsChangedTo(String flight, String date) {
        switch (flight) {
            case "Depart":
                while (!waitUtil.elementIsVisible(driver, seleniumUtil.findElementByDataRef(driver, date), 5)) {
                    waitUtil.elementIsClickable(driver, flightsPage.getDepartCarouselNext(), 4);
                    flightsPage.getDepartCarouselNext().click();
                    waitUtil.elementIsVisible(driver, flightsPage.getDataLoader(), 1);
                }
                seleniumUtil.findElementByDataRef(driver, date).click();
                break;
            case "Return":
                while (!waitUtil.elementIsVisible(driver, seleniumUtil.findElementByDataRef(driver, date), 5)) {
                    waitUtil.elementIsClickable(driver, flightsPage.getDepartCarouselNext(), 4);
                    flightsPage.getReturnCarouselNext().click();
                    waitUtil.elementIsVisible(driver, flightsPage.getDataLoader(), 1);
                }
                seleniumUtil.findElementByDataRef(driver, date).click();
                break;
        }
    }

    @Then("the {string} flight is selected")
    public void theFlightIsSelected(String flight) {
        switch (flight) {
            case "Depart":
                waitUtil.elementIsClickable(driver, flightsPage.getFlightDepart(), 5);
                flightsPage.getFlightDepart().click();
                break;
            case "Return":
                waitUtil.elementIsClickable(driver, flightsPage.getFlightReturn(), 5);
                flightsPage.getFlightReturn().click();
                break;
        }
    }

    @And("the {string} fare is selected for the flight")
    public void theFareIsSelectedForTheFlight(String fare) {
        switch (fare) {
            case "Value":
                waitUtil.elementIsClickable(driver, flightsPage.getValueFareBtn(), 10);
                flightsPage.getValueFareBtn().click();
                break;
        }
    }

    @When("the title for passenger {string} is selected as {string}")
    public void theTitleForPassengerIsSelected(String passenger, String title) {
        switch (passenger) {
            case "1":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerTitleDropdown().get(0), 10);
                flightsPage.getPassengerTitleDropdown().get(0).click();
                seleniumUtil.selectDropdownListOption(driver, flightsPage.getPassengerTitleDropdownSelect(), title);
                break;
            case "2":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerTitleDropdown().get(1), 10);
                flightsPage.getPassengerTitleDropdown().get(1).click();
                seleniumUtil.selectDropdownListOption(driver, flightsPage.getPassengerTitleDropdownSelect(), title);
                break;
        }
    }

    @And("the first name for passenger {string} is {string}")
    public void theFirstNameForPassengerIs(String passenger, String name) {
        switch (passenger) {
            case "1":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerFirstNameInput().get(0), 10);
                flightsPage.getPassengerFirstNameInput().get(0).click();
                flightsPage.getPassengerFirstNameInput().get(0).sendKeys(name);
                break;
            case "2":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerFirstNameInput().get(1), 10);
                flightsPage.getPassengerFirstNameInput().get(1).click();
                flightsPage.getPassengerFirstNameInput().get(1).sendKeys(name);
                break;
            case "3":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerFirstNameInput().get(2), 10);
                flightsPage.getPassengerFirstNameInput().get(2).click();
                flightsPage.getPassengerFirstNameInput().get(2).sendKeys(name);
                break;
        }
    }

    @And("the last name for passenger {string} is {string}")
    public void theLastNameForPassengerIs(String passenger, String name) {
        switch (passenger) {
            case "1":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerLastNameInput().get(0), 10);
                flightsPage.getPassengerFirstNameInput().get(0).click();
                flightsPage.getPassengerLastNameInput().get(0).sendKeys(name);
                break;
            case "2":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerLastNameInput().get(1), 10);
                flightsPage.getPassengerFirstNameInput().get(1).click();
                flightsPage.getPassengerLastNameInput().get(1).sendKeys(name);
                break;
            case "3":
                waitUtil.elementIsClickable(driver, flightsPage.getPassengerLastNameInput().get(2), 10);
                flightsPage.getPassengerFirstNameInput().get(2).click();
                flightsPage.getPassengerLastNameInput().get(2).sendKeys(name);
                break;
        }
    }

    @And("the seats are selected for {int} passengers")
    public void theSeatsAreSelectedForPassengers(Integer passengers) {
        int i;
        for (i = 0; i < passengers; i++){
            waitUtil.elementIsVisible(driver, flightsPage.getStandardSeatBtn().get(0), 10);
            waitUtil.elementIsClickable(driver, flightsPage.getStandardSeatBtn().get(0), 10);
            executor.executeScript("arguments[0].click();", flightsPage.getStandardSeatBtn().get(0));
        }
    }

    @When("the {string} cabin bag is selected")
    public void theCabinBagIsSelected(String type) {
        switch (type) {
            case "Small bag":
                waitUtil.elementIsClickable(driver, flightsPage.getSmallBagRadioBtn(), 10);
                executor.executeScript("arguments[0].click();", flightsPage.getSmallBagRadioBtn());
                break;
        }
    }

    @After
    public void afterHook() {
        //driver.quit();
    }
}

