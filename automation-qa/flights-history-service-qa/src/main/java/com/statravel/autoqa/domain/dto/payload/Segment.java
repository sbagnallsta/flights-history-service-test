/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

/**
 * @author STA Development Team
 *
 */
public class Segment {

    private String leaveDate;
    private String arriveDate;
    private String origin;
    private String destination;
    private String cabin;
    private String cabinCode;
    private String flightNumber;
    private String markAirline;
    private String opAirline;
    private String aircraft;
    
    /**
     * 
     * @param leaveDate the leavedate
     * @param arriveDate the arrivedate
     * @param origin origin
     * @param destination destination
     * @param cabin cabin
     * @param cabinCode cabinCode
     * @param flightNumber flightNumber
     * @param markAirline markAirline
     * @param opAirline opAirline
     * @param aircraft aircraft
     */
    public Segment(final String leaveDate, final String arriveDate,final String origin, final String destination, final String cabin, final String cabinCode, final String flightNumber, final String markAirline, final String opAirline,
            final String aircraft) {
        super();
        this.leaveDate = leaveDate;
        this.arriveDate = arriveDate;
        this.origin = origin;
        this.destination = destination;
        this.cabin = cabin;
        this.cabinCode = cabinCode;
        this.flightNumber = flightNumber;
        this.markAirline = markAirline;
        this.opAirline = opAirline;
        this.aircraft = aircraft;
    }
    /**
     * @return the leaveDate
     */
    public String getLeaveDate() {
        return leaveDate;
    }
    /**
     * @param leaveDate the leaveDate to set
     */
    public void setLeaveDate(final String leaveDate) {
        this.leaveDate = leaveDate;
    }
    /**
     * @return the arriveDate
     */
    public String getArriveDate() {
        return arriveDate;
    }
    /**
     * @param arriveDate the arriveDate to set
     */
    public void setArriveDate(final String arriveDate) {
        this.arriveDate = arriveDate;
    }
    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }
    /**
     * @param origin the origin to set
     */
    public void setOrigin(final String origin) {
        this.origin = origin;
    }
    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }
    /**
     * @param destination the destination to set
     */
    public void setDestination(final String destination) {
        this.destination = destination;
    }
    /**
     * @return the flightNumber
     */
    public String getFlightNumber() {
        return flightNumber;
    }
    /**
     * @param flightNumber the flightNumber to set
     */
    public void setFlightNumber(final String flightNumber) {
        this.flightNumber = flightNumber;
    }
    /**
     * @return the cabin
     */
    public String getCabin() {
        return cabin;
    }
    /**
     * @param cabin the cabin to set
     */
    public void setCabin(final String cabin) {
        this.cabin = cabin;
    }
    /**
     * @return the cabinCode
     */
    public String getCabinCode() {
        return cabinCode;
    }
    /**
     * @param cabinCode the cabinCode to set
     */
    public void setCabinCode(final String cabinCode) {
        this.cabinCode = cabinCode;
    }

    /**
     * @return the markAirline
     */
    public String getMarkAirline() {
        return markAirline;
    }
    /**
     * @param markAirline the markAirline to set
     */
    public void setMarkAirline(final String markAirline) {
        this.markAirline = markAirline;
    }
    /**
     * @return the opAirline
     */
    public String getOpAirline() {
        return opAirline;
    }
    /**
     * @param opAirline the opAirline to set
     */
    public void setOpAirline(final String opAirline) {
        this.opAirline = opAirline;
    }
    /**
     * @return the aircraft
     */
    public String getAircraft() {
        return aircraft;
    }
    /**
     * @param aircraft the aircraft to set
     */
    public void setAircraft(final String aircraft) {
        this.aircraft = aircraft;
    }    
    
    
    
}
