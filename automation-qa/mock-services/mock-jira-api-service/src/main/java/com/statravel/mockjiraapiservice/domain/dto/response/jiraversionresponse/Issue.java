package com.statravel.mockjiraapiservice.domain.dto.response.jiraversionresponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "key", "fields" })
public class Issue {
    
    private static final String PROJ_KEY = "PROJ-key";

    @JsonProperty("fields")
    private Fields fields;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("key")
    private String key;
    

    /**
     * 
     * @return fields
     */
    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    /**
     * 
     * @param fields fields
     */
    @JsonProperty("fields")
    public void setFields(final Fields fields) {
        this.fields = fields;
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
     * @return id
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * 
     * @param key
     *            key
     */
    @JsonProperty("key")
    public void setKey(final String key) {
        this.key = key;
    }
    
    /**
     * @param fields fields
     * @param id id
     */
    public Issue(final Fields fields, final String id) {
        super();
        this.fields = fields;
        this.id = id;
        this.key = PROJ_KEY;
    }

}
