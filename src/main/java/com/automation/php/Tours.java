package com.automation.php;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.CommonUtils;
import com.automation.utils.Log;

public class Tours extends CommonUtils{

	private final String cityTourName="//*[@id='s2id_autogen11']";
	private final String tourStartDate="//*[@class='form input-lg tchkin']";
	private final String tourguests="//*[@id='adults']";
	private final String selectTourType="//*[@id='s2id_tourtype']";
	private final String searchTours="//div[@id='tours']//button[@type='submit']";
	private final String visibleTourType="//ul[@class='select2-results']//li//div//span[@class='select2-match']";
	private final String visibleCityName="//ul[@class='select2-results']//div//span[@class='select2-match']";

	public void enterCityName(String cityname){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cityTourName)));
		
		Log.info("Enter City Name :: " + cityname);
		driver.findElement(By.xpath(cityTourName)).sendKeys(cityname);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(visibleCityName)));
		//driver.findElements(By.xpath(visibleCityName)).contains(cityname);
		driver.findElement(By.xpath(visibleCityName)).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span[contains(text(),'6 Days Around Thailand')]")));
		//driver.findElement(By.xpath("//div/span[contains(text(),'6 Days Around Thailand')]")).click();
	}
	//enterTourDate
	
	public void enterTourDate(String tourDate)
	{
		Log.info("Enter Tour Date" + tourDate);
		driver.findElement(By.xpath(tourStartDate)).clear();
		driver.findElement(By.xpath(tourStartDate)).sendKeys(tourDate);
	}
	
	//enterTourGuests
	public void enterTourGuests(String guests)
	{
	Log.info("Enter number of guests:: "+ guests);	
	driver.findElements(By.xpath(tourguests));
	Select guestno=new Select(driver.findElement(By.xpath(tourguests)));
	guestno.selectByVisibleText(guests);
	//Select select=new Select(driver.findElements(By.id(guests)));
	//driver.findElements(By.id(guests));
	
	}
	
	public void enterTourType(String tourType) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectTourType)));
		
		//driver.findElement(By.xpath(selectTourType)).sendKeys(tourType);
		Log.info("Select tour type: " +tourType);
		//driver.findElements(By.xpath(visibleTourType)).contains(tourType);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(visibleTourType)));
		driver.findElements(By.xpath(visibleTourType)).contains(tourType);
		driver.findElement(By.xpath(visibleTourType)).click();
	}

	public void clickSearch() {
		Log.info("Click Search Button");
		driver.findElement(By.xpath(searchTours)).click();		
	}
	
	
	}
	
	
	

