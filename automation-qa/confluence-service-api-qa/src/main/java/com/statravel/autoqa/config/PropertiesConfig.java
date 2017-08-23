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
	
	@Value("${confluence.service.host}")
	private String confluenceServiceHost;

    @Value("${confluence.service.health}")
    private String confluenceServiceHealthResource;

    @Value("${confluence.service.templates}")
    private String confluenceServiceTemplatesResource;
    
    
    /**
     * 
     * @return confluence service host
     */
    public String getConfluenceServiceHost() {
		return confluenceServiceHost;
	}

	/**
     * 
     * @return confluence service health resource
     */
    public String getConfluenceServiceHealthResource() {
        return confluenceServiceHealthResource;
    }

    /**
     * 
     * @return confluence service template resource
     */
    public String getConfluenceServiceTemplatesResource() {
        return confluenceServiceTemplatesResource;
    }

	@Override
	public String toString() {
		return "PropertiesConfig [confluenceServiceHost=" + confluenceServiceHost + ", confluenceServiceHealthResource="
				+ confluenceServiceHealthResource + ", confluenceServiceTemplatesResource="
				+ confluenceServiceTemplatesResource + "]";
	}

}
