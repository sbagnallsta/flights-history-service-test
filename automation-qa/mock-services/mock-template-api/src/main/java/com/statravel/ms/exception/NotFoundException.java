package com.statravel.ms.exception;

/**
 * @author STA Development Team
 *
 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5736906000788476054L;

    /**
     * Default constructor.
     */
    public NotFoundException() {
        super();
    }

    /**
     *
     * @param message
     *            exception message
     */
    public NotFoundException(final String message) {
        super(message);
    }

    /**
     *
     * @param cause
     *            exception cause
     */
    public NotFoundException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     *            exception message
     * @param cause
     *            cause exception cause
     */
    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
