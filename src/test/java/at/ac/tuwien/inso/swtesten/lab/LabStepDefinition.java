package at.ac.tuwien.inso.swtesten.lab;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LabStepDefinition {

	private LabSeleniumHelper labHelper = new LabSeleniumHelper();
	
	@Given("^Ich bin auf der Startseite$")
	public void ich_bin_auf_der_Startseite() throws Throwable {
	    labHelper.setUp();
	}

	@When("^Ich melde mich mit dem Team Benutzer \"([^\"]*)\" und dem Passwort \"([^\"]*)\" an$")
	public void ich_melde_mich_mit_dem_Team_Benutzer_und_dem_Passwort_an(String username, String password) throws Throwable {
	    labHelper.loginVereinWithUsernameAndPassword(username, password);
	}

	@Then("^Ich bin eingeloggt$")
	public void ich_bin_eingeloggt() throws Throwable {
	    labHelper.assertLoginSuccessful();
	}

	@When("^Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer \"([^\"]*)\" und dem Passwort \"([^\"]*)\" an$")
	public void ich_melde_mich_mit_dem_Veranstaltungs_Verwaltungs_Benutzer_und_dem_Passwort_an(String username, String password) throws Throwable {
	    labHelper.loginVeranstalterWithUsernameAndPassword(username, password);
	}

	@Then("^Anmeldung fehlgeschlagen$")
	public void anmeldung_fehlgeschlagen() throws Throwable {
		labHelper.assertLoginFailed();
	}
	
}
