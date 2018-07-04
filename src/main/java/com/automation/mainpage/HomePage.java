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
	private final String pickup = "//*[@id=\"select2-drop\"]/ul/li[4]/div";
	private final String dropoff = "//*[contains(@id, 'select2-drop')]/div/input";
	
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

	public void enterPickupLocation(String loc) {
		
		Log.info("Entering location :: " + loc);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pickup)));
//		driver.findElement(By.xpath(pickup)).clear();
		driver.findElement(By.xpath(pickup)).sendKeys(loc);
	}
	
	

}
