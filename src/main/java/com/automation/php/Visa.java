package com.automation.php;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.automation.utils.CommonUtils;
import com.automation.utils.Log;

public class Visa extends CommonUtils {

	private final String origincountry = "//*[@id=\"select2-drop\"]//input[(@class='select2-input') and (@type=\"text\")]";
	
	public void selectOriginCountry(String country) {
		Log.info("Selecting Country :: " + country);
		Select dropdown = new Select(driver.findElement(By.xpath("//*[contains(@name,'nationality_country')]")));
		dropdown.selectByVisibleText(country);
		
	}

}
