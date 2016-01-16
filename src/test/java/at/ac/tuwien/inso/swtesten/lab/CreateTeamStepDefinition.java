package at.ac.tuwien.inso.swtesten.lab;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTeamStepDefinition {
	
	private CreateTeamSeleniumHelper createTeam = new CreateTeamSeleniumHelper();

	@Given("^Ich bin als Verein-Benutzer angemeldet$")
	public void ich_bin_als_Verein_Benutzer_angemeldet() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^ich befinde mich auf der Startseite$")
	public void ich_befinde_mich_auf_der_Startseite() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Ich klicke auf Mein Verein/Team und gebe \"([^\"]*)\" und \"([^\"]*)\" und klicke auf Abschicken$")
	public void ich_klicke_auf_Mein_Verein_Team_und_gebe_und_und_klicke_auf_Abschicken(String arg1, String arg2) throws Throwable {
		createTeam.testCreateTeam();
	}

	@Then("^die Daten des Vereins wurden erfolgreich gespeichert$")
	public void die_Daten_des_Vereins_wurden_erfolgreich_gespeichert() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
