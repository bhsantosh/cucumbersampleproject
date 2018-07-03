package com.automation.suitesetupteardown;


import org.openqa.selenium.WebDriver;

import com.automation.utils.CommonProperty;
import com.automation.utils.CommonUtils;
import com.automation.utils.Log;
import com.automation.utils.PropertyManager;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class SuiteSetup extends CommonUtils{
	
	public WebDriver lunchdriver;
	
	@Before("@hotwire")
	public void beforeScenarioForCalculator(Scenario scenario) {
		Log.startTestCase();
		Log.info("");
		Log.info("------------------------ TESTCASE SETUP --------------------------------- ");
		printvariables();
		Log.info("---------------------------------------------------------------------------");
	    Log.info("");
	    Log.info("");
	    Log.info("------------------------ Connection DB --------------------------------- ");
	    Log.info("");
	    Log.info("");
		Log.info("---------------------------------------------------------------------------");
		lunchbrowser();
		Log.info("");
		Log.info("----------------------------------------------------");
	    Log.info("");
		Log.info("Scenario :: " + scenario.getName());
		Log.info("");
		Log.info("----------------------------------------------------");
	    Log.info("");
	}
	
	public void printvariables(){
		Log.info("");
		Log.info("");
		Log.info("\tBrowser     : " + PropertyManager.getProperty("browser"));
		Log.info("\tZone        : " + PropertyManager.getProperty("zone").toUpperCase());	
		Log.info("\tLog Dir     : " + CommonProperty.getProperty("logdir"));
		Log.info("");
		Log.info("");
	}
		
}
