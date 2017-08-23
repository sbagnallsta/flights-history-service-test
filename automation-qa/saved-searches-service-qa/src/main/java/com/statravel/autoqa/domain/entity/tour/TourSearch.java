package com.statravel.autoqa.domain.entity.tour;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.statravel.autoqa.domain.entity.Search;

/**
 * @author STA development team
 *
 */
@Entity
@Table(name = "tour_search")
public class TourSearch implements Serializable {

    private static final long serialVersionUID = 6002043243496722952L;

    private static final int PRIME_NUMBER = 31;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "duration")
    private String duration;

    @Column(name = "budget")
    private String budget;
    
    @Column(name = "destination")
    private String destination;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "search_id", referencedColumnName = "id")
    private Search search;

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
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }

    /**
     * @return the budget
     */
    public String getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(final String budget) {
        this.budget = budget;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(final String destination) {
        this.destination = destination;
    }

    /**
     * @return the search
     */
    public Search getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(final Search search) {
        this.search = search;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        
        final int prime = PRIME_NUMBER;
        int result = 1;
        
        result = prime * result + ((budget == null) ? 0 : budget.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        
        return result;
    }

    /* (non-Javadoc)
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        TourSearch other = (TourSearch) obj;
        if (budget == null) {
            if (other.budget != null) {
                return false;
            }
        } else if (!budget.equals(other.budget)) {
            return false;
        }
        if (destination == null) {
            if (other.destination != null) {
                return false;
            }
        } else if (!destination.equals(other.destination)) {
            return false;
        }
        if (duration == null) {
            if (other.duration != null) {
                return false;
            }
        } else if (!duration.equals(other.duration)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TourSearch [id=" + id + ", duration=" + duration + ", budget=" + budget + ", destination=" + destination + ", search=" + search + "]";
    }

   

}
