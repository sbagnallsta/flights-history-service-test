package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Accommodation {

    private String name;
    private String city;
    private String address;
    private String rooms;
    private String roomsType;
    private String checkInHour;
    private String checkInMinute;
    private String checkOutHour;
    private String checkOutMinute;
    private String nights;
    private String specialremark;

    /**
     * Builds a AccommodationBuilder object.
     * 
     * @param accommodationBuilder
     *            accommodation builder
     */
    private Accommodation(final AccommodationBuilder accommodationBuilder) {

        this.name = accommodationBuilder.name;
        this.city = accommodationBuilder.city;
        this.address = accommodationBuilder.address;
        this.rooms = accommodationBuilder.rooms;
        this.roomsType = accommodationBuilder.roomsType;
        this.checkInHour = accommodationBuilder.checkInHour;
        this.checkInMinute = accommodationBuilder.checkInMinute;
        this.checkOutHour = accommodationBuilder.checkOutHour;
        this.checkOutMinute = accommodationBuilder.checkOutMinute;
        this.nights = accommodationBuilder.nights;
        this.specialremark = accommodationBuilder.specialremark;

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the rooms
     */
    public String getRooms() {
        return rooms;
    }

    /**
     * @return the roomsType
     */
    public String getRoomsType() {
        return roomsType;
    }

    /**
     * @return the checkInHour
     */
    public String getCheckInHour() {
        return checkInHour;
    }

    /**
     * @return the checkInMinute
     */
    public String getCheckInMinute() {
        return checkInMinute;
    }

    /**
     * @return the checkOutHour
     */
    public String getCheckOutHour() {
        return checkOutHour;
    }

    /**
     * @return the checkOutMinute
     */
    public String getCheckOutMinute() {
        return checkOutMinute;
    }

    /**
     * @return the nights
     */
    public String getNights() {
        return nights;
    }

    /**
     * @return the special remark
     */
    public String getSpecialremark() {
        return specialremark;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Accommodation [name=" + name + ", city=" + city + ", address=" + address + ", rooms=" + rooms + ", roomsType=" + roomsType
                + ", checkInHour=" + checkInHour + ", checkInMinute=" + checkInMinute + ", checkOutHour=" + checkOutHour + ", checkOutMinute="
                + checkOutMinute + ", nights=" + nights + ", specialremark=" + specialremark + "]";
    }

    /**
     * 
     * @author STA Internal Team
     *
     */
    public static class AccommodationBuilder {

        private String name;
        private String city;
        private String address;
        private String rooms;
        private String roomsType;
        private String checkInHour;
        private String checkInMinute;
        private String checkOutHour;
        private String checkOutMinute;
        private String nights;
        private String specialremark;

        /**
         * 
         * @param name
         *            accommodation name
         * 
         * @return Accommodation Builder
         */
        public AccommodationBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        /**
         * 
         * @param city
         *            accommodation city
         * 
         * @return Accommodation Builder
         */
        public AccommodationBuilder setCity(final String city) {
            this.city = city;
            return this;
        }

        /**
         * 
         * @param address
         *            accommodation address
         * 
         * @return Accommodation Builder
         */
        public AccommodationBuilder setAddress(final String address) {
            this.address = address;
            return this;
        }

        /**
         * 
         * @param rooms
         *            accommodation rooms
         * 
         * @return Accommodation Builder
         */
        public AccommodationBuilder setRooms(final String rooms) {
            this.rooms = rooms;
            return this;
        }

        /**
         * @param roomsType
         *            accommodation rooms type
         * 
         * @return Accommodation Builder
         */
        public AccommodationBuilder setRoomsType(final String roomsType) {
            this.roomsType = roomsType;
            return this;
        }

        /**
         * @param checkInHour
         *            accommodation checkInHour
         * 
         * @return Accmmodation Builder
         */
        public AccommodationBuilder setCheckInHour(final String checkInHour) {
            this.checkInHour = checkInHour;
            return this;
        }

        /**
         * @param checkInMinute
         *            accommodation checkInHour
         * @return Accommodation Builder
         */
        public AccommodationBuilder setCheckInMinute(final String checkInMinute) {
            this.checkInMinute = checkInMinute;
            return this;
        }

        /**
         * @param checkOutHour
         *            accommodation checkOutHour
         * @return Accommodation Builder
         */
        public AccommodationBuilder setCheckOutHour(final String checkOutHour) {
            this.checkOutHour = checkOutHour;
            return this;
        }

        /**
         * @param checkOutMinute
         *            accommodation checkOutMinute
         * @return Accommodation Builder
         */
        public AccommodationBuilder setCheckOutMinute(final String checkOutMinute) {
            this.checkOutMinute = checkOutMinute;
            return this;
        }

        /**
         * @param nights
         *            accommodation nights
         * @return Accommodation Builder
         */
        public AccommodationBuilder setNights(final String nights) {
            this.nights = nights;
            return this;
        }

        /**
         * @param specialRemark
         *            accommodation specialRemark
         * @return Accommodation Builder
         */
        public AccommodationBuilder setSpecialRemark(final String specialRemark) {
            this.specialremark = specialRemark;
            return this;
        }

        /**
         * Builds a Accommodation object.
         * 
         * @return Accommodation object
         */
        public Accommodation build() {
            return new Accommodation(this);
        }

    }

}
