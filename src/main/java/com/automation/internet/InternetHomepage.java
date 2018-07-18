package com.automation.internet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.CommonProperty;
import com.automation.utils.CommonUtils;
import com.automation.utils.Log;
import com.automation.utils.PropertyManager;

public class InternetHomepage extends CommonUtils {

	private final static String cdom = "//*[contains(text(),'Challenging DOM')]";
	private final static String allcheckboxes = "//*[@id='checkboxes']/input";
	private final static String CHECKBOX = "//*[contains(text(),'Checkboxes')]";
	private final static String DISELEMENT = "//*[contains(text(),'Disappearing Elements')]";
	private final static String DISAPPEAR = "//*[(@ href = '/gallery/')]";
	private final static String DRAGTAB = "//*[contains(text(),'Drag and Drop')]";
	private final static String FIRSTBOX = "//*[(@id = 'column-a')]";
	private final static String SECBOX = "//*[(@id = 'column-b')]";
	private final static String DROPDOWNTAB = "//*[contains( text(),'Dropdown')]";
	private final static String DROPDOWN = "//*[(@id = 'dropdown')]";
	private final static String DYNAMICTAB = "//*[contains (text(),'Dynamic Controls')]";
	private final static String DYNAMICBUTTONREMOVE = "//*[(@id = 'btn') and contains(text(),'Remove')]";
	private final static String DYNAMICBUTTONADD = "//*[(@id = 'btn') and contains(text(),'Add')]";
	private final static String DYNAMICMESSAGE = "//*[(@id = 'message')]";
	private final static String DYNAMICCHECKBOX = "//*[(@id = 'checkbox')]";

	public void loginWithBasicAuth(String username, String password) {
		String URL = CommonProperty.getProperty("url" + PropertyManager.getProperty("zone").toUpperCase());
		Log.info("");
		String[] URLpart1 = URL.split("//");
		Log.info("split url is :: " + URLpart1[0]);
		String newURL = URLpart1[0] + "//" + username + ":" + password + "@" + URLpart1[1] + "/basic_auth";
		Log.info("Opening new URL : " + newURL);
		driver.navigate().to(newURL);
		String xpath = "//*[contains(text(),'Congratulations! You must have the proper credentials.')]";

		if (driver.findElement(By.xpath(xpath)).isDisplayed() && driver.findElement(By.xpath(xpath)).isEnabled()) {
			Log.highlight("Loging Success!!");
		} else {
			Log.error("Log in Failed !!");
			throw new IllegalArgumentException("Login Failed !!");
		}
	}

	public void openInternetpage() {
		String URL = CommonProperty.getProperty("url" + PropertyManager.getProperty("zone").toUpperCase());
		Log.info("");
		Log.info("Opening URL : " + URL);
		driver.navigate().to(URL);
	}

	public void gotoChallengingDOM() {
		Log.info("Goto Challeging DOM");
		driver.findElement(By.xpath(cdom)).click();
	}

	public void verifyLorem(String expected, int i) {
		String xpath = "//table//tr[" + i + "]/td[1]";
		String got = driver.findElement(By.xpath(xpath)).getText();
		if (!expected.equals(got)) {
			Log.error("Expected Lomer :: " + expected);
			Log.error("Got Lomer :: " + got);
			throw new IllegalArgumentException("Expected and got lomer values are incorrect");
		}
		Log.info(" Expected and got Lorem values are matching " + "Got :" + got + "  " + "Expected  ::" + expected);
	}

	public void verifyIpsum(String expected, int i) {
		String xpath = "//table//tr[" + i + "]/td[2]";
		String got = driver.findElement(By.xpath(xpath)).getText();
		if (!expected.equals(got)) {
			Log.error("Expected Ipsum :: " + expected);
			Log.error("Got Ipsum :: " + got);
			throw new IllegalArgumentException("Expected and got Ipsum values are incorrect");
		}
		Log.info(" Expected and got Ipsum values are matching " + "Got :" + got + "  " + "Expected  ::" + expected);
	}

	public void verifyDolor(String expected, int i) {
		String xpath = "//table//tr[" + i + "]/td[3]";
		String got = driver.findElement(By.xpath(xpath)).getText();

		if (!expected.equals(got)) {
			Log.error("Expected Dolor  ::" + expected);
			Log.error("Got Dolor  ::  " + got);
			throw new IllegalArgumentException("Expected and got Ipsum values are incorrect");

		}
		Log.info(" Expected and got Dolor values are matching " + "Got :" + got + "  " + "Expected  ::" + expected);
	}

