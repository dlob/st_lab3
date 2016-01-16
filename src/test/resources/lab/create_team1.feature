Feature: Verein anlegen

Scenario: Anlegen eines neuen Vereines Testverein (TV)
Given Ich bin als Verein-Benutzer angemeldet
And ich befinde mich auf der Startseite
When Ich klicke auf Mein Verein/Team und gebe "Musterverein" und "MV" und klicke auf Abschicken
Then die Daten des Vereins wurden erfolgreich gespeichert