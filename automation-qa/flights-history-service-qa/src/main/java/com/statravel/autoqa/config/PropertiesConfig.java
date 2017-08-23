package com.statravel.autoqa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 
 * @author STA Development Team.
 *
 */
@Component
public class PropertiesConfig {
    
    @Value("${flights.history.service.url}")
    private String hostUrl;
	
    /**
     * 
     * @return the flights history service health check endpoint
     */
	public String getHostUrl() {
        return hostUrl;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PropertiesConfig [hostUrl=" + hostUrl + "]";
    }
  
}
