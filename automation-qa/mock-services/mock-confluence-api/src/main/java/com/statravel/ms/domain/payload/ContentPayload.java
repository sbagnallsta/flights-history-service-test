package com.statravel.ms.domain.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author STA Development Team
 *
 */
public class ContentPayload {

    @JsonProperty("template")
    private String template;

    @JsonProperty("treeStructure")
    private String treeStructure;

    @JsonProperty("parentId")
    private String parentId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("space")
    @JsonInclude(Include.NON_NULL)
    private Space space;

    public class Space {
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(final String key) {
            this.key = key;
        }
    }

    /**
     * @return the template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * @param template
     *            the template to set
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * @return the treeStructure
     */
    public String getTreeStructure() {
        return treeStructure;
    }

    /**
     * @param treeStructure
     *            the treeStructure to set
     */
    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }

    /**
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the space
     */
    public Space getSpace() {
        return space;
    }

    /**
     * @param space
     *            the space to set
     */
    public void setSpace(final Space space) {
        this.space = space;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((space == null) ? 0 : space.hashCode());
        result = prime * result + ((template == null) ? 0 : template.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((treeStructure == null) ? 0 : treeStructure.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContentPayload other = (ContentPayload) obj;
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
            return false;
        if (space == null) {
            if (other.space != null)
                return false;
        } else if (!space.equals(other.space))
            return false;
        if (template == null) {
            if (other.template != null)
                return false;
        } else if (!template.equals(other.template))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (treeStructure == null) {
            if (other.treeStructure != null)
                return false;
        } else if (!treeStructure.equals(other.treeStructure))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ContentPayload [template=" + template + ", treeStructure=" + treeStructure + ", parentId=" + parentId + ", title=" + title
                + ", space=" + space + "]";
    }

}
