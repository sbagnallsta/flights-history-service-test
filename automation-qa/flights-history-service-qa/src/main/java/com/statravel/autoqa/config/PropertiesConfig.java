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
    
    @Value("${mongodb.database}")
    private String mongoDatabase;
    
    @Value("${mongodb.collection}")
    private String mongoCollection;
  
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
    public String getMongoDatabase() {
        return mongoDatabase;
    }

    /**
     * @return the mongoCollectionName
     */
    public String getMongoCollection() {
        return mongoCollection;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PropertiesConfig [hostUrl=" + hostUrl + ", mongoUrl=" + mongoUrl + ", mongoDatabase="
                + mongoDatabase + ", mongoCollection=" + mongoCollection + "]";
    }

}
