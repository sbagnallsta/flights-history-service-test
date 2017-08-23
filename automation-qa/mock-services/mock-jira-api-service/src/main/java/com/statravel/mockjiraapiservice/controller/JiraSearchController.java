/**
 * 
 */
package com.statravel.mockjiraapiservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.statravel.mockjiraapiservice.domain.dto.response.JiraErrorResponse;
import com.statravel.mockjiraapiservice.domain.dto.response.JiraVersionResponse;
import com.statravel.mockjiraapiservice.domain.dto.response.jiraversionresponse.Fields;
import com.statravel.mockjiraapiservice.domain.dto.response.jiraversionresponse.FixVersion;
import com.statravel.mockjiraapiservice.domain.dto.response.jiraversionresponse.Issue;

/**
 * @author STA Development Team
 *
 */
@RestController
@RequestMapping("/rest/api/2/search")
public class JiraSearchController {
    
    private static final String JQL_VERSION = "fixVersion=";
    private static final String JQL = "jql";
    private static final String UNRELEASED = "unreleased";
    private static final String RELEASED = "released";
    private static final String UNRELEASED_DESCRIPTION = "Unreleased DESCRIPTION";
    private static final String RELEASED_DESCRIPTION = "Released DESCRIPTION";
    
    /**
     * 
     * @param params params
     * @return a response
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> search(final @RequestParam Map<String, String> params) {
        ResponseEntity<?> responseEntity;
        
        String versionName = params.get(JQL);
        
        if (versionName.equals(JQL_VERSION + UNRELEASED)) {
        
            List<FixVersion> versions = new ArrayList<FixVersion>();
            versions.add(new FixVersion(false));
            
            Fields fields = new Fields(versions, UNRELEASED_DESCRIPTION);    
            List<Issue> issues = new ArrayList<Issue>();
            
            issues.add(new Issue(fields, UNRELEASED + "-id"));
            JiraVersionResponse response = new JiraVersionResponse(2, issues);
                       
            
            responseEntity = new ResponseEntity<Object>(response, HttpStatus.ACCEPTED);
            
        } else if (versionName.equals(JQL_VERSION + RELEASED)) {
            
            List<FixVersion> versions = new ArrayList<FixVersion>();
            versions.add(new FixVersion(true));
            
            Fields fields = new Fields(versions, RELEASED_DESCRIPTION);    
            List<Issue> issues = new ArrayList<Issue>();
            
            issues.add(new Issue(fields, RELEASED + "-id"));
            JiraVersionResponse response = new JiraVersionResponse(2, issues);
            
            responseEntity = new ResponseEntity<Object>(response, HttpStatus.ACCEPTED);
            
        } else {
 
            String query = versionName.substring(versionName.indexOf("=") + 1);
            String errorMessage = "The value '" + query + "' does not exist for the field 'fixVersion'.";
            JiraErrorResponse response = new JiraErrorResponse(errorMessage);
            
            responseEntity =  new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
            
        }
        return responseEntity;
    }

}
