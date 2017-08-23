package com.statravel.ms.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author STA Development Team
 *
 */
public class Field implements Serializable {

    private static final long serialVersionUID = 85406027487423098L;

    private static final int PRIME_NUMBER = 31;

    private Integer id;

    private String name;

    private List<ValidationRule> validationRules = new ArrayList<ValidationRule>();

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the validationRules
     */
    public List<ValidationRule> getValidationRules() {
        return validationRules;
    }

    /**
     * @param validationRules
     *            the validationRules to set
     */
    public void setValidationRules(final List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
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

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());

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

        if (!(obj instanceof Field)) {
            return false;
        }

        Field other = (Field) obj;

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
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
        return "Field [id=" + id + ", name=" + name + ", validationRules=" + validationRules + "]";
    }

}
