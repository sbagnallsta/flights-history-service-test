/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

import java.io.Serializable;

/**
 * @author STA Development Team
 *
 */
public class Destination implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3497880801668164651L;

    private static final int PRIME_NUMBER = 31;
    
    private String region;
    private String country;
    private String city;
    private String iata;
    
    /**
     * @param region .
     * @param country .
     * @param city .
     * @param iata .
     */
    public Destination(final String region, final String country, final String city, final String iata) {
        super();
        this.region = region;
        this.country = country;
        this.city = city;
        this.iata = iata;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(final String region) {
        this.region = region;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(final String country) {
        this.country = country;
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
        final int prime = PRIME_NUMBER;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((iata == null) ? 0 : iata.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
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
        Destination other = (Destination) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (iata == null) {
            if (other.iata != null)
                return false;
        } else if (!iata.equals(other.iata))
            return false;
        if (region == null) {
            if (other.region != null)
                return false;
        } else if (!region.equals(other.region))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Destination [region=" + region + ", country=" + country + ", city=" + city + ", iata=" + iata + "]";
    } 
    
    
}
