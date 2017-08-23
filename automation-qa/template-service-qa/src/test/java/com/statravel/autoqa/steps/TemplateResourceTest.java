package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.common.Constants;
import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.common.TestUtils;
import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.dto.response.Response;
import com.statravel.autoqa.domain.payload.TemplatePayload;
import com.statravel.autoqa.runner.CucumberStepsDefinition;

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
public class TemplateResourceTest {

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private ApplicationProperties propertiesConfig;

    private TestUtils testUtils = new TestUtils();

    private String templatesResourceUrl;
    private com.jayway.restassured.response.Response createTemplateResponse;

    /**
     * 
     */
    @Given("^I am on Template Service templates resource$")
    public void iAmOnTemplateServiceTemplatesResource() {

        templatesResourceUrl = propertiesConfig.getHostUrl() + Constants.TEMPLATES_RESOURCE;
    }

    /**
     * 
     */
    @When("^I request a simple template to be created$")
    public void iRequestASimpleTemplateToBeCreated() {

        this.createTemplateResponse = restUtils.performPostRequest(templatesResourceUrl, testUtils.buildTemplate(false, true));

    }

    /**
     * @param httpCode
     *            HTTP code
     */
    @Then("^I should get a (\\d+) HTTP status code$")
    public void iShouldGetAHTTPStatusCode(final int httpCode) {

        assertThat(this.createTemplateResponse).isNotNull();
        assertThat(this.createTemplateResponse.getStatusCode()).isEqualTo(httpCode);

    }

    /**
     * 
     */
    @And("^I should get the templated created payload$")
    public void iShouldGetTheTemplatedCreatedPayload() {

        Response response = restUtils.parseResponseBody(this.createTemplateResponse, Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNull();
        assertThat(response.getData()).isNotNull();

    }

    /**
     * 
     * @param productName
     *            product name
     * @param type
     *            type
     */
    @When("^I request a template to be created with missing mandatory data \"([^\"]*)\" \"([^\"]*)\"$")
    public void iRequestATemplateToBeCreatedWithMissingMandatoryData(final String productName, final String type) {

        TemplatePayload templatePayload = new TemplatePayload(productName, type);

        this.createTemplateResponse = restUtils.performPostRequest(templatesResourceUrl, templatePayload);

    }

    /**
     * 
     */
    @When("^I request a template to be created with template object missing when fields are found$")
    public void iRequestATemplateToBeCreatedWithTemplateObjectMissingWhenFieldsAreFound() {

        this.createTemplateResponse = restUtils.performPostRequest(templatesResourceUrl, testUtils.buildTemplate(true, false));

    }

    /**
     * 
     */
    @And("^I should get a payload with errors information$")
    public void iShouldGetAPayloadWithErrorsInformation() {

        Response response = restUtils.parseResponseBody(this.createTemplateResponse, Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNotNull();
        assertThat(response.getData()).isNull();

    }

    /**
     * 
     */
    @When("^I request a complex template to be created$")
    public void iRequestAComplexTemplateToBeCreated() {

        this.createTemplateResponse = restUtils.performPostRequest(templatesResourceUrl, testUtils.buildTemplate(true, true));

    }

}
