package com.statravel.autoqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.statravel.autoqa.domain.dto.template.FileRequest;
import com.statravel.autoqa.domain.dto.template.TagRequest;
import com.statravel.autoqa.service.RepositoryService;

/**
 * @author STA Development Team
 *
 */
@RestController
@RequestMapping("/repos/sta-travel")
public class GithubController {
	
	@Autowired
	private RepositoryService repositoryService;


    /**
     * Creates a tag with the information requested.
     * 
     * @param tagRequest
     *            data needed for the tag requested
     *            
     * @param repo
     * 			repository where tag will be created
     * 
     * @param releases
     * 			releases
     * 
     *
     * @return template parsed
     */
    @RequestMapping(value="/{repo}/releases", method = RequestMethod.POST)  
    @ResponseStatus(HttpStatus.CREATED)
    public void createTag(@RequestBody final TagRequest tagRequest, @PathVariable final String repo) {
    	        
    	if (!repositoryService.checkIfRepositoryIsValid(repo)) {
    		
    		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    	}

    }
    
    /**
     * Creates a file with the information requested.
     * 
     * @param fileRequest
     *            data needed for the file requested
     * 
     *
     * @return 201 http status code
     */
    @RequestMapping(value="/{repo}/contents/{fileName}", method = RequestMethod.PUT)  
    @ResponseStatus(HttpStatus.CREATED)
    public void createFile(@RequestBody final FileRequest fileRequest, @PathVariable final String repo) {  
    	
    	if (!repositoryService.checkIfRepositoryIsValid(repo)) {
    		
    		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    	}

    }

}
