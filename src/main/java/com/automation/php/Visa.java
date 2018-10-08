package com.automation.php;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.automation.utils.CommonUtils;
import com.automation.utils.Log;

public class Visa extends CommonUtils {

	private final String origincountry = "//*[contains(@name,'nationality_country')]";
	private final String destinationcountry = "//*[contains(@name,'destination_country')]";
	private final String search = "//div[@id='VISA']//button[@type='submit']/i";
	
	public void selectOriginCountry(String country) {
		Log.info("Selecting Country :: " + country);
		Select dropdown = new Select(driver.findElement(By.xpath(origincountry)));
		dropdown.selectByVisibleText(country);
		
	}

	public void selectdestinationcountry(String country) {
		Log.info("Selecting Destination Country ::" + country);
		Select dropdown2 = new Select(driver.findElement(By.xpath(destinationcountry)));
		dropdown2.selectByVisibleText(country);
	}
	
	public void enterSearch() {
		Log.info("Clicking on Search tab");
		driver.findElement(By.xpath(search)).click();
	}

	public void goBack() {
		Log.info("Going back");
		driver.navigate().back();
	}
}
