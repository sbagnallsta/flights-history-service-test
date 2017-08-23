package com.statravel.mockjiraapiservice.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author STA Development Team
 *
 */
@JsonPropertyOrder({ "name", "id", "released", "archived" })
public class JiraVersionRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("released")
    private Boolean released;

    @JsonProperty("archived")
    private Boolean archived;

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
     * @return id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *            id
     */
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
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

}
