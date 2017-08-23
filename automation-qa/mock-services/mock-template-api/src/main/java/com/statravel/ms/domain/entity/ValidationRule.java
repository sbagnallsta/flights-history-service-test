package com.statravel.ms.domain.entity;

import java.io.Serializable;

/**
 *
 * @author STA Development Team
 *
 */
public class ValidationRule implements Serializable {

    private static final long serialVersionUID = 85406027487423098L;

    private static final int PRIME_NUMBER = 31;

    private Integer id;

    private String rule;

    private String message;

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
     * @return the rule
     */
    public String getRule() {
        return rule;
    }

    /**
     * @param rule
     *            the rule to set
     */
    public void setRule(final String rule) {
        this.rule = rule;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
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

        result = prime * result + ((rule == null) ? 0 : rule.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());

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

        if (!(obj instanceof ValidationRule)) {
            return false;
        }

        ValidationRule other = (ValidationRule) obj;

        if (rule == null) {
            if (other.rule != null) {
                return false;
            }
        } else if (!rule.equals(other.rule)) {
            return false;
        }

        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
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
        return "ValidationRule [id=" + id + ", type=" + rule + ", message=" + message + "]";
    }

}
