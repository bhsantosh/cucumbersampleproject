package com.automation.runnerinternet;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//        dryRun = true,
		strict = false,
		
		tags = {"@done","~@ignore", "~@depricated", "~@backlog"},
		
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
				
//				"src/test/resources/com/automation/internet/BasicAuth.feature",
//				"src/test/resources/com/automation/internet/ChallengingDOM.feature",
//				"src/test/resources/com/automation/internet/Checkboxes.feature",
//				"src/test/resources/com/automation/internet/Disappearingelements.feature",
				"src/test/resources/com/automation/internet/DragandDrop.feature",



				
			}
		
		)

public class Functional {

}
