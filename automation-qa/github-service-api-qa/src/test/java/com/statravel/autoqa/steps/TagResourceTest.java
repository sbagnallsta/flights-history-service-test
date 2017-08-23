package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.common.TestUtils;
import com.statravel.autoqa.config.PropertiesConfig;
import com.statravel.autoqa.domain.dto.response.Response;
import com.statravel.autoqa.runner.CucumberStepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class TagResourceTest {
	
	@Autowired 
	private PropertiesConfig propertiesConfig;
	
	@Autowired
	private RestUtils restUtils;
	
	private String tagResourceUrl;
	
	private com.jayway.restassured.response.Response responseTag;
	
	private TestUtils testUtils = new TestUtils();
	
	@Given("^I am on GitHub Service tags resource$")
	public void iAmOnGitHubServiceTags_resource() {
		
		this.tagResourceUrl = propertiesConfig.getGithubTagsResourceUrl();

	}

	@When("^I request a tag to be created$")
	public void iRequestATagToBeCreated() {
	    
		this.responseTag = restUtils.performPostRequest(this.tagResourceUrl, testUtils.buildTag());
		
	}
	
	@Then("^I should get a (\\d+) HTTP status code from GitHub Service tags resource$")
	public void iShouldGetAHTTPStatusCodeFromGitHubServiceTagsResource(int httpCode) {
	    
		assertThat(this.responseTag).isNotNull();
		assertThat(this.responseTag.getStatusCode()).isEqualTo(httpCode);
		
	}

	@Then("^I should get the tag created payload$")
	public void iShouldGetTheTagCreatedPayload() {

		Response response = restUtils.parseResponseBody(this.responseTag, Response.class);

		assertThat(response).isNotNull();
		assertThat(response.getErrors()).isNull();
		assertThat(response.getData()).isNotNull();

	}
	
	@When("^I request a tag to be created with missing data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void iRequestATagToBeCreatedWithMissingData(String tagName, String body, String repository) {

		this.responseTag = restUtils.performPostRequest(this.tagResourceUrl, testUtils.buildTag(tagName, body, repository));
	}

	@Then("^I should get a tag payload with errors information$")
	public void iShouldGetATagPayloadWithErrorsInformation() {

		Response response = restUtils.parseResponseBody(this.responseTag, Response.class);

		assertThat(response).isNotNull();
		assertThat(response.getErrors()).isNotNull();
		assertThat(response.getData()).isNull();

	}
	
	@When("^I request a tag to be created with a wrong repository$")
	public void iRequestATagToBeCreatedWithAWrongRepository() {
	   
		this.responseTag = restUtils.performPostRequest(this.tagResourceUrl, testUtils.buildTagWrongRepository());
		
	}
	
}
