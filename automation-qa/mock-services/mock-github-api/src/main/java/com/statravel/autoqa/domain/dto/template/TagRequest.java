package com.statravel.autoqa.domain.dto.template;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * @author STA Development Team
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class TagRequest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2194672402168600833L;

	private static final int PRIME_NUMBER = 31;


	@JsonProperty("target_commitish")
    private String targetCommitish;

    @NotEmpty
    @JsonProperty("tag_name")
    private String tagName;
    
    @NotEmpty
    private String body;

    private boolean draft = false;
    
    private boolean prerelease = false;
    

	public String getTargetCommitish() {
		return targetCommitish;
	}

	public void setTargetCommitish(final String targetCommitish) {
		this.targetCommitish = targetCommitish;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(final String tagName) {
		this.tagName = tagName;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(final boolean draft) {
		this.draft = draft;
	}

	public boolean isPrerelease() {
		return prerelease;
	}

	public void setPrerelease(final boolean prerelease) {
		this.prerelease = prerelease;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME_NUMBER;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + (draft ? 1231 : 1237);
		result = prime * result + (prerelease ? 1231 : 1237);
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + ((targetCommitish == null) ? 0 : targetCommitish.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TagRequest other = (TagRequest) obj;
		if (body == null) {
			if (other.body != null) {
				return false;
			}
		} else if (!body.equals(other.body)) {
			return false;
		}
		if (draft != other.draft) {
			return false;
		}
		if (prerelease != other.prerelease) {
			return false;
		}
		if (tagName == null) {
			if (other.tagName != null) {
				return false;
			}
		} else if (!tagName.equals(other.tagName)) {
			return false;
		}
		if (targetCommitish == null) {
			if (other.targetCommitish != null) {
				return false;
			}
		} else if (!targetCommitish.equals(other.targetCommitish)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TagRequest [targetCommitish=" + targetCommitish + ", tagName=" + tagName + ", body=" + body + ", draft="
				+ draft + ", prerelease=" + prerelease + "]";
	}
    
	
}
