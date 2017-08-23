package com.statravel.autoqa.domain.payload.flight;

import java.io.Serializable;

/**
 * 
 * @author STA Development team
 *
 */
public class PreferredAirline implements Serializable {

    private static final long serialVersionUID = 977474943555090206L;

    private static final int PRIME_NUMBER = 31;

    private String code;

    /**
     * 
     */
    public PreferredAirline() {

    }

    /**
     * 
     * @param code
     *            airline code
     */
    public PreferredAirline(final String code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(final String code) {
        this.code = code;
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

        result = prime * result + ((code == null) ? 0 : code.hashCode());
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

        if (!(obj instanceof PreferredAirline)) {
            return false;
        }

        PreferredAirline other = (PreferredAirline) obj;

        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
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
        return "FlightSearchPreferredAirline [code=" + code + "]";
    }

}
