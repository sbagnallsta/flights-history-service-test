package com.statravel.autoqa.paymentformsui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class SeleniumProperties {

    private static String host;

    /**
     * 
     */
    public SeleniumProperties() {

    }

    /**
     * @return the host
     */
    public static String getHost() {

        return host;
    }

    /**
     * @param host
     *            the host to set
     */
    @Value("${selenium.host}")
    public void setHost(final String host) {
        SeleniumProperties.host = host;
    }

}
