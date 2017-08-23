package com.statravel.autoqa.domain.b2b.paymentform;

import java.util.Date;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Transfer {

    private String name;
    private String route;
    private Date departureDate;
    private String departureHour;
    private String departureMinute;
    private String specialRemarks;

    /**
     * Builds a Transfer object.
     * 
     * @param transferBuilder
     *            transfer builder
     */
    private Transfer(final TransferBuilder transferBuilder) {
        this.name = transferBuilder.name;
        this.route = transferBuilder.route;
        this.departureDate = transferBuilder.departureDate;
        this.departureHour = transferBuilder.departureHour;
        this.departureMinute = transferBuilder.departureMinute;
        this.specialRemarks = transferBuilder.specialRemarks;

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the route
     */
    public String getRoute() {
        return route;
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
     * @return the specialRemarks
     */
    public String getSpecialRemarks() {
        return specialRemarks;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Transfer [name=" + name + ", route=" + route + ", departureDate=" + departureDate + ", departureHour=" + departureHour
                + ", departureMinute=" + departureMinute + ", specialRemarks=" + specialRemarks + "]";
    }

    /**
     * 
     * @author STA Internal Team
     *
     */
    public static class TransferBuilder {

        private String name;
        private String route;
        private Date departureDate;
        private String departureHour;
        private String departureMinute;
        private String specialRemarks;

        /**
         * 
         * @param name
         *            transfer name
         * 
         * @return Transfer Builder
         */
        public TransferBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * 
         * @param route
         *            transfer route
         * 
         * @return Transfer Builder
         */
        public TransferBuilder setRoute(final String route) {
            this.route = route;
            return this;
        }

        /**
         * 
         * @param departureDate
         *            transfer departure date
         * 
         * @return Transfer Builder
         */
        public TransferBuilder setDepartureDate(final Date departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        /**
         * 
         * @param departureHour
         *            transfer departure hour
         * 
         * @return Transfer Builder
         */
        public TransferBuilder setDepartureHour(final String departureHour) {
            this.departureHour = departureHour;
            return this;
        }

        /**
         * 
         * @param departureMinute
         *            transfer departure minute
         * 
         * @return Transfer Builder
         */
        public TransferBuilder setDepartureMinute(final String departureMinute) {
            this.departureMinute = departureMinute;
            return this;
        }

        /**
         * 
         * @param specialRemarks
         *            transfer special remarks
         * 
         * @return Transfer Builder
         */
        public TransferBuilder setSpecialRemarks(final String specialRemarks) {
            this.specialRemarks = specialRemarks;
            return this;
        }

        /**
         * Builds a Transfer object.
         * 
         * @return Transfer object
         */
        public Transfer build() {
            return new Transfer(this);
        }

    }

}
