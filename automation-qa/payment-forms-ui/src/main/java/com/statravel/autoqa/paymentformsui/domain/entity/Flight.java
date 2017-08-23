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
@Table(name = "a_ui_payment_form_flights")
public class Flight implements Serializable {

    private static final long serialVersionUID = -6576026832687243079L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "airline")
    private String airline;

    @Column(name = "operator")
    private String operator;

    @Column(name = "number")
    private String number;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "departure_airport")
    private String departureAirport;
    
    @Column(name = "departure_airport_code")
    private String departureAirportCode;
    
    @Column(name = "departure_city")
    private String departureCity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "arrival_airport")
    private String arrivalAirport;
    
    @Column(name = "arrival_airport_code")
    private String arrivalAirportCode;
    
    @Column(name = "arrival_city")
    private String arrivalCity;

    @Column(name = "active", columnDefinition = "BIT")
    private boolean active;

    @Column(name = "type")
    private String type;

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
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * @param airline
     *            the airline to set
     */
    public void setAirline(final String airline) {
        this.airline = airline;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     *            the operator to set
     */
    public void setOperator(final String operator) {
        this.operator = operator;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(final String number) {
        this.number = number;
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
     * @return the departureAirport
     */
    public String getDepartureAirport() {
        return departureAirport;
    }

    /**
     * @param departureAirport
     *            the departureAirport to set
     */
    public void setDepartureAirport(final String departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     * @return the arrivalDate
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate
     *            the arrivalDate to set
     */
    public void setArrivalDate(final Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the arrivalAirport
     */
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * @param arrivalAirport
     *            the arrivalAirport to set
     */
    public void setArrivalAirport(final String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(final String type) {
        this.type = type;
    }
    
    /**
     * @return the departureAirportCode
     */
    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    /**
     * @param departureAirportCode the departureAirportCode to set
     */
    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    /**
     * @return the departureCity
     */
    public String getDepartureCity() {
        return departureCity;
    }

    /**
     * @param departureCity the departureCity to set
     */
    public void setDepartureCity(final String departureCity) {
        this.departureCity = departureCity;
    }

    /**
     * @return the arrivalAirportCode
     */
    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    /**
     * @param arrivalAirportCode the arrivalAirportCode to set
     */
    public void setArrivalAirportCode(final String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    /**
     * @return the arrivalCity
     */
    public String getArrivalCity() {
        return arrivalCity;
    }

    /**
     * @param arrivalCity the arrivalCity to set
     */
    public void setArrivalCity(final String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Flight [id=" + id + ", airline=" + airline + ", operator=" + operator + ", number=" + number + ", departureDate=" + departureDate
                + ", departureAirport=" + departureAirport + ", departureAirportCode=" + departureAirportCode + ", departureCity=" + departureCity
                + ", arrivalDate=" + arrivalDate + ", arrivalAirport=" + arrivalAirport + ", arrivalAirportCode=" + arrivalAirportCode
                + ", arrivalCity=" + arrivalCity + ", active=" + active + ", type=" + type + "]";
    }

}
