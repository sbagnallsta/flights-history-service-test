package com.statravel.ms.exception;

/**
 * @author STA Development Team
 *
 */
public class InternalServerErrorException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1750760230601845351L;

	/**
     * Default constructor.
     */
    public InternalServerErrorException() {
        super();
    }

    /**
     *
     * @param message
     *            exception message
     */
    public InternalServerErrorException(final String message) {
        super(message);
    }

    /**
     *
     * @param cause
     *            exception cause
     */
    public InternalServerErrorException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     *            exception message
     * @param cause
     *            cause exception cause
     */
    public InternalServerErrorException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
