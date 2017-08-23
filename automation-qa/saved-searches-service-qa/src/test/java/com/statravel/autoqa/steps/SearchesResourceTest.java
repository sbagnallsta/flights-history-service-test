package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.common.Constants;
import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.common.SearchUtils;
import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.dto.response.Response;
import com.statravel.autoqa.domain.enumeration.SearchType;
import com.statravel.autoqa.domain.payload.Search;
import com.statravel.autoqa.domain.payload.User;
import com.statravel.autoqa.repository.SearchRepository;
import com.statravel.autoqa.runner.CucumberStepsDefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class SearchesResourceTest {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private SearchUtils searchUtils;

    private String searchesResourceUrl;
    private String usersResourceUrl;

    private com.jayway.restassured.response.Response searchResponse;

    /**
     * 
     */
    @After
    public void afterScenario() {

        searchRepository.deleteSearchByUserIdAndPos(this.applicationProperties.getMystaUserId(), this.applicationProperties.getPos());

        this.searchResponse = null;

    }

    /**
     * 
     */
    @Given("^I am on Saved Searches Service searches resource$")
    public void iAmOnSavedSearchesServiceSearchesResource() {

        this.searchesResourceUrl = this.applicationProperties.getHostUrl() + Constants.SEARCHES_RESOURCE;

        this.usersResourceUrl = this.applicationProperties.getHostUrl() + Constants.USERS_RESOURCE;
    }

    /**
     * @param searchType
     *            search type
     * 
     */
    @When("^I request a \"([^\"]*)\" search to be created against a MySTA user$")
    public void iRequestASearchToBeCreatedAgainstAMySTAUser(final String searchType) {

        if (SearchType.FLIGHT.name().equalsIgnoreCase(searchType)) {

            this.searchResponse = this.restUtils.performPostRequest(this.searchesResourceUrl,
                    this.searchUtils.buildFlightSearch(this.applicationProperties.getMystaUserId()));

        } else if (SearchType.INSURANCE.name().equalsIgnoreCase(searchType)) {

            this.searchResponse = this.restUtils.performPostRequest(this.searchesResourceUrl,
                    this.searchUtils.buildInsuranceSearch(this.applicationProperties.getMystaUserId()));

        } else if (SearchType.TOUR.name().equalsIgnoreCase(searchType)) {
            
            this.searchResponse = this.restUtils.performPostRequest(this.searchesResourceUrl,
                    this.searchUtils.buildTourSearch(this.applicationProperties.getMystaUserId()));

        }

    }

    /**
     * 
     * @param httpStatusCode
     *            HTTP status code
     */
    @Then("^I should get a (\\d+) HTTP status on searches resource$")
    public void iShouldGetAHTTPStatusCodeWhenOnSearchesResource(final int httpStatusCode) {

        assertThat(this.searchResponse.getStatusCode()).isEqualTo(httpStatusCode);

    }

    /**
     * @param searchType
     *            search type
     * 
     */
    @Then("^I should get the \"([^\"]*)\" search created payload$")
    public void iShouldGetTheSearchCreatedPayload(final String searchType) {

        Response response = this.searchResponse.as(Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNull();
        assertThat(response.getData()).isNotNull();

        Search search = this.restUtils.parseResponseBody(response, Search.class);

        assertThat(search.getUserId()).isEqualTo(this.applicationProperties.getMystaUserId());

        if (SearchType.FLIGHT.name().equalsIgnoreCase(searchType)) {

            assertThat(search.getFlightSearch()).isNotNull();
            assertThat(search.getInsuranceSearch()).isNull();
            assertThat(search.getTourSearch()).isNull();

        } else if (SearchType.INSURANCE.name().equalsIgnoreCase(searchType)) {

            assertThat(search.getInsuranceSearch()).isNotNull();
            assertThat(search.getFlightSearch()).isNull();
            assertThat(search.getTourSearch()).isNull();

        } else if (SearchType.TOUR.name().equalsIgnoreCase(searchType)) {

            assertThat(search.getInsuranceSearch()).isNull();
            assertThat(search.getFlightSearch()).isNull();
            assertThat(search.getTourSearch()).isNotNull();

        }

    }

    /**
     * 
     * @param numberOfSearches
     *            number of searches
     */
    @Then("^I should get (\\d+) searches in the system$")
    public void iShouldGetSearchInTheSystem(final int numberOfSearches) {

        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put(Constants.POS_CODE_QUERY_PARAMETER, this.applicationProperties.getPos());

        Response response = this.restUtils.performGetRequest(this.usersResourceUrl + this.applicationProperties.getMystaUserId(), parameters)
                                          .as(Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNull();
        assertThat(response.getData()).isNotNull();

        User user = this.restUtils.parseResponseBody(response, User.class);
        
        assertThat(user.getSearchList().size()).isEqualTo(numberOfSearches);

    }

    /**
     * 
     */
    @When("^I request to delete a search$")
    public void iRequestToDeleteASearch() {

        this.searchResponse = this.restUtils.performPostRequest(this.searchesResourceUrl,
                this.searchUtils.buildFlightSearch(this.applicationProperties.getMystaUserId()));

        Search search = this.restUtils.parseResponseBody(this.searchResponse.as(Response.class), Search.class);

        this.searchResponse = this.restUtils.performDeleteRequest(this.searchesResourceUrl + search.getSearchUuid());

    }

    /**
     * 
     */
    @And("^I should get no payload$")
    public void iShouldGetNoPayload() {

        assertThat(this.searchResponse.getBody().prettyPrint()).isEmpty();

    }

    /**
     * 
     */
    @When("^I delete the invalid searches from the system$")
    public void iDeleteTheInvalidSearchesFromTheSystem() {

        this.restUtils.performPostRequest(this.searchesResourceUrl,
                this.searchUtils.buildFlightInvalidSearch(this.applicationProperties.getMystaUserId()));

        assertThat(this.searchRepository.findByFlightSearchFlightDestinationListDepartureDateBefore(Calendar.getInstance().getTime())).isNotEmpty();

        this.searchResponse = this.restUtils.performDeleteRequest(this.searchesResourceUrl);

    }

    /**
     * 
     * @param searchType
     *            search type
     */
    @When("^I carry out two \"([^\"]*)\" searches with the same details$")
    public void iCarryOutTwoSearchesWithTheSameDetails(final String searchType) {

        Search search = null;
                
        if (SearchType.FLIGHT.name().equalsIgnoreCase(searchType)) {

            search = this.searchUtils.buildFlightSearch(this.applicationProperties.getMystaUserId());

        } else if (SearchType.INSURANCE.name().equalsIgnoreCase(searchType)) {

            search = this.searchUtils.buildInsuranceSearch(this.applicationProperties.getMystaUserId());

        } else if (SearchType.TOUR.name().equalsIgnoreCase(searchType)) {

            search = this.searchUtils.buildTourSearch(this.applicationProperties.getMystaUserId());

        }                

        this.searchResponse = this.restUtils.performPostRequest(this.searchesResourceUrl, search);

        this.searchResponse = this.restUtils.performPostRequest(this.searchesResourceUrl, search);

    }

}
