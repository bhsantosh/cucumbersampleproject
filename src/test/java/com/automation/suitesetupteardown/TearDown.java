package com.automation.suitesetupteardown;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.utils.CommonSeleniumKeywords;
import com.automation.utils.CommonUtils;
import com.automation.utils.Log;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class TearDown extends CommonUtils{
	
	CommonSeleniumKeywords commonselenium = new CommonSeleniumKeywords();
	
//	@After("@hotwire") 
//	public void tearDown(Scenario scenario){
//		Log.info("----------------------------------------------------");
//		Log.info("");
//		Log.info("");
//		Log.info("STATUS : " + scenario.getStatus());
//		Log.info("");
//		Log.info("");
//		Log.info("----------------------------------------------------");
//		
//		
//		screenshot(scenario);
//		if(driver != null){
//			commonselenium.quitAllBrowser();
//		}
//		
//		Log.info("");
//		Log.info("");
//		Log.endTestCase();
//	}
	
	private void screenshot(Scenario scenario){
		if(scenario.isFailed()){
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] array = null;
			try {
				array = Files.readAllBytes(scrFile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
	        scenario.embed(array, "image/png");
		}
	}
}
