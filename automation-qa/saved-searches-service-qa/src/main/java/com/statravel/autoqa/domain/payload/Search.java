package com.statravel.autoqa.domain.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.statravel.autoqa.domain.payload.flight.FlightDestination;
import com.statravel.autoqa.domain.payload.flight.FlightSearch;
import com.statravel.autoqa.domain.payload.flight.PreferredAirline;
import com.statravel.autoqa.domain.payload.insurance.InsuranceSearch;
import com.statravel.autoqa.domain.payload.tour.TourSearch;

/**
 * 
 * @author STA Development team
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Search implements Serializable {

    private static final long serialVersionUID = 2352097384301206968L;

    private static final int PRIME_NUMBER = 31;

    private String pos;
    private String userId;
    private String searchQuery;
    private String searchUuid;
    private FlightSearch flightSearch;
    private InsuranceSearch insuranceSearch;
    private TourSearch tourSearch;

    /**
     * 
     */
    public Search() {

    }

    /**
     * 
     * Builds a FlightSearchBuilder object.
     * 
     * @param flightSearchBuilder
     *            flightSearchBuilder builder
     */
    public Search(final FlightSearchBuilder flightSearchBuilder) {

        this.pos = flightSearchBuilder.pos;
        this.userId = flightSearchBuilder.userId;
        this.searchQuery = UUID.randomUUID().toString();
        this.searchQuery = UUID.randomUUID().toString();

        this.flightSearch = new FlightSearch(flightSearchBuilder.numberOfAdults, flightSearchBuilder.numberOfStudents,
                flightSearchBuilder.numberOfUnder26, flightSearchBuilder.numberOfTeachers, flightSearchBuilder.cheapestPrice,
                flightSearchBuilder.flexibleDate, flightSearchBuilder.cabinClass);
        this.flightSearch.setFlightDestinationList(flightSearchBuilder.destinationList);
        this.flightSearch.setPreferredAirlineList(flightSearchBuilder.preferredAirlineList);

    }

    /**
     * 
     * Builds a InsuranceSearchBuilder object.
     * 
     * @param insuranceSearchBuilder
     *            insuranceSearchBuilder builder
     */
    public Search(final InsuranceSearchBuilder insuranceSearchBuilder) {

        this.pos = insuranceSearchBuilder.pos;
        this.userId = insuranceSearchBuilder.userId;
        this.searchQuery = UUID.randomUUID().toString();
        this.searchQuery = UUID.randomUUID().toString();

        this.insuranceSearch = new InsuranceSearch(insuranceSearchBuilder.policy, insuranceSearchBuilder.region, insuranceSearchBuilder.startDate,
                insuranceSearchBuilder.endDate, insuranceSearchBuilder.numberOfTravellers);

    }
    
    /**
     * 
     * @param tourSearchBuilder
     *              tourSearchBuilder builder;
     */
    public Search(final TourSearchBuilder tourSearchBuilder) {
        
        this.pos = tourSearchBuilder.pos;
        this.userId = tourSearchBuilder.userId;
        this.searchQuery = UUID.randomUUID().toString();
        this.searchQuery = UUID.randomUUID().toString();        
        
        this.tourSearch = new TourSearch(tourSearchBuilder.budget, tourSearchBuilder.destination, tourSearchBuilder.duration);
    }

    /**
     * @return the pos
     */
    public String getPos() {
        return pos;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the searchQuery
     */
    public String getSearchQuery() {
        return searchQuery;
    }

    /**
     * @return the searchUuid
     */
    public String getSearchUuid() {
        return searchUuid;
    }

    /**
     * @return the flightSearch
     */
    public FlightSearch getFlightSearch() {
        return flightSearch;
    }

    /**
     * @return the insuranceSearch
     */
    public InsuranceSearch getInsuranceSearch() {
        return insuranceSearch;
    }
    
    /**
     * 
     * @return a tour search
     */
    public TourSearch getTourSearch() {
        return tourSearch;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = PRIME_NUMBER;
        int result = 1;

        result = prime * result + ((insuranceSearch == null) ? 0 : insuranceSearch.hashCode());
        result = prime * result + ((flightSearch == null) ? 0 : flightSearch.hashCode());
        result = prime * result + ((tourSearch == null) ? 0 : tourSearch.hashCode());
        result = prime * result + ((pos == null) ? 0 : pos.hashCode());

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Search)) {
            return false;
        }

        Search other = (Search) obj;

        if (insuranceSearch == null) {
            if (other.insuranceSearch != null) {
                return false;
            }
        } else if (!insuranceSearch.equals(other.insuranceSearch)) {
            return false;
        }

        if (flightSearch == null) {
            if (other.flightSearch != null) {
                return false;
            }
        } else if (!flightSearch.equals(other.flightSearch)) {
            return false;
        }
        
        if (tourSearch == null) {
            if (other.tourSearch != null) {
                return false;
            }
        } else if (!tourSearch.equals(other.tourSearch)) {
            return false;
        }

        if (pos == null) {
            if (other.pos != null) {
                return false;
            }
        } else if (!pos.equals(other.pos)) {
            return false;
        }

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SearchResource [pos=" + pos + ", userId=" + userId + ", searchQuery=" + searchQuery + ", searchUuid=" + searchUuid + ", flightSearch="
                + flightSearch + ", insuranceSearch=" + insuranceSearch + ", tourSearch=" + tourSearch + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class FlightSearchBuilder {

        private String pos;
        private String userId;

        private int numberOfAdults;
        private int numberOfStudents;
        private int numberOfUnder26;
        private int numberOfTeachers;
        private double cheapestPrice;
        private boolean flexibleDate;
        private String cabinClass;
        
        private List<FlightDestination> destinationList = new ArrayList<FlightDestination>();
        private List<PreferredAirline> preferredAirlineList = new ArrayList<PreferredAirline>();

        /**
         * 
         * @param pos
         *            point of sales
         * @param userId
         *            user ID
         */
        public FlightSearchBuilder(final String pos, final String userId) {

            this.pos = pos;
            this.userId = userId;

        }

        /**
         * 
         * @param adults
         *            number of adults
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder numberOfAdults(final int adults) {
            this.numberOfAdults = adults;
            return this;
        }

        /**
         * 
         * @param students
         *            number of students
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder numberOfStudents(final int students) {
            this.numberOfStudents = students;
            return this;
        }

        /**
         * 
         * @param under26
         *            number of under 26
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder numberOfUnder26(final int under26) {
            this.numberOfUnder26 = under26;
            return this;
        }

        /**
         * 
         * @param teachers
         *            number of teachers
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder numberOfTeachers(final int teachers) {
            this.numberOfTeachers = teachers;
            return this;
        }

        /**
         * 
         * @param price
         *            cheapest price
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder cheapestPrice(final double price) {
            this.cheapestPrice = price;
            return this;
        }

        /**
         * 
         * @param isFlexibleDate
         *            flexible Date
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder flexibleDate(final boolean isFlexibleDate) {
            this.flexibleDate = isFlexibleDate;
            return this;
        }

        /**
         * 
         * @param cClass
         *            cabin class
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder cabinClass(final String cClass) {
            this.cabinClass = cClass;
            return this;
        }

        /**
         * 
         * @param from
         *            destination from
         * @param to
         *            destination to
         * @param departureDate
         *            departure date
         * @param departureTime
         *            departure time
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder destination(final String from, final String to, final Date departureDate, final String departureTime) {

            this.destinationList.add(new FlightDestination(from, to, departureDate, departureTime));
            return this;
        }

        /**
         * 
         * @param from
         *            destination from
         * @param to
         *            destination to
         * @param departureDate
         *            departure date
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder destination(final String from, final String to, final Date departureDate) {

            this.destinationList.add(new FlightDestination(from, to, departureDate, null));
            return this;
        }

        /**
         * 
         * @param code
         *            airline code
         * @return SearchBuilder instance
         */
        public FlightSearchBuilder preferredAirline(final String code) {

            this.preferredAirlineList.add(new PreferredAirline(code));

            return this;
        }

        /**
         * Builds Flight Search.
         * 
         * @return FlightSearchBuilder instance
         */
        public Search build() {
            return new Search(this);
        }
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class InsuranceSearchBuilder {

        private String pos;
        private String userId;

        private String policy;
        private String region;
        private Date startDate;
        private Date endDate;
        private Byte numberOfTravellers;

        /**
         * 
         * @param pos
         *            point of sales
         * @param userId
         *            user ID
         */
        public InsuranceSearchBuilder(final String pos, final String userId) {

            this.pos = pos;
            this.userId = userId;

        }

        /**
         * 
         * @param policy
         *            insurance policy
         * @return InsuranceSearchBuilder instance
         */
        public InsuranceSearchBuilder policy(final String policy) {
            this.policy = policy;
            return this;
        }

        /**
         * 
         * @param region
         *            region
         * @return InsuranceSearchBuilder instance
         */
        public InsuranceSearchBuilder region(final String region) {
            this.region = region;
            return this;
        }

        /**
         * 
         * @param startDate
         *            start date
         * @return InsuranceSearchBuilder instance
         */
        public InsuranceSearchBuilder startDate(final Date startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * 
         * @param endDate
         *            end date
         * @return InsuranceSearchBuilder instance
         */
        public InsuranceSearchBuilder endDate(final Date endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * 
         * @param numberOfTravellers
         *            number of travellers
         * @return InsuranceSearchBuilder instance
         */
        public InsuranceSearchBuilder numberOfTravellers(final Byte numberOfTravellers) {
            this.numberOfTravellers = numberOfTravellers;
            return this;
        }

        /**
         * Builds Flight Search.
         * 
         * @return FlightSearchBuilder instance
         */
        public Search build() {
            return new Search(this);
        }
    }
    
    /**
     * 
     * @author STA Development Team
     *
     */
    public static class TourSearchBuilder {
        
        private String pos;
        private String userId;

        private String duration;
        private String destination;
        private String budget;
        
        /**
         * 
         * @param pos
         *            point of sales
         * @param userId
         *            user ID
         */
        public TourSearchBuilder(final String pos, final String userId) {

            this.pos = pos;
            this.userId = userId;

        }

        /**
         * 
         * @param duration
         *            duration
         * @return TourSearchBuilder duration
         */
        public TourSearchBuilder duration(final String duration) {
            this.duration = duration;
            return this;
        }
        
        /**
         * 
         * @param destination
         *            destination
         * @return TourSearchBuilder destination
         */
        public TourSearchBuilder destination(final String destination) {
            this.destination = destination;
            return this;
        }
        
        /**
         * 
         * @param budget
         *            budget
         * @return TourSearchBuilder budget
         */
        public TourSearchBuilder budget(final String budget) {
            this.budget = budget;
            return this;
        }
        
        /**
         * Builds Tour Search.
         * 
         * @return TourSearchBuilder instance
         */
        public Search build() {
            return new Search(this);
        }
        
    }

}
