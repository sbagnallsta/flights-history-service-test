package com.statravel.autoqa.steps;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.jayway.restassured.response.Response;
import com.statravel.autoqa.common.Constants;
import com.statravel.autoqa.common.TestUtils;
import com.statravel.autoqa.config.PropertiesConfig;
import com.statravel.autoqa.domain.payload.ConfluencePayload;
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
public class ConfluenceResourceTest {

    @Autowired
    private PropertiesConfig propertiesConfig;

    private TestUtils testUtils = new TestUtils();

    private Response response;
    
    private String templateUrl;

    /**
    *
    */
    @Given("^I am on the page resource$")
    public void iAmOnThePageResource() {
    	
        templateUrl = propertiesConfig.getConfluenceServiceHost() + propertiesConfig.getConfluenceServiceTemplatesResource();

    }

    /**
    *
    */
    @When("^I make a \"([^\"]*)\" request to create a confluence page$")
    public void iMakeARequestToCreateAConfluencePage(final String requestType) {

        if (requestType.equals(Constants.VALID)) {

            response = getResponse(testUtils.validPayload());

        } else if (requestType.equals(Constants.INVALID)) {

            response = getResponse(testUtils.invalidPayload());

        } else if (requestType.equals(Constants.DUPLICATE)) {

            response = getResponse(testUtils.duplicatePayload());
  
        }

    }

    /**
     * 
     * @param code
     *            http status code we're expecting
     */
    @Then("^I should get a \"([^\"]*)\" HTTP status code$")
    public void iShouldGetAHTTPStatusCode(final String code) {

        assertEquals(Integer.parseInt(code), response.getStatusCode());
    }

    /**
     * 
     * @param errors
     *            type of error we're expecting
     */
    @Then("^I should get a response with the \"([^\"]*)\"$")
    public void iShouldGetAResponseWithThe(final String errors) {

        if (errors.equals(Constants.VALIDATION_ERRORS)) {

            assertTrue(response.asString().equals(Constants.VALIDATION_ERROR_MESSAGE));

        } else if (errors.equals(Constants.CONFLUNENCE_API_ERRORS)) {

            assertTrue(response.asString().equals(Constants.CONFLUENCE_API_ERROR_MESSAGE));

        }
    }

    private Response getResponse(final ConfluencePayload request) {
    	
        return given().contentType(Constants.CONTENT_TYPE).body(request).when().post(templateUrl).then().extract().response();

    }

}
