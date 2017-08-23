package com.statravel.autoqa.common;

import com.statravel.autoqa.domain.payload.ConfluencePayload;

/**
 * 
 * @author STA Development Team.
 *
 */
public class TestUtils {

    private static final String PRODUCT = "Saved Searches API";
    private static final String PRODUCT_COPY = "Saved Searches API COPY";

    /**
     * 
     * @return a valid template payload
     */
    public ConfluencePayload validPayload() {

        return new ConfluencePayload(PRODUCT);

    }

    /**
     * 
     * @return an invalid template payload
     */
    public ConfluencePayload invalidPayload() {

        return new ConfluencePayload(null);

    }

    /**
     * 
     * @return a duplicate payload
     */
    public ConfluencePayload duplicatePayload() {

        return new ConfluencePayload(PRODUCT_COPY);

    }

}
