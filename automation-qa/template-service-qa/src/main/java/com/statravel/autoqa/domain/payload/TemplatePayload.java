package com.statravel.autoqa.domain.payload;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class TemplatePayload implements Serializable {

    private static final long serialVersionUID = 747345836114879674L;

    private String product;

    private String type;

    private JsonNode templateObject;

    /**
     * @param product
     *            product name
     * @param type
     *            type
     * 
     */
    public TemplatePayload(final String product, final String type) {

        this.product = product;
        this.type = type;

    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product
     *            the product to set
     */
    public void setProduct(final String product) {
        this.product = product;
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
     * @return the templateObject
     */
    public JsonNode getTemplateObject() {
        return templateObject;
    }

    /**
     * @param templateObject
     *            the templateObject to set
     */
    public void setTemplateObject(final JsonNode templateObject) {
        this.templateObject = templateObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TemplatePayload [product=" + product + ", type=" + type + ", templateObject=" + templateObject + "]";
    }

}
