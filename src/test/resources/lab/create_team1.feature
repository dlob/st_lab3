Feature: Verein anlegen

Background:
Given Ich bin auf der Startseite
When Ich melde mich mit dem Team Benutzer "maxmuster" und dem Passwort "muster123" an
Then Ich bin eingeloggt und seh das Dashboard

Scenario: Anlegen eines neuen Vereines Testverein (TV)
Given Ich bin als Verein-Benutzer angemeldet
And ich befinde mich auf der Startseite
When Ich klicke auf Mein Verein/Team und gebe "Musterverein" und "MV" und klicke auf Abschicken
Then die Daten des Vereins wurden erfolgreich gespeichert