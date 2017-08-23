package com.statravel.autoqa.paymentformsui.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author STA development team
 *
 */
@Entity
@Table(name = "a_ui_payment_form_terms_and_conditions")
public class TermsAndCondition implements Serializable {

    private static final long serialVersionUID = -4238721666980128948L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "final_deposit_date")
    private Date finalDepositDate;

    @Column(name = "final_deposit_description", columnDefinition = "TEXT")
    private String finalDepositDescription;

    @Column(name = "final_deposit_active", columnDefinition = "BIT")
    private boolean finalDepositActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "final_payment_due_date")
    private Date finalPaymentDueDate;

    @Column(name = "final_payment_description", columnDefinition = "TEXT")
    private String finalPaymentDescription;

    @Column(name = "final_payment_active", columnDefinition = "BIT")
    private boolean finalPaymentActive;

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
     * @return the finalDepositDate
     */
    public Date getFinalDepositDate() {
        return finalDepositDate;
    }

    /**
     * @param finalDepositDate
     *            the finalDepositDate to set
     */
    public void setFinalDepositDate(final Date finalDepositDate) {
        this.finalDepositDate = finalDepositDate;
    }

    /**
     * @return the finalDepositDescription
     */
    public String getFinalDepositDescription() {
        return finalDepositDescription;
    }

    /**
     * @param finalDepositDescription
     *            the finalDepositDescription to set
     */
    public void setFinalDepositDescription(final String finalDepositDescription) {
        this.finalDepositDescription = finalDepositDescription;
    }

    /**
     * @return the finalDepositActive
     */
    public boolean getFinalDepositActive() {
        return finalDepositActive;
    }

    /**
     * @param finalDepositActive
     *            the finalDepositActive to set
     */
    public void setFinalDepositActive(final boolean finalDepositActive) {
        this.finalDepositActive = finalDepositActive;
    }

    /**
     * @return the finalPaymentDueDate
     */
    public Date getFinalPaymentDueDate() {
        return finalPaymentDueDate;
    }

    /**
     * @param finalPaymentDueDate
     *            the finalPaymentDueDate to set
     */
    public void setFinalPaymentDueDate(final Date finalPaymentDueDate) {
        this.finalPaymentDueDate = finalPaymentDueDate;
    }

    /**
     * @return the finalPaymentDescription
     */
    public String getFinalPaymentDescription() {
        return finalPaymentDescription;
    }

    /**
     * @param finalPaymentDescription
     *            the finalPaymentDescription to set
     */
    public void setFinalPaymentDescription(final String finalPaymentDescription) {
        this.finalPaymentDescription = finalPaymentDescription;
    }

    /**
     * @return the finalPaymentActive
     */
    public boolean getFinalPaymentActive() {
        return finalPaymentActive;
    }

    /**
     * @param finalPaymentActive
     *            the finalPaymentActive to set
     */
    public void setFinalPaymentActive(final boolean finalPaymentActive) {
        this.finalPaymentActive = finalPaymentActive;
    }

}
