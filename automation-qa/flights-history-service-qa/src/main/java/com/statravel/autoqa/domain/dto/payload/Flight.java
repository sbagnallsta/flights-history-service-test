/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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
    
    private static final int PRIME_NUMBER = 31;
    
    @Id
    private ObjectId id;
    
    private String pos;
    private Boolean manual;
    
    private String key;
    private Boolean campaignFare;
    private String campaignCode;
    private String saleStart;
    private String saleEnd;
    private String searchDateTime;
    private String season;
    private String advPurchPeriod;
    private Boolean opaque;
    private String bookByDates;
    private String ticketType;
    private String stay;
    private String flightType;
    private String flightTicketType;
    private String duration;
    private String departureDate;
    private String returnDate;
    private String eligibility;
    private List<String> stopovers = new ArrayList<>();
    private Boolean direct; 
    private Boolean restrictions;
    private Boolean exclusive;
    private Boolean layby;
    private Boolean multiflex;
    private String topOffer;
    private String urlDeep;
    
    private Destination dest;
    private Origin origin;
    private Fare fare;
    private List<Segment> flights = new ArrayList<>();
    
    /**
     * @param pos .
     * @param manual .
     * @param campaignFare .
     * @param campaignCode .
     * @param saleStart .
     * @param saleEnd .
     * @param searchDateTime .
     * @param season .
     * @param advPurchPeriod .
     * @param opaque .
     * @param bookByDates .
     * @param ticketType .
     * @param stay .
     * @param flightType .
     * @param flightTicketType .
     * @param duration .
     * @param departureDate .
     * @param returnDate .
     * @param eligibility .
     * @param stopovers .
     * @param direct .
     * @param restrictions .
     * @param exclusive .
     * @param layby .
     * @param multiflex .
     * @param topOffer .
     * @param urlDeep .
     * @param dest .
     * @param origin .
     * @param fare .
     * @param flights .
     */
    public Flight(final String pos, final Boolean manual,final String key, final Boolean campaignFare, final String campaignCode, final String saleStart, final String saleEnd,
            final String searchDateTime, final String season, final String advPurchPeriod, final Boolean opaque, final String bookByDates, final String ticketType, final String stay,
            final String flightType, final String flightTicketType, final String duration, final String departureDate, final String returnDate, final String eligibility,
            final List<String> stopovers, final Boolean direct, final Boolean restrictions, final Boolean exclusive, final Boolean layby, final Boolean multiflex, final String topOffer,
            final String urlDeep, final Destination dest, final Origin origin, final Fare fare, final List<Segment> flights) {
        super();
        this.key = key;
        this.pos = pos;
        this.manual = manual;
        this.campaignFare = campaignFare;
        this.campaignCode = campaignCode;
        this.saleStart = saleStart;
        this.saleEnd = saleEnd;
        this.searchDateTime = searchDateTime;
        this.season = season;
        this.advPurchPeriod = advPurchPeriod;
        this.opaque = opaque;
        this.bookByDates = bookByDates;
        this.ticketType = ticketType;
        this.flightTicketType = flightTicketType;
        this.stay = stay;
        this.flightType = flightType;
        this.duration = duration;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.eligibility = eligibility;
        this.stopovers = stopovers;
        this.direct = direct;
        this.restrictions = restrictions;
        this.exclusive = exclusive;
        this.layby = layby;
        this.multiflex = multiflex;
        this.topOffer = topOffer;
        this.urlDeep = urlDeep;
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
    public Boolean isManual() {
        return manual;
    }

    /**
     * @param manual the manual to set
     */
    public void setManual(final Boolean manual) {
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
    public Boolean isCampaignFare() {
        return campaignFare;
    }

    /**
     * @param campaignFare the campaignFare to set
     */
    public void setCampaignFare(final Boolean campaignFare) {
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
    public String getSaleStart() {
        return saleStart;
    }

    /**
     * @param saleStart the saleStart to set
     */
    public void setSaleStart(final String saleStart) {
        this.saleStart = saleStart;
    }

    /**
     * @return the saleEnd
     */
    public String getSaleEnd() {
        return saleEnd;
    }

    /**
     * @param saleEnd the saleEnd to set
     */
    public void setSaleEnd(final String saleEnd) {
        this.saleEnd = saleEnd;
    }

    /**
     * @return the searchDateTime
     */
    public String getSearchDateTime() {
        return searchDateTime;
    }

    /**
     * @param searchDateTime the searchDateTime to set
     */
    public void setSearchDateTime(final String searchDateTime) {
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
    public Boolean getOpaque() {
        return opaque;
    }

    /**
     * @param opaque the opaque to set
     */
    public void setOpaque(final Boolean opaque) {
        this.opaque = opaque;
    }

    /**
     * @return the bookByDates
     */
    public String getBookByDates() {
        return bookByDates;
    }

    /**
     * @param bookByDates the bookByDates to set
     */
    public void setBookByDates(final String bookByDates) {
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
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(final String returnDate) {
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
    public Boolean isDirect() {
        return direct;
    }

    /**
     * @param direct the direct to set
     */
    public void setDirect(final Boolean direct) {
        this.direct = direct;
    }

    /**
     * @return the restrictions
     */
    public Boolean isRestrictions() {
        return restrictions;
    }

    /**
     * @param restrictions the restrictions to set
     */
    public void setRestrictions(final Boolean restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * @return the exclusive
     */
    public Boolean isExclusive() {
        return exclusive;
    }

    /**
     * @param exclusive the exclusive to set
     */
    public void setExclusive(final Boolean exclusive) {
        this.exclusive = exclusive;
    }

    /**
     * @return the layby
     */
    public Boolean isLayby() {
        return layby;
    }

    /**
     * @param layby the layby to set
     */
    public void setLayby(final Boolean layby) {
        this.layby = layby;
    }

    /**
     * @return the multiflex
     */
    public Boolean isMultiflex() {
        return multiflex;
    }

    /**
     * @param multiflex the multiflex to set
     */
    public void setMultiflex(final Boolean multiflex) {
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = PRIME_NUMBER;
        int result = 1;
        result = prime * result + ((advPurchPeriod == null) ? 0 : advPurchPeriod.hashCode());
        result = prime * result + ((bookByDates == null) ? 0 : bookByDates.hashCode());
        result = prime * result + ((campaignCode == null) ? 0 : campaignCode.hashCode());
        result = prime * result + ((campaignFare == null) ? 0 : campaignFare.hashCode());
        result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
        result = prime * result + ((dest == null) ? 0 : dest.hashCode());
        result = prime * result + ((direct == null) ? 0 : direct.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + ((eligibility == null) ? 0 : eligibility.hashCode());
        result = prime * result + ((exclusive == null) ? 0 : exclusive.hashCode());
        result = prime * result + ((fare == null) ? 0 : fare.hashCode());
        result = prime * result + ((flightTicketType == null) ? 0 : flightTicketType.hashCode());
        result = prime * result + ((flightType == null) ? 0 : flightType.hashCode());
        result = prime * result + ((flights == null) ? 0 : flights.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((layby == null) ? 0 : layby.hashCode());
        result = prime * result + ((manual == null) ? 0 : manual.hashCode());
        result = prime * result + ((multiflex == null) ? 0 : multiflex.hashCode());
        result = prime * result + ((opaque == null) ? 0 : opaque.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((pos == null) ? 0 : pos.hashCode());
        result = prime * result + ((restrictions == null) ? 0 : restrictions.hashCode());
        result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
        result = prime * result + ((saleEnd == null) ? 0 : saleEnd.hashCode());
        result = prime * result + ((saleStart == null) ? 0 : saleStart.hashCode());
        result = prime * result + ((searchDateTime == null) ? 0 : searchDateTime.hashCode());
        result = prime * result + ((season == null) ? 0 : season.hashCode());
        result = prime * result + ((stay == null) ? 0 : stay.hashCode());
        result = prime * result + ((stopovers == null) ? 0 : stopovers.hashCode());
        result = prime * result + ((ticketType == null) ? 0 : ticketType.hashCode());
        result = prime * result + ((topOffer == null) ? 0 : topOffer.hashCode());
        result = prime * result + ((urlDeep == null) ? 0 : urlDeep.hashCode());
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
        Flight other = (Flight) obj;
        if (advPurchPeriod == null) {
            if (other.advPurchPeriod != null)
                return false;
        } else if (!advPurchPeriod.equals(other.advPurchPeriod))
            return false;
        if (bookByDates == null) {
            if (other.bookByDates != null)
                return false;
        } else if (!bookByDates.equals(other.bookByDates))
            return false;
        if (campaignCode == null) {
            if (other.campaignCode != null)
                return false;
        } else if (!campaignCode.equals(other.campaignCode))
            return false;
        if (campaignFare == null) {
            if (other.campaignFare != null)
                return false;
        } else if (!campaignFare.equals(other.campaignFare))
            return false;
        if (departureDate == null) {
            if (other.departureDate != null)
                return false;
        } else if (!departureDate.equals(other.departureDate))
            return false;
        if (dest == null) {
            if (other.dest != null)
                return false;
        } else if (!dest.equals(other.dest))
            return false;
        if (direct == null) {
            if (other.direct != null)
                return false;
        } else if (!direct.equals(other.direct))
            return false;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (eligibility == null) {
            if (other.eligibility != null)
                return false;
        } else if (!eligibility.equals(other.eligibility))
            return false;
        if (exclusive == null) {
            if (other.exclusive != null)
                return false;
        } else if (!exclusive.equals(other.exclusive))
            return false;
        if (fare == null) {
            if (other.fare != null)
                return false;
        } else if (!fare.equals(other.fare))
            return false;
        if (flightTicketType == null) {
            if (other.flightTicketType != null)
                return false;
        } else if (!flightTicketType.equals(other.flightTicketType))
            return false;
        if (flightType == null) {
            if (other.flightType != null)
                return false;
        } else if (!flightType.equals(other.flightType))
            return false;
        if (flights == null) {
            if (other.flights != null)
                return false;
        } else if (!flights.equals(other.flights))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (layby == null) {
            if (other.layby != null)
                return false;
        } else if (!layby.equals(other.layby))
            return false;
        if (manual == null) {
            if (other.manual != null)
                return false;
        } else if (!manual.equals(other.manual))
            return false;
        if (multiflex == null) {
            if (other.multiflex != null)
                return false;
        } else if (!multiflex.equals(other.multiflex))
            return false;
        if (opaque == null) {
            if (other.opaque != null)
                return false;
        } else if (!opaque.equals(other.opaque))
            return false;
        if (origin == null) {
            if (other.origin != null)
                return false;
        } else if (!origin.equals(other.origin))
            return false;
        if (pos == null) {
            if (other.pos != null)
                return false;
        } else if (!pos.equals(other.pos))
            return false;
        if (restrictions == null) {
            if (other.restrictions != null)
                return false;
        } else if (!restrictions.equals(other.restrictions))
            return false;
        if (returnDate == null) {
            if (other.returnDate != null)
                return false;
        } else if (!returnDate.equals(other.returnDate))
            return false;
        if (saleEnd == null) {
            if (other.saleEnd != null)
                return false;
        } else if (!saleEnd.equals(other.saleEnd))
            return false;
        if (saleStart == null) {
            if (other.saleStart != null)
                return false;
        } else if (!saleStart.equals(other.saleStart))
            return false;
        if (searchDateTime == null) {
            if (other.searchDateTime != null)
                return false;
        } else if (!searchDateTime.equals(other.searchDateTime))
            return false;
        if (season == null) {
            if (other.season != null)
                return false;
        } else if (!season.equals(other.season))
            return false;
        if (stay == null) {
            if (other.stay != null)
                return false;
        } else if (!stay.equals(other.stay))
            return false;
        if (stopovers == null) {
            if (other.stopovers != null)
                return false;
        } else if (!stopovers.equals(other.stopovers))
            return false;
        if (ticketType == null) {
            if (other.ticketType != null)
                return false;
        } else if (!ticketType.equals(other.ticketType))
            return false;
        if (topOffer == null) {
            if (other.topOffer != null)
                return false;
        } else if (!topOffer.equals(other.topOffer))
            return false;
        if (urlDeep == null) {
            if (other.urlDeep != null)
                return false;
        } else if (!urlDeep.equals(other.urlDeep))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Flight [pos=" + pos + ", manual=" + manual + ", key=" + key + ", campaignFare=" + campaignFare + ", campaignCode=" + campaignCode
                + ", saleStart=" + saleStart + ", saleEnd=" + saleEnd + ", searchDateTime=" + searchDateTime + ", season=" + season
                + ", advPurchPeriod=" + advPurchPeriod + ", opaque=" + opaque + ", bookByDates=" + bookByDates + ", ticketType=" + ticketType
                + ", stay=" + stay + ", flightType=" + flightType + ", flightTicketType=" + flightTicketType + ", duration=" + duration
                + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", eligibility=" + eligibility + ", stopovers=" + stopovers
                + ", direct=" + direct + ", restrictions=" + restrictions + ", exclusive=" + exclusive + ", layby=" + layby + ", multiflex="
                + multiflex + ", topOffer=" + topOffer + ", urlDeep=" + urlDeep + ", dest=" + dest + ", origin=" + origin + ", fare=" + fare
                + ", flights=" + flights + "]";
    }
     
    
}
