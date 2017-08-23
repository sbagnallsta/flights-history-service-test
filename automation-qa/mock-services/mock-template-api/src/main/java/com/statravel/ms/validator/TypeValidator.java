package com.statravel.ms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.statravel.ms.validator.annotation.ValidType;

/**
 *
 * @author STA Development Team
 *
 */
@Component
public class TypeValidator implements ConstraintValidator<ValidType, String> {

    /*
     * (non-Javadoc)
     *
     * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public void initialize(final ValidType arg0) {

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {

        if (value == null) {

            return false;

        }

        return true;

    }

}
