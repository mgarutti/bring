package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private static String HOMEPAGE_URL = "https://www.ryanair.com/gb/en";
    private static String DATA_REF_LOCATOR = "//*[@data-ref='";

    @FindBy (id = "input-button__departure")
    private WebElement departure_input;

    @FindBy (id = "input-button__destination")
    private WebElement destination_input;

    @FindBy (className = "cookie-popup-with-overlay__box")
    private WebElement cookie_modal;

    @FindBy (xpath = "//*[@data-ref='airport-item__name']")
    private WebElement airport_option;

    @FindBy (xpath = "//*[@data-ref='flight-search-widget__cta']")
    private WebElement search_flight_btn;

    @FindBy (xpath = "//*[@data-ref='cookie.accept-all']")
    private WebElement accept_all_cookie_btn;

    @FindBy (xpath = "//*[@data-ref='m-toggle-months-item']")
    private WebElement month_select;

    @FindBy (xpath = "//*[@data-ref='calendar-btn-next-month']")
    private WebElement next_month_btn;

    @FindBy (xpath = "//*[@data-id='2021-06-06']")
    private WebElement june_six_departure;

    @FindBy (xpath = "//*[@data-id='2021-10-30']")
    private WebElement october_thirty_return;

    @FindBy (xpath = "(//*[@data-ref='counter.counter__increment'])[1]")
    private WebElement adult_increment_btn;

    @FindBy (xpath = "(//*[@data-ref='counter.counter__increment'])[3]")
    private WebElement child_increment_btn;

    @FindBy (xpath = "//*[contains(@class, 'passengers__button-container')]/button")
    private WebElement passengers_done_btn;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCookieModal(){
        return cookie_modal;
    }

    public WebElement getAcceptAllCookiesBtn(){
        return accept_all_cookie_btn;
    }

    public static String getHomePageUrl(){
        return HOMEPAGE_URL;
    }

    public WebElement getDepartureInput() {
        return departure_input;
    }

    public WebElement getDestinationInput() {
        return destination_input;
    }

    public WebElement getSearchFlightBtn() {
        return search_flight_btn;
    }

    public WebElement getAirportOption() {
        return airport_option;
    }

    public WebElement getJuneSixDeparture() { return june_six_departure; }

    public WebElement getOctoberThirtyReturn() { return october_thirty_return; }

    public WebElement getNextMonthBtn() { return next_month_btn; }

    public WebElement getAdultIncrementBtn() { return adult_increment_btn; }

    public WebElement getChildIncrementBtn() { return child_increment_btn; }

    public WebElement getPassengersDoneBtn() { return passengers_done_btn; }

}
