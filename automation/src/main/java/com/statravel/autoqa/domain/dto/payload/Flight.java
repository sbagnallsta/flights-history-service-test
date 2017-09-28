/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author STA Development Team
 *
 */
@Document(collection = "history")
public class Flight implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4260782583736909109L;
        
    private String pos;
    private boolean manual;
    
    private String key;
    private boolean campaignFare;
    private String campaignCode;
    private Date saleStart;
    private Date saleEnd;
    private Date searchDateTime;
    private String season;
    private String advPurchPeriod;
    private boolean opaque;
    private Date bookByDates;
    private String ticketType;
    private String stay;
    private String flightType;
    private String flightTicketType;
    private String duration;
    private Date departureDate;
    private Date returnDate;
    private String eligibility;
    private List<String> stopovers = new ArrayList<>();
    private boolean direct; 
    private boolean restrictions;
    private boolean exclusive;
    private boolean layby;
    private boolean multiflex;
    private String topOffer;
    private String urlDeep;
    
    private Destination dest;
    private Origin origin;
    private Fare fare;
    private List<Segment> flights = new ArrayList<>();
    
    /**
     * 
     */
    public Flight() {
        super();
    }
        
    /**
     * 
     * @param pos .
     * @param manual .
     * @param stopovers .
     * @param dest .
     * @param origin .
     * @param fare .
     * @param flights .
     */
    public Flight(final String pos, final boolean manual, final List<String> stopovers, final Destination dest, final Origin origin, final Fare fare, final List<Segment> flights) {
        super();
        this.pos = pos;
        this.manual = manual;
        this.stopovers = stopovers;
        this.dest = dest;
        this.origin = origin;
        this.fare = fare;
        this.flights = flights;
    }

    /**
     * @return the pos
     */
    public String getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(final String pos) {
        this.pos = pos;
    }

    /**
     * @return the manual
     */
    public boolean isManual() {
        return manual;
    }

    /**
     * @param manual the manual to set
     */
    public void setManual(final boolean manual) {
        this.manual = manual;
    }
    
    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
     * @return the campaignFare
     */
    public boolean isCampaignFare() {
        return campaignFare;
    }

    /**
     * @param campaignFare the campaignFare to set
     */
    public void setCampaignFare(final boolean campaignFare) {
        this.campaignFare = campaignFare;
    }

    /**
     * @return the campaignCode
     */
    public String getCampaignCode() {
        return campaignCode;
    }

    /**
     * @param campaignCode the campaignCode to set
     */
    public void setCampaignCode(final String campaignCode) {
        this.campaignCode = campaignCode;
    }

    /**
     * @return the saleStart
     */
    public Date getSaleStart() {
        return saleStart;
    }

    /**
     * @param saleStart the saleStart to set
     */
    public void setSaleStart(final Date saleStart) {
        this.saleStart = saleStart;
    }

    /**
     * @return the saleEnd
     */
    public Date getSaleEnd() {
        return saleEnd;
    }

    /**
     * @param saleEnd the saleEnd to set
     */
    public void setSaleEnd(final Date saleEnd) {
        this.saleEnd = saleEnd;
    }

    /**
     * @return the searchDateTime
     */
    public Date getSearchDateTime() {
        return searchDateTime;
    }

    /**
     * @param searchDateTime the searchDateTime to set
     */
    public void setSearchDateTime(final Date searchDateTime) {
        this.searchDateTime = searchDateTime;
    }

    /**
     * @return the season
     */
    public String getSeason() {
        return season;
    }

    /**
     * @param season the season to set
     */
    public void setSeason(final String season) {
        this.season = season;
    }

    /**
     * @return the advPurchPeriod
     */
    public String getAdvPurchPeriod() {
        return advPurchPeriod;
    }

    /**
     * @param advPurchPeriod the advPurchPeriod to set
     */
    public void setAdvPurchPeriod(final String advPurchPeriod) {
        this.advPurchPeriod = advPurchPeriod;
    }

    /**
     * @return the opaque
     */
    public boolean getOpaque() {
        return opaque;
    }

    /**
     * @param opaque the opaque to set
     */
    public void setOpaque(final boolean opaque) {
        this.opaque = opaque;
    }

    /**
     * @return the bookByDates
     */
    public Date getBookByDates() {
        return bookByDates;
    }

    /**
     * @param bookByDates the bookByDates to set
     */
    public void setBookByDates(final Date bookByDates) {
        this.bookByDates = bookByDates;
    }

    /**
     * @return the ticketType
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * @param ticketType the ticketType to set
     */
    public void setTicketType(final String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * @return the stay
     */
    public String getStay() {
        return stay;
    }

    /**
     * @param stay the stay to set
     */
    public void setStay(final String stay) {
        this.stay = stay;
    }

    /**
     * @return the flightType
     */
    public String getFlightType() {
        return flightType;
    }

    /**
     * @param flightType the flightType to set
     */
    public void setFlightType(final String flightType) {
        this.flightType = flightType;
    }

    /**
     * @return the flightTicketType
     */
    public String getFlightTicketType() {
        return flightTicketType;
    }

    /**
     * @param flightTicketType the flightTicketType to set
     */
    public void setFlightTicketType(final String flightTicketType) {
        this.flightTicketType = flightTicketType;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }

    /**
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(final Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(final Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the eligibility
     */
    public String getEligibility() {
        return eligibility;
    }

    /**
     * @param eligibility the eligibility to set
     */
    public void setEligibility(final String eligibility) {
        this.eligibility = eligibility;
    }

    /**
     * @return the stopovers
     */
    public List<String> getStopovers() {
        return stopovers;
    }

    /**
     * @param stopovers the stopovers to set
     */
    public void setStopovers(final List<String> stopovers) {
        this.stopovers = stopovers;
    }

    /**
     * @return the direct
     */
    public boolean isDirect() {
        return direct;
    }

    /**
     * @param direct the direct to set
     */
    public void setDirect(final boolean direct) {
        this.direct = direct;
    }

    /**
     * @return the restrictions
     */
    public boolean isRestrictions() {
        return restrictions;
    }

    /**
     * @param restrictions the restrictions to set
     */
    public void setRestrictions(final boolean restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * @return the exclusive
     */
    public boolean isExclusive() {
        return exclusive;
    }

    /**
     * @param exclusive the exclusive to set
     */
    public void setExclusive(final boolean exclusive) {
        this.exclusive = exclusive;
    }

    /**
     * @return the layby
     */
    public boolean isLayby() {
        return layby;
    }

    /**
     * @param layby the layby to set
     */
    public void setLayby(final boolean layby) {
        this.layby = layby;
    }

    /**
     * @return the multiflex
     */
    public boolean isMultiflex() {
        return multiflex;
    }

    /**
     * @param multiflex the multiflex to set
     */
    public void setMultiflex(final boolean multiflex) {
        this.multiflex = multiflex;
    }

    /**
     * @return the topOffer
     */
    public String getTopOffer() {
        return topOffer;
    }

    /**
     * @param topOffer the topOffer to set
     */
    public void setTopOffer(final String topOffer) {
        this.topOffer = topOffer;
    }

    /**
     * @return the urlDeep
     */
    public String getUrlDeep() {
        return urlDeep;
    }

    /**
     * @param urlDeep the urlDeep to set
     */
    public void setUrlDeep(final String urlDeep) {
        this.urlDeep = urlDeep;
    }

    /**
     * @return the dest
     */
    public Destination getDest() {
        return dest;
    }

    /**
     * @param dest the dest to set
     */
    public void setDest(final Destination dest) {
        this.dest = dest;
    }

    /**
     * @return the origin
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(final Origin origin) {
        this.origin = origin;
    }

    /**
     * @return the fare
     */
    public Fare getFare() {
        return fare;
    }

    /**
     * @param fare the fare to set
     */
    public void setFare(final Fare fare) {
        this.fare = fare;
    }

    /**
     * @return the flights
     */
    public List<Segment> getFlights() {
        return flights;
    }

    /**
     * @param flights the flights to set
     */
    public void setFlights(final List<Segment> flights) {
        this.flights = flights;
    }
     
}
