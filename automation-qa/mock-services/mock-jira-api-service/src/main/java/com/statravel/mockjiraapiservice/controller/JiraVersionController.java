/**
 * 
 */
package com.statravel.mockjiraapiservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.statravel.mockjiraapiservice.domain.dto.request.JiraVersionRequest;
import com.statravel.mockjiraapiservice.domain.dto.response.JiraErrorResponse;
import com.statravel.mockjiraapiservice.domain.dto.response.JiraVersionPutResponse;

/**
 * @author STA Development Team
 *
 */
@RestController
@RequestMapping("/rest/api/2/version")
public class JiraVersionController {

    private static final String ERROR_MESSAGE = "Unrecognized field \"hello\" (Class com.atlassian.jira.rest.v2.issue.version.VersionBean), not marked as ignorable\n at [Source: org.apache.catalina.connector.CoyoteInputStream@1292c32; line: 4, column: 11] (through reference chain: com.atlassian.jira.rest.v2.issue.version.VersionBean[\"hello\"])";
 
    private static final String UNRELEASED = "unreleased";
    private static final String RELEASED = "released";
    private static final String FOUR_HUNDRED = "400";

    /**
     * 
     * @param id
     *            id
     * @param request
     *            request
     * @return response
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> version(@PathVariable final String id, @RequestBody final JiraVersionRequest request) {
        ResponseEntity<?> responseEntity;

        if (id.equals(RELEASED) || id.equals(UNRELEASED)) {

            JiraVersionPutResponse response = new JiraVersionPutResponse(id,
                    request.getArchived(), request.getReleased(), 10003);

            responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);

        } else if (id.equals(FOUR_HUNDRED)) {

            List<String> errorMessages = new ArrayList<String>();
            errorMessages.add(ERROR_MESSAGE);

            responseEntity = new ResponseEntity<Object>(errorMessages, HttpStatus.BAD_REQUEST);

        } else {

            JiraErrorResponse errorResponse = new JiraErrorResponse("Could not find version for id ' " + id + "'");

            responseEntity = new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);

        }
        
        return responseEntity;

    }

}
