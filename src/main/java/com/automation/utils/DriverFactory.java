package com.automation.utils;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    public synchronized static RemoteWebDriver createInstance(URL hubUrl, String browserName) {
        
    	RemoteWebDriver driver = null;
        
        if (browserName.equalsIgnoreCase("firefox")) {
        	Log.info("-----------> Lunching Firefox <-----------");
        	Log.info("");
        	FirefoxOptions options = new FirefoxOptions();
        	options.setAcceptInsecureCerts(true);
            driver = new RemoteWebDriver(hubUrl, options);
            return driver;
        }
        
        if (browserName.equalsIgnoreCase("chrome")) {
        	Log.info("-----------> Lunching Chrome <-----------");
        	Log.info("");
        	ChromeOptions options = new ChromeOptions();
			options.addArguments("--cipher-suite-blacklist=0x0088,0x0087,0x0039,0x0038,0x0044,0x0045,0x0066,0x0032,0x0033,0x0016,0x0013");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("start-maximized");
			options.addArguments("test-type");
			options.addArguments("allow-running-insecure-content");
			options.addArguments("disable-extensions");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			options.addArguments("--user-agent=Mozilla/5.0 Chrome/61.0.3163 (CI test)");
			driver = new RemoteWebDriver(hubUrl, options);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            return driver;
        }
        
        if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("internetexplorer")) {
        	Log.info("-----------> Lunching IE <-----------");
        	Log.info("");
        	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			
			capabilities.setJavascriptEnabled(false);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			
			driver = new RemoteWebDriver(hubUrl, capabilities);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            return driver;
        }
        if (browserName.equalsIgnoreCase("safari")) {
            DesiredCapabilities capability = DesiredCapabilities.safari();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("opera")) {
            DesiredCapabilities capability = DesiredCapabilities.opera();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("phantomjs")) {
            DesiredCapabilities capability = DesiredCapabilities.phantomjs();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("android")) {
            DesiredCapabilities capability = DesiredCapabilities.android();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("htmlUnit")) {
            DesiredCapabilities capability = DesiredCapabilities.htmlUnit();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("htmlUnitWithJs")) {
//            DesiredCapabilities capability = DesiredCapabilities.htmlUnitWithJs();
//            driver = new RemoteWebDriver(hubUrl, capability);
//            return driver;
        }
        if (browserName.equalsIgnoreCase("ipad")) {
            DesiredCapabilities capability = DesiredCapabilities.ipad();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("iphone")) {
            DesiredCapabilities capability = DesiredCapabilities.iphone();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        Log.info("RemoteDriverFactory created an instance of RemoteWebDriver for: " + browserName);
        return driver;
    }
}