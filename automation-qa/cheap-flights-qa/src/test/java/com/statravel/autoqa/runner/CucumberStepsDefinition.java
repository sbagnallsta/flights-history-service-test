package com.statravel.autoqa.runner;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.statravel.autoqa.CheapFlightsQAApplication;

/**
 * 
 * @author STA Development Team
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CheapFlightsQAApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public @interface CucumberStepsDefinition {

}
