package com.automation.runnerphp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true,
		strict = false,
		tags = {"@done","~@ignore", "~@depricated", "~@backlog"},
		plugin={
				"pretty:target/cucumber-pretty.txt",
				"html:target/html-report",
			    "json:target/json/json-report.json",
				"junit:target/junit/junit-report.xml",
				"usage:target/cucumber-usage.json",
			
		},
		
		glue = {"com.automation.teststeps","com.automation.suitesetupteardown"},
		monochrome = true,
		features = {
//				"src/test/resources/com/automation/php/BookACar.feature",
//				"src/test/resources/com/automation/php/BookaHotel.feature",
//				"src/test/resources/com/automation/php/BookaFlight.feature",
//				 "src/test/resources/com/automation/php/BookAVisa.feature",
//				"src/test/resources/com/automation/php/Subscribe.feature",
//			 "src/test/resources/com/automation/php/BookATours.feature",*/
			 "src/test/resources/com/automation/php/BookNewTours.feature",
//			 "src/test/resources/com/automation/php/BookAToursPratik.feature",

			}
		
		)

public class Regression {
}