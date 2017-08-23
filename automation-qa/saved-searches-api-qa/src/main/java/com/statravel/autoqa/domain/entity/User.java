package com.statravel.autoqa.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author STA development team
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 2109813055971173905L;

    private static final int PRIME_NUMBER = 31;

    @Id
    private String id;

    @Column(name = "is_mysta_user")
    private boolean mystaUser;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Search> searchList = new ArrayList<Search>();

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
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = PRIME_NUMBER;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());

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

        if (!(obj instanceof User)) {
            return false;
        }

        User other = (User) obj;

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
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
        return "user [id=" + id + ", isMystaUser=" + mystaUser + "]";
    }

}
