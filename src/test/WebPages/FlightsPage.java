package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
    private WebDriver driver;

    @FindBy (xpath = "//*[@data-e2e='fare-card--standard']/div/button")
    private WebElement value_fare_btn;

    @FindBy (className = "login-touchpoint__chevron-container")
    private WebElement login_later_btn;

    @FindBy (xpath = "(//*[@data-e2e='carousel-next'])[1]")
    private WebElement depart_carousel_next;

    @FindBy (xpath = "(//*[@data-e2e='carousel-next'])[2]")
    private WebElement return_carousel_next;

    @FindBy (xpath = "(//*[@data-e2e='date-item'])[2]")
    private WebElement new_depart_date;

    @FindBy (xpath = "(//*[@data-e2e='date-item'])[7]")
    private WebElement new_return_date;

    @FindBy (xpath = "//*[@data-e2e='flight-card--outbound']")
    private WebElement flight_depart;

    @FindBy (xpath = "//*[@data-e2e='flight-card--inbound']")
    private WebElement flight_return;

    public FlightsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getDepartCarouselNext(){
        return depart_carousel_next;
    }

    public WebElement getReturnCarouselNext(){
        return return_carousel_next;
    }

    public WebElement getNewDepartDate(){ return new_depart_date; }

    public WebElement getNewReturnDate(){ return new_return_date; }

    public WebElement getFlightDepart(){ return flight_depart; }

    public WebElement getFlightReturn(){ return flight_return; }

    public WebElement getValueFareBtn() { return  value_fare_btn; }

    public WebElement getLoginLaterBtn() { return login_later_btn; }

}
