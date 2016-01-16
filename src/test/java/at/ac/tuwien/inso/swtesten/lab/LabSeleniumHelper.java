package at.ac.tuwien.inso.swtesten.lab;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import at.ac.tuwien.inso.swtesten.util.SeleniumWebDriver;

public class LabSeleniumHelper {

	private WebDriver driver;
	private String baseUrl;

	public void setUp() {
		driver = SeleniumWebDriver.getDriver();
		baseUrl = "http://accreditation.qtixx.com/test/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void shutDown() {
		SeleniumWebDriver.closeDriver();
	}
	
}
