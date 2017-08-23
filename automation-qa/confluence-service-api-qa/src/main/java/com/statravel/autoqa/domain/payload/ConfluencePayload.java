package com.statravel.autoqa.domain.payload;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author STA Development Team.
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ConfluencePayload implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4983198241740974990L;

    private String title;
    private String product;
    private String type;
    private TemplateObject templateObject;

    /**
     * @param product
     * @param space
     */
    public ConfluencePayload(String product) {
        super();
        this.title = "title1";
        this.product = product;
        this.type = "Release";
        this.templateObject = new TemplateObject();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
    public void setProduct(String product) {
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
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the templateObject
     */
    public TemplateObject getTemplateObject() {
        return templateObject;
    }

    /**
     * @param templateObject
     *            the templateObject to set
     */
    public void setTemplateObject(TemplateObject templateObject) {
        this.templateObject = templateObject;
    }

	@Override
	public String toString() {
		return "ConfluencePayload [title=" + title + ", product=" + product + ", type=" + type + ", templateObject="
				+ templateObject + "]";
	}

}
