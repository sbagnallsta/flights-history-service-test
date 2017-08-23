package com.statravel.autoqa.commons;

/**
 * 
 * @author STA Development Team
 *
 */
public final class AssertionMessages {

    public static final String PAGE_NOT_LOADED_LOGIN = "Login page has not been loaded";
    public static final String PAGE_NOT_LOADED_HOME = "Home page has not been loaded";
    public static final String PAGE_NOT_LOADED_FLIGHT_RESULT = "Flight result page has not been loaded";
    public static final String SEARCH_MESSAGE_NOT_DISPLAY = "Saved searches not displayed on homescreen";
    public static final String MOST_RECENT_SEARCH_NOT_DISPLAYED = "The most recent valid search is not the first search in the saved search dropdown";

    public static final String SAVED_SEARCH_COUNT_NOT_UPDATING = "The expected number of saved searches was {0}, but the actual was {1}";
    public static final String SAME_SAVED_SEARCHES_SHOULD_NOT_APPEAR_MORE_THEN_ONCE = "The first saved search, {0}, and the second saved search {0}, are the same";
    public static final String SAVED_SEARCH_COUNT_SHOULD_NOT_BE_ZERO = "There were no saved searches, where we were expecting at least 1";

    // Global
    public static final String RESULT_PAGE_LOADED = "Result page has been loaded";
    public static final String RESULT_PAGE_SEARCH_LOADED = "Searches have been loaded in the result page";
    public static final String ONE_WAY_SEARCH_NOT_DISPLAYED = "One-way search is not displayed in the saved search dropdown";
    public static final String RETURN_SEARCH_NOT_DISPLAYED = "Return search is not displayed in the saved search dropdown";
    public static final String MULTICITY_SEARCH_NOT_DISPLAYED = "Multi-City search is not displayed in the saved search dropdown";
    public static final String MULTICITY_SEARCH_DATES_NOT_DISPLAYED = "Multi-City dates are not displayed in the saved search dropdown";
    public static final String MULTICITY_FIRST_SEARCH_NOT_DISPLAYED = "Multi-City first search is not displayed in the saved search dropdown";
    public static final String MULTICITY_EDITED_SEARCH_NOT_DISPLAYED = "Multi-City edited search is not displayed in the saved search dropdown";
    public static final String ONE_WAY_OPTION_SELECTED = "One way option has been selected";
    public static final String RETURN_OPTION_SELECTED = "Return option has been selected";
    public static final String MULTI_CITY_OPTION_SELECTED = "Multi-city option has been selected";
    public static final String SAVED_SEARCH_ICON_NOT_DISPLAYED = "Saved search icon not displaying";

    /**
     * 
     */
    private AssertionMessages() {

    }
}
