package com.statravel.autoqa.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.statravel.autoqa.common.Constants;
import com.statravel.autoqa.common.RestUtils;
import com.statravel.autoqa.common.TestUtils;
import com.statravel.autoqa.config.PropertiesConfig;
import com.statravel.autoqa.domain.dto.payload.Flight;
import com.statravel.autoqa.runner.CucumberStepsDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *@author STA Development Team
 *
 */
@CucumberStepsDefinition
public class FlightsTest {
    
    @Autowired
    private RestUtils restUtils;

    @Autowired
    private PropertiesConfig propertiesConfig;
      
    private TestUtils testUtils = new TestUtils();
    
    private String flightsUrl;
    
    private com.jayway.restassured.response.Response response;
    
    private List<Flight> flightsAdded = new ArrayList<>();
            
    /**
    *
    */
    @Given("^I am POSTing flights to the Flights History Service flights resource$")
    public void iAmPOSTingFlightsToTheFlightsHistoryServiceFlightsResource() {
        
        this.flightsUrl = propertiesConfig.getHostUrl() + Constants.FLIGHTS_RESOURCE;
        
    }

    /**
    *@param flightType manual or collector
    */
    @When("^The request is valid \"([^\"]*)\" flights$")
    public void theRequestIsValidFlights(final String flightType) {
        
        theRequestIsValidFlightsWithASpecificPOS(flightType, TestUtils.NA);
    }

    /**
    *@param statusCode status code of response
    */
    @Then("^I should get a (\\d+) HTTP status code from Flights History Service flights resource$")
    public void iShouldGetAHTTPStatusCodeFromFlightsHistoryServiceFlightsResource(final int statusCode) {
    
        assertThat(this.response.statusCode()).isEqualTo(statusCode);
            
    }

    /**
    *
    */
    @Then("^The flights should be stored$")
    public void theFlightsShouldBeStored() {
        
        Boolean stored = false;
        
        MongoClient mongoClient = new MongoClient(propertiesConfig.getMongoUrl(), 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(propertiesConfig.getMongoDatabase());
        MongoCollection<Document> document = mongoDatabase.getCollection(propertiesConfig.getMongoCollection());        
        FindIterable<Document> iterable = document.find();
        
        for (Iterator<Flight> i = this.flightsAdded.iterator(); i.hasNext();) {
            Flight flight = i.next();
            
            for (Document current : iterable) {
                String pos = current.getString(TestUtils.POS);
                Boolean manual = current.getBoolean(TestUtils.MANUAL);
                
                if ((flight.getPos().equals(pos)) && (flight.isManual().equals(manual))) {
                    
                    stored = true;

                }
                           
            }
            
            assertThat(true).isEqualTo(stored);
        }
        
        mongoClient.close();
           
    }

    /**
     * @param flightType collector or manual
     * @param pos pos
     */
    @When("^The request is valid \"([^\"]*)\" flights with a specific POS \"([^\"]*)\"$")
    public void theRequestIsValidFlightsWithASpecificPOS(final String flightType, final String pos) {
        List<Flight> flightObjects = new ArrayList<Flight>();
        Flight flight = null;
        
        if (flightType.equals(TestUtils.MANUAL)) {
            
            flight = testUtils.createFlight(pos, true);

            flightObjects.add(flight);
                       
        } else if (flightType.equals(TestUtils.COLLECTOR)) {
            
            flight = testUtils.createFlight(pos, false);
            
            flightObjects.add(flight);
            
        } 
        
        flightsAdded.add(flight);        
        
        this.response = restUtils.performPostRequest(flightsUrl, flightObjects);
        
    }

    /**
    *
    */
    @Then("^Both sets of flights should be stored$")
    public void bothSetsOfFlightsShouldBeStored() {
        
        theFlightsShouldBeStored();
        
    }
    
}