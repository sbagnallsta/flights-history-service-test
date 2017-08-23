package com.statravel.ms.domain.dto.template;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.statravel.ms.validator.annotation.ValidProduct;
import com.statravel.ms.validator.annotation.ValidType;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class TemplateRequest implements Serializable {

    private static final long serialVersionUID = 747345836114879674L;

    private static final int PRIME_NUMBER = 31;

    @ValidProduct
    private String product;

    @ValidType
    private String type;

    private JsonNode templateObject;

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
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = PRIME_NUMBER;

        int result = 1;

        result = prime * result + ((templateObject == null) ? 0 : templateObject.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());

        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof TemplateRequest)) {
            return false;
        }

        TemplateRequest other = (TemplateRequest) obj;

        if (templateObject == null) {
            if (other.templateObject != null) {
                return false;
            }
        } else if (!templateObject.equals(other.templateObject)) {
            return false;
        }

        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }

        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }

        return true;
    }

	@Override
	public String toString() {
		return "TemplateRequest [product=" + product + ", type=" + type + ", templateObject=" + templateObject + "]";
	}

}
