package com.statravel.autoqa.domain;

/**
 * 
 * @author STA Development Team
 *
 */
public final class FlightSearch {

    private String departureDate;
    private String returnDate;
    private String arrivalDestination;
    private String departureDestination;
    private String adults;
    private String departureCode;
    private String arrivalCode;
    private String flightType;

    /**
     * @return the departureDate
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * @return the arrivalDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * 
     * @param departureDate
     */
    public void setDepartureDate(final String departureDate) {
		this.departureDate = departureDate;
	}

	/**
     * @return the arrivalDestination
     */
    public String getArrivalDestination() {
        return arrivalDestination;
    }

    /**
     * @return the departureDestination
     */
    public String getDepartureDestination() {
        return departureDestination;
    }

    /**
     * @return the adults
     */
    public String getDepartureCode() {
        return departureCode;
    }

    /**
     * @return the adults
     */
    public String getArrivalCode() {
        return arrivalCode;
    }

    /**
     * @return the adults
     */
    public String getAdults() {
        return adults;
    }

    /**
     * 
     * @return the flight type
     */
    public String getFlightType() {
        return flightType;
    }

    /**
     * 
     * @param builder
     *            flight search builder
     */
    private FlightSearch(final FlightSearchBuilder builder) {
        this.departureDate = builder.departureDate;
        this.returnDate = builder.returnDate;
        this.arrivalDestination = builder.arrivalDestination;
        this.departureDestination = builder.departureDestination;
        this.adults = builder.adults;
        this.departureCode = builder.departureCode;
        this.arrivalCode = builder.arrivalCode;
        this.flightType = builder.flightType;

    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class FlightSearchBuilder {
        private String departureDate;
        private String returnDate;
        private String arrivalDestination;
        private String departureDestination;
        private String adults;
        private String arrivalCode;
        private String departureCode;
        private String flightType;

        /**
         * 
         * @param date
         *            departure date as string
         * 
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setDepartureDate(final String date) {
            this.departureDate = date;
            return this;
        }

        /**
         * 
         * @param date
         *            return accommodation name
         * 
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setReturnDate(final String date) {
            this.returnDate = date;
            return this;
        }

        /**
         * 
         * @param destination
         *            arrival destination
         * 
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setArrivalDestination(final String destination) {
            this.arrivalDestination = destination;
            return this;
        }

        /**
         * 
         * @param destination
         *            departure destination
         * 
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setDepartureDestination(final String destination) {
            this.departureDestination = destination;
            return this;
        }

        /**
         * 
         * @param adults
         *            number of adults travelling
         * 
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setAdults(final String adults) {
            this.adults = adults;
            return this;
        }

        /**
         * 
         * @param departureCode
         *            departureCode of departure airport
         * 
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setDepartureCode(final String departureCode) {
            this.departureCode = departureCode;
            return this;
        }

        /**
         * 
         * @param arrivalCode
         *            arrivalCode of arrival airport
         * 
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setArrivalCode(final String arrivalCode) {
            this.arrivalCode = arrivalCode;
            return this;
        }

        /**
         * 
         * @param type
         *            the flight type - either return or one-way
         * @return FlightSearchBuilder Builder
         */
        public FlightSearchBuilder setFlightType(final String type) {
            this.flightType = type;
            return this;
        }

        /**
         * Builds a Accommodation object.
         * 
         * @return FlightSearchBuilder object
         */
        public FlightSearch build() {
            return new FlightSearch(this);
        }
    }
}
