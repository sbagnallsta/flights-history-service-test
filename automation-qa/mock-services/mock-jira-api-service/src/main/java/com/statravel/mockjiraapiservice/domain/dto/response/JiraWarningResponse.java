/**
 * 
 */
package com.statravel.mockjiraapiservice.domain.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errorMessages", "warningMessages" })
public class JiraWarningResponse {

    @JsonProperty("errorMessages")
    private List<String> errorMessages = null;

    @JsonProperty("errors")
    private List<Object> errors = null;

    /**
     * 
     * @return errorMessages
     */
    @JsonProperty("errorMessages")
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * 
     * @param errorMessages
     *            the errors
     */
    @JsonProperty("errorMessages")
    public void setErrorMessages(final List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * 
     * @return warningMessages
     */
    @JsonProperty("warningMessages")
    public List<Object> getErrors() {
        return errors;
    }

    /**
     * 
     * @param errors
     *            errors
     */
    @JsonProperty("warningMessages")
    public void setErrors(final List<Object> errors) {
        this.errors = errors;
    }

    /**
     * @param errorMessages errors
     * @param errors errors
     */
    public JiraWarningResponse(final List<String> errorMessages, final List<Object> errors) {
        super();
        this.errorMessages = errorMessages;
        this.errors = errors;
    }

}
