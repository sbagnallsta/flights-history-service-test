package com.statravel.autoqa.paymentformsui.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author STA Development Team
 *
 */
@Entity
@Table(name = "a_ui_payment_form_costs_details")
public class Cost implements Serializable {

    private static final long serialVersionUID = -2754997006041858183L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "flight_amount")
    private Double flightAmount;

    @Column(name = "flight_active", columnDefinition = "BIT")
    private boolean flightActive;

    @Column(name = "airfare_amount")
    private Double airfareAmount;

    @Column(name = "airfair_active", columnDefinition = "BIT")
    private boolean airfairActive;

    @Column(name = "taxes_amount")
    private Double taxesAmount;

    @Column(name = "taxes_active", columnDefinition = "BIT")
    private boolean taxesActive;

    @Column(name = "deposit_amount")
    private Double depositAmount;

    @Column(name = "deposit_active", columnDefinition = "BIT")
    private boolean depositActive;

    @Column(name = "accommodation_amount")
    private Double accommodationAmount;

    @Column(name = "accommodation_active", columnDefinition = "BIT")
    private boolean accommodationActive;

    @Column(name = "transfer_amount")
    private Double transferAmount;

    @Column(name = "transfer_active", columnDefinition = "BIT")
    private boolean transferActive;

    @Column(name = "other_amount")
    private Double otherAmount;

    @Column(name = "other_active", columnDefinition = "BIT")
    private boolean otherActive;

    @Column(name = "balance_amount")
    private Double balanceAmount;

    @Column(name = "balance_active", columnDefinition = "BIT")
    private boolean balanceActive;

    @Column(name = "terms_and_conditions", columnDefinition = "TEXT")
    private String termsAndConditions;

    @Column(name = "terms_and_conditions_active", columnDefinition = "BIT")
    private boolean termsAndConditionsActive;

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
     * @return the flightAmount
     */
    public Double getFlightAmount() {
        return flightAmount;
    }

    /**
     * @param flightAmount
     *            the flightAmount to set
     */
    public void setFlightAmount(final Double flightAmount) {
        this.flightAmount = flightAmount;
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

    /**
     * @return the airfareAmount
     */
    public Double getAirfareAmount() {
        return airfareAmount;
    }

    /**
     * @param airfareAmount
     *            the airfareAmount to set
     */
    public void setAirfareAmount(final Double airfareAmount) {
        this.airfareAmount = airfareAmount;
    }

    /**
     * @return the airfairActive
     */
    public boolean getAirfairActive() {
        return airfairActive;
    }

    /**
     * @param airfairActive
     *            the airfairActive to set
     */
    public void setAirfairActive(final boolean airfairActive) {
        this.airfairActive = airfairActive;
    }

    /**
     * @return the taxesAmount
     */
    public Double getTaxesAmount() {
        return taxesAmount;
    }

    /**
     * @param taxesAmount
     *            the taxesAmount to set
     */
    public void setTaxesAmount(final Double taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    /**
     * @return the taxesActive
     */
    public boolean getTaxesActive() {
        return taxesActive;
    }

    /**
     * @param taxesActive
     *            the taxesActive to set
     */
    public void setTaxesActive(final boolean taxesActive) {
        this.taxesActive = taxesActive;
    }

    /**
     * @return the depositAmount
     */
    public Double getDepositAmount() {
        return depositAmount;
    }

    /**
     * @param depositAmount
     *            the depositAmount to set
     */
    public void setDepositAmount(final Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    /**
     * @return the depositActive
     */
    public boolean getDepositActive() {
        return depositActive;
    }

    /**
     * @param depositActive
     *            the depositActive to set
     */
    public void setDepositActive(final boolean depositActive) {
        this.depositActive = depositActive;
    }

    /**
     * @return the balanceAmount
     */
    public Double getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * @param balanceAmount
     *            the balanceAmount to set
     */
    public void setBalanceAmount(final Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    /**
     * @return the balanceActive
     */
    public boolean getBalanceActive() {
        return balanceActive;
    }

    /**
     * @param balanceActive
     *            the balanceActive to set
     */
    public void setBalanceActive(final boolean balanceActive) {
        this.balanceActive = balanceActive;
    }

    /**
     * @return the termsAndConditions
     */
    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    /**
     * @param termsAndConditions
     *            the termsAndConditions to set
     */
    public void setTermsAndConditions(final String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    /**
     * @return the termsAndConditionsActive
     */
    public boolean getTermsAndConditionsActive() {
        return termsAndConditionsActive;
    }

    /**
     * @param termsAndConditionsActive
     *            the termsAndConditionsActive to set
     */
    public void setTermsAndConditionsActive(final boolean termsAndConditionsActive) {
        this.termsAndConditionsActive = termsAndConditionsActive;
    }

    /**
     * @return the accommodationAmount
     */
    public Double getAccommodationAmount() {
        return accommodationAmount;
    }

    /**
     * @param accommodationAmount
     *            the accommodationAmount to set
     */
    public void setAccommodationAmount(final Double accommodationAmount) {
        this.accommodationAmount = accommodationAmount;
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
     * @return the transferAmount
     */
    public Double getTransferAmount() {
        return transferAmount;
    }

    /**
     * @param transferAmount
     *            the transferAmount to set
     */
    public void setTransferAmount(final Double transferAmount) {
        this.transferAmount = transferAmount;
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
     * @return the otherAmount
     */
    public Double getOtherAmount() {
        return otherAmount;
    }

    /**
     * @param otherAmount
     *            the otherAmount to set
     */
    public void setOtherAmount(final Double otherAmount) {
        this.otherAmount = otherAmount;
    }

    /**
     * @return the otherActive
     */
    public boolean isOtherActive() {
        return otherActive;
    }

    /**
     * @param otherActive
     *            the otherActive to set
     */
    public void setOtherActive(final boolean otherActive) {
        this.otherActive = otherActive;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CostDetails [id=" + id + ", flightAmount=" + flightAmount + ", flightActive=" + flightActive + ", airfareAmount=" + airfareAmount
                + ", airfairActive=" + airfairActive + ", taxesAmount=" + taxesAmount + ", taxesActive=" + taxesActive + ", depositAmount="
                + depositAmount + ", depositActive=" + depositActive + ", accommodationAmount=" + accommodationAmount + ", accommodationActive="
                + accommodationActive + ", transferAmount=" + transferAmount + ", transferActive=" + transferActive + ", otherAmount=" + otherAmount
                + ", otherActive=" + otherActive + ", balanceAmount=" + balanceAmount + ", balanceActive=" + balanceActive + ", termsAndConditions="
                + termsAndConditions + ", termsAndConditionsActive=" + termsAndConditionsActive + "]";
    }

}
