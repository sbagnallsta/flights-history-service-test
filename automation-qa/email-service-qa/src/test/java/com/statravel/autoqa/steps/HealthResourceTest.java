package com.statravel.autoqa.steps;

import static com.jayway.restassured.RestAssured.given;

import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.config.PropertiesConfig;
import com.statravel.autoqa.runner.CucumberStepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class HealthResourceTest {
    
    @Autowired
    private PropertiesConfig propertiesConfig;
       
    private String healthResourceUrl;
    
    @Given("^I am on Email Service health resource$")
    public void iAmOnEmailServiceHealthResource() {
        
        this.healthResourceUrl = propertiesConfig.getEmailHealthUrl();
        
    }
    
    @Then("^I should get a 200 Http status code")
    public void iMakeAGETRequest() {
        
        given().contentType("application/json").when().get(healthResourceUrl).then().assertThat().statusCode(200);
        
    }
    
}
