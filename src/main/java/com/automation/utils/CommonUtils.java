package com.automation.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class CommonUtils{

	public static WebDriver driver;
	
	public void setdriver(WebDriver lunchdriver) {
		driver = lunchdriver;
	}
	
	public WebDriver getdriver() {
		return driver;
	}
	
	public WebDriver lunchbrowser(){
		String browser = PropertyManager.getProperty("browser");
		URL huburl = null;
		
		
		Log.info("");
		Log.info("");
		try {
			huburl = new URL("http://localhost:5555/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
//		WebDriver driver = DriverFactory.createInstance(huburl, browser);
		
		WebDriver driver = LocalDriverFactory.createInstance(browser);
		setdriver(driver);
		return driver;		
	}
	
	public WebDriver lunchbrowser(String browser){
		URL huburl = null;
		
		Log.info("");
		Log.info("");
		try {
			huburl = new URL("http://localhost:5555/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
//		WebDriver driver = DriverFactory.createInstance(huburl, browser);
		
		WebDriver driver = LocalDriverFactory.createInstance(browser);
	
		setdriver(driver);
		return driver;
		
	}
	
	/*public WebDriver lunchbrowser(){
		String browser = PropertyManager.getProperty("browser");
		
		String driverLocation = null;
		WebDriver lunchdriver = null;
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			Log.info("----------- > Lunching firefox < -----------");
			Log.info("[This is Windows]");
			Log.info("");
			lunchdriver = new FirefoxDriver();
			
		}
		else if( browser.equalsIgnoreCase("chrome"))
		{
			Log.info("----------- > Lunching Chrome < -----------");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--cipher-suite-blacklist=0x0088,0x0087,0x0039,0x0038,0x0044,0x0045,0x0066,0x0032,0x0033,0x0016,0x0013");
			options.addArguments("--disable-popup-blocking");
			driverLocation = PropertyManager.getProperty("user.dir") + PropertyManager.getProperty("driverdir") + PropertyManager.getProperty("chromedriver");
			System.setProperty("webdriver.chrome.driver", driverLocation);
			Log.info("[This is Windows]");
			Log.info("");
			lunchdriver= new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("internetexplorer"))
		{
			Log.info("----------- > Lunching Internet Explorer < -----------");
			driverLocation = PropertyManager.getProperty("user.dir")+ PropertyManager.getProperty("driverdir") + PropertyManager.getProperty("iedriver");
			System.setProperty("webdriver.ie.driver",driverLocation);
			
			InternetExplorerDriverService service = InternetExplorerDriverService.createDefaultService();
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			
			//capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			//clear cache
			capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			//clear season
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			//capabilities.setCapability(InternetExplorerDriver.LOG_LEVEL, "TRACE");
			//capabilities.setCapability(InternetExplorerDriver.LOG_FILE, "C:/PACTS_Repo/Selenium/WorkSpace/PsiPsxCalculatorAutomation/log/seleniumlog.log");
			//capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
					
			Log.info("");
			Log.info("");
			lunchdriver = new InternetExplorerDriver(service, capabilities);
			lunchdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
		}
	
		setdriver(lunchdriver);
		return lunchdriver;		
	}*/
}
