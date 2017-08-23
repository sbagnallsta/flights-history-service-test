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
	
    @Value("${mongodb.host}")
    private String mongoUrl;
    
    @Value("${mongodb.databaseName}")
    private String mongoDatabaseName;
    
    @Value("${mongodb.collectionName}")
    private String mongoCollectionName;
  
    /**
     * 
     * @return the flights history service health check endpoint
     */
    public String getHostUrl() {
        return hostUrl;
    }
    
    /**
     * 
     * @return the url for the mongo db
     */
    public String getMongoUrl() {
        return mongoUrl;
    }

    /**
     * @return the mongoDatabaseName
     */
    public String getMongoDatabaseName() {
        return mongoDatabaseName;
    }

    /**
     * @return the mongoCollectionName
     */
    public String getMongoCollectionName() {
        return mongoCollectionName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PropertiesConfig [hostUrl=" + hostUrl + ", mongoUrl=" + mongoUrl + ", mongoDatabaseName="
                + mongoDatabaseName + ", mongoCollectionName=" + mongoCollectionName + "]";
    }

}
