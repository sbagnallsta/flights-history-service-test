package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class PassengerInformation {

    private String middleName;
    private String passportNumber;
    private String dateOfBirth;
    private String phoneNumber;

    /**
     * 
     * @param passengerInformationBuilder
     *            passenger information builder
     */
    private PassengerInformation(final PassengerInformationBuilder passengerInformationBuilder) {
        this.middleName = passengerInformationBuilder.middleName;
        this.passportNumber = passengerInformationBuilder.passportNumber;
        this.dateOfBirth = passengerInformationBuilder.dateOfBirth;
        this.phoneNumber = passengerInformationBuilder.phoneNumber;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @return the passportNumber
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * @return the dateOfBirth
     */
    public String getdateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PassengerInformation [middleName=" + middleName + ", passportNumber=" + passportNumber + ", dateOfBirth=" + dateOfBirth
                + ", phoneNumber=" + phoneNumber + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class PassengerInformationBuilder {
        private String middleName;
        private String passportNumber;
        private String dateOfBirth;
        private String phoneNumber;

        /**
         * 
         * @param middleName
         * @return passenger information builder
         */
        public PassengerInformationBuilder setMiddleName(final String middleName) {
            this.middleName = middleName;
            return this;
        }

        /**
         * 
         * @param passportNumber
         * @return passenger information builder
         */
        public PassengerInformationBuilder setPassportNumber(final String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        /**
         * 
         * @param dateOfBirth
         * @return passenger information builder
         */
        public PassengerInformationBuilder setdateOfBirth(final String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        /**
         * 
         * @param phoneNumber
         * @return passenger information builder
         */
        public PassengerInformationBuilder setPhoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Builds passenger information object.
         * 
         * @return passenger information object
         */
        public PassengerInformation build() {
            return new PassengerInformation(this);
        }
    }

}
