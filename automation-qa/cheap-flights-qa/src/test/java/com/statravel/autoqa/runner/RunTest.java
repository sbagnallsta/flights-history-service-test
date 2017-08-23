package com.statravel.autoqa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author STA Development Team
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = { "src/test/resources" }, glue = { "com/statravel/autoqa/steps" }, plugin = { "pretty",
        "html:target/cucumber" })
public class RunTest {

}
