package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.common.Constants;
import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.common.SettingsUtils;
import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.dto.response.Response;
import com.statravel.autoqa.domain.payload.Settings;
import com.statravel.autoqa.repository.SettingsRepository;
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
public class SettingsResourceTest {

    @Autowired
    private SettingsRepository settingsRepository;

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private SettingsUtils settingsUtils;

    @Autowired
    private ApplicationProperties applicationProperties;

    private String settingsResourceUrl;

    private com.jayway.restassured.response.Response settingsResponse;

    private Settings settingsToCompare;

    /**
     * 
     */
    @After
    public void afterScenario() {

        this.settingsRepository.save(new com.statravel.autoqa.domain.entity.Settings(applicationProperties.getPos(), (byte) 6, true));

    }

    /**
     * 
     */
    @Given("^I am on Saved Searches Service settings resource$")
    public void iAmOnSavedSearchesServiceSettingsResource() {

        settingsResourceUrl = this.applicationProperties.getHostUrl() + Constants.SETTINGS_RESOURCE;
    }

    /**
     * 
     */
    @When("^I search for a settings on the system$")
    public void iSearchForASettingsOnTheSystem() {

        this.settingsResponse = this.restUtils.performGetRequest(this.settingsResourceUrl + applicationProperties.getPos());

    }

    /**
     * 
     */
    @When("^I request a setting to be updated$")
    public void iRequestASettingToBeUpdated() {

        settingsToCompare = this.settingsUtils.buildSettings();
        
        this.settingsResponse = this.restUtils.performPutRequest(this.settingsResourceUrl + applicationProperties.getPos(), this.settingsToCompare);

    }

    /**
     * 
     * @param httpStatusCode
     *            HTTP status code
     */
    @Then("^I should get a (\\d+) HTTP status on settings resource$")
    public void iShouldGetAHTTPStatusCodeWhenOnSettingsResource(final int httpStatusCode) {

        assertThat(this.settingsResponse.getStatusCode()).isEqualTo(httpStatusCode);

    }

    /**
     * 
     */
    @Then("^I should get the settings payload$")
    public void iShouldGetTheSettingsPayload() {

        Response response = this.settingsResponse.as(Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNull();
        assertThat(response.getData()).isNotNull();       

    }
    
    /**
     * 
     */
    @And("^I should get the cache cleared$")
    public void iShouldGetTheCacheCleared() {

        Settings settings = this.restUtils.parseResponseBody(this.settingsResponse.as(Response.class), Settings.class);
        
        assertThat(settings.getMaxNumberSearches()).isEqualTo(settingsToCompare.getMaxNumberSearches());


    }

}
