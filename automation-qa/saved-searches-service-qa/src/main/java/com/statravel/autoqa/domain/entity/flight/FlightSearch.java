package com.statravel.autoqa.domain.entity.flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import com.statravel.autoqa.domain.entity.Search;

/**
 * @author STA development team
 *
 */
@Entity
@Table(name = "flight_search")
public class FlightSearch implements Serializable {

    private static final long serialVersionUID = -8180948295886773091L;

    private static final int PRIME_NUMBER = 31;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number_of_adults")
    private Byte numberOfAdults;

    @Column(name = "number_of_students")
    private Byte numberOfStudents;

    @Column(name = "number_of_under_26")
    private Byte numberOfUnder26;

    @Column(name = "number_of_teachers")
    private Byte numberOfTeachers;

    @Column(name = "cheapest_price")
    private double cheapestPrice;

    @Column(name = "cabin_class")
    private String cabinClass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "search_id", referencedColumnName = "id")
    private Search search;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    @Valid
    private List<FlightDestination> flightDestinationList = new ArrayList<>();

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
     * @return the numberOfAdults
     */
    public Byte getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * @param numberOfAdults
     *            the numberOfAdults to set
     */
    public void setNumberOfAdults(final Byte numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    /**
     * @return the numberOfStudents
     */
    public Byte getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * @param numberOfStudents
     *            the numberOfStudents to set
     */
    public void setNumberOfStudents(final Byte numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * @return the numberOfUnder26
     */
    public Byte getNumberOfUnder26() {
        return numberOfUnder26;
    }

    /**
     * @param numberOfUnder26
     *            the numberOfUnder26 to set
     */
    public void setNumberOfUnder26(final Byte numberOfUnder26) {
        this.numberOfUnder26 = numberOfUnder26;
    }

    /**
     * @return the numberOfTeachers
     */
    public Byte getNumberOfTeachers() {
        return numberOfTeachers;
    }

    /**
     * @param numberOfTeachers
     *            the numberOfTeachers to set
     */
    public void setNumberOfTeachers(final Byte numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }

    /**
     * @return the cheapestPrice
     */
    public double getCheapestPrice() {
        return cheapestPrice;
    }

    /**
     * @param cheapestPrice
     *            the cheapestPrice to set
     */
    public void setCheapestPrice(final double cheapestPrice) {
        this.cheapestPrice = cheapestPrice;
    }

    /**
     * @return the cabinClass
     */
    public String getCabinClass() {
        return cabinClass;
    }

    /**
     * @param cabinClass
     *            the cabinClass to set
     */
    public void setCabinClass(final String cabinClass) {
        this.cabinClass = cabinClass;
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

    /**
     * @return the flightDestinationList
     */
    public List<FlightDestination> getFlightDestinationList() {
        return flightDestinationList;
    }

    /**
     * @param flightDestinationList
     *            the flight destination list to set
     */
    public void setFlightDestinationList(final List<FlightDestination> flightDestinationList) {
        this.flightDestinationList = flightDestinationList;
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

        result = prime * result + ((flightDestinationList == null) ? 0 : flightDestinationList.hashCode());
        result = prime * result + ((numberOfAdults == null) ? 0 : numberOfAdults.hashCode());
        result = prime * result + ((numberOfStudents == null) ? 0 : numberOfStudents.hashCode());
        result = prime * result + ((numberOfTeachers == null) ? 0 : numberOfTeachers.hashCode());
        result = prime * result + ((numberOfUnder26 == null) ? 0 : numberOfUnder26.hashCode());

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

        if (!(obj instanceof FlightSearch)) {
            return false;
        }

        FlightSearch other = (FlightSearch) obj;

        if (flightDestinationList == null) {
            if (other.flightDestinationList != null) {
                return false;
            }
        } else if (!flightDestinationList.containsAll(other.flightDestinationList)
                || !other.flightDestinationList.containsAll(flightDestinationList)) {
            return false;
        }

        if (numberOfAdults == null) {
            if (other.numberOfAdults != null) {
                return false;
            }
        } else if (!numberOfAdults.equals(other.numberOfAdults)) {
            return false;
        }

        if (numberOfStudents == null) {
            if (other.numberOfStudents != null) {
                return false;
            }
        } else if (!numberOfStudents.equals(other.numberOfStudents)) {
            return false;
        }

        if (numberOfTeachers == null) {
            if (other.numberOfTeachers != null) {
                return false;
            }
        } else if (!numberOfTeachers.equals(other.numberOfTeachers)) {
            return false;
        }

        if (numberOfUnder26 == null) {
            if (other.numberOfUnder26 != null) {
                return false;
            }
        } else if (!numberOfUnder26.equals(other.numberOfUnder26)) {
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
        return "FlightSearch [id=" + id + ", numberOfAdults=" + numberOfAdults + ", numberOfStudents=" + numberOfStudents + ", numberOfUnder26="
                + numberOfUnder26 + ", numberOfTeachers=" + numberOfTeachers + ", cabinClass=" + cabinClass + ", flightDestinationList="
                + flightDestinationList + "]";
    }

}
