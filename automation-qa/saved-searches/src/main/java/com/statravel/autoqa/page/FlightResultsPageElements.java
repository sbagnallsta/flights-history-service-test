package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author STA Development Team
 *
 */
public class FlightResultsPageElements extends PageElements {

    @FindBy(css = ".counter")
    private WebElement flightCounter;

    @FindBy(xpath = ".//*[@id='glbFlightResultsContainer']/p")
    private WebElement multiCityFlightCounter;

    @FindBy(css = ".search-bar-infobox.nowrap")
    private WebElement flightSearchToFrom;

    @FindBy(css = ".flight-type")
    private WebElement flightSearchType;

    @FindBy(css = "#page_content")
    private WebElement pageContent;

    @FindBy(css = "#hResults")
    private WebElement multiCityResult;

    @FindBy(css = "#glbFlightSummary")
    private WebElement flightSearchResultsPageId;

    @FindBy(css = "#btnShowSearchCriteria")
    private WebElement editMultiCitySearchButton;

    @FindBy(xpath = "//*[@id='multiCityOptions[0].originLocationBlock']/div/input")
    private WebElement multiCityFlightFromTextField;

    @FindBy(xpath = "//*[@id='ext-gen76']/div[3]/div/table/tbody/tr/td")
    private WebElement multiCityFlightFromDropDown1;

    @FindBy(xpath = "//*[@id='glbContainer']/form/div[4]/a/img")
    private WebElement updateSearch;

    /**
     * 
     * @return the flight counter
     */
    public WebElement getFlightCounter() {
        return flightCounter;
    }

    /**
     * 
     * @return to to and from for the search
     */
    public WebElement getFlightSearchToFrom() {
        return flightSearchToFrom;
    }

    /**
     * 
     * @return the flight type searched for
     */
    public WebElement getFlightSearchType() {
        return flightSearchType;
    }

    public WebElement getPageContent() {
        return pageContent;
    }

    public WebElement getFlightSearchResultsPageId() {
        return flightSearchResultsPageId;
    }

    public WebElement getMultiCityResult() {
        return multiCityResult;
    }

    public WebElement getMultiCityFlightCounter() {
        return multiCityFlightCounter;
    }

    public WebElement getEditMultiCitySearchButton() {
        return editMultiCitySearchButton;
    }

    public WebElement getMultiCityFlightFromTextField() {
        return multiCityFlightFromTextField;
    }

    public WebElement getMultiCityFlightFromDropDown1() {
        return multiCityFlightFromDropDown1;
    }

    public WebElement getUpdateSearch() {
        return updateSearch;
    }

}
