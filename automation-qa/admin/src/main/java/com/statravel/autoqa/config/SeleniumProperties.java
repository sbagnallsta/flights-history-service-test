package com.statravel.autoqa.config;

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
    private static String appURL;

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

    /**
     * @return the appURL
     */
    public static String getAppURL() {
        return appURL;
    }

    /**
     * @param appURL the appURL to set
     */
    @Value("${selenium.app.url}")
    public void setAppURL(final String appURL) {
        SeleniumProperties.appURL = appURL;
    }


}
