/**
 * 
 */
package com.statravel.autoqa.common;

import java.util.ArrayList;
import java.util.List;

import com.statravel.autoqa.domain.dto.payload.Destination;
import com.statravel.autoqa.domain.dto.payload.Fare;
import com.statravel.autoqa.domain.dto.payload.Flight;
import com.statravel.autoqa.domain.dto.payload.Origin;
import com.statravel.autoqa.domain.dto.payload.Segment;

/**
 * @author STA Development Team
 *
 */
public class TestUtils {
    
    public static final String COLLECTOR = "collector";
    public static final String MANUAL = "manual";
    
    public static final String POS = "pos";

    
    public static final String NA = "NA";
    
    //----FLIGHT TOP LEVEL ATTRIBUTES
    private static final String KEY = "key";
    private static final Boolean CAMP_FARE = false;
    private static final String CAMP_CODE = "2016_contiki_summer";  
    private static final String SALE_START = "2017-12-12";
    private static final String SALE_END = "2017-12-14";
    private static final String SEARCH_DATE = "2017-11-11";
    private static final String SEASON = "Summer";
    private static final String ADV_PURCH = "12 hour";
    private static final Boolean OPAQUE = true; 
    private static final String BOOK_BY = "2017-12-15";
    private static final String TICKET_TYPE = "BIFA_Private_SATA";
    private static final String STAY = "180 days";
    private static final String FLIGHT_TYPE = "internation";
    private static final String FLIGHT_TICKET_TYPE = "a ticket type?";
    private static final String DURATION = "1d4h39m";
    private static final String DEPART_DATE = "2017-09-09";
    private static final String RETURN_DATE = "2017-10-10";
    private static final String ELIGIBILITY = "student";
    private static final String STOP_OVER_1 = "ATL";
    private static final Boolean DIRECT = false;
    private static final Boolean RESTRICTIONS = true;
    private static final Boolean EXCLUSIVE = false;
    private static final Boolean LAYBY = true;
    private static final Boolean MULTI_FLEX = false; 
    private static final String TOP_OFFER = "contiki_camp";
    private static final String URL_DEEP =  "http://book.statravel.com.au/staglobe/AirSearchInterstitialScreen.do?cabinClass=Economy&preferedAirline%5B0%5D=&departureDestLocation=SYD&departureOriginLocation=LON&followAction=AirFlightSearch&div=au&departureDay=17&departureMonthYear=08-2017&departureTime=A&directFlights=false&travellersCount=1&pos=1ASTAGLOBE-AU&isSearchWidget=true&returnDay=22&returnMonthYear=09-2017&returnTime=A&typeOfSearch=RT&flexibleSearch=false&travellerTypes%5B0%5D=STU";

    //----DESTINATION ATTRIBUTES
    private static final String DEST_REGION = "America";
    private static final String DEST_COUNTRY = "Mexico";
    private static final String DEST_CITY = "Tijuana";
    private static final String DEST_IATA = "TQA";

    //----FARE ATTRIBUTES
    private static final String CURRENCY = "usd";
    private static final Double NETT = 1500.00;
    private static final Double Q = 100.00;
    private static final Double YQ = 200.00;
    private static final Double BOOKING_FEE = 200.00;
    private static final Double TOTAL = 2000.00;
    private static final String TYPE_1 = "BAPA";
    
    //----SEGMENT ATTRIBUTES
    private static final String LEAVE_DATE = "2017-06-06";
    private static final String ARRIVE_DATE = "2017-06-07";
    private static final String SEG_ORIGIN = "LONDON";
    private static final String SEG_DESTINATION = "LISBON";
    private static final String CABIN = "Economy";
    private static final String CABIN_CODE = "E";
    private static final String NUM = "BA 123";
    private static final String MARK_AIRLINE = "VN";
    private static final String OP_AIRLINE = "BA";
    private static final String AIRCRAFT = "747";
    
    //-----ORIGIN ATTRIBUTES
    private static final String ORG_CITY = "London";
    private static final String ORG_IATA = "LDN";   
        
    /**
     * 
     * @param pos the pos
     * @param isManual true for manual false for collector
     * @return a flight object
     */
    public Flight createFlight(final String pos, final Boolean isManual) {
        Segment flight = new Segment(LEAVE_DATE, ARRIVE_DATE, SEG_ORIGIN, SEG_DESTINATION, CABIN, CABIN_CODE, NUM, MARK_AIRLINE, OP_AIRLINE, AIRCRAFT);
        List<Segment> flights = new ArrayList<Segment>(1);
        flights.add(flight);
        
        Destination destination = new Destination(DEST_REGION, DEST_COUNTRY, DEST_CITY, DEST_IATA);
        
        List<String> fareTypes = new ArrayList<String>(1);
        fareTypes.add(TYPE_1);
        Fare fare = new Fare(CURRENCY, NETT, Q, YQ, BOOKING_FEE, TOTAL, fareTypes);
        
        Origin origin = new Origin(ORG_CITY, ORG_IATA);
       
        List<String> stopOvers = new ArrayList<String>(1);
        stopOvers.add(STOP_OVER_1);
        return new Flight(pos, isManual, KEY, CAMP_FARE, CAMP_CODE, SALE_START, SALE_END, SEARCH_DATE, SEASON, ADV_PURCH, OPAQUE, BOOK_BY, TICKET_TYPE, STAY, FLIGHT_TYPE, FLIGHT_TICKET_TYPE, DURATION, DEPART_DATE, RETURN_DATE, ELIGIBILITY, stopOvers, DIRECT, RESTRICTIONS, EXCLUSIVE, LAYBY, MULTI_FLEX, TOP_OFFER, URL_DEEP, destination, origin, fare, flights);
    }
    
}
