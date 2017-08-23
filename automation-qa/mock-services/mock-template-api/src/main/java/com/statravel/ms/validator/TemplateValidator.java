package com.statravel.ms.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.SmartValidator;

import com.statravel.ms.domain.dto.response.Error;
import com.statravel.ms.domain.dto.template.TemplateRequest;
import com.statravel.ms.exception.ValidatorException;

/**
 * @author STA Development Team
 *
 */
@Component
public class TemplateValidator {

    @Autowired
    private SmartValidator smartValidator;

    /**
     * Validates the template request.
     *
     * @param templateRequest
     *            template request
     *
     */
    public void validate(final TemplateRequest templateRequest) {

        DataBinder binder = new DataBinder(TemplateRequest.class);

        BindingResult validationResult = binder.getBindingResult();

        smartValidator.validate(templateRequest, validationResult);

        List<Error> errors = new ArrayList<>();

        for (ObjectError objectError : validationResult.getAllErrors()) {

            errors.add(new Error(objectError.getDefaultMessage()));
        }

        if (!errors.isEmpty()) {

            throw new ValidatorException(errors);

        }

    }

}
