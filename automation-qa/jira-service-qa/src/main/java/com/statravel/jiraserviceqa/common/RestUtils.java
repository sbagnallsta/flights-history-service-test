package com.statravel.jiraserviceqa.common;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

/**
 * 
 * @author STA Development Team.
 *
 */
@Component
public class RestUtils { 
    
    /**
     * 
     * Parses the response body.
     * @param response
     *            response body object to be parsed
     * 
     * @param valueType
     *            Class type to return as parsed object
     * 
     * @param <T>
     *            Class type to return as parsed object
     * 
     * @return object parsed
     */
    public <T> T parseResponseBody(final Response response, final Class<T> valueType) {

        Gson gson = new Gson();

        return gson.fromJson(response.getBody().prettyPrint(), valueType);

    }
    
    /**
     * 
     * @param url the url we want to get
     * @return response
     */
    public Response performGetRequest(final String url) {
        
        return RestAssured.get(url);
        
    }
    
    /**
     * 
     * @param url the url we want to put to
     * @return a response
     */
    public Response performPutRequest(final String url) {
        
        return RestAssured.put(url);
    }
    
    
}
