package com.statravel.mockjiraapiservice.domain.dto.response.jiraversionresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "fixVersions", "customfield_11700" })
public class Fields {

    /**
     * @param fixVersions fixVersions
     * @param customfield customfield
     */
    public Fields(final List<FixVersion> fixVersions, final String customfield) {
        super();
        this.fixVersions = fixVersions;
        this.customfield = customfield;
    }

    @JsonProperty("customfield_11700")
    private String customfield;
    
    @JsonProperty("fixVersions")
    private List<FixVersion> fixVersions = null;

    /**
     * 
     * @return fixVersions
     */
    @JsonProperty("fixVersions")
    public List<FixVersion> getFixVersions() {
        return fixVersions;
    }

    /**
     * 
     * @param fixVersions fixVersions
     */
    @JsonProperty("fixVersions")
    public void setFixVersions(final List<FixVersion> fixVersions) {
        this.fixVersions = fixVersions;
    }
    
    /**
     * 
     * @return customfield
     */
    @JsonProperty("customfield_11700")
    public String getName() {
        return customfield;
    }

    /**
     * 
     * @param customfield
     *            customfield
     */
    @JsonProperty("customfield_11700")
    public void setName(final String customfield) {
        this.customfield = customfield;
    }

}
