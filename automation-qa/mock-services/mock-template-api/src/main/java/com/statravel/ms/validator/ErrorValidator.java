package com.statravel.ms.validator;

import org.springframework.stereotype.Component;

import com.statravel.ms.exception.InternalServerErrorException;
import com.statravel.ms.exception.NotFoundException;


/**
 * @author STA Development Team
 *
 */
@Component
public class ErrorValidator {


    private static final String BAD_GATEWAY_ERROR = "502";
    private static final String NOT_FOUND_ERROR = "404";

	/**
     * Generates a bad .
     *
     * @param product
     *            product request
     *
     */
    public void validate(final String product) {

       
    	if (product.equals(BAD_GATEWAY_ERROR)) {
    		
    		 throw new InternalServerErrorException();
    		
    	}
    	
    	if (product.equals(NOT_FOUND_ERROR)) {
    	    
    	    throw new NotFoundException();
    	}

    }

}
