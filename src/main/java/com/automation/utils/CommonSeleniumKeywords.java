package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSeleniumKeywords extends CommonUtils {

	public String getBrowserAlise() {
		return driver.getWindowHandle();
	}

	public void switchBrowser(String pageAlise) {
		driver.switchTo().window(pageAlise);
	}
	
	public void switchToWindow(String windowAliase) {
		driver.switchTo().window(windowAliase);
	}
	
	public void switchFrame(String framename) {
		driver.switchTo().defaultContent();
		WebElement frame = new WebDriverWait(driver, Long.parseLong(CommonProperty.getProperty("timeout")))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("frame[name='"+ framename +"']")));
		driver.switchTo().frame(frame);
	}

	public void switchiFrame(String framename) {
		WebElement frame = new WebDriverWait(driver, Long.parseLong(CommonProperty.getProperty("timeout")))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(framename)));
		driver.switchTo().frame(frame);
	}

	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public void quitAllBrowser() {

		Log.info("");
		Log.warn("Driver Quit");
		driver.quit();
		driver = null;
	}
}
