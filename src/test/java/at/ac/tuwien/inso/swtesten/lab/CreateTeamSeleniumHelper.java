package at.ac.tuwien.inso.swtesten.lab;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTeamSeleniumHelper {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://accreditation.qtixx.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCreateTeam() throws Exception {
		driver.get(baseUrl + "/test/set-online/index.php?active_menu=home");
		driver.findElement(By.linkText("Mein Verein/Team")).click();
		driver.findElement(By.name("manage_verein_name")).clear();
		driver.findElement(By.name("manage_verein_name")).sendKeys(
				"Musterverein");
		driver.findElement(By.name("manage_verein_short")).clear();
		driver.findElement(By.name("manage_verein_short")).sendKeys("MV");
		driver.findElement(By.name("regtouradmin_submit")).click();
	}

	// @After
	// public void tearDown() throws Exception {
	// driver.quit();
	// String verificationErrorString = verificationErrors.toString();
	// if (!"".equals(verificationErrorString)) {
	// fail(verificationErrorString);
	// }
	// }

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

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
