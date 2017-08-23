package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public class Extra {

    private String price;

    private String productName;

    private String productInformation;

    /**
     * 
     * @param price
     *            Extra price
     * @param productName
     *            Extra product name
     * @param productInformation
     *            Extra product information
     */
    public Extra(final String price, final String productName, final String productInformation) {
        super();
        this.price = price;
        this.productName = productName;
        this.productInformation = productInformation;
    }

    /**
     * 
     * @param price
     *            Extra price
     */
    public Extra(final String price) {
        super();
        this.price = price;
    }

    /**
     * 
     * @param productName
     *            Extra productName
     * @param productInformation
     *            Extra porductInformation
     */
    public Extra(final String productName, final String productInformation) {
        super();
        this.productName = productName;
        this.productInformation = productInformation;
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
     * @return the productInformation
     */
    public String getProductInformation() {
        return productInformation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Extra [price=" + price + ", productName=" + productName + ", productInformation=" + productInformation + "]";
    }

}
