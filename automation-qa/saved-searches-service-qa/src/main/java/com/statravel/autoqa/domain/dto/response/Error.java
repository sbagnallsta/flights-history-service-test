package com.statravel.autoqa.domain.dto.response;

import java.io.Serializable;

/**
 * 
 * @author STA Development Team
 *
 */
public class Error implements Serializable {

    private static final long serialVersionUID = -5138923206473581630L;

    private static final int PRIME_NUMBER = 31;   

    private String title;

    /**
     * 
     */
    public Error() {
        super();
    }

    /**
     * 
     * @param title
     *            title of the error found
     */
    public Error(final String title) {
        super();
        this.title = title;
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
    public void setTitle(final String title) {
        this.title = title;
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

        result = prime * result + ((title == null) ? 0 : title.hashCode());

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

        if (!(obj instanceof Error)) {
            return false;
        }

        Error other = (Error) obj;

        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
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
        return "Error [title=" + title + "]";
    }

}
