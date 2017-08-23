package com.statravel.jiraserviceqa.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.jiraserviceqa.common.RestUtils;
import com.statravel.jiraserviceqa.config.ApplicationProperties;
import com.statravel.jiraserviceqa.runner.CucumberStepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class VersionResourceTest {
    
    @Autowired
    private ApplicationProperties propertiesConfig;
    
    @Autowired
    private RestUtils restUtils;
    
    private String jiraResourceUrl;
    private String jiraApiVersionUrl;
    
    private static final String NO = "no";
    
    private static final String JIRA_ERROR = "unexpected JIRA error";
    private static final String JIRA_ERROR_MESSAGE = "{\"errors\":[{\"title\":\"Unexpected error from the JIRA API\"}]}";
    
    private static final String ISSUES = "release issues";
    private static final String ISSUES_MESSAGE = "{\"data\":[{\"id\":\"unreleased-id\",\"key\":\"PROJ-key\",\"fields\":{\"customfield_11700\":\"Unreleased DESCRIPTION\"}}]}";
    
    private static final String RELEASED = "released";
    private static final String RELEASE_STATUS_TRUE = "\"released\":true";
    
    private static final String UNRELEASED = "unreleased";
    private static final String RELEASE_STATUS_FALSE = "\"released\":false";
    
    
    private com.jayway.restassured.response.Response serviceResponse;
    private com.jayway.restassured.response.Response apiResponse;
    
    /**
    *
    */
    @Given("^I am on the Jira Service$")
    public void iAmOnTheJiraService() {

        this.jiraResourceUrl = propertiesConfig.getJiraVersionsUrl();
        this.jiraApiVersionUrl = propertiesConfig.getJiraApiVersionsUrl();
        
    }

    /**
    *@param product the product
    *@param version the version
    */
    @When("^I make a request to create a release with \"([^\"]*)\" product and \"([^\"]*)\" version$")
    public void iMakeARequestToCreateAReleaseWithProductAndVersion(final String product, final String version) { 
        
        this.serviceResponse = restUtils.performPutRequest(MessageFormat.format("{0}/{1}/{2}", this.jiraResourceUrl, product, version));
        
    }
    
    /**
     * 
     * @param releaseStatus if has been released or not
     */
    @When("^There is a \"([^\"]*)\" version which matches my request$")
    public void thereIsAVersionWhichMatchesMyRequest(final String releaseStatus) {
              
        if (releaseStatus.equals(RELEASED)) {

            this.apiResponse = restUtils.performGetRequest(MessageFormat.format(jiraApiVersionUrl, RELEASED));
            
            assertTrue(this.apiResponse.getBody().asString().indexOf(RELEASE_STATUS_FALSE) == -1);
            assertTrue(this.apiResponse.getBody().asString().indexOf(RELEASE_STATUS_TRUE) != -1);
                        
        } else if (releaseStatus.equals(UNRELEASED)) {
            
            this.apiResponse = restUtils.performGetRequest(MessageFormat.format(jiraApiVersionUrl, UNRELEASED));
            
            assertTrue(this.apiResponse.getBody().asString().indexOf(RELEASE_STATUS_FALSE) != -1);
            assertTrue(this.apiResponse.getBody().asString().indexOf(RELEASE_STATUS_TRUE) == -1);
            
        }
        
    }

    /**
    *@param code status code
    */
    @Then("^I get a \"([^\"]*)\" http status code$")
    public void iGetA(final int code) {
        
        assertThat(this.serviceResponse).isNotNull();
        assertThat(this.serviceResponse.getStatusCode()).isEqualTo(code);
        
    }

    /**
    *@param responseBody responseBody
    */
    @Then("^I get \"([^\"]*)\" response body$")
    public void iGetResponseBody(final String responseBody) {
        if (responseBody.equals(NO)) {
            
            assertTrue(this.serviceResponse.getBody().asString().length() == 0);
        
        } else if (responseBody.equals(JIRA_ERROR)) {
            
            assertTrue(this.serviceResponse.getBody().asString().equals(JIRA_ERROR_MESSAGE));
            
        } else if (responseBody.equals(ISSUES)) {

            assertTrue(this.serviceResponse.getBody().asString().equals(ISSUES_MESSAGE));
            
        } else {
            
            assertTrue(false);
            
        }
    
    }

}