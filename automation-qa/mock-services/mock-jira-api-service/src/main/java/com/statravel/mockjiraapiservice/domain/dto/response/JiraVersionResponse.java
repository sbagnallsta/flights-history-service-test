/**
 * 
 */
package com.statravel.mockjiraapiservice.domain.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.statravel.mockjiraapiservice.domain.dto.response.jiraversionresponse.Issue;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "total", "issues" })
public class JiraVersionResponse {
    
    @JsonProperty("total")
    private Integer total;

    @JsonProperty("issues")
    private List<Issue> issues = null;

    /**
     * 
     * @return total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total total
     */
    @JsonProperty("total")
    public void setTotal(final Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return issues
     */
    @JsonProperty("issues")
    public List<Issue> getIssues() {
        return issues;
    }

    /**
     * 
     * @param issues issues
     */
    @JsonProperty("issues")
    public void setIssues(final List<Issue> issues) {
        this.issues = issues;
    }

    /**
     * @param total total 
     * @param issues issues
     */
    public JiraVersionResponse(final Integer total, final List<Issue> issues) {
        super();
        this.total = total;
        this.issues = issues;
    }
    
    

}
