package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author STA Development Team
 *
 */
public class HomePageElements extends PageElements {

    @FindBy(xpath = ".//*[@id='nav-top']/ul/div/li[3]")
    private WebElement savedSearches;

    @FindBy(css = "#saved-searches-count")
    private WebElement savedSearchesIcon;

    @FindBy(xpath = ".//div[@class='nav-left']//li[@class='saved-searches-info']")
    private WebElement savedSearchesNewMessage;

    @FindBy(css = ".flight_depart_location")
    private WebElement flightDepartureInput;

    @FindBy(xpath = ".//*[@id='ui-id-1']/li[1]/a")
    private WebElement departureCityOneWay;

    @FindBy(xpath = ".//*[@id='ui-id-1']/li[1]/a")
    private WebElement departureCityReturn;

    @FindBy(css = ".flight_arrive_location")
    private WebElement flightArrivalInput;

    @FindBy(xpath = ".//*[@id='ui-id-2']/li[1]/a")
    private WebElement arrivalCityOneWay;

    @FindBy(css = ".flight_depart_date")
    private WebElement departureCalander;

    @FindBy(css = ".flight_return_date")
    private WebElement returnCalander;

    @FindBy(css = ".adults")
    private WebElement adults;

    @FindBy(xpath = ".//div[@class='standardSearch qbtb_flights']//fieldset[@class='submit contain']//button")
    private WebElement findFlightButton;

    @FindBy(xpath = ".//input[@class='flight_one_way']/..")
    private WebElement oneWayButton;

    @FindBy(xpath = ".//input[@class='flight_return']/..")
    private WebElement returnButton;

    @FindBy(xpath = "//input[@class='flight_multi_city']/..")
    private WebElement multiCityButton;

    @FindBy(css = ".ui-datepicker-days-cell-over.ui-datepicker-current-day")
    private WebElement departureDate;

    @FindBy(css = ".ui-datepicker-days-cell-over.ui-datepicker-current-day")
    private WebElement returnDate;

    @FindBy(xpath = ".//*[@id='nav-top']/ul/div[1]/li[3]/ul/li[2]/div[2]")
    private WebElement firstSavedSearch;

    @FindBy(xpath = ".//*[@id='nav-top']/ul/div[1]/li[3]/ul/li[3]/div[2]")
    private WebElement editedSavedSearch;

    @FindBy(xpath = ".//*[@id='nav-top']/ul/div[1]/li[3]/ul/li[2]/div[2]/div[2]")
    private WebElement multiCityDate;

    @FindBy(xpath = ".//*[@id='nav-top']/ul/div[1]/li[4]/ul/li[3]/span")
    private WebElement firstSavedSearchDelete;

    @FindBy(xpath = ".//*[@id='nav-top']/ul/div[1]/li[4]/ul/li[4]/div")
    private WebElement secondSavedSearch;

    @FindBy(css = "#circle")
    private WebElement savedSearchCircle;

    @FindBy(css = ".account.nav-dropdown")
    private WebElement loginLink;

    @FindBy(css = ".icon-itinerary>a")
    private WebElement accountLink;

    @FindBy(css = ".icon-logout>a")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='nav-top']/ul/div[1]/li[3]/ul/li[2]/div[2]/div/span")
    private WebElement searchToReRun;

    /**
     * 
     * @return savedSearches
     */
    public WebElement getSavedSearches() {

        return savedSearches;
    }

    /**
     * 
     * @return savedSearchesIcon
     */
    public WebElement getSavedSearchesIcon() {

        return savedSearchesIcon;
    }

    /**
     * 
     * @return savedSearchesNewMessage
     * 
     */
    public WebElement getSavedSearchesNewMessage() {

        return savedSearchesNewMessage;
    }

    /**
     * 
     * @return flightDepartureInput
     */
    public WebElement getFlightDepatureInput() {

        return flightDepartureInput;
    }

    /**
     * 
     * @return flightArrivalInput
     */
    public WebElement getFlightArrivalInput() {

        return flightArrivalInput;
    }

    /**
     * 
     * @return departureCalander
     */
    public WebElement getDepartureCalander() {

        return departureCalander;
    }

    /**
     * 
     * @return returnCalander
     */
    public WebElement getReturnCalander() {

        return returnCalander;
    }

    /**
     * 
     * @return adults
     */
    public WebElement getAdults() {

        return adults;
    }

    /**
     * 
     * @return findFlightButton
     */
    public WebElement getFindFlightButton() {

        return findFlightButton;
    }

    /**
     * 
     * @return oneWayButton
     */
    public WebElement getOneWayButton() {

        return oneWayButton;
    }

    /**
     * 
     * @return departureDate
     */
    public WebElement getDepartureDate() {

        return departureDate;
    }

    /**
     * 
     * @return returnDate
     */
    public WebElement getReturnDate() {

        return returnDate;
    }

    /**
     * 
     * @return departureCityOneWay
     */
    public WebElement getDepartureCityOneWay() {

        return departureCityOneWay;
    }

    /**
     * 
     * @return arrivalCityOneWay
     */
    public WebElement getArrivalCityOneWay() {

        return arrivalCityOneWay;
    }

    /**
     * 
     * @return firstSavedSearch
     */
    public WebElement getFirstSavedSearch() {

        return firstSavedSearch;
    }

    /**
     * 
     * @return secondSavedSearch
     */
    public WebElement getSecondSavedSearch() {

        return secondSavedSearch;
    }

    /**
     * 
     * @return savedSearchCircle
     */
    public WebElement getSavedSearchCircle() {

        return savedSearchCircle;
    }

    /**
     * 
     * @return loginLink
     */
    public WebElement getLoginLink() {

        return loginLink;
    }

    /**
     * 
     * @return logoutLink
     */
    public WebElement getLogoutLink() {

        return logoutLink;
    }

    /**
     * 
     * @return returnButton
     */
    public WebElement getReturnButton() {

        return returnButton;
    }

    /**
     * 
     * @return multiCityButton
     */
    public WebElement getMultiCityButton() {
        return multiCityButton;
    }

    /**
     * 
     * @return firstSavedSearchDelete
     */
    public WebElement getFirstSavedSearchDelete() {

        return firstSavedSearchDelete;
    }

    /**
     * 
     * @return accountLink
     */
    public WebElement getAccountLink() {

        return accountLink;
    }

    public WebElement getSearchToReRun() {
        return searchToReRun;
    }

    public WebElement getFlightDepartureInput() {
        return flightDepartureInput;
    }

    public WebElement getMultiCityDate() {
        return multiCityDate;
    }

    public WebElement getEditedSavedSearch() {
        return editedSavedSearch;
    }

}
