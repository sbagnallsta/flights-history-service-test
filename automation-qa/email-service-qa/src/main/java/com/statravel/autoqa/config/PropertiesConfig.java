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
    
    @Value("${resource.email.url}")
    private String emailResourceUrl;

    private static final String EMAIL = "emails";
    private static final String HEALTH = "health";

	public String getEmailResourceUrl() {
		return emailResourceUrl + EMAIL;
	}
	
	public String getEmailHealthUrl() {
        return emailResourceUrl + HEALTH;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PropertiesConfig [emailResourceUrl=" + emailResourceUrl + "]";
    }
  
}
