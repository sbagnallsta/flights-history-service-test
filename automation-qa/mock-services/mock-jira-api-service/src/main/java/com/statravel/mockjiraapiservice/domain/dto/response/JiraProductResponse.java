/**
 * 
 */
package com.statravel.mockjiraapiservice.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "self", "id", "name", "archived", "released", "startDate", "releaseDate", "userStartDate", "userReleaseDate", "projectId" })
public class JiraProductResponse {

    private static final String SELF = "https://statravel.atlassian.net/rest/api/2/version/";
    
    @JsonProperty("self")
    private String self;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("archived")
    private Boolean archived;
    
    @JsonProperty("released")
    private Boolean released;
    
    @JsonProperty("startDate")
    private String startDate;
    
    @JsonProperty("releaseDate")
    private String releaseDate;
    
    @JsonProperty("userStartDate")
    private String userStartDate;
    
    @JsonProperty("userReleaseDate")
    private String userReleaseDate;
    
    @JsonProperty("projectId")
    private Integer projectId;


    /**
     * @param id
     *            id
     * @param name
     *            name
     * @param released
     *            released
     */
    public JiraProductResponse(final String id, final String name, final Boolean released) {
        super();
        this.self = SELF + id;
        this.id = id;
        this.name = name;
        this.archived = false;
        this.released = released;
        this.startDate = "2016-02-22";
        this.releaseDate = "2016-03-09";
        this.userStartDate = "22/Feb/16";
        this.userReleaseDate = "09/Mar/16";
        this.projectId = 10003;
    }
    
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
     * @param self self
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
     * @param id id
     */
    @JsonProperty("id")
    public void setId(final String id) {
        this.id = id;
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
     * @param name name
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
     * @param archived archived
     */
    @JsonProperty("archived")
    public void setArchived(final Boolean archived) {
        this.archived = archived;
    }

    /**
     * 
     * @return release
     */
    @JsonProperty("released")
    public Boolean getReleased() {
        return released;
    }

    /**
     * 
     * @param released released
     */
    @JsonProperty("released")
    public void setReleased(final Boolean released) {
        this.released = released;
    }

    /**
     * 
     * @return startDate
     */
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate startDate
     */
    @JsonProperty("startDate")
    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    /**
     * 
     * @return releaseDate
     */
    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * 
     * @param releaseDate releaseDate
     */
    @JsonProperty("releaseDate")
    public void setReleaseDate(final String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 
     * @return userStartDate
     */
    @JsonProperty("userStartDate")
    public String getUserStartDate() {
        return userStartDate;
    }

    /**
     * 
     * @param userStartDate userStartDate
     */
    @JsonProperty("userStartDate")
    public void setUserStartDate(final String userStartDate) {
        this.userStartDate = userStartDate;
    }

    /**
     * 
     * @return userReleaseDate
     */
    @JsonProperty("userReleaseDate")
    public String getUserReleaseDate() {
        return userReleaseDate;
    }

    /**
     * 
     * @param userReleaseDate userReleaseDate
     */
    @JsonProperty("userReleaseDate")
    public void setUserReleaseDate(final String userReleaseDate) {
        this.userReleaseDate = userReleaseDate;
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
     * @param projectId projectId
     */
    @JsonProperty("projectId")
    public void setProjectId(final Integer projectId) {
        this.projectId = projectId;
    }

}
