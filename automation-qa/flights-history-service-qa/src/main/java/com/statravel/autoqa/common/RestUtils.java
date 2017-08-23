package com.statravel.autoqa.common;


import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

/**
 * 
 * @author STA Development Team.
 *
 */
@Component
public class RestUtils { 
	
    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtils.class);

    private static final String JSON_MAPPING_EXCEPTION_MESSAGE = "Mapping failed!";

    /**
     * 
     * @param response
     *            response to be parsed
     * 
     * @param valueType
     *            Class type to return as parsed object
     * 
     * @param <T>
     *            Class type to return as parsed object
     * 
     * @return object parsed
     */
    public <T> T parseResponseBody(final com.statravel.autoqa.domain.payload.service.history.Response response, final Class<T> valueType) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writeValueAsString(response.getData());

            return mapper.readValue(jsonInString, valueType);

        } catch (IOException ioe) {

            LOGGER.warn(JSON_MAPPING_EXCEPTION_MESSAGE, ioe);

            return null;
        }

    }

    /**
     * Performs a POST request.
     * 
     * @param url
     *            url to perform the POST request
     * 
     * @param requestBody
     *            request body
     * 
     * @return response
     */
    public Response performPostRequest(final String url, final Object requestBody) {

        return RestAssured.given().contentType(MediaType.APPLICATION_JSON.toString()).body(requestBody).when().post(url);
    }

    /**
     * Performs a POST request.
     * 
     * @param url
     *            url to perform the POST request
     * 
     * @param parameters
     *            query parameters
     * 
     * @param requestBody
     *            request body
     * 
     * @return response
     */
    public Response performPostRequest(final String url, final Map<String, ?> parameters, final Object requestBody) {

        return RestAssured.given().queryParameters(parameters).contentType(MediaType.APPLICATION_JSON.toString()).body(requestBody).when().post(url);
    }

    /**
     * Performs a GET request.
     * 
     * @param url
     *            url to perform the GET request
     * 
     * @return response
     */
    public Response performGetRequest(final String url) {

        return RestAssured.when().get(url);

    }

    /**
     * Performs a GET request passing a path parameter.
     * 
     * @param url
     *            url to perform the GET request
     * 
     * @param parameters
     *            query parameters
     * 
     * @return response
     */
    public Response performGetRequest(final String url, final Map<String, ?> parameters) {

        return RestAssured.given().queryParameters(parameters).when().get(url);

    }

    /**
     * Performs a DELETE request.
     * 
     * @param url
     *            url to perform the DELETE request
     * 
     * @return response
     */
    public Response performDeleteRequest(final String url) {

        return RestAssured.when().delete(url);

    }

    /**
     * Performs a PUT request.
     * 
     * @param url
     *            url to perform the PUT request
     * 
     * @param requestBody
     *            request body
     * 
     * @return response
     */
    public Response performPutRequest(final String url, final Object requestBody) {

        return RestAssured.given().contentType(MediaType.APPLICATION_JSON.toString()).body(requestBody).when().put(url);
    }

    /**
     * Performs a PUT request.
     * 
     * @param url
     *            url to perform the PUT request
     * 
     * @param parameters
     *            query parameters
     * 
     * @param requestBody
     *            request body
     * 
     * @return response
     */
    public Response performPutRequest(final String url, final Map<String, ?> parameters, final Object requestBody) {

        return RestAssured.given().queryParameters(parameters).contentType(MediaType.APPLICATION_JSON.toString()).body(requestBody).when().put(url);
    }
    
}
