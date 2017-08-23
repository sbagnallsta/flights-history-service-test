package com.statravel.autoqa.domain.entity.insurance;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.statravel.autoqa.domain.entity.Search;

/**
 * @author STA development team
 *
 */
@Entity
@Table(name = "insurance_search")
public class InsuranceSearch implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceSearch.class);

    private static final long serialVersionUID = 4849401603454779639L;

    private static final String DATES_PARSING_EXCEPTION_LOGGER_MESSAGE = "Dates {0} and {1} not parsed!";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final int PRIME_NUMBER = 31;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "policy")
    private String policy;

    @Column(name = "region")
    private String region;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "number_of_travellers")
    private Byte numberOfTravellers;

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

    /**
     * @return the search
     */
    public Search getSearch() {
        return search;
    }

    /**
     * @param search
     *            the search to set
     */
    public void setSearch(final Search search) {
        this.search = search;
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

        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((numberOfTravellers == null) ? 0 : numberOfTravellers.hashCode());
        result = prime * result + ((policy == null) ? 0 : policy.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());

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

        if (!(obj instanceof InsuranceSearch)) {
            return false;
        }

        InsuranceSearch other = (InsuranceSearch) obj;

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {

            endDate = dateFormat.parse(dateFormat.format(endDate));
            other.endDate = dateFormat.parse(dateFormat.format(other.endDate));

        } catch (ParseException pe) {

            LOGGER.warn(MessageFormat.format(DATES_PARSING_EXCEPTION_LOGGER_MESSAGE, endDate, other.endDate), pe);

            return false;
        }

        if (endDate == null) {
            if (other.endDate != null) {
                return false;
            }
        } else if (endDate.before(other.endDate) || endDate.after(other.endDate)) {
            return false;
        }

        if (numberOfTravellers == null) {
            if (other.numberOfTravellers != null) {
                return false;
            }
        } else if (!numberOfTravellers.equals(other.numberOfTravellers)) {
            return false;
        }

        if (policy == null) {
            if (other.policy != null) {
                return false;
            }
        } else if (!policy.equals(other.policy)) {
            return false;
        }

        if (region == null) {
            if (other.region != null) {
                return false;
            }
        } else if (!region.equals(other.region)) {
            return false;
        }

        try {

            startDate = dateFormat.parse(dateFormat.format(startDate));
            other.startDate = dateFormat.parse(dateFormat.format(other.startDate));

        } catch (ParseException pe) {

            LOGGER.warn(MessageFormat.format(DATES_PARSING_EXCEPTION_LOGGER_MESSAGE, startDate, other.startDate), pe);

            return false;
        }

        if (startDate == null) {
            if (other.startDate != null) {
                return false;
            }
        } else if (startDate.before(other.startDate) || startDate.after(other.startDate)) {
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
        return "InsuranceSearch [id=" + id + ", policy=" + policy + ", region=" + region + ", startDate=" + startDate + ", endDate=" + endDate
                + ", numberOfTravellers=" + numberOfTravellers + "]";
    }

}
