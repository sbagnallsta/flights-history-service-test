package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Seat {

    private String aisle;
    private String window;

    /**
     * 
     * @param seatBuilder
     *            seat builder
     */
    private Seat(final SeatBuilder seatBuilder) {
        this.aisle = seatBuilder.aisle;
        this.window = seatBuilder.window;
    }

    /**
     * @return the aisle
     */
    public String getAisle() {
        return aisle;
    }

    /**
     * @return the window
     */
    public String getWindow() {
        return window;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Seat [aisle=" + aisle + ", window=" + window + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class SeatBuilder {

        private String aisle;
        private String window;

        /**
         * 
         * @param aisle
         * @return seat builder
         */
        public SeatBuilder seaSeat(final String aisle) {
            this.aisle = aisle;
            return this;
        }

        /**
         * 
         * @param window
         * @return seat builder
         */
        public SeatBuilder setWindow(final String window) {
            this.window = window;
            return this;
        }

        /**
         * Built a Seat object.
         * 
         * @return seat object
         */
        public Seat build() {
            return new Seat(this);
        }

    }

}
