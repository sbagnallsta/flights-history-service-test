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
     * Builds a search object.
     * 
     * @param userId
     *            user id
     * @return search object built
     */
    public Search buildSearch(final String userId) {

        Calendar calendarDestination1 = Calendar.getInstance();
        calendarDestination1.add(Calendar.DATE, Constants.TWO_DAY);

        Calendar calendarDestination2 = Calendar.getInstance();
        calendarDestination2.add(Calendar.DATE, Constants.FIVE_DAY);

        return new Search.SearchBuilder(applicationProperties.getPos(), userId).numberOfAdults(1)
                                                                               .destination(Constants.LONDON_CITY_CODE, Constants.LISBON_CITY_CODE,
                                                                                       calendarDestination1.getTime())
                                                                               .destination(Constants.LISBON_CITY_CODE, Constants.LONDON_CITY_CODE,
                                                                                       calendarDestination2.getTime())
                                                                               .build();
    }

    /**
     * Builds an invalid search object.
     * 
     * @param userId
     *            user id
     * @return search object built
     */
    public Search buildInvalidSearch(final String userId) {

        Calendar calendarDestination1 = Calendar.getInstance();
        calendarDestination1.add(Calendar.DATE, -Constants.TWO_DAY);

        Calendar calendarDestination2 = Calendar.getInstance();
        calendarDestination2.add(Calendar.DATE, -Constants.FIVE_DAY);

        return new Search.SearchBuilder(applicationProperties.getPos(), userId).numberOfAdults(1)
                                                                               .destination(Constants.LONDON_CITY_CODE, Constants.LISBON_CITY_CODE,
                                                                                       calendarDestination1.getTime())
                                                                               .destination(Constants.LISBON_CITY_CODE, Constants.LONDON_CITY_CODE,
                                                                                       calendarDestination2.getTime())
                                                                               .build();
    }

}
