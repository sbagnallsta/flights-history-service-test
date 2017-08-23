package com.statravel.autoqa.common;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.statravel.autoqa.domain.payload.TemplatePayload;

/**
 * 
 * @author STA Development Team
 *
 */
public class TestUtils {

    private static final String PRODUCT_NAME_FAIL = "CI Testing Product Fail";
    private static final String TYPE_NAME_FAIL = "CI Type Fail";
    private static final String PRODUCT_NAME_FOR_COMPLEX_TEMPLATE = "B2B API";
    private static final String TYPE_NAME_FOR_COMPLEX_TEMPLATE = "Confluence Release Page";
    private static final String PRODUCT_NAME_FOR_SIMPLE_TEMPLATE = "Email Test";
    private static final String TYPE_NAME_FOR_SIMPLE_TEMPLATE = "Email Release";

    /**
     * @param isComplex
     *            specify whether is a complex template or simple
     * 
     * @param valid
     *            Boolean: true to create valid template, false to create invalid template
     * 
     * @return {@link com.statravel.autoqa.domain.payload.TemplatePayload}
     */
    public TemplatePayload buildTemplate(final boolean isComplex, final boolean valid) {

        if (valid) {

            if (isComplex) {

                return this.buildComplexTemplatePayload();
            } else {

                return new TemplatePayload(PRODUCT_NAME_FOR_SIMPLE_TEMPLATE, TYPE_NAME_FOR_SIMPLE_TEMPLATE);
            }

        } else {

            return new TemplatePayload(PRODUCT_NAME_FAIL, TYPE_NAME_FAIL);
        }

    }

    /**
     * Builds a complex TemplatePayload.
     * 
     * @return {@link com.statravel.autoqa.domain.payload.TemplatePayload}
     * 
     */
    private TemplatePayload buildComplexTemplatePayload() {

        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;

        ObjectNode templateBody = nodeFactory.objectNode();

        templateBody.put("team", "Internal");
        templateBody.put("version", "1");
        templateBody.put("product", "B2B");
        templateBody.put("githubTag", "");
        templateBody.put("changeRequestNumber", "");

        TemplatePayload templatePayload = new TemplatePayload(PRODUCT_NAME_FOR_COMPLEX_TEMPLATE, TYPE_NAME_FOR_COMPLEX_TEMPLATE);

        templatePayload.setTemplateObject(templateBody);

        return templatePayload;

    }

}
