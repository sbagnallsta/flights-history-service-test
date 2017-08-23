package com.statravel.mockjiraapiservice.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "self", "id", "description", "name", "archived", "released", "projectId" })
public class JiraVersionPutResponse {
    
    private static final String SELF_STRING = "https://statravel.atlassian.net/rest/api/2/version/";
    private static final String TESTING_DESCRIPTION = "Testing Release Description";
    private static final String TESTING_DESCRIPTION_NAME = "Testing Release Name";
    
    @JsonProperty("self")
    private String self;

    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("name")
    private String name;

    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("released")
    private Boolean released;

    @JsonProperty("projectId")
    private Integer projectId;

    /**
     * 
     * @return self
     */
    @JsonProperty("self")
    public String getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *            self
     */
    @JsonProperty("self")
    public void setSelf(final String self) {
        this.self = self;
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
     * @return description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *            description
     */
    @JsonProperty("description")
    public void setDescription(final String description) {
        this.description = description;
    }

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

    /**
     * 
     * @return projectId
     */
    @JsonProperty("projectId")
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 
     * @param projectId
     *            projectId
     */
    @JsonProperty("projectId")
    public void setProjectId(final Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @param id
     *            id
     * @param archived
     *            archived
     * @param released
     *            released
     * @param projectId
     *            projectId
     */
    public JiraVersionPutResponse(final String id, final Boolean archived,
            final Boolean released, final Integer projectId) {
        super();
        this.self = SELF_STRING + id;
        this.id = id;
        this.description = TESTING_DESCRIPTION;
        this.name = TESTING_DESCRIPTION_NAME;
        this.archived = archived;
        this.released = released;
        this.projectId = projectId;
    }

}
