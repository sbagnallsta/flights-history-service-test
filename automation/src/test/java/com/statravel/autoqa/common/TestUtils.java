/**
 * 
 */
package com.statravel.autoqa.common;

import java.text.SimpleDateFormat;
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
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public static final String SOURCE_COLLECTOR = "collector";
    public static final String SOURCE_MANUAL = "manual";
    
    public static final String POS = "pos";
    public static final String NA = "NA";
    
    //----FLIGHT TOP LEVEL ATTRIBUTES
    private static final String STOP_OVER_1 = "ATL";

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
     * @throws Exception an Exception parsing the date
     */
    public Flight createFlight(final String pos, final boolean isManual) {
        Segment flight = null;
        
        try {
            
            flight = new Segment(sdf.parse("2017-11-11"), sdf.parse("2017-11-18"), SEG_ORIGIN, SEG_DESTINATION, CABIN, CABIN_CODE, NUM, MARK_AIRLINE, OP_AIRLINE, AIRCRAFT);
        
        } catch (Exception exception) {
            
            flight = null;
            
        }
        
        List<Segment> flights = new ArrayList<Segment>(1);
        flights.add(flight);
        
        Destination destination = new Destination(DEST_REGION, DEST_COUNTRY, DEST_CITY, DEST_IATA);
        
        List<String> fareTypes = new ArrayList<String>(1);
        fareTypes.add(TYPE_1);
        Fare fare = new Fare(CURRENCY, NETT, Q, YQ, BOOKING_FEE, TOTAL, fareTypes);
        
        Origin origin = new Origin(ORG_CITY, ORG_IATA);
       
        List<String> stopOvers = new ArrayList<String>(1);
        stopOvers.add(STOP_OVER_1);
        return new Flight(pos, isManual, stopOvers, destination, origin, fare, flights);
    }
    
}
