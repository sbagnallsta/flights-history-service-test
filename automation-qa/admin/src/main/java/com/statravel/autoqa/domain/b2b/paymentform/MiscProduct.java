package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public class MiscProduct {

    private String price;

    private String productName;

    private String productInforamtion;

    /**
     * 
     * @param price
     *            Misc price
     * @param productName
     *            Misc Product name
     * @param productInforamtion
     *            Misc Product information
     */
    public MiscProduct(final String price, final String productName, final String productInforamtion) {
        super();
        this.price = price;
        this.productName = productName;
        this.productInforamtion = productInforamtion;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @return the productInforamtion
     */
    public String getProductInforamtion() {
        return productInforamtion;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MiscProduct [price=" + price + ", productName=" + productName + ", productInforamtion=" + productInforamtion + "]";
    }

}
