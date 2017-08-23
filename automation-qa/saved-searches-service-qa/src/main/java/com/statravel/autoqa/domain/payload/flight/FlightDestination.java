package com.statravel.autoqa.domain.payload.flight;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author STA Development Team
 *
 */
public class FlightDestination implements Serializable {

    private static final long serialVersionUID = -427035857180869382L;

    private static final int PRIME_NUMBER = 31;

    private String destinationFrom;

    private String destinationTo;

    private Date departureDate;

    private String departureTime;

    /**
     * 
     */
    public FlightDestination() {

    }

    /**
     * 
     * @param destinationFrom
     *            destination from
     * @param destinationTo
     *            destination to
     * @param departureDate
     *            departure date
     * @param departureTime
     *            departure time
     */
    public FlightDestination(final String destinationFrom, final String destinationTo, final Date departureDate, final String departureTime) {
        this.destinationFrom = destinationFrom;
        this.destinationTo = destinationTo;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }

    /**
     * @return the destinationFrom
     */
    public String getDestinationFrom() {
        return destinationFrom;
    }

    /**
     * @param destinationFrom
     *            the destinationFrom to set
     */
    public void setDestinationFrom(final String destinationFrom) {
        this.destinationFrom = destinationFrom;
    }

    /**
     * @return the destinationTo
     */
    public String getDestinationTo() {
        return destinationTo;
    }

    /**
     * @param destinationTo
     *            the destinationTo to set
     */
    public void setDestinationTo(final String destinationTo) {
        this.destinationTo = destinationTo;
    }

    /**
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate
     *            the departureDate to set
     */
    public void setDepartureDate(final Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime
     *            the departureTime to set
     */
    public void setDepartureTime(final String departureTime) {
        this.departureTime = departureTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = PRIME_NUMBER;
        int result = 1;

        result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
        result = prime * result + ((destinationFrom == null) ? 0 : destinationFrom.hashCode());
        result = prime * result + ((destinationTo == null) ? 0 : destinationTo.hashCode());

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof FlightDestination)) {
            return false;
        }

        FlightDestination other = (FlightDestination) obj;

        if (departureDate == null) {
            if (other.departureDate != null) {
                return false;
            }
        } else if (departureDate.before(other.departureDate) || departureDate.after(other.departureDate)) {
            return false;
        }

        if (destinationFrom == null) {
            if (other.destinationFrom != null) {
                return false;
            }
        } else if (!destinationFrom.equals(other.destinationFrom)) {
            return false;
        }

        if (destinationTo == null) {
            if (other.destinationTo != null) {
                return false;
            }
        } else if (!destinationTo.equals(other.destinationTo)) {
            return false;
        }

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FlightSearchDestination [destinationFrom=" + destinationFrom + ",  destinationTo=" + destinationTo + ", departureDate="
                + departureDate + ", departureTime=" + departureTime + "]";
    }

}
