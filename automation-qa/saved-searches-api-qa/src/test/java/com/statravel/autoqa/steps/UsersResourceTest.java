package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.statravel.autoqa.common.Constants;
import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.common.SearchUtils;
import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.dto.response.Response;
import com.statravel.autoqa.domain.payload.User;
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
public class UsersResourceTest {

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private SearchUtils searchUtils;

    @Autowired
    private ApplicationProperties applicationProperties;

    private String searchesResourceUrl;
    private String usersResourceUrl;

    private User mySTAUser;
    private User anonymousUser;

    private com.jayway.restassured.response.Response userResponse;

    /**
     * 
     */
    @After
    public void afterScenario() {

        this.mySTAUser = null;
        this.anonymousUser = null;
        this.userResponse = null;

    }

    /**
     * 
     */
    @Given("^I am on Saved Searches Service users resource$")
    public void iAmOnSavedSearchesServiceUsersResource() {

        searchesResourceUrl = this.applicationProperties.getHostUrl() + Constants.SEARCHES_RESOURCE;

        usersResourceUrl = this.applicationProperties.getHostUrl() + Constants.USERS_RESOURCE;

    }

    /**
     * 
     */
    @When("^I search for a MySTA user on the system$")
    public void iSearchForAMySTAUserOnTheSystem() {

        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put(Constants.POS_CODE_QUERY_PARAMETER, this.applicationProperties.getPos());

        this.userResponse = restUtils.performGetRequest(usersResourceUrl + this.applicationProperties.getMystaUserId(), parameters);

    }

    /**
     * 
     * @param httpStatusCode
     *            HTTP status code
     */
    @Then("^I should get a (\\d+) HTTP status code on users resource$")
    public void iShouldGetAHTTPStatusCode(final int httpStatusCode) {

        assertThat(this.userResponse.getStatusCode()).isEqualTo(httpStatusCode);
    }

    /**
     * 
     */
    @Then("^I should get the user payload$")
    public void iShouldGetTheUserPayload() {

        Response response = this.userResponse.as(Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNull();
        assertThat(response.getData()).isNotNull();

    }

    /**
     * 
     */
    @When("^I request a search to be created against an Anonymous user$")
    public void iRequestASearchToBeCreatedAgainstAnAnonymousUser() {

        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put(Constants.POS_CODE_QUERY_PARAMETER, this.applicationProperties.getPos());

        com.jayway.restassured.response.Response createUserResponse = restUtils.performPostRequest(usersResourceUrl, parameters, new User());

        assertThat(createUserResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED.value());

        Response userRes = createUserResponse.as(Response.class);

        assertThat(userRes).isNotNull();
        assertThat(userRes.getErrors()).isNull();
        assertThat(userRes.getData()).isNotNull();

        this.anonymousUser = restUtils.parseResponseBody(userRes, User.class);

        com.jayway.restassured.response.Response createSearchResponse = restUtils.performPostRequest(searchesResourceUrl,
                searchUtils.buildSearch(anonymousUser.getId()));

        assertThat(createSearchResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED.value());

        Response searchResponse = createUserResponse.as(Response.class);

        assertThat(searchResponse).isNotNull();
        assertThat(searchResponse.getErrors()).isNull();
        assertThat(searchResponse.getData()).isNotNull();

    }

    /**
     * 
     */
    @And("^I request a search to be created against a MySTA user$")
    public void iRequestASearchToBeCreatedAgainstAMySTAUser() {

        com.jayway.restassured.response.Response createSearchResponse = restUtils.performPostRequest(searchesResourceUrl,
                searchUtils.buildSearch(applicationProperties.getMystaUserId()));

        assertThat(createSearchResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED.value());

        Response searchResponse = createSearchResponse.as(Response.class);

        assertThat(searchResponse).isNotNull();
        assertThat(searchResponse.getErrors()).isNull();
        assertThat(searchResponse.getData()).isNotNull();

    }

    /**
     * 
     */
    @When("^I synchronise the searches of Anonymous user and MySTA user$")
    public void iSynchroniseTheSearchesOfAnonymousUserAndMySTAUser() {

        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put(Constants.POS_CODE_QUERY_PARAMETER, this.applicationProperties.getPos());

        // -------------------------- Anonymous User --------------------------

        com.jayway.restassured.response.Response getAnonymousUserResponse = restUtils.performGetRequest(usersResourceUrl + this.anonymousUser.getId(),
                parameters);

        assertThat(getAnonymousUserResponse.getStatusCode()).isEqualTo(HttpStatus.OK.value());

        Response userResp1 = getAnonymousUserResponse.as(Response.class);

        assertThat(userResp1).isNotNull();
        assertThat(userResp1.getErrors()).isNull();
        assertThat(userResp1.getData()).isNotNull();

        this.anonymousUser = restUtils.parseResponseBody(userResp1, User.class);

        assertThat(this.anonymousUser.getSearchList()).isNotEmpty();
        assertThat(this.anonymousUser.getSearchList().size()).isEqualTo(1);

        // -------------------------- MySTA User --------------------------

        com.jayway.restassured.response.Response getMySTAUserResponse = restUtils.performGetRequest(
                usersResourceUrl + this.applicationProperties.getMystaUserId(), parameters);

        assertThat(getMySTAUserResponse.getStatusCode()).isEqualTo(HttpStatus.OK.value());

        Response userResp2 = getMySTAUserResponse.as(Response.class);

        assertThat(userResp2).isNotNull();
        assertThat(userResp2.getErrors()).isNull();
        assertThat(userResp2.getData()).isNotNull();

        this.mySTAUser = restUtils.parseResponseBody(userResp2, User.class);

        assertThat(this.mySTAUser.getSearchList()).isNotEmpty();
        assertThat(this.mySTAUser.getSearchList().size()).isEqualTo(1);

        this.userResponse = restUtils.performPutRequest(this.usersResourceUrl + this.anonymousUser.getId(), parameters,
                this.applicationProperties.getMystaUserId());

    }

    /**
     * 
     */
    @And("^I should get the user payload with searches synchronised$")
    public void iShouldGetTheUserPayloadWithSearchesSynchronised() {

        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put(Constants.POS_CODE_QUERY_PARAMETER, this.applicationProperties.getPos());

        int oldMySTASearchListSize = this.mySTAUser.getSearchList().size();

        Response response = this.userResponse.as(Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNull();
        assertThat(response.getData()).isNotNull();

        this.mySTAUser = restUtils.parseResponseBody(response, User.class);

        assertThat(this.mySTAUser.getSearchList()).isNotEmpty();
        assertThat(this.mySTAUser.getSearchList().size()).isGreaterThan(oldMySTASearchListSize);

        com.jayway.restassured.response.Response getAnonymousUserResponse = restUtils.performGetRequest(usersResourceUrl + this.anonymousUser.getId(),
                parameters);

        assertThat(getAnonymousUserResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND.value());

    }

}
