package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsPage {
    private WebDriver driver;

    private static String FLIGHTS_PAGE_URL = "https://www.ryanair.com/gb/en/trip/flights/";

    @FindBy (xpath = "//*[@data-e2e='fare-card--standard']/div/button")
    private WebElement value_fare_btn;

    @FindBy (className = "login-touchpoint__chevron-container")
    private WebElement login_later_btn;

    @FindBy (className = "date-item__loader ng-star-inserted")
    private WebElement data_loader;

    @FindBy (xpath = "(//*[@data-e2e='carousel-next'])[1]")
    private WebElement depart_carousel_next;

    @FindBy (xpath = "(//*[@data-e2e='carousel-next'])[2]")
    private WebElement return_carousel_next;

    @FindBy (xpath = "//*[@data-e2e='carousel-next']")
    private List<WebElement> carousel_next;

    @FindBy (xpath = "//*[@data-e2e='flight-card--outbound']")
    private WebElement flight_depart;

    @FindBy (xpath = "//*[@data-e2e='flight-card--inbound']")
    private WebElement flight_return;

    @FindBy (xpath = "//*[contains(@class, 'continue-flow')]//button")
    private WebElement continue_flow_btn;

    @FindBy (xpath = "//*[contains(@class, 'dropdown__toggle b2')]")
    private List<WebElement> passenger_title_dropdown;

    @FindBy (xpath = "//*[contains(@class, 'dropdown__menu-items')]//button")
    private List<WebElement> passenger_title_dropdown_select;

    @FindBy (xpath = "//*[contains(@id, '.name')]")
    private List<WebElement> passenger_first_name_input;

    @FindBy (xpath = "//*[contains(@id, '.surname')]")
    private List<WebElement> passenger_surname_input;

    @FindBy (xpath = "//*[contains(@class, 'seats-modal__buttons')]//button")
    private WebElement okay_got_it_btn;

    @FindBy (xpath = "//*[contains(@class, 'seats-modal__title')]")
    private WebElement family_seats_modal_title;

    @FindBy (xpath = "//*[contains(@data-ref, 'seat-map__seat-row')]//button[contains(@class, 'standard')]")
    private List<WebElement> standard_seat_btn;

    @FindBy (xpath = "//*[contains(@class, 'seats-action')]//button")
    private WebElement next_flight_btn;

    @FindBy (xpath = "//*[contains(@class, 'enhanced-takeover-beta')]//button[contains(@class, 'dismiss')]")
    private WebElement dismiss_fast_track_btn;

    @FindBy (xpath = "//*[@data-at='both-all-SBAG-add']")
    private WebElement small_bag_radio_btn;

    @FindBy (xpath = "//*[contains(@class, 'products-list')]//button")
    private WebElement continue_to_checkout_btn;

    @FindBy (xpath = "//*[@data-ref='basket-tooltip']")
    private WebElement basket_tooltip;

    @FindBy (xpath = "//*[contains(@class, 'seats-prompt__buttons')]//button[2]")
    private WebElement pick_same_return_seats;

    public FlightsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getFlightsPageUrl(){
        return FLIGHTS_PAGE_URL;
    }

    public WebElement getDepartCarouselNext(){
        return depart_carousel_next;
    }

    public WebElement getReturnCarouselNext(){
        return return_carousel_next;
    }

    public WebElement getFlightDepart(){ return flight_depart; }

    public WebElement getFlightReturn(){ return flight_return; }

    public WebElement getValueFareBtn() { return  value_fare_btn; }

    public WebElement getLoginLaterBtn() { return login_later_btn; }

    public WebElement getDataLoader() { return  data_loader;}

    public WebElement getContinueFlowBtn() { return continue_flow_btn; }

    public WebElement getFamilySeatsModalTitle() { return family_seats_modal_title; }

    public WebElement getOkayGotItBtn() { return okay_got_it_btn; }

    public WebElement getNextFlightBtn() { return next_flight_btn; }

    public WebElement getDismissFastTrackBtn() { return dismiss_fast_track_btn; }

    public WebElement getContinueToCheckoutBtn() { return continue_to_checkout_btn; }

    public WebElement getBasket_tooltip() { return basket_tooltip; }

    public WebElement getSmallBagRadioBtn() { return small_bag_radio_btn; }

    public WebElement getPickSameReturnSeats() { return pick_same_return_seats; }

    public List<WebElement> getPassengerTitleDropdown() {
        return passenger_title_dropdown;
    }

    public List<WebElement> getPassengerTitleDropdownSelect() {
        return passenger_title_dropdown_select;
    }

    public List<WebElement> getPassengerFirstNameInput() {
        return passenger_first_name_input;
    }

    public List<WebElement> getPassengerLastNameInput() {
        return passenger_surname_input;
    }

    public List<WebElement> getStandardSeatBtn() {
        return standard_seat_btn;
    }
    public List<WebElement> getCarouselNext() {
        return carousel_next;
    }

}
