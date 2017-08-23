/**
 * 
 */
package com.statravel.mockjiraapiservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.statravel.mockjiraapiservice.domain.dto.response.JiraErrorResponse;
import com.statravel.mockjiraapiservice.domain.dto.response.JiraProductResponse;

/**
 * @author STA Development Team
 *
 */
@RestController
@RequestMapping("/rest/api/2/project")
public class JiraProjectController {
    
    private static final String UNRELEASED = "unreleased";
    private static final String RELEASED = "released";
    private static final String RELEASED_VERSION = "released version";
    private static final String UNRELEASED_VERSION = "unreleased version";
    
    /**
     * 
     * @param projectName projectName
     * @return response
     */
    @RequestMapping(value = "/{projectName}/versions", method = RequestMethod.GET)
    public ResponseEntity<?> project(@PathVariable final String projectName) { 
        
        ResponseEntity<?> responseEntity;
        
        if (projectName.equals(UNRELEASED)) {
            
            JiraProductResponse object = new JiraProductResponse(
                    UNRELEASED,
                    UNRELEASED_VERSION,
                    false
                    );
         
            
            List<JiraProductResponse> response = new ArrayList<JiraProductResponse>();
            response.add(object);
            responseEntity =  new ResponseEntity<Object>(response, HttpStatus.OK);
            
        } else if (projectName.equals(RELEASED)) {
            
            JiraProductResponse object = new JiraProductResponse(
                    RELEASED,
                    RELEASED_VERSION,
                    true
                    );
            
            List<JiraProductResponse> response = new ArrayList<JiraProductResponse>();
            response.add(object);
            responseEntity =  new ResponseEntity<Object>(response, HttpStatus.OK);
            
        } else {
            
            List<String> errorMessages = new ArrayList<String>();
            errorMessages.add("No project could be found with key '" + projectName + "'.");
            List<Object> errors = new ArrayList<Object>();
            
           
            JiraErrorResponse response = new JiraErrorResponse(errorMessages, errors);
            
            responseEntity =  new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
            
        }
        
        return responseEntity;
    }

}
