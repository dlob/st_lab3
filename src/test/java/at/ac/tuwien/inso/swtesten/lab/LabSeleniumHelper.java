package at.ac.tuwien.inso.swtesten.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

	public void createVeranstaltungFromParams(String veranstaltung,
			String dateFrom, String dateTo, String nennungFrom,
			String nennungTo, String timeZone, String email, String typ,
			String country, String currency, String address, String reg_mode) {
		driver.get(baseUrl + "/set-online/index.php?active_menu=home");

		driver.findElement(By.linkText("Neue Veranstaltung")).click();
		driver.findElement(By.name("verinfo_bezeichnung")).clear();
		driver.findElement(By.name("verinfo_bezeichnung")).sendKeys(
				veranstaltung);
		driver.findElement(By.name("verinfo_datum")).clear();
		driver.findElement(By.name("verinfo_datum")).sendKeys(dateFrom);
		driver.findElement(By.name("verinfo_datumend")).clear();
		driver.findElement(By.name("verinfo_datumend")).sendKeys(dateTo);
		driver.findElement(By.name("verinfo_regstart")).clear();
		driver.findElement(By.name("verinfo_regstart")).sendKeys(nennungFrom);
		driver.findElement(By.name("verinfo_regend")).clear();
		driver.findElement(By.name("verinfo_regend")).sendKeys(nennungTo);

		new Select(driver.findElement(By.name("verinfo_timezone")))
				.selectByVisibleText(timeZone);

		driver.findElement(By.name("verinfo_eventcontactemail")).clear();
		driver.findElement(By.name("verinfo_eventcontactemail"))
				.sendKeys(email);

		new Select(driver.findElement(By.name("verinfo_typ")))
				.selectByVisibleText(typ);
		new Select(driver.findElement(By.name("verinfo_land")))
				.selectByVisibleText(country);

		new Select(driver.findElement(By.name("verinfo_waehrung")))
				.selectByVisibleText(currency);
		driver.findElement(By.name("verinfo_adresse")).clear();
		driver.findElement(By.name("verinfo_adresse")).sendKeys(address);

		new Select(driver.findElement(By.name("verinfo_regmode")))
				.selectByVisibleText(reg_mode);

		driver.findElement(By.name("event_license_check")).click();
		driver.findElement(By.name("verinfoedit_submit")).click();
	}

	public boolean veranstaltungExists(String veranstaltung) {

		driver.get(baseUrl
				+ "/set-online/administration_veranstaltung.php?active_menu=adminveranstaltungen");
		driver.findElement(By.linkText("Meine Veranstaltungen")).click();

		return isElementPresent(By.partialLinkText(veranstaltung));
	}

	public void assertVeranstaltungExists(String veranstaltung) {
		assertTrue(veranstaltungExists(veranstaltung));
	}

	public void createKategorieInVeranstaltung(String veranstaltung,
			String bezeichnung, String alterVon, String alterBis, String sex,
			String team) {
		driver.get(baseUrl
				+ "/set-online/administration_veranstaltung.php?active_menu=adminveranstaltungen");
		driver.findElement(By.linkText("Meine Veranstaltungen")).click();

		driver.findElement(By.partialLinkText(veranstaltung)).click();
		driver.findElement(By.linkText("Kategorien angelegt")).click();
		driver.findElement(By.linkText("Neue Kategorie anlegen")).click();

		driver.findElement(By.name("cat_bezeichnung")).clear();
		driver.findElement(By.name("cat_bezeichnung")).sendKeys(bezeichnung);
		driver.findElement(By.name("cat_von")).clear();
		driver.findElement(By.name("cat_von")).sendKeys(alterVon);
		driver.findElement(By.name("cat_bis")).clear();
		driver.findElement(By.name("cat_bis")).sendKeys(alterBis);
		new Select(driver.findElement(By.name("cat_sex")))
				.selectByVisibleText(sex);
		try {
			boolean b = Boolean.parseBoolean(team);
			if (b)
				driver.findElement(By.name("cat_team")).click();
		} catch (Exception e) {
			// do nothing instead
		}
		driver.findElement(By.name("cat_submit")).click();
	}

	public boolean kategorieExists(String veranstaltung, String kategorie) {

		driver.get(baseUrl
				+ "/set-online/administration_veranstaltung.php?active_menu=adminveranstaltungen");
		driver.findElement(By.linkText("Meine Veranstaltungen")).click();
		driver.findElement(By.partialLinkText(veranstaltung)).click();
		
		driver.findElement(By.linkText("Kategorien angelegt")).click();
		
		return isElementPresent(By.xpath("//tr.dctabrowwhite/td[text() == "+kategorie));
	}

	public void assertKategorieExists(String veranstaltung, String kategorie) {
		assertTrue(veranstaltungExists(veranstaltung));
	}

	public void assertOnDashboard() throws Exception {
		assertEquals(driver.getCurrentUrl(), "http://accreditation.qtixx.com/test/set-online/home_user_main.php?active_menu=dashboard");
	}

	public void assertOnAdminDashboard() throws Exception {
		assertEquals(driver.getCurrentUrl(), "http://accreditation.qtixx.com/test/set-online/administration.php?active_menu=Administration");
	}
	
	public void assertErrorBox() throws Exception {
		assertTrue(isElementPresent(By.cssSelector("li.global-message-item.error span.msg-text")));
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
