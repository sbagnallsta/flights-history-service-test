package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.common.TestUtils;
import com.statravel.autoqa.config.PropertiesConfig;
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
public class EmailResourceTest {
	
	@Autowired
	private PropertiesConfig propertiesConfig;
	
    @Autowired
    private RestUtils restUtils;
    
    private TestUtils testUtils = new TestUtils();
	
	private String emailResourceUrl;
	
	private com.jayway.restassured.response.Response responseEmail;

	/**
	 * 
	 */
	@Test
	public void sonarTest() {
	    assertTrue(true);
	}
	
	/**
	 * 
	 */
    @Given("^I am on Email Service resource$")
    public void iAmOnEmailServiceResource() {
        
        this.emailResourceUrl = propertiesConfig.getEmailResourceUrl();    

    }
	
	/**
	 * 
	 */
    @When("^I make a valid request for an email to be sent out$")
    public void iMakeAValidRequestForAnEmailToBeSentOut() {
        
        this.responseEmail = restUtils.performPostRequest(this.emailResourceUrl, testUtils.buildEmail());
        
    }

    /**
     * 
     * @param httpStatusCode the status code of the response
     */
    @Then("^I should get a (\\d+) HTTP status code back from Email Service resource$")
    public void iShouldGetAHTTPStatusCodeBackFromEmailServiceResource(final int httpStatusCode) {

        assertThat(this.responseEmail).isNotNull();
        assertThat(this.responseEmail.getStatusCode()).isEqualTo(httpStatusCode);
        
    }

    /**
     * 
     * @param sender senders email
     * @param to to email
     * @param cc cc email
     * @param bcc bcc email
     */
    @When("^I make an invalid request for an email to be sent out with bad data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iMakeAnInvalidRequestForAnEmailToBeSentOutWithBadData(final String sender, final String to, final String cc, final String bcc) {

        this.responseEmail = restUtils.performPostRequest(this.emailResourceUrl, testUtils.buildEmail(sender, to, cc, bcc));
        
    }

    /**
     * 
     * @param numberOfErrors the number of errors returned
     */
    @Then("^I should get an error object with (\\d+) item$")
    public void iShouldGetAnErrorObjectWithItem(final int numberOfErrors) {
        
        assertThat(this.responseEmail.path(TestUtils.ERRORS).toString()).isNotNull();
        ArrayList<String> errors = this.responseEmail.path(TestUtils.ERRORS);
        assertEquals(errors.size(), numberOfErrors);
        
    }

    /**
     * 
     */
    @When("^I make a valid request for an email to be sent out for a nonexistant template$")
    public void iMakeAValidRequestForAnEmailToBeSentOutForANonexistantTemplate() {
 
        this.responseEmail = restUtils.performPostRequest(this.emailResourceUrl, testUtils.buildUnknowProductEmail());
        
    }
    
    /**
     * 
     */
    @When("^I request a email to be sent out with bad gateway error in the product$")
    public void iRequestAEmailToBeSentOutWithBadGatewayErrorInTheHeader() {
           
        this.responseEmail = restUtils.performPostRequest(this.emailResourceUrl, testUtils.buildBadGateGayEmailRequest());
   
    }
	
}
