package com.statravel.ms.domain.dto.response;

/**
 * @author STA Development Team
 *
 */
public class ConfluenceAPIErrorResponse extends ConfluenceAPIContent {

    private int statusCode;
    private String message;
    private Data data;

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     *            the statusCode to set
     */
    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
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

    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(final Data data) {
        this.data = data;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ConfluenceAPIErrorResponse [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
    }

    /**
     * @param statusCode
     * @param message
     * @param data
     */
    public ConfluenceAPIErrorResponse(int statusCode, String message, Data data) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

}
