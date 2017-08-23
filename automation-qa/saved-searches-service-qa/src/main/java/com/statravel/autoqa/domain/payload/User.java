package com.statravel.autoqa.domain.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author STA Development Team
 *
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2109813055971173905L;

    private String id;

    private boolean mystaUser;

    private List<Search> searchList = new ArrayList<>();

    /**
     * 
     */
    public User() {
        super();
    }

    /**
     * @param id
     *            user id
     * @param mystaUser
     *            specify whether the user is registered MySTA or not.
     */
    public User(final String id, final boolean mystaUser) {
        this.id = id;
        this.mystaUser = mystaUser;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the mystaUser
     */
    public boolean isMystaUser() {

        return mystaUser;

    }

    /**
     * @param mystaUser
     *            the mystaUser to set
     */
    public void setMystaUser(final boolean mystaUser) {
        this.mystaUser = mystaUser;
    }

    /**
     * @return the searchList
     */
    public List<Search> getSearchList() {
        return searchList;
    }

    /**
     * @param searchList
     *            the searchList to set
     */
    public void setSearchList(final List<Search> searchList) {
        this.searchList = searchList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "user [id=" + id + ", mystaUser=" + mystaUser + "]";
    }

}
