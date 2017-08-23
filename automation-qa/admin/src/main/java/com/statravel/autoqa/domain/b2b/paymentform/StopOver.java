package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public class StopOver {

    private String price;

    private String product;

    /**
     * 
     * @param price
     *          stop over price
     * @param product
     *          stop over product
     */
    public StopOver(final String price, final String product) {
        super();
        this.price = price;
        this.product = product;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StopOver [price=" + price + ", product=" + product + "]";
    }

}
