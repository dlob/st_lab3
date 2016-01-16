Feature: Login

Background:
Given Ich bin auf der Startseite

Scenario: Team Benutzer einloggen
When Ich melde mich mit dem Team Benutzer "maxmuster" und dem Passwort "muster123" an
Then Ich bin eingeloggt

Scenario: Veranstaltungs-Verwaltungs Benutzer einloggen
When Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer "maxmuster" und dem Passwort "muster123" an
Then Ich bin eingeloggt

Scenario: Team Benutzer einloggen fehlgeschlagen
When Ich melde mich mit dem Team Benutzer "maxmuster" und dem Passwort "muster1234" an
Then Anmeldung fehlgeschlagen

Scenario: Veranstaltungs-Verwaltungs Benutzer einloggen fehlgeschlagen
When Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer "maxschneider" und dem Passwort "muster123" an
Then Anmeldung fehlgeschlagen
