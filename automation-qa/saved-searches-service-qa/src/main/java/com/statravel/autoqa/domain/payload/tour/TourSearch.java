package com.statravel.autoqa.domain.payload.tour;

import java.io.Serializable;

/**
 * @author STA development team
 *
 */
public class TourSearch implements Serializable {

    private static final long serialVersionUID = 6002043243496722952L;

    private String duration;
    private String budget;
    private String destination;
    
    /**
     * 
     */
    public TourSearch() {
        
    }

    /**
     * 
     * @param duration duration
     * @param budget budget
     * @param destination destination
     */
    public TourSearch(final String duration, final String budget, final String destination) {
        
        super();
        this.duration = duration;
        this.budget = budget;
        this.destination = destination;
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

    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TourSearch [duration=" + duration + ", budget=" + budget + ", destination=" + destination + "]";
    }

   

}
