package com.statravel.jiraserviceqa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author STA Development Team
 *
 */
@Component
public class ApplicationProperties {
    
    private static final String VERSIONS = "versions";
    
    @Value("${jira.resource.url}")
    private String jiraResourceUrl;
    
    @Value("${jira.api.versions.url}")
    private String jiraApiVersionsUrl;

    /**
     * @return the jiraResourceUrl
     */
    public String getJiraResourceUrl() {
        return jiraResourceUrl;
    }

    /**
     * @param jiraResourceUrl the jiraResourceUrl to set
     */
    public void setJiraResourceUrl(final String jiraResourceUrl) {
        this.jiraResourceUrl = jiraResourceUrl;
    }

    /**
     * 
     * @return the versions url
     */
    public String getJiraVersionsUrl() {
        return jiraResourceUrl + VERSIONS;
    }

    /**
     * @return the jiraApiUrl
     */
    public String getJiraApiVersionsUrl() {
        return jiraApiVersionsUrl;
    }

    /**
     * @param jiraApiVersionsUrl the jiraApiVersionsUrl to set
     */
    public void setJiraApiVersionsUrl(final String jiraApiVersionsUrl) {
        this.jiraApiVersionsUrl = jiraApiVersionsUrl;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ApplicationProperties [jiraResourceUrl=" + jiraResourceUrl + ", jiraApiVersionsUrl=" + jiraApiVersionsUrl + "]";
    }
        

}