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
		labHelper.assertNotLoggedIn();
		labHelper.loginVereinWithUsernameAndPassword(username, password);
	}

	@When("^Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer \"([^\"]*)\" und dem Passwort \"([^\"]*)\" an$")
	public void ich_melde_mich_mit_dem_Veranstaltungs_Verwaltungs_Benutzer_und_dem_Passwort_an(String username, String password) throws Throwable {
		labHelper.assertNotLoggedIn();
		labHelper.loginVeranstalterWithUsernameAndPassword(username, password);
	}

	@Then("^Ich bin eingeloggt$")
	public void ich_bin_eingeloggt() throws Throwable {
	    labHelper.assertLoggedIn();
		labHelper.shutDown();
	}

	@Then("^Anmeldung fehlgeschlagen$")
	public void anmeldung_fehlgeschlagen() throws Throwable {
		labHelper.assertNotLoggedIn();
		labHelper.shutDown();
	}
	
	@Then("^Ich bin eingeloggt und seh das Dashboard$")
	public void ich_bin_eingeloggt_uns_seh_das_Dashboard() throws Throwable {
	    labHelper.assertLoggedIn();
	    labHelper.assertOnDashboard();
	}
	
	@Then("^Ich bin eingeloggt und seh das Administrator Dashboard$")
	public void ich_bin_eingeloggt_uns_seh_das_Administrator_Dashboard() throws Throwable {
	    labHelper.assertLoggedIn();
	    labHelper.assertOnAdminDashboard();
	}
	
	@Then("^eine Fehlermeldung erscheint$")
	public void eine_Fehlermeldung_erscheint() throws Exception {
		labHelper.assertErrorBox();
		labHelper.shutDown();
	}
}
