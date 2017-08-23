package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Others {

    private String title;

    private String tripDetails;

    /**
     * Builds a Others object.
     * 
     * @param othersBuilder
     *            other builder
     */
    private Others(final OthersBuilder othersBuilder) {

        this.title = othersBuilder.title;

        this.tripDetails = othersBuilder.tripDetails;

    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the tripDetails
     */
    public String getTripDetails() {
        return tripDetails;
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class OthersBuilder {

        private String title;

        private String tripDetails;

        /**
         * 
         * @param title
         *            others title
         * @return Others Builder
         */
        public OthersBuilder setTitle(final String title) {
            this.title = title;
            return this;
        }

        /**
         * 
         * @param tripDetails
         *            tripDetails
         * @return Others Builder
         */
        public OthersBuilder setTripDetails(final String tripDetails) {
            this.tripDetails = tripDetails;
            return this;
        }

        /**
         * Builds a Others object.
         * 
         * @return Others object
         */
        public Others build() {
            return new Others(this);
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Otheres [title=" + title + ", tripDetails=" + tripDetails + "]";
        }

    }
}
