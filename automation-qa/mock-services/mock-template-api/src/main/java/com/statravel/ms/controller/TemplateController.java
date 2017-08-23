package com.statravel.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.statravel.ms.domain.dto.response.Response;
import com.statravel.ms.domain.dto.template.TemplateRequest;
import com.statravel.ms.domain.entity.Template;
import com.statravel.ms.service.MockTemplateService;
import com.statravel.ms.validator.ErrorValidator;
import com.statravel.ms.validator.TemplateValidator;

/**
 * @author STA Development Team
 *
 */
@RestController
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private MockTemplateService templateService;

    @Autowired
    private TemplateValidator templateValidator;
    
    @Autowired
    private ErrorValidator errorValidator;

    private static final String COPY = "COPY";

    /**
     * Creates a template with the information requested.
     *
     * @param templateRequest
     *            data needed for the template requested
     *
     *
     * @return template parsed
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Response createTemplate(@RequestBody final TemplateRequest templateRequest) {
    	
        System.out.println(templateRequest);
        
    	errorValidator.validate(templateRequest.getProduct());

        templateValidator.validate(templateRequest);

        Template object;

        if (templateRequest.toString().contains(COPY)) {

            object = templateService.createInvalidTemplate();
           
        } else {

            object = templateService.createValidTemplate();

        }

        return new Response(object);

    }

}
