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

    @Value("${resource.github.tags.url}")
    private String githubTagsResourceUrl;
    
    @Value("${resource.github.files.url}")
    private String githubFilessResourceUrl;
    

    /**
     * 
     * @return gitHub tags resource
     */
	public String getGithubTagsResourceUrl() {
		return githubTagsResourceUrl;
	}

	/**
	 * 
	 * @return gitHub files resource
	 */
	public String getGithubFilessResourceUrl() {
		return githubFilessResourceUrl;
	}

	@Override
	public String toString() {
		return "PropertiesConfig [githubTagsResourceUrl=" + githubTagsResourceUrl + ", githubFilessResourceUrl="
				+ githubFilessResourceUrl + "]";
	}

  
}
