package com.statravel.ms.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.statravel.ms.validator.ProductValidator;

/**
 *
 * @author STA Development Team
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = ProductValidator.class)
public @interface ValidProduct {

    /**
     *
     * @return validation message
     */
    String message() default "Product not valid!";

    /**
     *
     * @return validation groups
     */
    Class<?>[] groups() default {};

    /**
     *
     * @return validation payload
     */
    Class<? extends Payload>[] payload() default {};

}
