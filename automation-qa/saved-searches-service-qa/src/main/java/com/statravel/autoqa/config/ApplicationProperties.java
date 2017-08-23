package com.statravel.autoqa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class ApplicationProperties {

    private static final String UK_POS_CODE = "uk";

    @Value("${host.url}")
    private String hostUrl;

    @Value("${mysta.userId}")
    private String mystaUserId;

    /**
     * @return the hostUrl
     */
    public String getHostUrl() {
        return hostUrl;
    }

    /**
     * @return the mystaUserId
     */
    public String getMystaUserId() {
        return mystaUserId;
    }

    /**
     * @return the point of sales code
     */
    public String getPos() {
        return UK_POS_CODE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PropertiesConfig [hostUrl=" + hostUrl + ", mystaUserId=" + mystaUserId + ", pos=" + UK_POS_CODE + "]";
    }

}
