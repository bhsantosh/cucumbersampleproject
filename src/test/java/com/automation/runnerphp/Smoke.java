package com.automation.runnerphp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//        dryRun = true,
		strict = false,
		
		tags = {"@smoke","~@ignore", "~@depricated", "~@backlog"},
		
		plugin={
//				"pretty:target/cucumber-pretty.txt",
//				"html:target/html-report",
			    "json:target/json/json-report.json",
//				"junit:target/junit/junit-report.xml",
//				"usage:target/cucumber-usage.json",
				},
		
		glue = {"com.automation.teststeps","com.automation.suitesetupteardown"},
		monochrome = true,
		features = {
				
				"src/test/resources/com/automation/php/BookACar.feature",
				"src/test/resources/com/automation/php/BookaHotel.feature",
				"src/test/resources/com/automation/php/BookaFlight.feature",
			}
		
		)

public class Smoke {
}