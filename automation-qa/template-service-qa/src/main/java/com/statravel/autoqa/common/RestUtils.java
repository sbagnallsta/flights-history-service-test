package com.statravel.autoqa.common;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class RestUtils {

    /**
     * 
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

}