	public void verifySit(String expected, int i) {
		String xpath = "//table//tr[" + i + "]/td[4]";
		String got = driver.findElement(By.xpath(xpath)).getText();

		if (!expected.equals(got)) {
			Log.error("Expected Sit  ::" + expected);
			Log.error("Got  Sit  :: " + got);
			throw new IllegalArgumentException("Expected and got Sit values are incorrect");
		}
		Log.info(" Expected and got Sit values are matching " + "Got :" + got + "  " + "Expected  ::" + expected);
	}

	public void verifyAmet(String expected, int i) {
		String xpath = "//table//tr[" + i + "]/td[5]";
		String got = driver.findElement(By.xpath(xpath)).getText();

		if (!expected.equals(got)) {
			Log.error("Expected Amet  ::" + expected);
			Log.error("Got Amet   :: " + got);
			throw new IllegalArgumentException("Expected and got Amet values are incorrect");

		}
		Log.info("Expected and got Amet values are matching " + "Got :" + got + "  " + "Expected  ::" + expected);

	}

	public void verifyDiceret(String expected, int i) {
		String xpath = "//table//tr[" + i + "]/td[6]";
		String got = driver.findElement(By.xpath(xpath)).getText();

		if (!expected.equals(got)) {
			Log.error("Expected   Diceret ::" + expected);
			Log.error("Got Diceret  :: " + got);
			throw new IllegalArgumentException(" Expected and Got Diceret values are incorrect");
		}
		Log.info("Expected and got Diceret values are matching " + "Got :" + got + "  " + "Expected  ::" + expected);
	}

	public void editLorem(String editof) {
		String xpath = "//td[contains(text()," + editof + ")]/..//a[text()='edit']";
		driver.findElement(By.xpath(xpath)).click();
		Log.info("Edit for     :: " + editof + "   ::is selected");
	}

	public void deleteLorem(String deleteof) {
		String xpath = "//td[contains(text()," + deleteof + ")]/..//a[text()='delete']";
		driver.findElement(By.xpath(xpath)).click();
		Log.info("Delete for     :: " + deleteof + "   ::is selected");
	}

	public void gotoCheckbox() {
		Log.info("Click on Check boxes tab");
		driver.findElement(By.xpath(CHECKBOX)).click();
	}

	public void clickAllCheckboxes() {
		int i = 1;
		List<WebElement> checkboxes = driver.findElements(By.xpath(allcheckboxes));
		for (WebElement checkbox : checkboxes) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(checkbox));
			if (!checkbox.isSelected()) {
				Log.info("Clicking Check Box :: " + i);
				checkbox.click();
			} else {
				checkbox.click();
				checkbox.click();
			}

