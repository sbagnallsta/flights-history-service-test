package com.statravel.autoqa.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author STA development team
 *
 */
@Entity
@Table(name = "a_ui_payment_form")
public class PaymentFormEntity implements Serializable {

    private static final long serialVersionUID = -6041329593739215842L;

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

    @Column(name = "travel_heading")
    private String travelHeading;

    @Column(name = "url")
    private String url;

    @Column(name = "active", columnDefinition = "BIT")
    private boolean active;

    @Column(name = "deleted", columnDefinition = "BIT")
    private boolean deleted;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "travel_intro", columnDefinition = "TEXT")
    private String travelIntro;

    @Column(name = "quote_active", columnDefinition = "BIT")
    private boolean quoteActive;

    @Column(name = "flight_details_active", columnDefinition = "BIT")
    private boolean flightDetailsActive;

    @Column(name = "flight_getting_around_active", columnDefinition = "BIT")
    private boolean flightGettingAroundActive;

    @Column(name = "flight_getting_back_active", columnDefinition = "BIT")
    private boolean flightGettingBackActive;

    @Column(name = "flight_getting_there_active", columnDefinition = "BIT")
    private boolean flightGettingThereActive;

    @Column(name = "accommodation_active", columnDefinition = "BIT")
    private boolean accommodationActive;

    @Column(name = "transfer_active", columnDefinition = "BIT")
    private boolean transferActive;

    @Column(name = "others_active", columnDefinition = "BIT")
    private boolean othersActive;

    @Column(name = "important_instructions_active", columnDefinition = "BIT")
    private boolean importantInstructionsActive;

    @Column(name = "cancellation_fees_active", columnDefinition = "BIT")
    private boolean cancellationFeesActive;

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

    @Column(name = "url_friendly_partner_name")
    private String urlFriendlyPartnerName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cost_details_id", nullable = false)
    private PaymentFormCostEntity paymentFormCostEntity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_and_conditions_id", nullable = false)
    private PaymentFormsTermsAndConditionsEntity paymentFormsTermsAndConditionsEntity;

    /**
     * Default constructor.
     */
    public PaymentFormEntity() {
        super();
    }

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
     * @return the createdate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     *            the createdate to set
     */
    public void setCreatedate(final Date createdate) {
        this.createdate = createdate;
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
     * @return the paymentFormCostEntity
     */
    public PaymentFormCostEntity getPaymentFormCostEntity() {
        return paymentFormCostEntity;
    }

    /**
     * @param paymentFormCostEntity
     *            the paymentFormCostEntity to set
     */
    public void setPaymentFormCostEntity(final PaymentFormCostEntity paymentFormCostEntity) {
        this.paymentFormCostEntity = paymentFormCostEntity;
    }

    /**
     * @return the paymentFormsTermsAndConditionsEntity
     */
    public PaymentFormsTermsAndConditionsEntity getPaymentFormsTermsAndConditionsEntity() {
        return paymentFormsTermsAndConditionsEntity;
    }

    /**
     * @param paymentFormsTermsAndConditionsEntity
     *            the paymentFormsTermsAndConditionsEntity to set
     */
    public void setPaymentFormsTermsAndConditionsEntity(final PaymentFormsTermsAndConditionsEntity paymentFormsTermsAndConditionsEntity) {
        this.paymentFormsTermsAndConditionsEntity = paymentFormsTermsAndConditionsEntity;
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

        if (!(obj instanceof PaymentFormEntity)) {
            return false;
        }

        PaymentFormEntity other = (PaymentFormEntity) obj;

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentFormEntity [id=" + id + ", posId=" + posId + ", uniqueId=" + uniqueId + ", name=" + name + ", travelHeading=" + travelHeading
                + ", url=" + url + ", active=" + active + ", deleted=" + deleted + ", partnerName=" + partnerName + ", tripName=" + tripName
                + ", travelIntro=" + travelIntro + ", quoteActive=" + quoteActive + ", flightDetailsActive=" + flightDetailsActive
                + ", flightGettingAroundActive=" + flightGettingAroundActive + ", flightGettingBackActive=" + flightGettingBackActive
                + ", flightGettingThereActive=" + flightGettingThereActive + ", accommodationActive=" + accommodationActive + ", transferActive="
                + transferActive + ", othersActive=" + othersActive + ", importantInstructionsActive=" + importantInstructionsActive
                + ", cancellationFeesActive=" + cancellationFeesActive + ", extrasActive=" + extrasActive + ", stopoversActive=" + stopoversActive
                + ", seatActive=" + seatActive + ", mealActive=" + mealActive + ", miscActive=" + miscActive + ", urlFriendlyPartnerName="
                + urlFriendlyPartnerName + ", createdate=" + createdate + ", modifiedDate=" + modifiedDate + ", paymentFormCostEntity="
                + paymentFormCostEntity + ", paymentFormsTermsAndConditionsEntity=" + paymentFormsTermsAndConditionsEntity + "]";
    }

}
