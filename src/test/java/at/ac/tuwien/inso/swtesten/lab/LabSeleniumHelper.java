package at.ac.tuwien.inso.swtesten.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import at.ac.tuwien.inso.swtesten.util.SeleniumWebDriver;

public class LabSeleniumHelper {

	private WebDriver driver;
	private String baseUrl;

	public void setUp() {
		driver = SeleniumWebDriver.getDriver();
		baseUrl = "http://accreditation.qtixx.com/test";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void loginVereinWithUsernameAndPassword(String username,
			String password) throws Exception {
		driver.get(baseUrl + "/set-online/index.php");
		driver.findElement(By.id("loginMainButton")).click();
		driver.findElement(By.id("login_username")).clear();
		driver.findElement(By.id("login_username")).sendKeys(username);
		driver.findElement(By.id("login_passwd")).clear();
		driver.findElement(By.id("login_passwd")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

	public void loginVeranstalterWithUsernameAndPassword(String username,
			String password) throws Exception {
		driver.get(baseUrl + "/set-online/index.php");
		driver.findElement(By.id("loginMainButton")).click();
		driver.findElement(By.id("admin_login_username")).clear();
		driver.findElement(By.id("admin_login_username")).sendKeys(username);
		driver.findElement(By.id("admin_login_passwd")).clear();
		driver.findElement(By.id("admin_login_passwd")).sendKeys(password);
		driver.findElement(By.id("login2")).click();
	}
	
	public void assertLoggedIn() {
		assertTrue(isElementPresent(By.id("logoutMainButton")));
	}
	
	public void assertNotLoggedIn() {
		assertFalse(isElementPresent(By.id("logoutMainButton")));
	}
	
	public void logout() throws Exception {
		driver.findElement(By.id("logoutMainButton")).click();
	}

	public void assertOnDashboard() throws Exception {
		assertEquals(driver.getCurrentUrl(), "http://accreditation.qtixx.com/test/set-online/home_user_main.php?active_menu=dashboard");
	}

	public void assertOnAdminDashboard() throws Exception {
		assertEquals(driver.getCurrentUrl(), "http://accreditation.qtixx.com/test/set-online/administration.php?active_menu=Administration");
	}
		
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void shutDown() {
		SeleniumWebDriver.closeDriver();
	}

}
