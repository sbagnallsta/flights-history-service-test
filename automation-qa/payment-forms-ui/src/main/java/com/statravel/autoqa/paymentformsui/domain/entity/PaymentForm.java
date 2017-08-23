package com.statravel.autoqa.paymentformsui.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author STA Development Team
 *
 */
@Entity
@Table(name = "a_ui_payment_form")
public class PaymentForm implements Serializable {

    private static final long serialVersionUID = 4101346690693406617L;

    private static final int HASH_PRIME_NUMBER = 31;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pos_id")
    private Long posId;

    @Column(name = "unique_id")
    private String uniqueId;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "url_friendly_partner_name")
    private String urlFriendlyPartnerName;

    @Column(name = "partner_logo_url")
    private String partnerLogoUrl;

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "travel_heading")
    private String travelHeading;

    @Column(name = "travel_intro", columnDefinition = "TEXT")
    private String travelIntro;

    @Column(name = "quote_active", columnDefinition = "BIT")
    private boolean quoteActive;

    @Column(name = "flight_details_active", columnDefinition = "BIT")
    private boolean flightDetailsActive;

    @Column(name = "flight_getting_there_active", columnDefinition = "BIT")
    private boolean flightGettingThereActive;

    @Column(name = "flight_getting_back_active", columnDefinition = "BIT")
    private boolean flightGettingBackActive;

    @Column(name = "flight_getting_around_active", columnDefinition = "BIT")
    private boolean flightGettingAroundActive;

    @Column(name = "accommodation_active", columnDefinition = "BIT")
    private boolean accommodationActive;

    @Column(name = "others_active", columnDefinition = "BIT")
    private boolean othersActive;

    @Column(name = "transfer_active", columnDefinition = "BIT")
    private boolean transferActive;

    @Column(name = "extras_active", columnDefinition = "BIT")
    private boolean extrasActive;

    @Column(name = "stopovers_active", columnDefinition = "BIT")
    private boolean stopoversActive;

    @Column(name = "seat_active", columnDefinition = "BIT")
    private boolean seatActive;

    @Column(name = "meal_active", columnDefinition = "BIT")
    private boolean mealActive;

    @Column(name = "misc_active", columnDefinition = "BIT")
    private boolean miscActive;

    @Column(name = "misc_product_name")
    private String miscProductName;

    @Column(name = "important_instructions", columnDefinition = "TEXT")
    private String importantInstructions;

    @Column(name = "important_instructions_active", columnDefinition = "BIT")
    private boolean importantInstructionsActive;

    @Column(name = "cancellation_fees_active", columnDefinition = "BIT")
    private boolean cancellationFeesActive;

    @Column(name = "legal_copy", columnDefinition = "TEXT")
    private String legalCopy;

    @Column(name = "active", columnDefinition = "BIT")
    private boolean active;

    @Column(name = "deleted", columnDefinition = "BIT")
    private boolean deleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cost_details_id", nullable = false)
    private Cost cost;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "terms_and_conditions_id", nullable = false)
    private TermsAndCondition termsAndCondition;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "form_id", referencedColumnName = "id", nullable = false)
    private List<Misc> misc = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "form_id", referencedColumnName = "id", nullable = false)
    private List<Others> others = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "form_id", referencedColumnName = "id", nullable = false)
    private List<Flight> flightList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "form_id", referencedColumnName = "id", nullable = false)
    private List<Transfer> transferList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "form_id", referencedColumnName = "id", nullable = false)
    private List<Extra> extra = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "form_id", referencedColumnName = "id", nullable = false)
    private List<Stopover> stopover = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "a_ui_payment_form_field", joinColumns = @JoinColumn(name = "form_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "html_field_id", referencedColumnName = "id"))
    private List<HtmlField> htmlFieldList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "form_id", referencedColumnName = "id", nullable = false)
    private List<Accommodation> accommodationList = new ArrayList<>();

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the posId
     */
    public Long getPosId() {
        return posId;
    }

    /**
     * @param posId
     *            the posId to set
     */
    public void setPosId(final Long posId) {
        this.posId = posId;
    }

    /**
     * @return the uniqueId
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * @param uniqueId
     *            the uniqueId to set
     */
    public void setUniqueId(final String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * @return the partnerName
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * @param partnerName
     *            the partnerName to set
     */
    public void setPartnerName(final String partnerName) {
        this.partnerName = partnerName;
    }

    /**
     * @return the urlFriendlyPartnerName
     */
    public String getUrlFriendlyPartnerName() {
        return urlFriendlyPartnerName;
    }

    /**
     * @param urlFriendlyPartnerName
     *            the urlFriendlyPartnerName to set
     */
    public void setUrlFriendlyPartnerName(final String urlFriendlyPartnerName) {
        this.urlFriendlyPartnerName = urlFriendlyPartnerName;
    }

    /**
     * @return the partnerLogoUrl
     */
    public String getPartnerLogoUrl() {
        return partnerLogoUrl;
    }

    /**
     * @param partnerLogoUrl
     *            the partnerLogoUrl to set
     */
    public void setPartnerLogoUrl(final String partnerLogoUrl) {
        this.partnerLogoUrl = partnerLogoUrl;
    }

    /**
     * @return the tripName
     */
    public String getTripName() {
        return tripName;
    }

    /**
     * @param tripName
     *            the tripName to set
     */
    public void setTripName(final String tripName) {
        this.tripName = tripName;
    }

    /**
     * @return the travelHeading
     */
    public String getTravelHeading() {
        return travelHeading;
    }

    /**
     * @param travelHeading
     *            the travelHeading to set
     */
    public void setTravelHeading(final String travelHeading) {
        this.travelHeading = travelHeading;
    }

    /**
     * @return the travelIntro
     */
    public String getTravelIntro() {
        return travelIntro;
    }

    /**
     * @param travelIntro
     *            the travelIntro to set
     */
    public void setTravelIntro(final String travelIntro) {
        this.travelIntro = travelIntro;
    }

    /**
     * @return the quoteActive
     */
    public boolean isQuoteActive() {
        return quoteActive;
    }

    /**
     * @param quoteActive
     *            the quoteActive to set
     */
    public void setQuoteActive(final boolean quoteActive) {
        this.quoteActive = quoteActive;
    }

    /**
     * @return the flightDetailsActive
     */
    public boolean isFlightDetailsActive() {
        return flightDetailsActive;
    }

    /**
     * @param flightDetailsActive
     *            the flightDetailsActive to set
     */
    public void setFlightDetailsActive(final boolean flightDetailsActive) {
        this.flightDetailsActive = flightDetailsActive;
    }

    /**
     * @return the flightGettingThereActive
     */
    public boolean isFlightGettingThereActive() {
        return flightGettingThereActive;
    }

    /**
     * @param flightGettingThereActive
     *            the flightGettingThereActive to set
     */
    public void setFlightGettingThereActive(final boolean flightGettingThereActive) {
        this.flightGettingThereActive = flightGettingThereActive;
    }

    /**
     * @return the flightGettingBackActive
     */
    public boolean isFlightGettingBackActive() {
        return flightGettingBackActive;
    }

    /**
     * @param flightGettingBackActive
     *            the flightGettingBackActive to set
     */
    public void setFlightGettingBackActive(final boolean flightGettingBackActive) {
        this.flightGettingBackActive = flightGettingBackActive;
    }

    /**
     * @return the flightGettingAroundActive
     */
    public boolean isFlightGettingAroundActive() {
        return flightGettingAroundActive;
    }

    /**
     * @param flightGettingAroundActive
     *            the flightGettingAroundActive to set
     */
    public void setFlightGettingAroundActive(final boolean flightGettingAroundActive) {
        this.flightGettingAroundActive = flightGettingAroundActive;
    }

    /**
     * @return the accommodationActive
     */
    public boolean isAccommodationActive() {
        return accommodationActive;
    }

    /**
     * @param accommodationActive
     *            the accommodationActive to set
     */
    public void setAccommodationActive(final boolean accommodationActive) {
        this.accommodationActive = accommodationActive;
    }

    /**
     * @return the othersActive
     */
    public boolean isOthersActive() {
        return othersActive;
    }

    /**
     * @param othersActive
     *            the othersActive to set
     */
    public void setOthersActive(final boolean othersActive) {
        this.othersActive = othersActive;
    }

    /**
     * @return the transferActive
     */
    public boolean isTransferActive() {
        return transferActive;
    }

    /**
     * @param transferActive
     *            the transferActive to set
     */
    public void setTransferActive(final boolean transferActive) {
        this.transferActive = transferActive;
    }

    /**
     * @return the extrasActive
     */
    public boolean isExtrasActive() {
        return extrasActive;
    }

    /**
     * @param extrasActive
     *            the extrasActive to set
     */
    public void setExtrasActive(final boolean extrasActive) {
        this.extrasActive = extrasActive;
    }

    /**
     * @return the stopoversActive
     */
    public boolean isStopoversActive() {
        return stopoversActive;
    }

    /**
     * @param stopoversActive
     *            the stopoversActive to set
     */
    public void setStopoversActive(final boolean stopoversActive) {
        this.stopoversActive = stopoversActive;
    }

    /**
     * @return the seatActive
     */
    public boolean isSeatActive() {
        return seatActive;
    }

    /**
     * @param seatActive
     *            the seatActive to set
     */
    public void setSeatActive(final boolean seatActive) {
        this.seatActive = seatActive;
    }

    /**
     * @return the mealActive
     */
    public boolean isMealActive() {
        return mealActive;
    }

    /**
     * @param mealActive
     *            the mealActive to set
     */
    public void setMealActive(final boolean mealActive) {
        this.mealActive = mealActive;
    }

    /**
     * @return the miscActive
     */
    public boolean isMiscActive() {
        return miscActive;
    }

    /**
     * @param miscActive
     *            the miscActive to set
     */
    public void setMiscActive(final boolean miscActive) {
        this.miscActive = miscActive;
    }

    /**
     * @return the miscProductName
     */
    public String getMiscProductName() {
        return miscProductName;
    }

    /**
     * @param miscProductName
     *            the miscProductName to set
     */
    public void setMiscProductName(final String miscProductName) {
        this.miscProductName = miscProductName;
    }

    /**
     * @return the importantInstructions
     */
    public String getImportantInstructions() {
        return importantInstructions;
    }

    /**
     * @param importantInstructions
     *            the importantInstructions to set
     */
    public void setImportantInstructions(final String importantInstructions) {
        this.importantInstructions = importantInstructions;
    }

    /**
     * @return the importantInstructionsActive
     */
    public boolean isImportantInstructionsActive() {
        return importantInstructionsActive;
    }

    /**
     * @param importantInstructionsActive
     *            the importantInstructionsActive to set
     */
    public void setImportantInstructionsActive(final boolean importantInstructionsActive) {
        this.importantInstructionsActive = importantInstructionsActive;
    }

    /**
     * @return the cancellationFeesActive
     */
    public boolean isCancellationFeesActive() {
        return cancellationFeesActive;
    }

    /**
     * @param cancellationFeesActive
     *            the cancellationFeesActive to set
     */
    public void setCancellationFeesActive(final boolean cancellationFeesActive) {
        this.cancellationFeesActive = cancellationFeesActive;
    }

    /**
     * @return the legalCopy
     */
    public String getLegalCopy() {
        return legalCopy;
    }

    /**
     * @param legalCopy
     *            the legalCopy to set
     */
    public void setLegalCopy(final String legalCopy) {
        this.legalCopy = legalCopy;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active
     *            the active to set
     */
    public void setActive(final boolean active) {
        this.active = active;
    }

    /**
     * @return the deleted
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     *            the deleted to set
     */
    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate
     *            the modifiedDate to set
     */
    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return the cost
     */
    public Cost getCost() {
        return cost;
    }

    /**
     * @param cost
     *            the cost to set
     */
    public void setCost(final Cost cost) {
        this.cost = cost;
    }

    /**
     * @return the termsAndCondition
     */
    public TermsAndCondition getTermsAndCondition() {
        return termsAndCondition;
    }

    /**
     * @param termsAndCondition
     *            the termsAndCondition to set
     */
    public void setTermsAndCondition(final TermsAndCondition termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    /**
     * @return the misc
     */
    public List<Misc> getMisc() {
        return misc;
    }

    /**
     * @param misc
     *            the misc to set
     */
    public void setMisc(final List<Misc> misc) {
        this.misc = misc;
    }

    /**
     * @return the others
     */
    public List<Others> getOthers() {
        return others;
    }

    /**
     * @param others
     *            the others to set
     */
    public void setOthers(final List<Others> others) {
        this.others = others;
    }

    /**
     * @return the flightList
     */
    public List<Flight> getFlightList() {
        return flightList;
    }

    /**
     * @param flightList
     *            the flightList to set
     */
    public void setFlightList(final List<Flight> flightList) {
        this.flightList = flightList;
    }

    /**
     * @return the transferList
     */
    public List<Transfer> getTransferList() {
        return transferList;
    }

    /**
     * @param transferList
     *            the transferList to set
     */
    public void setTransferList(final List<Transfer> transferList) {
        this.transferList = transferList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = HASH_PRIME_NUMBER;
        int result = 1;

        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + (deleted ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((posId == null) ? 0 : posId.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());

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

        if (!(obj instanceof PaymentForm)) {
            return false;
        }

        PaymentForm other = (PaymentForm) obj;

        if (active != other.active) {
            return false;
        }

        if (deleted != other.deleted) {
            return false;
        }

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (posId == null) {
            if (other.posId != null) {
                return false;
            }
        } else if (!posId.equals(other.posId)) {
            return false;
        }

        if (url == null) {
            if (other.url != null) {
                return false;
            }
        } else if (!url.equals(other.url)) {
            return false;
        }

        return true;
    }

    /**
     * @return the extra
     */
    public List<Extra> getExtra() {
        return extra;
    }

    /**
     * @param extra
     *            the extra to set
     */
    public void setExtra(final List<Extra> extra) {
        this.extra = extra;
    }

    /**
     * @return the stopover
     */
    public List<Stopover> getStopover() {
        return stopover;
    }

    /**
     * @param stopover
     *            the stopover to set
     */
    public void setStopover(final List<Stopover> stopover) {
        this.stopover = stopover;
    }

    /**
     * @return the htmlFieldList
     */
    public List<HtmlField> getHtmlFieldList() {
        return htmlFieldList;
    }

    /**
     * @param htmlFieldList
     *            the htmlFieldList to set
     */
    public void setHtmlFieldList(final List<HtmlField> htmlFieldList) {
        this.htmlFieldList = htmlFieldList;
    }

    /**
     * @return the accommodationList
     */
    public List<Accommodation> getAccommodationList() {
        return accommodationList;
    }

    /**
     * @param accommodationList
     *            the accommodationList to set
     */
    public void setAccommodationList(final List<Accommodation> accommodationList) {
        this.accommodationList = accommodationList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentForm [id=" + id + ", posId=" + posId + ", uniqueId=" + uniqueId + ", name=" + name + ", url=" + url + ", partnerName="
                + partnerName + ", urlFriendlyPartnerName=" + urlFriendlyPartnerName + ", partnerLogoUrl=" + partnerLogoUrl + ", tripName=" + tripName
                + ", travelHeading=" + travelHeading + ", travelIntro=" + travelIntro + ", quoteActive=" + quoteActive + ", flightDetailsActive="
                + flightDetailsActive + ", flightGettingThereActive=" + flightGettingThereActive + ", flightGettingBackActive="
                + flightGettingBackActive + ", flightGettingAroundActive=" + flightGettingAroundActive + ", accommodationActive="
                + accommodationActive + ", othersActive=" + othersActive + ", transferActive=" + transferActive + ", extrasActive=" + extrasActive
                + ", stopoversActive=" + stopoversActive + ", seatActive=" + seatActive + ", mealActive=" + mealActive + ", miscActive=" + miscActive
                + ", miscProductName=" + miscProductName + ", importantInstructions=" + importantInstructions + ", importantInstructionsActive="
                + importantInstructionsActive + ", cancellationFeesActive=" + cancellationFeesActive + ", legalCopy=" + legalCopy + ", active="
                + active + ", deleted=" + deleted + ", modifiedDate=" + modifiedDate + ", cost=" + cost + ", termsAndCondition=" + termsAndCondition
                + ", misc=" + misc + ", others=" + others + ", flightList=" + flightList + ", transferList=" + transferList + ", extra=" + extra
                + ", stopover=" + stopover + ", htmlFieldList=" + htmlFieldList + ", accommodationList=" + accommodationList + "]";
    }

}
