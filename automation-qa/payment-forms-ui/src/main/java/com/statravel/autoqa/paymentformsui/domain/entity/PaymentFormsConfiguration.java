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
@Table(name = "a_ui_payment_form_config")
public class PaymentFormsConfiguration implements Serializable {

    private static final long serialVersionUID = 6472637313082748445L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pos_id")
    private Long posId;

    @Column(name = "environment")
    private String environment;

    @Column(name = "url")
    private String url;

    @Column(name = "bcc_email_address")
    private String bccEmailAddress;

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
     * @return the environment
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * @param environment
     *            the environment to set
     */
    public void setEnvironment(final String environment) {
        this.environment = environment;
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
     * @return the bccEmailAddress
     */
    public String getBccEmailAddress() {
        return bccEmailAddress;
    }

    /**
     * @param bccEmailAddress
     *            the bccEmailAddress to set
     */
    public void setBccEmailAddress(final String bccEmailAddress) {
        this.bccEmailAddress = bccEmailAddress;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentFormsConfiguration [id=" + id + ", posId=" + posId + ", environment=" + environment + ", url=" + url + ", bccEmailAddress="
                + bccEmailAddress + "]";
    }

}
