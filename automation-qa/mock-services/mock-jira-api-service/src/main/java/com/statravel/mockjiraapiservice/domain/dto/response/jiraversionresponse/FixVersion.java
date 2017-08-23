package com.statravel.mockjiraapiservice.domain.dto.response.jiraversionresponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author STA Development Team
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "archived", "released" })
public class FixVersion {

    private static final String TEST_NAME = "Testing Release NAME";
    
    /**
     * @param released
     *            released
     */
    public FixVersion(final Boolean released) {
        super();
        this.name = TEST_NAME;
        this.archived = false;
        this.released = released;
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("released")
    private Boolean released;


    /**
     * 
     * @return name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *            name
     */
    @JsonProperty("name")
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * 
     * @return archived
     */
    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    /**
     * 
     * @param archived
     *            archived
     */
    @JsonProperty("archived")
    public void setArchived(final Boolean archived) {
        this.archived = archived;
    }

    /**
     * 
     * @return released
     */
    @JsonProperty("released")
    public Boolean getReleased() {
        return released;
    }

    /**
     * 
     * @param released
     *            released
     */
    @JsonProperty("released")
    public void setReleased(final Boolean released) {
        this.released = released;
    }
}