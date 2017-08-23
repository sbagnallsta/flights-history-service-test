/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

/**
 * @author STA Development Team
 *
 */
public class Destination {
    
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
    
}