			i++;
		}

	}

	public void clickCheckbox(int first) {
		String CHECKBOXFIRST = "//*[@id='checkboxes']/input[" + first + "]";
		Log.info("clicking on checkbox :: " + first);
		WebElement checkbox = driver.findElement(By.xpath(CHECKBOXFIRST));

		if (!checkbox.isSelected()) {
			checkbox.click();
		} else {
			checkbox.click();
			checkbox.click();
		}

	}

	public void clickDisapperingelements() {
		Log.info("clicking Disappearing elements tab");
		driver.findElement(By.xpath(DISELEMENT)).click();
	}

	public void verifyGallerytabNotVisible() {
		try {
			WebElement gallery = driver.findElement(By.xpath(DISAPPEAR));

			if (!(gallery.isEnabled() && gallery.isDisplayed())) {
				Log.info("");
				Log.highlight("Gallery tab is not Visible");
				Log.info("");

			} else {
				Log.info("Going back to Home page");
				driver.navigate().back();
				clickDisapperingelements();
			}
		} catch (NoSuchElementException e) {
			Log.warn("No Such Element found");
		}
	}

	public void pageReload() {
		Log.highlight("Refresh happened.");
		driver.navigate().refresh();
	}

	public void verifyGallerytabVisible() {

		boolean isvisible = false;
		for (int i = 0; i <= 2; i++) {
			try {
				WebElement gallery = driver.findElement(By.xpath(DISAPPEAR));

				if (gallery.isEnabled() && gallery.isDisplayed()) {
					Log.info("");
					Log.highlight("Gallery tab is Visible");
					Log.info("");
					isvisible = true;
					break;

				} else {
					pageReload();
				}
			} catch (NoSuchElementException e) {
				pageReload();
			}
		}

		if (!isvisible) {
			Log.error("Gallery tab is not Visible");
			throw new IllegalArgumentException("Gallery tab is not Visible");
		}
		Log.info("Gallery is visible");
	}

	public void dragAndDrop() {
		Log.info("Opening Drag and Drop page");
		driver.findElement(By.xpath(DRAGTAB)).click();

	}

	public void pictureA() {
		WebElement from = driver.findElement(By.xpath(FIRSTBOX));
		String firstBoxText = from.getText();
		Log.info("text in first box is " + firstBoxText);
		WebElement to = driver.findElement(By.xpath(SECBOX));
		String secBoxText = to.getText();
		Log.info("text in 2nd box is " + secBoxText);

		Point coordinates1 = from.getLocation();
		Point coordinates2 = to.getLocation();
		Log.info("X ::" + coordinates1.getX() + " Y ::  " + coordinates1.getY());
		Log.info("X ::" + coordinates2.getX() + " Y ::  " + coordinates2.getY());

		new Actions(driver).clickAndHold(from).moveByOffset(coordinates2.getX(), coordinates2.getY()).release()
				.perform();

	}

	public void clickDropdown() {
		Log.info("User select Drop down tab");
		driver.findElement(By.xpath(DROPDOWNTAB)).click();
	}

	public void selectOption(int i) {
		Log.info("Selecting Option :: " + i);
		Select dropdown = new Select(driver.findElement(By.xpath(DROPDOWN)));
		dropdown.selectByValue("" + i);
	}

	public void selectOption(String text) {
		Log.info("Selecting :: " + text);
		Select dropdown = new Select(driver.findElement(By.xpath(DROPDOWN)));
		dropdown.selectByVisibleText(text);
	}

	public void clickDynamicControls() {
		Log.info("User select Dynamic controls tab");
		driver.findElement(By.xpath(DYNAMICTAB)).click();
	}

	public void removeCheckbox() {
		Log.info("Removing Check box");
		WebElement button = (driver.findElement(By.xpath(DYNAMICBUTTONREMOVE)));
		String buttonName = button.getText();
		if (buttonName.equalsIgnoreCase("Remove")) {
			button.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(DYNAMICBUTTONADD)));
		}
	}

	public void verifyCheckboxIsRemoved() {
		WebElement message = (driver.findElement(By.xpath(DYNAMICMESSAGE)));
		if (message.getText().equals("It's gone!")) {
			Log.info("Message is displayed correctly");
		} else {
			Log.error("Check box is Not Removed");
			throw new IllegalArgumentException("Check box is not Removed");
		}

		try {
			Boolean checkbox = driver.findElement(By.xpath(DYNAMICCHECKBOX)).isEnabled();
			Boolean checkbox1 = driver.findElement(By.xpath(DYNAMICCHECKBOX)).isDisplayed();

			if (checkbox && checkbox1) {
				Log.error("Check box is Not Removed");
				throw new IllegalArgumentException("Check box is not Removed");
			} else {
				Log.info("Check box is Successfully Removed with Valid Message");
			}
		} catch (NoSuchElementException e) {
			Log.info("Check box is not  present");
		}

	}

	public void addCheckbox() {
		WebElement button = (driver.findElement(By.xpath(DYNAMICBUTTONADD)));
		String buttonName = button.getText();
		if (buttonName.equalsIgnoreCase("Add")) {
			Log.info("Adding Check box");
			button.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(DYNAMICBUTTONREMOVE)));

		} else {
			Log.info("Add button is not available");
		}
	}

	public void verifyCheckboxIsAdded() {
		WebElement message = (driver.findElement(By.xpath(DYNAMICMESSAGE)));
		Boolean checkbox = driver.findElement(By.xpath(DYNAMICCHECKBOX)).isEnabled();
		Boolean checkbox1 = driver.findElement(By.xpath(DYNAMICCHECKBOX)).isDisplayed();

		if (message.getText().equals("It's back!")) {
			Log.info("Message is displayed correctly after adding checkbox");
		} else {
			Log.error("Message is not displayed correctly");
			throw new IllegalArgumentException("Message is not displayed correctly");
		}

		if (checkbox && checkbox1) {
			Log.info("Check box is added back successfully");
		} else {
			Log.error("Check box is not added");
			throw new IllegalArgumentException("Check box is not added");
		}

	}
}
