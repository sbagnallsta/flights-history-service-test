/**
 * 
 */
package com.statravel.mockjiraapiservice.domain.dto.response;

import java.util.ArrayList;
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
public class JiraErrorResponse {

    @JsonProperty("errorMessages")
    private List<String> errorMessages = null;

    @JsonProperty("warningMessages")
    private List<Object> warningMessages = null;

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
    public List<Object> getWarningMessages() {
        return warningMessages;
    }

    /**
     * 
     * @param warningMessages
     *            warnings
     */
    @JsonProperty("warningMessages")
    public void setWarningMessages(final List<Object> warningMessages) {
        this.warningMessages = warningMessages;
    }

    /**
     * @param errorMessages errors
     * @param warningMessages warnings
     */
    public JiraErrorResponse(final List<String> errorMessages, final List<Object> warningMessages) {
        super();
        this.errorMessages = errorMessages;
        this.warningMessages = warningMessages;
    }

    /**
     * @param errorMessage errorMessage
     */
    public JiraErrorResponse(final String errorMessage) {
        List<String> errorMessages = new ArrayList<String>();
        errorMessages.add(errorMessage);      
        this.errorMessages = errorMessages;
        this.warningMessages = null;
    }

}
