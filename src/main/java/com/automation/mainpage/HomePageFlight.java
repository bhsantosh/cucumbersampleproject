package com.automation.mainpage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.CommonProperty;
import com.automation.utils.CommonUtils;
import com.automation.utils.Log;
import com.automation.utils.PropertyManager;

import junit.framework.Assert;

public class HomePageFlight extends CommonUtils {

	private final String gotoflight = "//*[(@data-title ='flights' )]";
	private final String roundtripbutton = "//*[(@for='round')]";
	private final String cabinclass = "//*[(@name = 'cabinclass')]";
	private final String economyclass = "//*[(@value = 'economy')]";
	private final String businessclass = "//*[(@value = 'business')]";
	private final String firstclass = "//*[(@value = 'first')]";
	private final String orgairportname = "//*[(@id=\"s2id_location_from\")]";
	private final String orgairportnameenter = "//*[@id='select2-drop']/div/input";
	private final String orgairportnamedropdown = "//*[(@class=\"select2-result-label\")]";
	private final String destinationname = "//*[(@id=\"s2id_location_to\")]";
	private final String destinationnamedropdown = "//*[(@id=\"select2-drop\")]/div/input";
	private final String destinationnamedropdownselection = "//*[(@class=\"select2-result-label\")]";
	private final String departingdate = "//*[(@ name = \"departure\")]";
	private final String returndate = "//*[(@name = 'arrival')]";
	private final String guestno = "//*[(@name=\"totalManualPassenger\")]";
	private final String adultdropdown = "//*[(@ name=\"madult\")]";
	private final String childdropdown = "//*[(@name=\"mchildren\")]";
	private final String infantdropdown = "//*[(@name=\"minfant\")]";
	private final String popupdone = "//*[(@id=\"sumManualPassenger\")]";
	private final String flightsearch = "//div[@id='flights']//button[@type='submit']";

	public void openHotwire() {
		String URL = CommonProperty.getProperty("url" + PropertyManager.getProperty("zone").toUpperCase());
		Log.info("");
		Log.info("Opening URL:" + URL);
		driver.navigate().to(URL);
		String title = driver.getTitle();
		Log.info(title);
	}

	public void gotoflighttab() {

		Log.info("Go to Flight tab");

		driver.findElement(By.xpath(gotoflight)).click();
	}

	public void roundtrip() {

		Log.info("Click on Round trip radion button");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(roundtripbutton)));
		driver.findElement(By.xpath(roundtripbutton)).click();
	}

	public void selectFlightClass(String cal) {
		Log.info("selecting the Flight Class :: " + cal);

		Select dropdown = new Select(driver.findElement(By.xpath(cabinclass)));
		dropdown.selectByValue(cal.toLowerCase());

		// String xpath = "//*[(@name = 'cabinclass')]/option[@value='"+
		// cal.toLowerCase() +"']";
		// driver.findElement(By.xpath(xpath)).click();
	}

	public void verifyFlightClassDropdown() {
		Select dropdown = new Select(driver.findElement(By.xpath(cabinclass)));
		List<WebElement> classname_elements = dropdown.getOptions();

		ArrayList<String> classnames = new ArrayList<String>();

		for (WebElement classname_element : classname_elements) {
			classnames.add(classname_element.getText());
		}

		for (int j = 0; j < classnames.size(); j++) {
			Log.info("---->>>>>>>" + classnames.get(j) + "<<<<<<---------");
		}

		if (classnames.contains("FIRST") && classnames.contains("ECONOMY") && classnames.contains("BUSINESS")) {
			Log.highlight("PASS");
		} else {
			Log.error("FAIL");
			throw new IllegalArgumentException("Dropdown not found");
		}
	}

	public void orgairport(String airport) {

		Log.info("Enter the originating airport as ::" + airport);

		driver.findElement(By.xpath(orgairportname)).click();

		driver.findElement(By.xpath(orgairportnameenter)).sendKeys(airport);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(orgairportnamedropdown)));

		driver.findElement(By.xpath(orgairportnamedropdown)).click();

	}

	public void desAirportName(String desairport) {

		Log.info("Enter Destination airport or city name   ::" + desairport);
		driver.findElement(By.xpath(destinationname)).click();
		driver.findElement(By.xpath(destinationnamedropdown)).sendKeys(desairport);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(destinationnamedropdownselection)));

		driver.findElement(By.xpath(destinationnamedropdownselection)).click();
	}

	public void departingDate(String deptdate) {
		Log.info("Entering Departing Dates ::" + deptdate);
		driver.findElement(By.xpath(departingdate)).clear();
		driver.findElement(By.xpath(departingdate)).sendKeys(deptdate);

	}

	public void returnDate(String returndates) {
		Log.info("Entering Return date ::" + returndates);
		driver.findElement(By.xpath(returndate)).clear();
		driver.findElement(By.xpath(returndate)).sendKeys(returndates);
	}

	// public void noOfGuest(String guest) {
	//
	// Log.info("Selecting no of Guest::"+ guest);
	//
	// driver.findElement(By.xpath(guestno)).click();
	//
	// WebDriverWait wait = new WebDriverWait(driver,10);
	// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(adult)));
	// driver.findElement(By.xpath(adult)).click();
	// Select dropdown = new Select(driver.findElement(By.xpath(adult)));
	// dropdown.selectByValue(guest);
	// driver.findElement(By.xpath(popupdone)).click();
	//
	//
	//
	// }

	public void enterNoOfGuest(int adult, int child, int infant) {

		String adults = "" + adult;
		String childs = "" + child;
		String infants = "" + infant;

		driver.findElement(By.xpath(guestno)).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(adultdropdown)));

		enterNoOfAdults(adults);
		enterNoOfChild(childs);
		enterNoOfInfant(infants);

		driver.findElement(By.xpath(popupdone)).click();

	}

	public void enterNoOfGuest(String noofguests) {
		String adults = noofguests.split("adult")[0].replaceAll(" ", "").replaceAll("s", "").replaceAll(",", "");
		String childs = (noofguests.split("adult")[1]).split("child")[0].replaceAll(" ", "").replaceAll("s", "")
				.replaceAll(",", "");
		String infants = (noofguests.split("child")[1]).split("infant")[0].replaceAll(" ", "").replaceAll("s", "")
				.replaceAll(",", "");

		Log.highlight(adults);
		Log.highlight(childs);
		Log.highlight(infants);

		driver.findElement(By.xpath(guestno)).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(adultdropdown)));

		enterNoOfAdults(adults);
		enterNoOfChild(childs);
		enterNoOfInfant(infants);

		driver.findElement(By.xpath(popupdone)).click();
	}

	public void enterNoOfAdults(String adult) {
		Log.info("Select no of Adults   ::" + adult);
		driver.findElement(By.xpath(adultdropdown)).click();
		Select dropdownadult = new Select(driver.findElement(By.xpath(adultdropdown)));
		dropdownadult.selectByValue(adult);

	}

	public void enterNoOfChild(String child) {
		Log.info("Select no of Child   :: " + child);
		Select dropdownchild = new Select(driver.findElement(By.xpath(childdropdown)));
		dropdownchild.selectByValue(child);
	}

	public void enterNoOfInfant(String infant) {
		Log.info("Select no of Infant :: " + infant);
		Select dropdowninfant = new Select(driver.findElement(By.xpath(infantdropdown)));
		dropdowninfant.selectByValue(infant);
	}

	public void flightSearch() {
		Log.info("Selecting Final Search buttton");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(flightsearch)));
		driver.findElement(By.xpath(flightsearch)).click();
	}

}
