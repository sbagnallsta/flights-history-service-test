package com.statravel.autoqa.domain.payload;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author STA Development Team.
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class TagPayLoad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4983198241740974990L;
	
	private String tagName;
	
	private String body;

    private String repository;

    /**
     * 
     * @param tagName
     * 			tag name
     * @param body
     * 			bode message
     * @param repository
     * 			repository
     */
    public TagPayLoad(final String tagName, final String body, final String repository) {

        this.tagName = tagName;
        this.body = body;
        this.repository = repository;

    }

	/**
	 * 
	 * @return tag name
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * 
	 * @return body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 
	 * @return repository
	 */
	public String getRepository() {
		return repository;
	}

	@Override
	public String toString() {
		return "PlayLoad [tagName=" + tagName + ", body=" + body + ", repository=" + repository + "]";
	}

}
