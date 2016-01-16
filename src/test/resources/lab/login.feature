Feature: Login

Scenario: Team Benutzer einloggen
Given Ich bin auf der Startseite
When Ich melde mich mit dem Team Benutzer "maxmuster" und dem Passwort "muster123" an
Then Ich bin eingeloggt

Scenario: Veranstaltungs-Verwaltungs Benutzer einloggen
Given Ich bin auf der Startseite
When Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer "maxmuster" und dem Passwort "muster123" an
Then Ich bin eingeloggt

Scenario: Team Benutzer einloggen fehlgeschlagen
Given Ich bin auf der Startseite
When Ich melde mich mit dem Team Benutzer "maxmuster" und dem Passwort "muster1234" an
Then Anmeldung fehlgeschlagen

Scenario: Veranstaltungs-Verwaltungs Benutzer einloggen fehlgeschlagen
Given Ich bin auf der Startseite
When Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer "maxschneider" und dem Passwort "muster123" an
Then Anmeldung fehlgeschlagen