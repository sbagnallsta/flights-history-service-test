package com.statravel.autoqa.common;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.payload.Search;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class SearchUtils {

    @Autowired
    private ApplicationProperties applicationProperties;

    /**
     * Builds a flight search object.
     * 
     * @param userId
     *            user id
     * @return flight search object built
     */
    public Search buildFlightSearch(final String userId) {

        Calendar calendarDestination1 = Calendar.getInstance();
        calendarDestination1.add(Calendar.DATE, Constants.TWO_DAY);

        Calendar calendarDestination2 = Calendar.getInstance();
        calendarDestination2.add(Calendar.DATE, Constants.FIVE_DAY);

        return new Search.FlightSearchBuilder(applicationProperties.getPos(), userId).numberOfAdults(1)
                                                                                     .destination(Constants.LONDON_CITY_CODE,
                                                                                             Constants.LISBON_CITY_CODE,
                                                                                             calendarDestination1.getTime())
                                                                                     .destination(Constants.LISBON_CITY_CODE,
                                                                                             Constants.LONDON_CITY_CODE,
                                                                                             calendarDestination2.getTime())
                                                                                     .cabinClass("Standard")
                                                                                     .build();
    }

    /**
     * Builds an insurance search object.
     * 
     * @param userId
     *            user id
     * @return insurance search object built
     */
    public Search buildInsuranceSearch(final String userId) {

        Calendar calendarDestination1 = Calendar.getInstance();
        calendarDestination1.add(Calendar.DATE, Constants.TWO_DAY);

        Calendar calendarDestination2 = Calendar.getInstance();
        calendarDestination2.add(Calendar.DATE, Constants.FIVE_DAY);

        return new Search.InsuranceSearchBuilder(applicationProperties.getPos(), userId).policy(Constants.POLICY)
                                                                                        .region(Constants.REGION)
                                                                                        .startDate(calendarDestination1.getTime())
                                                                                        .endDate(calendarDestination2.getTime())
                                                                                        .numberOfTravellers((byte) 1)
                                                                                        .build();
    }
    
    /**
     * 
     * @param userId userId
     * @return tour search object
     */
    public Search buildTourSearch(final String userId) {
        String budget = "any";
        String duration = "any";
        String destination = "Italy";
        
        return new Search.TourSearchBuilder(applicationProperties.getPos(), userId).budget(budget).duration(duration).destination(destination).build();
        
    }

    /**
     * Builds an invalid flight search object.
     * 
     * @param userId
     *            user id
     * @return flight search object built
     */
    public Search buildFlightInvalidSearch(final String userId) {

        Calendar calendarDestination1 = Calendar.getInstance();
        calendarDestination1.add(Calendar.DATE, -Constants.TWO_DAY);

        Calendar calendarDestination2 = Calendar.getInstance();
        calendarDestination2.add(Calendar.DATE, -Constants.FIVE_DAY);

        return new Search.FlightSearchBuilder(applicationProperties.getPos(), userId).numberOfAdults(1)
                                                                                     .destination(Constants.LONDON_CITY_CODE,
                                                                                             Constants.LISBON_CITY_CODE,
                                                                                             calendarDestination1.getTime())
                                                                                     .destination(Constants.LISBON_CITY_CODE,
                                                                                             Constants.LONDON_CITY_CODE,
                                                                                             calendarDestination2.getTime())
                                                                                     .cabinClass("Standard")
                                                                                     .build();
    }

}
