package com.statravel.ms.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author STA Development Team
 *
 */
public class Template implements Serializable {

    /**
     * @param id
     * @param treeStructure
     * @param parentId
     * @param product
     * @param type
     * @param team
     * @param space
     * @param template
     * @param fields
     */
    public Template(final Integer id, final String treeStructure, final Integer parentId, final Product product, final Type type, final Team team,
            final Space space, final String template, final List<Field> fields) {
        super();
        this.id = id;
        this.treeStructure = treeStructure;
        this.parentId = parentId;
        this.product = product;
        this.type = type;
        this.team = team;
        this.space = space;
        this.template = template;
        this.fields = fields;
    }

    private static final long serialVersionUID = -257499051396575759L;

    private static final int PRIME_NUMBER = 31;

    @JsonIgnore
    private Integer id;

    private String treeStructure;

    private Integer parentId;

    @JsonIgnore
    private Product product;

    @JsonIgnore
    private Type type;

    @JsonIgnore
    private Team team;

    @JsonIgnore
    private Space space;

    private String template;

    @JsonIgnore
    private List<Field> fields = new ArrayList<Field>();

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return the treeStructure
     */
    public String getTreeStructure() {
        return treeStructure;
    }

    /**
     * @return the parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(final Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @param treeStructure
     *            the treeStructure to set
     */
    public void setTreeStructure(final String treeStructure) {
        this.treeStructure = treeStructure;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product
     *            the product to set
     */
    public void setProduct(final Product product) {
        this.product = product;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(final Type type) {
        this.type = type;
    }

    /**
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param team
     *            the team to set
     */
    public void setTeam(final Team team) {
        this.team = team;
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
    public void setTemplate(final String template) {
        this.template = template;
    }

    /**
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @param fields
     *            the fields to set
     */
    public void setFields(final List<Field> fields) {
        this.fields = fields;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = PRIME_NUMBER;
        int result = 1;

        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((space == null) ? 0 : space.hashCode());
        result = prime * result + ((team == null) ? 0 : team.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());

        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Template)) {
            return false;
        }

        Template other = (Template) obj;

        if (parentId == null) {
            if (other.parentId != null) {
                return false;
            }
        } else if (!parentId.equals(other.parentId)) {
            return false;
        }

        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }

        if (space == null) {
            if (other.space != null) {
                return false;
            }
        } else if (!space.equals(other.space)) {
            return false;
        }

        if (team == null) {
            if (other.team != null) {
                return false;
            }
        } else if (!team.equals(other.team)) {
            return false;
        }

        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }

        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Template [id=" + id + ", treeStructure=" + treeStructure + ", parentId=" + parentId + ", product=" + product + ", type=" + type
                + ", team=" + team + ", space=" + space + ", template=" + template + ", fields=" + fields + "]";
    }

}
