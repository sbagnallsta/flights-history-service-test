package com.statravel.ms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.statravel.ms.domain.dto.response.ConfluenceAPIContent;
import com.statravel.ms.domain.dto.response.ConfluenceAPIErrorResponse;
import com.statravel.ms.domain.dto.response.ConfluenceAPISuccessResponse;
import com.statravel.ms.domain.dto.response.Data;
import com.statravel.ms.domain.payload.ContentPayload;

/**
 * @author STA Development Team
 *
 */
@RestController
@RequestMapping(value = "/content")
public class ContentController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ConfluenceAPIContent postContent(@RequestBody final ContentPayload contentPayload) {

        ConfluenceAPIContent response;

        if (contentPayload.toString().contains("COPY")) {

            String[] empty = new String[] {};

            Data data = new Data(false, true, empty, false);

            response = new ConfluenceAPIErrorResponse(400, "Error message from MOCK CONFLUENCE API", data);

        } else {

            response = new ConfluenceAPISuccessResponse(133343147, "page", "current", "Success message from MOCK CONFLUENCE API");
        }

        return response;

    }

}
