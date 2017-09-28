/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

import java.io.Serializable;
import java.util.Date;

/**
 * @author STA Development Team
 *
 */
public class Segment implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3865662985428955579L;
    
    private static final int PRIME_NUMBER = 31;
    
    private Date leaveDate;
    private Date arriveDate;
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
    public Segment(final Date leaveDate, final Date arriveDate,final String origin, final String destination, final String cabin, final String cabinCode, final String flightNumber, final String markAirline, final String opAirline,
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
    public Date getLeaveDate() {
        return leaveDate;
    }
    /**
     * @param leaveDate the leaveDate to set
     */
    public void setLeaveDate(final Date leaveDate) {
        this.leaveDate = leaveDate;
    }
    /**
     * @return the arriveDate
     */
    public Date getArriveDate() {
        return arriveDate;
    }
    /**
     * @param arriveDate the arriveDate to set
     */
    public void setArriveDate(final Date arriveDate) {
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
    
    
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = PRIME_NUMBER;
        int result = 1;
        result = prime * result + ((aircraft == null) ? 0 : aircraft.hashCode());
        result = prime * result + ((arriveDate == null) ? 0 : arriveDate.hashCode());
        result = prime * result + ((cabin == null) ? 0 : cabin.hashCode());
        result = prime * result + ((cabinCode == null) ? 0 : cabinCode.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
        result = prime * result + ((leaveDate == null) ? 0 : leaveDate.hashCode());
        result = prime * result + ((markAirline == null) ? 0 : markAirline.hashCode());
        result = prime * result + ((opAirline == null) ? 0 : opAirline.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        return result;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Segment other = (Segment) obj;
        if (aircraft == null) {
            if (other.aircraft != null)
                return false;
        } else if (!aircraft.equals(other.aircraft))
            return false;
        if (arriveDate == null) {
            if (other.arriveDate != null)
                return false;
        } else if (!arriveDate.equals(other.arriveDate))
            return false;
        if (cabin == null) {
            if (other.cabin != null)
                return false;
        } else if (!cabin.equals(other.cabin))
            return false;
        if (cabinCode == null) {
            if (other.cabinCode != null)
                return false;
        } else if (!cabinCode.equals(other.cabinCode))
            return false;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        if (flightNumber == null) {
            if (other.flightNumber != null)
                return false;
        } else if (!flightNumber.equals(other.flightNumber))
            return false;
        if (leaveDate == null) {
            if (other.leaveDate != null)
                return false;
        } else if (!leaveDate.equals(other.leaveDate))
            return false;
        if (markAirline == null) {
            if (other.markAirline != null)
                return false;
        } else if (!markAirline.equals(other.markAirline))
            return false;
        if (opAirline == null) {
            if (other.opAirline != null)
                return false;
        } else if (!opAirline.equals(other.opAirline))
            return false;
        if (origin == null) {
            if (other.origin != null)
                return false;
        } else if (!origin.equals(other.origin))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Segment [leaveDate=" + leaveDate + ", arriveDate=" + arriveDate + ", origin=" + origin + ", destination=" + destination + ", cabin="
                + cabin + ", cabinCode=" + cabinCode + ", flightNumber=" + flightNumber + ", markAirline=" + markAirline + ", opAirline=" + opAirline
                + ", aircraft=" + aircraft + "]";
    }    
    
    
    
}
