package com.statravel.ms.exception;

import java.util.ArrayList;
import java.util.List;
import com.statravel.ms.domain.dto.response.Error;

/**
 * @author STA Development Team
 *
 */
public class ValidatorException extends RuntimeException {

    private static final long serialVersionUID = 5736906000788476054L;

    private List<Error> errors = new ArrayList<Error>();

    /**
     * Default constructor.
     */
    public ValidatorException() {
        super();
    }

    /**
     *
     * @param errors
     *            List of errors
     */
    public ValidatorException(final List<Error> errors) {
        super();
        this.errors = errors;
    }

    /**
     *
     * @param message
     *            exception message
     */
    public ValidatorException(final String message) {
        super(message);
    }

    /**
     *
     * @param cause
     *            exception cause
     */
    public ValidatorException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     *            exception message
     * @param cause
     *            cause exception cause
     */
    public ValidatorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the errors
     */
    public List<Error> getErrors() {
        return errors;
    }

}
