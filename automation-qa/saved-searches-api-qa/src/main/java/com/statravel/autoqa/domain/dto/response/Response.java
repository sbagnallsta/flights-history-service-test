package com.statravel.autoqa.domain.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(Include.NON_NULL)
public final class Response implements Serializable {

    private static final long serialVersionUID = 4791965696334331363L;

    private static final int PRIME_NUMBER = 31;

    private Object data;
    private List<Error> errors;

    /**
     * 
     */
    public Response() {

    }

    /**
     * 
     * @param data
     *            data
     */
    public Response(final Object data) {
        this.data = data;
    }

    /**
     * 
     * @param errors
     *            list of errors
     */
    public Response(final List<Error> errors) {
        this.errors = errors;

    }

    /**
     * 
     * @param error
     *            error
     */
    public Response(final Error error) {

        this.errors = new ArrayList<Error>();
        errors.add(error);

    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @return the errors
     */
    public List<Error> getErrors() {
        return errors;
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

        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((errors == null) ? 0 : errors.hashCode());

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

        if (!(obj instanceof Response)) {
            return false;
        }

        Response other = (Response) obj;

        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }

        if (errors == null) {
            if (other.errors != null) {
                return false;
            }
        } else if (!errors.equals(other.errors)) {
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
        return "Response [data=" + data + ", errors=" + errors + "]";
    }

}
