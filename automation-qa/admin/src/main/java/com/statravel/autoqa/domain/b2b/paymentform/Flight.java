package com.statravel.autoqa.domain.b2b.paymentform;

import java.util.Date;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Flight {

    private String airline;
    private String operator;
    private String number;
    private Date departureDate;
    private String departureHour;
    private String departureMinute;
    private String departureCity;
    private String departureAirportCode;
    private String departureAirport;
    private Date arrivalDate;
    private String arrivalHour;
    private String arrivalMinute;
    private String arrivalCity;
    private String arrivalAirportCode;
    private String arrivalAirport;

    /**
     * Builds a Flight object.
     * 
     * @param flightBuilder
     *            transfer builder
     */
    private Flight(final FlightBuilder flightBuilder) {
        this.airline = flightBuilder.airline;
        this.operator = flightBuilder.operator;
        this.number = flightBuilder.number;
        this.departureDate = flightBuilder.departureDate;
        this.departureHour = flightBuilder.departureHour;
        this.departureMinute = flightBuilder.departureMinute;
        this.departureCity = flightBuilder.departureCity;
        this.departureAirportCode = flightBuilder.departureAirportCode;
        this.departureAirport = flightBuilder.departureAirport;
        this.arrivalDate = flightBuilder.arrivalDate;
        this.arrivalHour = flightBuilder.arrivalHour;
        this.arrivalMinute = flightBuilder.arrivalMinute;
        this.arrivalCity = flightBuilder.arrivalCity;
        this.arrivalAirportCode = flightBuilder.arrivalAirportCode;
        this.arrivalAirport = flightBuilder.arrivalAirport;

    }

    /**
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @return the departureHour
     */
    public String getDepartureHour() {
        return departureHour;
    }

    /**
     * @return the departureMinute
     */
    public String getDepartureMinute() {
        return departureMinute;
    }

    /**
     * @return the departureCity
     */
    public String getDepartureCity() {
        return departureCity;
    }

    /**
     * @return the departureAirportCode
     */
    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    /**
     * @return the departureAirport
     */
    public String getDepartureAirport() {
        return departureAirport;
    }

    /**
     * @return the arrivalDate
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @return the arrivalHour
     */
    public String getArrivalHour() {
        return arrivalHour;
    }

    /**
     * @return the arrivalMinute
     */
    public String getArrivalMinute() {
        return arrivalMinute;
    }

    /**
     * @return the arrivalCity
     */
    public String getArrivalCity() {
        return arrivalCity;
    }

    /**
     * @return the arrivalAirportCode
     */
    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    /**
     * @return the arrivalAirport
     */
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Flight [airline=" + airline + ", operator=" + operator + ", number=" + number + ", departureDate=" + departureDate
                + ", departureHour=" + departureHour + ", departureMinute=" + departureMinute + ", departureCity=" + departureCity
                + ", departureAirportCode=" + departureAirportCode + ", departureAirport=" + departureAirport + ", arrivalDate=" + arrivalDate
                + ", arrivalHour=" + arrivalHour + ", arrivalMinute=" + arrivalMinute + ", arrivalCity=" + arrivalCity + ", arrivalAirportCode="
                + arrivalAirportCode + ", arrivalAirport=" + arrivalAirport + "]";
    }

    /**
     * 
     * @author STA Internal Team
     *
     */
    public static class FlightBuilder {

        private String airline;
        private String operator;
        private String number;
        private Date departureDate;
        private String departureHour;
        private String departureMinute;
        private String departureCity;
        private String departureAirportCode;
        private String departureAirport;
        private Date arrivalDate;
        private String arrivalHour;
        private String arrivalMinute;
        private String arrivalCity;
        private String arrivalAirportCode;
        private String arrivalAirport;

        /**
         * 
         * @param airline
         *            airline name
         * 
         * @return Flight Builder
         */
        public FlightBuilder setAirline(final String airline) {
            this.airline = airline;
            return this;
        }

        /**
         * 
         * @param operator
         *            operator name
         * 
         * @return Flight Builder
         */
        public FlightBuilder setOperator(final String operator) {
            this.operator = operator;
            return this;
        }

        /**
         * 
         * @param number
         *            flight number
         * 
         * @return Flight Builder
         */
        public FlightBuilder setNumber(final String number) {
            this.number = number;
            return this;
        }

        /**
         * 
         * @param departureDate
         *            flight departure date
         * 
         * @return Flight Builder
         */
        public FlightBuilder setDepartureDate(final Date departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        /**
         * 
         * @param departureHour
         *            flight departure hour
         * 
         * @return Flight Builder
         */
        public FlightBuilder setDepartureHour(final String departureHour) {
            this.departureHour = departureHour;
            return this;
        }

        /**
         * 
         * @param departureMinute
         *            flight departure minute
         * 
         * @return Flight Builder
         */
        public FlightBuilder setDepartureMinute(final String departureMinute) {
            this.departureMinute = departureMinute;
            return this;
        }

        /**
         * 
         * @param departureCity
         *            departure city
         * 
         * @return Flight Builder
         */
        public FlightBuilder setDepartureCity(final String departureCity) {
            this.departureCity = departureCity;
            return this;
        }

        /**
         * 
         * @param departureAirportCode
         *            departure Airport code
         * 
         * @return Flight Builder
         */
        public FlightBuilder setDepartureAirportCode(final String departureAirportCode) {
            this.departureAirportCode = departureAirportCode;
            return this;
        }

        /**
         * 
         * @param departureAirport
         *            departure Airport
         * 
         * @return Flight Builder
         */
        public FlightBuilder setDepartureAirport(final String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        /**
         * 
         * @param arrivalDate
         *            flight departure date
         * 
         * @return Flight Builder
         */
        public FlightBuilder setArrivalDate(final Date arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }

        /**
         * 
         * @param arrivalHour
         *            flight arrival hour
         * 
         * @return Flight Builder
         */
        public FlightBuilder setArrivalHour(final String arrivalHour) {
            this.arrivalHour = arrivalHour;
            return this;
        }

        /**
         * 
         * @param arrivalMinute
         *            flight arrival minute
         * 
         * @return Flight Builder
         */
        public FlightBuilder setArrivalMinute(final String arrivalMinute) {
            this.arrivalMinute = arrivalMinute;
            return this;
        }

        /**
         * 
         * @param arrivalCity
         *            arrival city
         * 
         * @return Flight Builder
         */
        public FlightBuilder setArrivalCity(final String arrivalCity) {
            this.arrivalCity = arrivalCity;
            return this;
        }

        /**
         * 
         * @param arrivalAirportCode
         *            arrival Airport code
         * 
         * @return Flight Builder
         */
        public FlightBuilder setArrivalAirportCode(final String arrivalAirportCode) {
            this.arrivalAirportCode = arrivalAirportCode;
            return this;
        }

        /**
         * 
         * @param arrivalAirport
         *            arrival Airport
         * 
         * @return Flight Builder
         */
        public FlightBuilder setArrivalAirport(final String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        /**
         * Builds a Transfer object.
         * 
         * @return Transfer object
         */
        public Flight build() {
            return new Flight(this);
        }

    }

}
