package com.automation.mainpage;

import com.automation.utils.CommonProperty;
import com.automation.utils.CommonUtils;
import com.automation.utils.Log;
import com.automation.utils.PropertyManager;

public class HomePage extends CommonUtils{

	public void openHotwire() {
		String URL = CommonProperty.getProperty("url" + PropertyManager.getProperty("zone").toUpperCase());
		Log.info("");
		Log.info("Opening URL : " + URL);
		driver.navigate().to(URL);
		String title =  driver.getTitle();
		Log.info(title);
		
		
	}
	
	

}
