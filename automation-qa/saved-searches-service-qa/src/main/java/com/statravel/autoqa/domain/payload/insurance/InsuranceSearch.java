package com.statravel.autoqa.domain.payload.insurance;

import java.io.Serializable;
import java.util.Date;

/**
 * @author STA development team
 *
 */
public class InsuranceSearch implements Serializable {

    private static final long serialVersionUID = 1562733649140639605L;

    private String policy;
    private String region;
    private Date startDate;
    private Date endDate;
    private Byte numberOfTravellers;

    /**
     * 
     */
    public InsuranceSearch() {

    }

    /**
     * @param policy
     *            policy
     * @param region
     *            region
     * @param startDate
     *            start date
     * @param endDate
     *            end date
     * @param numberOfTravellers
     *            number of travellers
     */
    public InsuranceSearch(final String policy, final String region, final Date startDate, final Date endDate, final Byte numberOfTravellers) {
        
        super();
        this.policy = policy;
        this.region = region;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfTravellers = numberOfTravellers;
    }

    /**
     * @return the policy
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * @param policy
     *            the policy to set
     */
    public void setPolicy(final String policy) {
        this.policy = policy;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     *            the region to set
     */
    public void setRegion(final String region) {
        this.region = region;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the numberOfTravellers
     */
    public Byte getNumberOfTravellers() {
        return numberOfTravellers;
    }

    /**
     * @param numberOfTravellers
     *            the numberOfTravellers to set
     */
    public void setNumberOfTravellers(final Byte numberOfTravellers) {
        this.numberOfTravellers = numberOfTravellers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "InsuranceSearch [policy=" + policy + ", region=" + region + ", startDate=" + startDate + ", endDate=" + endDate
                + ", numberOfTravellers=" + numberOfTravellers + "]";
    }

}
