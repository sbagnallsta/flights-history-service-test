package com.statravel.autoqa.domain.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author STA Development Team
 *
 */
public final class FlightSearch implements Serializable {

    private static final long serialVersionUID = -8180948295886773091L;

    private int numberOfAdults;

    private int numberOfStudents;

    private int numberOfUnder26;

    private int numberOfTeachers;

    private boolean flexibleDate;

    private String cabinClass;

    private List<FlightDestination> flightDestinationList = new ArrayList<FlightDestination>();

    private List<PreferredAirline> preferredAirlineList = new ArrayList<PreferredAirline>();

    /**
     * 
     */
    public FlightSearch() {

    }

    /**
     * 
     * @param numberOfAdults
     *            number of adults
     * @param numberOfStudents
     *            number of students
     * @param numberOfUnder26
     *            number of under26
     * @param numberOfTeachers
     *            number of teachers
     * @param flexibleDate
     *            is date flexible
     * @param cabinClass
     *            cabin class
     */
    public FlightSearch(final int numberOfAdults, final int numberOfStudents, final int numberOfUnder26, final int numberOfTeachers,
            final boolean flexibleDate, final String cabinClass) {
        this.numberOfAdults = numberOfAdults;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUnder26 = numberOfUnder26;
        this.numberOfTeachers = numberOfTeachers;
        this.flexibleDate = flexibleDate;
        this.cabinClass = cabinClass;
    }

    /**
     * @return the numberOfAdults
     */
    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * @return the numberOfStudents
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * @return the numberOfUnder26
     */
    public int getNumberOfUnder26() {
        return numberOfUnder26;
    }

    /**
     * @return the numberOfTeachers
     */
    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }

    /**
     * @return the flexibleDate
     */
    public boolean isFlexibleDate() {
        return flexibleDate;
    }

    /**
     * @return the cabinClass
     */
    public String getCabinClass() {
        return cabinClass;
    }

    /**
     * @return the flightDestinationList
     */
    public List<FlightDestination> getFlightDestinationList() {
        return flightDestinationList;
    }

    /**
     * @param flightDestinationList
     *            the flightDestinationList to set
     */
    public void setFlightDestinationList(final List<FlightDestination> flightDestinationList) {
        this.flightDestinationList = flightDestinationList;
    }

    /**
     * @return the preferredAirlineList
     */
    public List<PreferredAirline> getPreferredAirlineList() {
        return preferredAirlineList;
    }

    /**
     * @param preferredAirlineList
     *            the preferredAirlineList to set
     */
    public void setPreferredAirlineList(final List<PreferredAirline> preferredAirlineList) {
        this.preferredAirlineList = preferredAirlineList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FlightSeach [numberOfAdults=" + numberOfAdults + ", numberOfStudents=" + numberOfStudents + ", numberOfUnder26=" + numberOfUnder26
                + ", numberOfTeachers=" + numberOfTeachers + ", flexibleDate=" + flexibleDate + ", cabinClass=" + cabinClass
                + ", flightDestinationList=" + flightDestinationList + ", preferredAirlineList=" + preferredAirlineList + "]";
    }

}
