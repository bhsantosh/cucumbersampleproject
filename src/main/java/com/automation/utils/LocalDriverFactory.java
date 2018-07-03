package com.automation.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.collect.Lists;

public class LocalDriverFactory {
	
	public static WebDriver createInstance(String browserName) {
        
    	RemoteWebDriver driver = null;
    	String driverLocation = null;
        
        if (browserName.equalsIgnoreCase("firefox")) {
        	Log.info("-----------> Lunching Firefox <-----------");
            driver = new FirefoxDriver();
            return driver;
        }
        
        if (browserName.equalsIgnoreCase("chrome")) {
        	Log.info("-----------> Lunching Chrome <-----------");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--cipher-suite-blacklist=0x0088,0x0087,0x0039,0x0038,0x0044,0x0045,0x0066,0x0032,0x0033,0x0016,0x0013");
			options.addArguments("--disable-popup-blocking");
			options.setCapability("chrome.switches", Lists.newArrayList("load-extension=/Applications/Chrome.app/Contents/MacOS/applet"));
			driverLocation = PropertyManager.getProperty("user.dir") + CommonProperty.getProperty("driverdir") + CommonProperty.getProperty("chromedriver");
			System.setProperty("webdriver.chrome.driver", driverLocation);
			//System.setProperty("webdriver.chrome.driver",
			 //          "//Users//kaflepratik//Documents//Automation//cucumbe jars//final version of jar for Cucumber//chromedriver");
			driver = new ChromeDriver(options);
            return driver;
        }
        
        if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("internetexplorer")) {
        	Log.info("-----------> Lunching IE <-----------");
        	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true); //clear cache
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true); //clear season
			capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			driverLocation = PropertyManager.getProperty("user.dir")+ CommonProperty.getProperty("driverdir") + CommonProperty.getProperty("iedriver");
			File file = new File(driverLocation);
			System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
			InternetExplorerDriverService service = InternetExplorerDriverService.createDefaultService();
			driver = new InternetExplorerDriver(service, capabilities);
			driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyManager.getProperty("timeout")), TimeUnit.SECONDS);
        }
        
        if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            return driver;
        }
        if (browserName.equalsIgnoreCase("opera")) {
            driver = new OperaDriver();
            return driver;
        }
        return driver;
    }
}