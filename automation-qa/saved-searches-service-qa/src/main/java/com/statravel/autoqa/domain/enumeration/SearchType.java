package com.statravel.autoqa.domain.enumeration;

/**
 * 
 * @author STA Development Team
 *
 */
public enum SearchType {

    FLIGHT("flight"), INSURANCE("insurance"), TOUR("tour");

    private final String type;

    /**
     * 
     * @param type
     *            user type
     */
    SearchType(final String type) {
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

}
