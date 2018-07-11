package com.automation.php;

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
	private final String hotel = "//*[(@data-title =\"HOTELS\")]";
	private final String location = "//*[@id='select2-drop']/div/input";
	private final String checkindate = "//*[(@name=\"checkin\")]";
	private final String checkoutdate = "//*[(@name = \"checkout\")]";
	private final String noguest = "//*[(@ id = \"travellersInput\")]";
	private final String adultadd = "//*[(@ id = \"adultInput\")]";
	private final String adultaddplus = "//*[(@id = 'adultPlusBtn')]";
	private final String childadd = "//*[(@id = \"childInput\")]";
	private final String Childaddplus = "//*[(@id=\"childPlusBtn\")]";
	private final String searchhotel = "//div[@id='HOTELS']//button[@type='submit']/i";
	
	public String openPHPTravels() {
		String URL = CommonProperty.getProperty("url" + PropertyManager.getProperty("zone").toUpperCase());
		Log.info("");
		Log.info("Opening URL : " + URL);
		driver.navigate().to(URL);
		String title =  driver.getTitle();
		Log.info(title);
		return URL;
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

	public void gotohoteltab() {
		Log.info("select Hotels tab");
		driver.findElement(By.xpath(hotel)).click();
		
	}

	public void cityName(String cityname) {
		Log.info("Entering City Name :: "+ cityname);
		driver.findElement(By.xpath("//*[@id='s2id_autogen8']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(location)));
		
		driver.findElement(By.xpath(location)).clear();
		driver.findElement(By.xpath(location)).sendKeys(cityname);
//		driver.findElement(By.xpath(location)).click();
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='select2-match']")));
		driver.findElement(By.xpath("//*[@class='select2-match']")).click();
		
	}

	public void checkIn(String checkin) {
		Log.info("Entering Check in Date ::  " + checkin);
		driver.findElement(By.xpath(checkindate)).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(checkindate)));
		
		driver.findElement(By.xpath(checkindate)).clear();
		driver.findElement(By.xpath(checkindate)).sendKeys(checkin);
	}

	public void checkout(String checkout) {
		Log.info("Entering checkout location :: "+ checkout);
		driver.findElement(By.xpath(checkoutdate)).click ();
		
		driver.findElement(By.xpath(checkoutdate)).clear();
		driver.findElement(By.xpath(checkoutdate)).sendKeys(checkout);
	}

	public void guest(String no) {
		Log.info("Entering no of guest  ::" + no);
		
		String adultChild = no;
		String [] splitvalue= adultChild.split("Adults,");
		String adult = splitvalue[0];
		String child1 = splitvalue[1];
		String []child = child1.split("child");
		String child2 = child[0];
		int noadult = Integer.valueOf(adult.replaceAll(" ", ""));
		int nochild = Integer.valueOf(child2.replaceAll(" ", ""));
		
		Log.info("Entering no of guest  ::" + adult +"::::"+ child2);
		
		driver.findElement(By.xpath(noguest)).click();
		driver.findElement(By.xpath(adultadd)).clear();
		driver.findElement(By.xpath(adultadd)).sendKeys("0");
		
		for(int i = 0; i< noadult; i++){
			
		driver.findElement(By.xpath(adultaddplus)).click();
		
		}
//		driver.findElement(By.xpath(noguest)).click();
		driver.findElement(By.xpath(childadd)).clear();
		driver.findElement(By.xpath(childadd)).sendKeys("0");
		
		for(int j = 0; j< nochild; j++){
			
		driver.findElement(By.xpath(Childaddplus)).click();
		
		}
	}

	public void hotelSearch() {
		Log.info("Click Search tab");
		driver.findElement(By.xpath(searchhotel)).click();
	}
	
	

}
