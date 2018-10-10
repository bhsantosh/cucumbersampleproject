package com.automation.php;


import com.automation.utils.Log;

public class Tours {

	private final String cityTourName="//*[@placeholder='Search by Listing or City Name']";

	public void enterCityName(){
		Log.info("Enter City Name:");
		/*driverfindElement(By.xpath(cityTourName)).click();*/
		
			
		}

	public String getCityTourName() {
		Log.info("Enter City Name:");
		return cityTourName;
	}
	
	
	
}
