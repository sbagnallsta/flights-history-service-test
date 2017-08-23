package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.commons.WebDriverFactory;
import com.statravel.autoqa.domain.FlightSearch;

@Service
public class GlobePage extends Page<GlobePageElements>{
	
	 @Autowired
	 private WebDriverCommons webDriverCommons;
	 
	 private GlobePageElements globePageElements;

	@Override
	public boolean isPageLoaded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		
		globePageElements = new GlobePageElements();

	    super.initialiseElements(globePageElements);
		
	}

	@Override
	public GlobePageElements getPageElements() {
		
		return globePageElements;
	}
	
	public void selectOneWay() {
		
		webDriverCommons.scrollTo(globePageElements.getOneWayFlight());
		globePageElements.getOneWayFlight().click();
		
	}
	
	public void selectReturn() {
		
		webDriverCommons.scrollTo(globePageElements.getReturnFlight());
		globePageElements.getReturnFlight().click();
		
	}
	
	public void selectMultiCity() {
		
		webDriverCommons.scrollTo(globePageElements.getMultiCityFlight());
		globePageElements.getMultiCityFlight().click();
		
	}
	
	public String getRadionButtonValue(WebElement element) {
		
		return element.getAttribute("value");
	}
	
	public void selectNumberOfFlights() {
		
		Select select = webDriverCommons.createSelect(globePageElements.getNumberOfFlightsDropDown());
		select.selectByIndex(1);
		
	}
	
	 /**
     * 
     * Fills destination and date section.
     * 
     * @param search
     *            the flight we are going to search for
     */
    public void fillOneWayDestinationsDates(final FlightSearch search) {
    	
    	webDriverCommons.scrollTo(globePageElements.getFromCityOrAirport());
    	globePageElements.getFromCityOrAirport().clear();
    	globePageElements.getFromCityOrAirport().sendKeys(search.getDepartureDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getFromCityAirportDropDown());
    	
    	Actions action = new Actions(WebDriverFactory.getWebDriver());
    	action.moveToElement(globePageElements.getFromCityAirportDropDown()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getToCityOrAirport());
    	globePageElements.getToCityOrAirport().clear();
    	globePageElements.getToCityOrAirport().sendKeys(search.getArrivalDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getToCityAirportDropDown());
    	action.moveToElement(globePageElements.getToCityAirportDropDown()).click().perform();
    	
    	Select select = webDriverCommons.createSelect(globePageElements.getDepartureMonthYear());
        select.selectByIndex(1);

    }
    
    /**
     * 
     * Fills destination and date section.
     * 
     * @param search
     *            the flight we are going to search for
     */
    public void fillReturnDestinationsDates(final FlightSearch search) {
    	
    	webDriverCommons.scrollTo(globePageElements.getFromCityOrAirport());
    	globePageElements.getFromCityOrAirport().clear();
    	globePageElements.getFromCityOrAirport().sendKeys(search.getDepartureDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getFromCityAirportDropDown());
    	
    	Actions action = new Actions(WebDriverFactory.getWebDriver());
    	action.moveToElement(globePageElements.getFromCityAirportDropDown()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getToCityOrAirport());
    	globePageElements.getToCityOrAirport().clear();
    	globePageElements.getToCityOrAirport().sendKeys(search.getArrivalDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getToReturnCityAirportDropDown());
    	action.moveToElement(globePageElements.getToReturnCityAirportDropDown()).click().perform();
    	
    	Select select = webDriverCommons.createSelect(globePageElements.getDepartureMonthYear());
        select.selectByIndex(1);
        
        Select returnSelect = webDriverCommons.createSelect(globePageElements.getReturnMonthYear());
        returnSelect.selectByIndex(1);

    }
    
    /**
     * 
     * Fills destination and date section.
     * 
     * @param search
     *            the flight we are going to search for
     */
    public void fillMultiCityDestinationsDates(final FlightSearch search1, final FlightSearch search2, final FlightSearch search3) {
    	
    	Actions action = new Actions(WebDriverFactory.getWebDriver());
    	//Flight 1
    	webDriverCommons.scrollTo(globePageElements.getMultiCityFlightFrom1());
    	globePageElements.getMultiCityFlightFrom1().clear();
    	globePageElements.getMultiCityFlightFrom1().sendKeys(search1.getDepartureDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityFlightFromDropDown1());  	
    	action.moveToElement(globePageElements.getMultiCityFlightFromDropDown1()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getMultiCityFlightTo1());
    	globePageElements.getMultiCityFlightTo1().clear();
    	globePageElements.getMultiCityFlightTo1().sendKeys(search1.getArrivalDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityFlightToDropDown1());
    	action.moveToElement(globePageElements.getMultiCityFlightToDropDown1()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getMultiCityInputDate1());
    	globePageElements.getMultiCityInputDate1().click();
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityDate1());
    	webDriverCommons.scrollTo(globePageElements.getMultiCityDate1());
    	globePageElements.getMultiCityDate1().click();

    	//Flight 2
    	webDriverCommons.scrollTo(globePageElements.getMultiCityFlightFrom2());
    	globePageElements.getMultiCityFlightFrom2().clear();
    	globePageElements.getMultiCityFlightFrom2().sendKeys(search2.getDepartureDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityFlightFromDropDown2());
    	action.moveToElement(globePageElements.getMultiCityFlightFromDropDown2()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getMultiCityFlightTo2());
    	globePageElements.getMultiCityFlightTo2().clear();
    	globePageElements.getMultiCityFlightTo2().sendKeys(search2.getArrivalDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityFlightToDropDown2());
    	action.moveToElement(globePageElements.getMultiCityFlightToDropDown2()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getMultiCityInputDate2());
    	globePageElements.getMultiCityInputDate2().click();
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityDate2());
    	webDriverCommons.scrollTo(globePageElements.getMultiCityDate2());
    	globePageElements.getMultiCityDate2().click();

    	
    	//Flight 3
    	webDriverCommons.scrollTo(globePageElements.getMultiCityFlightFrom3());
    	globePageElements.getMultiCityFlightFrom3().clear();
    	globePageElements.getMultiCityFlightFrom3().sendKeys(search3.getDepartureDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityFlightFromDropDown3());
    	action.moveToElement(globePageElements.getMultiCityFlightFromDropDown3()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getMultiCityFlightTo3());
    	globePageElements.getMultiCityFlightTo3().clear();
    	globePageElements.getMultiCityFlightTo3().sendKeys(search3.getArrivalDestination());
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityFlightToDropDown3());
    	action.moveToElement(globePageElements.getMultiCityFlightToDropDown3()).click().perform();
    	
    	webDriverCommons.scrollTo(globePageElements.getMultiCityInputDate3());
    	globePageElements.getMultiCityInputDate3().click();
    	webDriverCommons.waitForElementToBeVisible(globePageElements.getMultiCityDate3());
    	webDriverCommons.scrollTo(globePageElements.getMultiCityDate3());
    	globePageElements.getMultiCityDate3().click();

    }
    
    /**
     * Retrieves the date selected for a flight.
     * 
     * @param element
     * 			date view element 
     * @param flightSearch
     * 			flight search
     */			
    public void setDateSelected(final WebElement element, final FlightSearch flightSearch ) {
    	
    	String[] date = element.getAttribute("value").split(" ");
    	if (date.length > 0) {
    		
    		flightSearch.setDepartureDate(date[0] + " " + date[1]);
    	}
    	
    }
      
    
    /**
     * Fills travellers section.
     */
    public void fillTravelers() {
    	 	
    	webDriverCommons.scrollTo(globePageElements.getAdultsOver26());
    	webDriverCommons.selectFromDropdown(globePageElements.getAdultsOver26(), "2");
    	
    }
    
    /**
     * Fills flights section.
     */
    public void fillFlightsOption() {
    	 	
    	webDriverCommons.scrollTo(globePageElements.getCabinClass());
    	
    	Select select = webDriverCommons.createSelect(globePageElements.getCabinClass());
        select.selectByIndex(0);
    	
    }
    
    public void clickOnSearchButton() {
    	
    	webDriverCommons.scrollTo(globePageElements.getSearchButton());
    	
    	globePageElements.getSearchButton().click();
    	
    }

}
