package com.statravel.autoqa;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author STA Development Team
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html.report",
        "json:target/json.report", }, features = "src/test/resources/feature", monochrome = true)
public class CucumberRunner {

}
