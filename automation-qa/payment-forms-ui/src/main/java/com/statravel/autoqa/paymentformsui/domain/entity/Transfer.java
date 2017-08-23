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
 * 
 * @author STA Development Team
 *
 */
@Entity
@Table(name = "a_ui_payment_form_transfer_details")
public class Transfer implements Serializable {

    private static final long serialVersionUID = 9157673883539472669L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "routes", columnDefinition = "TEXT")
    private String routes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "special_remarks", columnDefinition = "TEXT")
    private String specialRemarks;

    @Column(name = "active", columnDefinition = "BIT")
    private boolean active;

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
     * @return the routes
     */
    public String getRoutes() {
        return routes;
    }

    /**
     * @param routes
     *            the routes to set
     */
    public void setRoutes(final String routes) {
        this.routes = routes;
    }

    /**
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate
     *            the departureDate to set
     */
    public void setDepartureDate(final Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the specialRemarks
     */
    public String getSpecialRemarks() {
        return specialRemarks;
    }

    /**
     * @param specialRemarks
     *            the specialRemarks to set
     */
    public void setSpecialRemarks(final String specialRemarks) {
        this.specialRemarks = specialRemarks;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Transfer [id=" + id + ", name=" + name + ", routes=" + routes + ", departureDate=" + departureDate + ", specialRemarks="
                + specialRemarks + ", active=" + active + "]";
    }
}
