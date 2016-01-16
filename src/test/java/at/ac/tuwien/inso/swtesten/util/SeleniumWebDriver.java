package at.ac.tuwien.inso.swtesten.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class SeleniumWebDriver {

	private static WebDriver webdriver = null;

	public static WebDriver getDriver() {		
		if(webdriver == null) {
			webdriver = new FirefoxDriver(new FirefoxProfile());
		}
		
		return webdriver;
	}

	public static void closeDriver() {
		try {
			webdriver.quit();	
			webdriver = null;
		} catch (UnreachableBrowserException e) {}
	}

}
