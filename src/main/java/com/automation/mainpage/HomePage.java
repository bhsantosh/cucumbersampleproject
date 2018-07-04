package com.automation.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.CommonProperty;
import com.automation.utils.CommonUtils;
import com.automation.utils.Log;
import com.automation.utils.PropertyManager;

public class HomePage extends CommonUtils{

	private final String car = "//*[(@data-title='CARS')]";
	private final String pickup = "//*[@id='carlocations']";
	private final String dropoff = "//*[@name=\"dropoffLocation\"]";
	private final String pickupdate = "//*[(@name=\"pickupDate\")]";
	private final String pickuptime = "//*[(@name =\"pickupTime\")]";
	private final String dropupdate = "//*[(@name = \"dropoffDate\")]";
	private final String dropuptime = "//*[(@name = \"dropoffTime\")]";
	private final String search = "//div[@id='CARS']//button[@type='submit']/i";
	
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
		Log.info("Entering Pickup location :: " + loc);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pickup)));
		Select dropdown = new Select(driver.findElement(By.xpath(pickup)));
		dropdown.selectByVisibleText(loc);
	}

	public void enterDropoffLocation(String loc) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Log.info("Entering Dropoff location :: " + loc);
		Select dropdown = new Select(driver.findElement(By.xpath(dropoff)));
		dropdown.selectByVisibleText(loc);
	}

	public void enterPickupDate(String date, String time) {
		Log.info("Entering pick up date and time ::"+ date + time);
		driver.findElement(By.xpath(pickupdate)).clear();
		driver.findElement(By.xpath(pickupdate)).sendKeys(date);
		Select dropdown =new Select(driver.findElement(By.xpath(pickuptime)));
		dropdown.selectByValue(time);
		
				
	}

	public void enterDropoffLocation(String date, String time) {
		Log.info("Entering Drop-off date and time ::"+ date + time);
		driver.findElement(By.xpath(dropupdate)).clear();
		driver.findElement(By.xpath(dropupdate)).sendKeys(date);
		Select dropdown =new Select(driver.findElement(By.xpath(dropuptime)));
		dropdown.selectByValue(time);
		
	}

	public void enterSearch() {
		Log.info("Clicking on Search tab");
		driver.findElement(By.xpath(search)).click();
	}
	
	

}
