/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

/**
 * @author STA Development Team
 *
 */
public class Origin {
    
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
    
}
