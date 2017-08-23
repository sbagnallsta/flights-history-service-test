package com.statravel.autoqa.domain.entity;

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
public class PaymentFormCostEntity implements Serializable {

    private static final long serialVersionUID = -4763174574111377779L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "flight_amount")
    private double flightAmount;

    @Column(name = "airfare_amount")
    private double airfareAmount;

    @Column(name = "taxes_amount")
    private double taxesAmount;

    @Column(name = "terms_and_conditions", columnDefinition = "TEXT")
    private String termsAndConditions;

    @Column(name = "accommodation_amount")
    private double accommodationAmount;

    @Column(name = "transfer_amount")
    private double transferAmount;

    @Column(name = "other_amount")
    private double otherAmount;

    @Column(name = "deposit_amount")
    private double depositAmount;

    @Column(name = "balance_amount")
    private double balanceAmount;

    @Column(name = "flight_active", columnDefinition = "BIT")
    private boolean flightActive;

    @Column(name = "airfair_active", columnDefinition = "BIT")
    private boolean airfairActive;

    @Column(name = "taxes_active", columnDefinition = "BIT")
    private boolean taxesActive;

    @Column(name = "terms_and_conditions_active", columnDefinition = "BIT")
    private boolean termsAndConditionsActive;

    @Column(name = "accommodation_active", columnDefinition = "BIT")
    private boolean accommodationActive;

    @Column(name = "transfer_active", columnDefinition = "BIT")
    private boolean transferActive;

    @Column(name = "other_active", columnDefinition = "BIT")
    private boolean otherActive;

    @Column(name = "deposit_active", columnDefinition = "BIT")
    private boolean depositActive;

    @Column(name = "balance_active", columnDefinition = "BIT")
    private boolean balanceActive;

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
    public double getFlightAmount() {
        return flightAmount;
    }

    /**
     * @param flightAmount
     *            the flightAmount to set
     */
    public void setFlightAmount(final double flightAmount) {
        this.flightAmount = flightAmount;
    }

    /**
     * @return the airfareAmount
     */
    public double getAirfareAmount() {
        return airfareAmount;
    }

    /**
     * @param airfareAmount
     *            the airfareAmount to set
     */
    public void setAirfareAmount(final double airfareAmount) {
        this.airfareAmount = airfareAmount;
    }

    /**
     * @return the taxesAmount
     */
    public double getTaxesAmount() {
        return taxesAmount;
    }

    /**
     * @param taxesAmount
     *            the taxesAmount to set
     */
    public void setTaxesAmount(final double taxesAmount) {
        this.taxesAmount = taxesAmount;
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
     * @return the accommodationAmount
     */
    public double getAccommodationAmount() {
        return accommodationAmount;
    }

    /**
     * @param accommodationAmount
     *            the accommodationAmount to set
     */
    public void setAccommodationAmount(final double accommodationAmount) {
        this.accommodationAmount = accommodationAmount;
    }

    /**
     * @return the transferAmount
     */
    public double getTransferAmount() {
        return transferAmount;
    }

    /**
     * @param transferAmount
     *            the transferAmount to set
     */
    public void setTransferAmount(final double transferAmount) {
        this.transferAmount = transferAmount;
    }

    /**
     * @return the otherAmount
     */
    public double getOtherAmount() {
        return otherAmount;
    }

    /**
     * @param otherAmount
     *            the otherAmount to set
     */
    public void setOtherAmount(final double otherAmount) {
        this.otherAmount = otherAmount;
    }

    /**
     * @return the depositAmount
     */
    public double getDepositAmount() {
        return depositAmount;
    }

    /**
     * @param depositAmount
     *            the depositAmount to set
     */
    public void setDepositAmount(final double depositAmount) {
        this.depositAmount = depositAmount;
    }

    /**
     * @return the balanceAmount
     */
    public double getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * @param balanceAmount
     *            the balanceAmount to set
     */
    public void setBalanceAmount(final double balanceAmount) {
        this.balanceAmount = balanceAmount;
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
     * @return the airfairActive
     */
    public boolean isAirfairActive() {
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
     * @return the taxesActive
     */
    public boolean isTaxesActive() {
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
     * @return the termsAndConditionsActive
     */
    public boolean isTermsAndConditionsActive() {
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

    /**
     * @return the depositActive
     */
    public boolean isDepositActive() {
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
     * @return the balanceActive
     */
    public boolean isBalanceActive() {
        return balanceActive;
    }

    /**
     * @param balanceActive
     *            the balanceActive to set
     */
    public void setBalanceActive(final boolean balanceActive) {
        this.balanceActive = balanceActive;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentFormCostEntity [id=" + id + ", flightAmount=" + flightAmount + ", airfareAmount=" + airfareAmount + ", taxesAmount="
                + taxesAmount + ", termsAndConditions=" + termsAndConditions + ", accommodationAmount=" + accommodationAmount + ", transferAmount="
                + transferAmount + ", otherAmount=" + otherAmount + ", depositAmount=" + depositAmount + ", balanceAmount=" + balanceAmount
                + ", flightActive=" + flightActive + ", airfairActive=" + airfairActive + ", taxesActive=" + taxesActive
                + ", termsAndConditionsActive=" + termsAndConditionsActive + ", accommodationActive=" + accommodationActive + ", transferActive="
                + transferActive + ", otherActive=" + otherActive + ", depositActive=" + depositActive + ", balanceActive=" + balanceActive + "]";
    }

}
