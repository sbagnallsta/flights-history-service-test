package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Address {

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    /**
     * 
     * @param addressBuilder
     *            address builder
     */
    private Address(final AddressBuilder addressBuilder) {
        this.addressLineOne = addressBuilder.addressLineOne;
        this.addressLineTwo = addressBuilder.addressLineTwo;
        this.city = addressBuilder.city;
        this.state = addressBuilder.state;
        this.zipCode = addressBuilder.zipCode;
        this.country = addressBuilder.country;
    }

    /**
     * @return the addressLineOne
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    /**
     * @return the addressLineTwo
     */
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Address [addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city + ", state=" + state
                + ", zipCode=" + zipCode + ", country=" + country + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class AddressBuilder {

        private String addressLineOne;
        private String addressLineTwo;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        /**
         * 
         * @param addressLineOne
         * @return address builder
         */
        public AddressBuilder setAddressLineOne(final String addressLineOne) {
            this.addressLineOne = addressLineOne;
            return this;
        }

        /**
         * 
         * @param addressLineTwo
         * @return address builder
         */
        public AddressBuilder setAddressLineTwo(final String addressLineTwo) {
            this.addressLineTwo = addressLineTwo;
            return this;
        }

        public AddressBuilder setCity(final String city) {
            this.city = city;
            return this;
        }

        /**
         * 
         * @param state
         * @return address builder
         */
        public AddressBuilder setState(final String state) {
            this.state = state;
            return this;
        }

        /**
         * 
         * @param zipCode
         * @return address builder
         */
        public AddressBuilder setZipCode(final String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        /**
         * 
         * @param country
         * @return address builder
         */
        public AddressBuilder setCountry(final String country) {
            this.country = country;
            return this;
        }

        /**
         * Build Address object.
         * 
         * @return Address object
         */
        public Address build() {
            return new Address(this);
        }
    }

}
