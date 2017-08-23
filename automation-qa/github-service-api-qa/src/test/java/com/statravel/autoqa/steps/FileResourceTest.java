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
public class FileResourceTest {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Autowired
    private RestUtils restUtils;

    private TestUtils testUtils = new TestUtils();

    private String fileResourceUrl;

    private com.jayway.restassured.response.Response responseFile;

    @Given("^I am on GitHub Service files resource$")
    public void iAmOnGitHubServiceFilesResource() {

        this.fileResourceUrl = propertiesConfig.getGithubFilessResourceUrl();

    }

    @When("^I request a file to be created$")
    public void iRequestAFileToBeCreated() {
                
        this.responseFile = restUtils.performPostRequest(this.fileResourceUrl, testUtils.buildFile());

    }

    @Then("^I should get a (\\d+) HTTP status code back from GitHub Service files resource$")
    public void iShouldGetAHTTPStatusCodeBackFromGitHubServiceFilesResource(int httpCode) {
        
        assertThat(this.responseFile).isNotNull();
        assertThat(this.responseFile.getStatusCode()).isEqualTo(httpCode);

    }

    @Then("^I should get the file created payload$")
    public void iShouldGetTheFileCreatedPayload() {

        Response response = restUtils.parseResponseBody(this.responseFile, Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNull();
        assertThat(response.getData()).isNotNull();

    }

    @When("^I request a file to be created with missing data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iRequestAFileToBeCreatedWithMissingData(String message, String path, String repository, String content, String branch) {

        this.responseFile = restUtils.performPostRequest(this.fileResourceUrl, testUtils.buildFile(message, path, repository, content, branch));

    }

    @Then("^I should get a file payload with errors information$")
    public void iShouldGetAFilePayloadWithErrorsInformation() {

        Response response = restUtils.parseResponseBody(this.responseFile, Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getErrors()).isNotNull();
        assertThat(response.getData()).isNull();

    }

    @When("^I request a file to be created with a wrong repository$")
    public void iRequestAFileToBeCreatedWithAWrongRepository() {

        this.responseFile = restUtils.performPostRequest(this.fileResourceUrl, testUtils.buildFileWrongRepository());

    }

}
