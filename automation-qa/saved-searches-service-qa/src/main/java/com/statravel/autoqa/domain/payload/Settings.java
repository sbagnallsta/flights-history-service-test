package com.statravel.autoqa.domain.payload;

import java.io.Serializable;

/**
 * 
 * @author STA Development Team
 *
 */
public class Settings implements Serializable {

    private static final long serialVersionUID = 1481321181410694753L;

    private static final int PRIME_NUMBER = 31;

    private String pos;

    private Byte maxNumberSearches;

    private boolean flightActive;

    /**
     * 
     */
    public Settings() {

    }

    /**
     * @param maxNumberSearches
     *            max number of searches
     * @param flightActive
     *            flight active flag
     */
    public Settings(final Byte maxNumberSearches, final boolean flightActive) {
        this.maxNumberSearches = maxNumberSearches;
        this.flightActive = flightActive;

    }

    /**
     * @param pos
     *            point of sales code
     * @param maxNumberSearches
     *            max number of searches
     * @param flightActive
     *            flight active flag
     */
    public Settings(final String pos, final Byte maxNumberSearches, final boolean flightActive) {
        this.pos = pos;
        this.maxNumberSearches = maxNumberSearches;
        this.flightActive = flightActive;
    }

    /**
     * @return the pos
     */
    public String getPos() {
        return pos;
    }

    /**
     * @param pos
     *            the pos to set
     */
    public void setPos(final String pos) {
        this.pos = pos;
    }

    /**
     * @return the maxNumberSearches
     */
    public Byte getMaxNumberSearches() {
        return maxNumberSearches;
    }

    /**
     * @param maxNumberSearches
     *            the maxNumberSearches to set
     */
    public void setMaxNumberSearches(final Byte maxNumberSearches) {
        this.maxNumberSearches = maxNumberSearches;
    }

    /**
     * @return the flightActive
     */
    public boolean isFlightActive() {
        return flightActive;
    }

    /**
     * @param flightActive
     *            the flightActive to set
     */
    public void setFlightActive(final boolean flightActive) {
        this.flightActive = flightActive;
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

        result = prime * result + ((maxNumberSearches == null) ? 0 : maxNumberSearches.hashCode());
        result = prime * result + ((pos == null) ? 0 : pos.hashCode());

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

        if (getClass() != obj.getClass()) {
            return false;
        }

        Settings other = (Settings) obj;

        if (maxNumberSearches == null) {
            if (other.maxNumberSearches != null) {
                return false;
            }
        } else if (!maxNumberSearches.equals(other.maxNumberSearches)) {
            return false;
        }

        if (pos == null) {
            if (other.pos != null) {
                return false;
            }
        } else if (!pos.equals(other.pos)) {
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
        return "SavedSearchesSettings [pos=" + pos + ", maxNumberSearches=" + maxNumberSearches + ", flightActive=" + flightActive + "]";
    }

}
