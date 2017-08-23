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
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8673925453293025812L;
	
	private Object data;
    private List<Error> errors;

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
     * 
     * @param data
     *            data
     */
    public Response(final Object data) {
        this.data = data;
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Response [data=" + data + ", errors=" + errors + "]";
    }

}
