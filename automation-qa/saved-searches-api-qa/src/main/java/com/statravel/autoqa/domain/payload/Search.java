package com.statravel.autoqa.domain.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @author STA Development team
 *
 */
public class Search implements Serializable {

    private static final long serialVersionUID = 2352097384301206968L;

    private static final int PRIME_NUMBER = 31;

    private String pos;
    private String userId;
    private String searchQuery;
    private String searchUuid;
    private FlightSearch flightSearch;

    /**
     * 
     */
    public Search() {

    }

    /**
     * 
     * Builds a SearchBuilder object.
     * 
     * @param searchBuilder
     *            searchBuilder builder
     */
    public Search(final SearchBuilder searchBuilder) {

        this.pos = searchBuilder.pos;
        this.userId = searchBuilder.userId;
        this.searchQuery = UUID.randomUUID().toString();
        this.searchQuery = UUID.randomUUID().toString();
        this.flightSearch = new FlightSearch(searchBuilder.numberOfAdults, searchBuilder.numberOfStudents, searchBuilder.numberOfUnder26,
                searchBuilder.numberOfTeachers, searchBuilder.flexibleDate, searchBuilder.cabinClass);
        this.flightSearch.setFlightDestinationList(searchBuilder.destinationList);
        this.flightSearch.setPreferredAirlineList(searchBuilder.preferredAirlineList);

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = PRIME_NUMBER;
        int result = 1;

        result = prime * result + ((flightSearch == null) ? 0 : flightSearch.hashCode());
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

        if (flightSearch == null) {
            if (other.flightSearch != null) {
                return false;
            }
        } else if (!flightSearch.equals(other.flightSearch)) {
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
                + flightSearch + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class SearchBuilder {

        private String pos;
        private String userId;

        private int numberOfAdults;
        private int numberOfStudents;
        private int numberOfUnder26;
        private int numberOfTeachers;
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
        public SearchBuilder(final String pos, final String userId) {

            this.pos = pos;
            this.userId = userId;

        }

        /**
         * 
         * @param adults
         *            number of adults
         * @return SearchBuilder instance
         */
        public SearchBuilder numberOfAdults(final int adults) {
            this.numberOfAdults = adults;
            return this;
        }

        /**
         * 
         * @param students
         *            number of students
         * @return SearchBuilder instance
         */
        public SearchBuilder numberOfStudents(final int students) {
            this.numberOfStudents = students;
            return this;
        }

        /**
         * 
         * @param under26
         *            number of under 26
         * @return SearchBuilder instance
         */
        public SearchBuilder numberOfUnder26(final int under26) {
            this.numberOfUnder26 = under26;
            return this;
        }

        /**
         * 
         * @param teachers
         *            number of teachers
         * @return SearchBuilder instance
         */
        public SearchBuilder numberOfTeachers(final int teachers) {
            this.numberOfTeachers = teachers;
            return this;
        }

        /**
         * 
         * @param isFlexibleDate
         *            flexible Date
         * @return SearchBuilder instance
         */
        public SearchBuilder flexibleDate(final boolean isFlexibleDate) {
            this.flexibleDate = isFlexibleDate;
            return this;
        }

        /**
         * 
         * @param cClass
         *            cabin class
         * @return SearchBuilder instance
         */
        public SearchBuilder cabinClass(final String cClass) {
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
        public SearchBuilder destination(final String from, final String to, final Date departureDate, final String departureTime) {

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
        public SearchBuilder destination(final String from, final String to, final Date departureDate) {

            this.destinationList.add(new FlightDestination(from, to, departureDate, null));
            return this;
        }

        /**
         * 
         * @param code
         *            airline code
         * @return SearchBuilder instance
         */
        public SearchBuilder preferredAirline(final String code) {

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

}
