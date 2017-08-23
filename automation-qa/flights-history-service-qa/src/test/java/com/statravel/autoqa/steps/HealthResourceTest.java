package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.statravel.autoqa.common.Constants;
import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.config.PropertiesConfig;
import com.statravel.autoqa.runner.CucumberStepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class HealthResourceTest {
    
    @Autowired
    private RestUtils restUtils;
    
    @Autowired
    private PropertiesConfig propertiesConfig;
       
    private String healthCheckUrl;
    
    private com.jayway.restassured.response.Response response;
    
    /**
     * 
     */
    @Given("^I am on Flights History Service health resource$")
    public void iAmOnFlightsHistoryServiceHealthResource() {
        
        this.healthCheckUrl = propertiesConfig.getHostUrl() + Constants.HEALTH_RESOURCE;
        
    }
    
    /**
     * 
     */
    @When("^I perform a request to check the health of the service$")
    public void iMakeAHttpGetRequest() {
        
        this.response = restUtils.performGetRequest(healthCheckUrl);
        
    }
    
    /**
     * 
     */
    @Then("^I should get a positive response")
    public void iShouldGetAPositiveResponse() {
        
        assertThat(this.response.getStatusCode()).isEqualTo(HttpStatus.OK.value());
        
    }
    
}
