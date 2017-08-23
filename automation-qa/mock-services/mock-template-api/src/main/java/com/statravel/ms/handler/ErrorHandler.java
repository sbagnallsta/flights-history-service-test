package com.statravel.ms.handler;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.statravel.ms.domain.dto.response.Error;
import com.statravel.ms.domain.dto.response.Response;
import com.statravel.ms.exception.InternalServerErrorException;
import com.statravel.ms.exception.NotFoundException;
import com.statravel.ms.exception.ValidatorException;

/**
 *
 * @author STA Development Team
 *
 */
@ControllerAdvice
@RestController
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    private static final String INTERNAL_ERROR_MESSAGE = "Internal server error, try again!";
    private static final String BAD_GATEWAY_ERROR_MESSAGE = "Bad gateway error, try again!";
    private static final String BAD_REQUEST_ERROR_MESSAGE = "{0} field is required!";
    private static final String BAD_REQUEST_INVALID_DATA_ERROR_MESSAGE = "Invalid data!";
    private static final String METHOD_NOT_ALLOWED_ERROR_MESSAGE = "{0} method not allowed on the requested resource!";
    private static final String MEDIA_TYPE_NOT_SUPPORTED_ERROR_MESSAGE = "Media type not supported!";
    private static final String NOT_FOUND_ERROR_MESSAGE = "Data required not found!";

    /**
     * Handles the bad requests when required parameters are not provided.
     *
     * @param missingServletRequestParameterException
     *            MissingServletRequestParameterException instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleException(final MissingServletRequestParameterException missingServletRequestParameterException) {

        String errorMessage = MessageFormat.format(BAD_REQUEST_ERROR_MESSAGE, missingServletRequestParameterException.getParameterName());

        LOGGER.warn(errorMessage, missingServletRequestParameterException);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(new Error(errorMessage)));

    }

    /**
     * Handles the bad requests when invalid data types are provided.
     *
     * @param httpMessageNotReadableException
     *            HttpMessageNotReadableException instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleException(final HttpMessageNotReadableException httpMessageNotReadableException) {

        LOGGER.warn(BAD_REQUEST_INVALID_DATA_ERROR_MESSAGE, httpMessageNotReadableException);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(new Error(BAD_REQUEST_INVALID_DATA_ERROR_MESSAGE)));

    }

    /**
     * Handles the bad requests when parameters are not valid.
     *
     * @param validatorException
     *            ValidatorException instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ValidatorException.class)
    public ResponseEntity<?> handleException(final ValidatorException validatorException) {

        String errorMessage = MessageFormat.format(BAD_REQUEST_ERROR_MESSAGE, validatorException.getErrors());

        LOGGER.warn(errorMessage, validatorException);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(validatorException.getErrors()));

    }

    /**
     * Handles the 404 errors.
     *
     * @param notFoundException
     *            NotFoundException instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> handleException(final NotFoundException notFoundException) {

        LOGGER.info(NOT_FOUND_ERROR_MESSAGE, notFoundException);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    /**
     * Handles the bad requests when required parameters are not provided.
     *
     * @param httpRequestMethodNotSupportedException
     *            HttpRequestMethodNotSupportedException instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleException(final HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {

        String errorMessage = MessageFormat.format(METHOD_NOT_ALLOWED_ERROR_MESSAGE, httpRequestMethodNotSupportedException.getMethod());

        LOGGER.warn(errorMessage, httpRequestMethodNotSupportedException);

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new Response(new Error(errorMessage)));

    }

    /**
     * Handles Unsupported Media Type Requests.
     *
     * @param httpMediaTypeException
     *            HttpMediaTypeException instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(value = HttpMediaTypeException.class)
    public ResponseEntity<?> handleException(final HttpMediaTypeException httpMediaTypeException) {

        LOGGER.warn(MEDIA_TYPE_NOT_SUPPORTED_ERROR_MESSAGE, httpMediaTypeException);

        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(new Response(new Error(MEDIA_TYPE_NOT_SUPPORTED_ERROR_MESSAGE)));

    }

    /**
     * Handles the internal server errors.
     *
     * @param exception
     *            Exception instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleException(final Exception exception) {

        LOGGER.error(INTERNAL_ERROR_MESSAGE, exception);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(new Error(INTERNAL_ERROR_MESSAGE)));

    }
    
    /**
     * Handles bad gateway errors.
     *
     * @param badGatewayException
     *            badGatewayException instance
     * @return response entity
     */
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(value = InternalServerErrorException.class)
    public ResponseEntity<?> handleException(final InternalServerErrorException badGatewayException) {

        LOGGER.error(BAD_GATEWAY_ERROR_MESSAGE, badGatewayException);

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new Response(new Error(BAD_GATEWAY_ERROR_MESSAGE)));

    }

}
