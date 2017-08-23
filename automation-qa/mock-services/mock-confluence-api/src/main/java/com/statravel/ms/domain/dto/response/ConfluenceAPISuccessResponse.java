package com.statravel.ms.domain.dto.response;

/**
 * @author STA Development Team
 *
 */
public class ConfluenceAPISuccessResponse extends ConfluenceAPIContent {

    private int id;
    private String type;
    private String status;
    private String title;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @param id
     *            id
     * @param type
     *            type
     * @param status
     *            status
     * @param title
     *            title
     */
    public ConfluenceAPISuccessResponse(final int id, final String type, final String status, final String title) {
        super();
        this.id = id;
        this.type = type;
        this.status = status;
        this.title = title;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ConfluenceAPISuccessResponse [id=" + id + ", type=" + type + ", status=" + status + ", title=" + title + "]";
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
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

}
