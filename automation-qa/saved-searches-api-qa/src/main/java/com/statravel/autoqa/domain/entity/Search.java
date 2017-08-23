package com.statravel.autoqa.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

/**
 * @author STA development team
 *
 */
@Entity
@Table(name = "search")
@NamedStoredProcedureQuery(name = "Search.cleanup", procedureName = "cleanUpSearches")
public class Search implements Serializable {

    private static final long serialVersionUID = -257499051396575759L;

    private static final int PRIME_NUMBER = 31;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "search_uuid")
    private String searchUuid;

    @Column(name = "pos")
    private String pos;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "search_query", columnDefinition = "text")
    private String searchQuery;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Valid
    @OneToOne(mappedBy = "search", cascade = CascadeType.ALL)
    private FlightSearch flightSearch;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the searchUuid
     */
    public String getSearchUuid() {
        return searchUuid;
    }

    /**
     * @param searchUuid
     *            the searchUuid to set
     */
    public void setSearchUuid(final String searchUuid) {
        this.searchUuid = searchUuid;
    }

    /**
     * @return the pos
     */
    public String getPos() {
        return pos;
    }

    /**
     * @param pos
     *            the pos to set
     */
    public void setPos(final String pos) {
        this.pos = pos;
    }

    /**
     * @return the searchQuery
     */
    public String getSearchQuery() {
        return searchQuery;
    }

    /**
     * @param searchQuery
     *            the searchQuery to set
     */
    public void setSearchQuery(final String searchQuery) {
        this.searchQuery = searchQuery;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */

    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * @return the flightSearch
     */
    public FlightSearch getFlightSearch() {
        return flightSearch;
    }

    /**
     * @param flightSearch
     *            the flightSearch to set
     */
    public void setFlightSearch(final FlightSearch flightSearch) {

        this.flightSearch = flightSearch;
        this.flightSearch.setSearch(this);
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the user id to set
     */
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * sets default value before save.
     */
    @PrePersist
    protected void onCreate() {
        if (date == null) {
            date = new Date();
        }
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

        result = prime * result + ((flightSearch == null) ? 0 : flightSearch.hashCode());
        result = prime * result + ((pos == null) ? 0 : pos.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());

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

        if (!(obj instanceof Search)) {
            return false;
        }

        Search other = (Search) obj;

        if (flightSearch == null) {
            if (other.flightSearch != null) {
                return false;
            }
        } else if (!flightSearch.equals(other.flightSearch)) {
            return false;
        }

        if (pos == null) {
            if (other.pos != null) {
                return false;
            }
        } else if (!pos.equals(other.pos)) {
            return false;
        }

        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
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
        return "Search [id=" + id + ", searchUuid=" + searchUuid + ", pos=" + pos + ", userId=" + userId + ", searchQuery=" + searchQuery + ", date="
                + date + ", flightSearch=" + flightSearch + "]";
    }

}
