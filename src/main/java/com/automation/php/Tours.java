package com.automation.php;


import org.openqa.selenium.By;

import com.automation.utils.CommonUtils;
import com.automation.utils.Log;

public class Tours extends CommonUtils{

	private final String cityTourName="//*[contains(@class,'select2-container hotelsearch locationlisttours')]";

	public void enterCityName(String cityname){
		Log.info("Enter City Name :: " + cityname);
//		driver.findElement(By.xpath(cityTourName)).clear();
		driver.findElement(By.xpath(cityTourName)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(cityTourName+"/a")).sendKeys(cityname);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//li[contains(@class,'select2-results')]/ul/li")).click();
	}



	}
	
	
	

