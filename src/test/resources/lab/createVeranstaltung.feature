Feature: Verstanstaltung anlegen

Background: 
Given Ich bin auf der Startseite
When Ich melde mich mit dem Veranstaltungs-Verwaltungs Benutzer "maxmuster" und dem Passwort "muster123" an
Then Ich bin eingeloggt und seh das Administrator Dashboard

Scenario: Veranstaltung anlegen
Given Ich bin auf der Startseite
When Ich erstelle eine neue Veranstaltung mit dem Namen "meine Veranstaltung" von "2016.01.01" bis "2017.01.01" mit Start der Nennung "2015.01.01" und Ende "2015.12.31" Zeitzone "Europe/Vienna" Kontakt-Email "mymail@issecret.com" Typ "Turnier" Land "Austria" Waehrung "EUR" Adresse "no need" Registrierungsmodus "Stichtag"
Then Veranstaltung "meine Veranstaltung" wurde erstellt

Scenario: Team Benutzer einloggen fehlgeschlagen
Given Ich bin auf der Startseite
When Ich melde mich mit dem Team Benutzer "maxmuster" und dem Passwort "muster1234" an
Then Anmeldung fehlgeschlagen