/**
 * 
 */
package com.statravel.autoqa.domain.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author STA Development Team
 *
 */
public class Fare implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6276092526183708949L;

    private static final int PRIME_NUMBER = 31;
    
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookingFees == null) ? 0 : bookingFees.hashCode());
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((net == null) ? 0 : net.hashCode());
        result = prime * result + ((qCharges == null) ? 0 : qCharges.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((yqTaxes == null) ? 0 : yqTaxes.hashCode());
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
        Fare other = (Fare) obj;
        if (bookingFees == null) {
            if (other.bookingFees != null)
                return false;
        } else if (!bookingFees.equals(other.bookingFees))
            return false;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        if (net == null) {
            if (other.net != null)
                return false;
        } else if (!net.equals(other.net))
            return false;
        if (qCharges == null) {
            if (other.qCharges != null)
                return false;
        } else if (!qCharges.equals(other.qCharges))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (yqTaxes == null) {
            if (other.yqTaxes != null)
                return false;
        } else if (!yqTaxes.equals(other.yqTaxes))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Fare [currency=" + currency + ", net=" + net + ", qCharges=" + qCharges + ", yqTaxes=" + yqTaxes + ", bookingFees=" + bookingFees
                + ", total=" + total + ", type=" + type + "]";
    }      
    
    
}
