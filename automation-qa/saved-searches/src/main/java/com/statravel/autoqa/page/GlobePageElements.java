package com.statravel.autoqa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobePageElements extends PageElements {
	
	@FindBy(css = "#glbSearchMasthead")
	private WebElement advancedSearchTitle;
	
	@FindBy(css = "#flight-type1")
	private WebElement returnFlight;
	
	@FindBy(css = "#flight-type2")
	private WebElement oneWayFlight;
	
	@FindBy(css = "#flight-type3")
	private WebElement multiCityFlight;
	
	@FindBy(css = "#departureOriginLocationTextRT")
	private WebElement fromCityOrAirport;
	
	@FindBy(css = "#departureDestLocationTextRT")
	private WebElement toCityOrAirport;
	
	@FindBy(css = "#departureDayRT")
	private WebElement departureDay;
	
	@FindBy(css = "#departureMonthYearRT")
	private WebElement departureMonthYear;
	
	@FindBy(css = "#departureTimeRT")
	private WebElement departureTime;
	
	@FindBy(css = "#returnDayRT")
	private WebElement returnDay;
	
	@FindBy(css = "#returnMonthYearRT")
	private WebElement returnMonthYear;
	
	@FindBy(css = "#returnTimeRT")
	private WebElement returnTime;
	
	@FindBy(css = "#search-flexible-dates")
	private WebElement flexibleDates;
	
	@FindBy(css = "#directFlights")
	private WebElement nonStopFlights;	
	
	@FindBy(css = "#travelersStudentMenu")
	private WebElement student;	
	
	@FindBy(css = "#travelersUnderMenu")
	private WebElement under26;	
	
	@FindBy(css = "#travelersAdultMenu")
	private WebElement adultsOver26;	
	
	@FindBy(css = "#travelersTeacherMenu")
	private WebElement teacher;	
	
	@FindBy(css = "#cabinClass")
	private WebElement cabinClass;	
	
	@FindBy(css = "#btnSearch")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='ext-gen100']/div[3]/div/table/tbody/tr/td")
	private WebElement fromCityAirportDropDown;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div[5]/div/table/tbody/tr/td")
	private WebElement toCityAirportDropDown;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div[4]/div/table/tbody/tr/td")
	private WebElement toReturnCityAirportDropDown;
	
	@FindBy(css = "#multiCityOptionCount")
	private WebElement numberOfFlightsDropDown;

	@FindBy(xpath = "//*[@id='multiCityOptions[0].originLocationBlock']/div/input")
	private WebElement multiCityFlightFrom1;
	
	@FindBy(xpath = "//*[@id='multiCityFlight[0]']/fieldset[2]/div/div/input")
	private WebElement multiCityFlightTo1;
	
	@FindBy(xpath = "//*[@id='multiCityOptions[1].originLocationBlock']/div/input")
	private WebElement multiCityFlightFrom2;
	
	@FindBy(xpath = "//*[@id='multiCityOptions[1].destinationLocationBlock']/div/input")
	private WebElement multiCityFlightTo2;
	
	@FindBy(xpath = "//*[@id='multiCityOptions[2].originLocationBlock']/div/input")
	private WebElement multiCityFlightFrom3;
	
	@FindBy(xpath = "//*[@id='multiCityOptions[2].destinationLocationBlock']/div/input")
	private WebElement multiCityFlightTo3;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div/div/table/tbody/tr/td")
	private WebElement multiCityFlightFromDropDown1;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div[4]/div/table/tbody/tr/td")
	private WebElement multiCityFlightToDropDown1;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div[7]/div/table/tbody/tr/td")
	private WebElement multiCityFlightFromDropDown2;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div[8]/div/table/tbody/tr/td")
	private WebElement multiCityFlightToDropDown2;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div[9]/div/table/tbody/tr/td")
	private WebElement multiCityFlightFromDropDown3;
	
	@FindBy(xpath = "//*[@id='ext-gen100']/div[10]/div/table/tbody/tr/td")
	private WebElement multiCityFlightToDropDown3;
	
	@FindBy(xpath = "//*[@id='calendarMonthBlock2']/table/tbody/tr[4]/td[2]/a")
	private WebElement multiCityDate1;
	
	@FindBy(xpath = "//*[@id='calendarMonthBlock2']/table/tbody/tr[4]/td[5]/a")
	private WebElement multiCityDate2;
	
	@FindBy(xpath = "//*[@id='calendarMonthBlock2']/table/tbody/tr[4]/td[1]/a")
	private WebElement multiCityDate3;
	
	@FindBy(xpath = "//*[@id='multiCityOptions[0].departureDateBlock']/input[4]")
	private WebElement multiCityInputDate1;
	
	@FindBy(xpath = "//*[@id='multiCityOptions[1].departureDateBlock']/input[4]")
	private WebElement multiCityInputDate2;
	
	@FindBy(xpath = "//*[@id='multiCityOptions[2].departureDateBlock']/input[4]")
	private WebElement multiCityInputDate3;
	
	
	public WebElement getAdvancedSearchTitle() {
		return advancedSearchTitle;
	}

	public WebElement getReturnFlight() {
		return returnFlight;
	}

	public WebElement getOneWayFlight() {
		return oneWayFlight;
	}

	public WebElement getMultiCityFlight() {
		return multiCityFlight;
	}

	public WebElement getFromCityOrAirport() {
		return fromCityOrAirport;
	}

	public WebElement getToCityOrAirport() {
		return toCityOrAirport;
	}

	public WebElement getDepartureDay() {
		return departureDay;
	}

	public WebElement getDepartureMonthYear() {
		return departureMonthYear;
	}

	public WebElement getDepartureTime() {
		return departureTime;
	}

	public WebElement getReturnDay() {
		return returnDay;
	}

	public WebElement getReturnMonthYear() {
		return returnMonthYear;
	}

	public WebElement getReturnTime() {
		return returnTime;
	}

	public WebElement getFlexibleDates() {
		return flexibleDates;
	}

	public WebElement getNonStopFlights() {
		return nonStopFlights;
	}

	public WebElement getStudent() {
		return student;
	}

	public WebElement getUnder26() {
		return under26;
	}

	public WebElement getAdultsOver26() {
		return adultsOver26;
	}

	public WebElement getTeacher() {
		return teacher;
	}

	public WebElement getCabinClass() {
		return cabinClass;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getFromCityAirportDropDown() {
		return fromCityAirportDropDown;
	}

	public WebElement getToCityAirportDropDown() {
		return toCityAirportDropDown;
	}

	public WebElement getToReturnCityAirportDropDown() {
		return toReturnCityAirportDropDown;
	}

	public WebElement getNumberOfFlightsDropDown() {
		return numberOfFlightsDropDown;
	}

	public WebElement getMultiCityFlightFrom1() {
		return multiCityFlightFrom1;
	}

	public WebElement getMultiCityFlightTo1() {
		return multiCityFlightTo1;
	}

	public WebElement getMultiCityFlightFrom2() {
		return multiCityFlightFrom2;
	}

	public WebElement getMultiCityFlightTo2() {
		return multiCityFlightTo2;
	}

	public WebElement getMultiCityFlightFrom3() {
		return multiCityFlightFrom3;
	}

	public WebElement getMultiCityFlightTo3() {
		return multiCityFlightTo3;
	}

	public WebElement getMultiCityDate1() {
		return multiCityDate1;
	}

	public WebElement getMultiCityDate2() {
		return multiCityDate2;
	}

	public WebElement getMultiCityDate3() {
		return multiCityDate3;
	}

	public WebElement getMultiCityInputDate1() {
		return multiCityInputDate1;
	}

	public WebElement getMultiCityInputDate2() {
		return multiCityInputDate2;
	}

	public WebElement getMultiCityInputDate3() {
		return multiCityInputDate3;
	}

	public WebElement getMultiCityFlightFromDropDown1() {
		return multiCityFlightFromDropDown1;
	}

	public WebElement getMultiCityFlightToDropDown1() {
		return multiCityFlightToDropDown1;
	}

	public WebElement getMultiCityFlightFromDropDown2() {
		return multiCityFlightFromDropDown2;
	}

	public WebElement getMultiCityFlightToDropDown2() {
		return multiCityFlightToDropDown2;
	}

	public WebElement getMultiCityFlightFromDropDown3() {
		return multiCityFlightFromDropDown3;
	}

	public WebElement getMultiCityFlightToDropDown3() {
		return multiCityFlightToDropDown3;
	}
	
}
