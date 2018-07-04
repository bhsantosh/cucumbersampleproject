package com.automation.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.CommonProperty;
import com.automation.utils.CommonUtils;
import com.automation.utils.Log;
import com.automation.utils.PropertyManager;

public class HomePage extends CommonUtils{

	private final String car = "//*[(@data-title='CARS')]";
	private final String loctype = "//*[contains(@id, 'select2-drop')]/div/input";
	private final String locpath = "//*[contains(@id, 'select2-drop')]/div/input";
	
	public void openHotwire() {
		String URL = CommonProperty.getProperty("url" + PropertyManager.getProperty("zone").toUpperCase());
		Log.info("");
		Log.info("Opening URL : " + URL);
		driver.navigate().to(URL);
		String title =  driver.getTitle();
		Log.info(title);
		
	}

	public void gotoCarTab() {
		Log.info("Goto Car Tab");
		driver.findElement(By.xpath(car)).click();
	}

	public void enterLocation(String loc) {
		Log.info("Entering location :: " + loc);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locpath)));
		driver.findElement(By.xpath(locpath)).clear();
		driver.findElement(By.xpath(locpath)).sendKeys(loc);
	}
	
	

}
