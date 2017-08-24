/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

import java.io.Serializable;

/**
 * @author STA Development Team
 *
 */
public class Origin implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5002033383105877811L;
    
    private static final int PRIME_NUMBER = 31;
    
    private String city;
    private String iata;
    
    /**
     * @param city .
     * @param iata .
     */
    public Origin(final String city, final String iata) {
        super();
        this.city = city;
        this.iata = iata;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return the iata
     */
    public String getIata() {
        return iata;
    }

    /**
     * @param iata the iata to set
     */
    public void setIata(final String iata) {
        this.iata = iata;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((iata == null) ? 0 : iata.hashCode());
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
        Origin other = (Origin) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (iata == null) {
            if (other.iata != null)
                return false;
        } else if (!iata.equals(other.iata))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Origin [city=" + city + ", iata=" + iata + "]";
    }
    
    
    
}
