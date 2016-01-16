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
	public void ich_melde_mich_mit_dem_Team_Benutzer_und_dem_Passwort_an(
			String username, String password) throws Throwable {
		labHelper.assertNotLoggedIn();
		labHelper.loginVereinWithUsernameAndPassword(username, password);
	}

	@When("^Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer \"([^\"]*)\" und dem Passwort \"([^\"]*)\" an$")
	public void ich_melde_mich_mit_dem_Veranstaltungs_Verwaltungs_Benutzer_und_dem_Passwort_an(
			String username, String password) throws Throwable {
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

	@When("^Ich erstelle eine neue Veranstaltung mit dem Namen \"([^\"]*)\" von \"([^\"]*)\" bis \"([^\"]*)\" mit Start der Nennung \"([^\"]*)\" und Ende \"([^\"]*)\" Zeitzone \"([^\"]*)\" Kontakt-Email \"([^\"]*)\" Typ \"([^\"]*)\" Land \"([^\"]*)\" Waehrung \"([^\"]*)\" Adresse \"([^\"]*)\" Registrierungsmodus \"([^\"]*)\"$")
	public void ich_erstelle_eine_neue_Veranstaltung_mit_dem_Namen_von_bis_mit_Start_der_Nennung_und_Ende_Zeitzone_Kontakt_Email_Typ_Land_Waehrung_Adresse_Registrierungsmodus(
			String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6, String arg7, String arg8, String arg9, String arg10,
			String arg11, String arg12) throws Throwable {
		labHelper.createVeranstaltungFromParams(arg1, arg2, arg3, arg4, arg5, arg6, arg7,
				arg8, arg9, arg10, arg11, arg12);
	}

	@Then("^Veranstaltung \"([^\"]*)\" existiert$")
	public void veranstaltung_existiert(String arg1) throws Throwable {
		labHelper.assertVeranstaltungExists(arg1);
	}

	@When("^Ich erstelle eine neue Kategorie in der Veranstaltung \"([^\"]*)\" mit Bezeichnung \"([^\"]*)\" Alter-von \"([^\"]*)\" Alter-bis \"([^\"]*)\" Geschlecht \"([^\"]*)\" Teamkategorie \"([^\"]*)\"$")
	public void ich_erstelle_eine_neue_Kategorie_in_der_Veranstaltung_mit_Bezeichnung_Alter_von_Alter_bis_Geschlecht_Teamkategorie(
			String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6) throws Throwable {
		labHelper.createKategorieInVeranstaltung(arg1,  arg2, arg3, arg4, arg5, arg6);
	}

	@Then("^Kategorie \"([^\"]*)\" in \"([^\"]*)\" existiert$")
	public void kategorie_in_existiert(String arg1, String arg2)
			throws Throwable {
		labHelper.assertKategorieExists(arg1, arg2);
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
