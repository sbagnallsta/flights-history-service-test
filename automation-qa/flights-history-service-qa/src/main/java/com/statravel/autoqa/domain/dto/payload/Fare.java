/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

import java.util.ArrayList;
import java.util.List;

/**
 * @author STA Development Team
 *
 */
public class Fare {

    private String currency;
    private Double net;
    private Double qCharges;
    private Double yqTaxes;
    private Double bookingFees;
    private Double total;
    private List<String> type = new ArrayList<>();
    
    /**
     * @param currency .
     * @param net .
     * @param qCharges .
     * @param yqTaxes .
     * @param bookingFees .
     * @param total .
     * @param type .
     */
    public Fare(final String currency, final Double net, final Double qCharges, final Double yqTaxes, final Double bookingFees, final Double total, final List<String> type) {
        super();
        this.currency = currency;
        this.net = net;
        this.qCharges = qCharges;
        this.yqTaxes = yqTaxes;
        this.bookingFees = bookingFees;
        this.total = total;
        this.type = type;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    /**
     * @return the net
     */
    public Double getNet() {
        return net;
    }

    /**
     * @param net the net to set
     */
    public void setNet(final Double net) {
        this.net = net;
    }

    /**
     * @return the qCharges
     */
    public Double getqCharges() {
        return qCharges;
    }

    /**
     * @param qCharges the qCharges to set
     */
    public void setqCharges(final Double qCharges) {
        this.qCharges = qCharges;
    }

    /**
     * @return the yqTaxes
     */
    public Double getYqTaxes() {
        return yqTaxes;
    }

    /**
     * @param yqTaxes the yqTaxes to set
     */
    public void setYqTaxes(final Double yqTaxes) {
        this.yqTaxes = yqTaxes;
    }

    /**
     * @return the bookingFees
     */
    public Double getBookingFees() {
        return bookingFees;
    }

    /**
     * @param bookingFees the bookingFees to set
     */
    public void setBookingFees(final Double bookingFees) {
        this.bookingFees = bookingFees;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(final Double total) {
        this.total = total;
    }

    /**
     * @return the type
     */
    public List<String> getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(final List<String> type) {
        this.type = type;
    }      
    
}
