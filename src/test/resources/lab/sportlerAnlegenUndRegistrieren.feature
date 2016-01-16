Feature: Sportler anlegen und zu einer Veranstaltung anmelden

Background:
Given Ich bin auf der Startseite
When Ich melde mich mit dem Team Benutzer "maxmuster" und dem Passwort "muster123" an
Then Ich bin eingeloggt und seh das Dashboard

Scenario: Anlegen eines neuen Vereines
And When Ich klicke auf Mein Verein/Team und gebe "Musterverein" und "MV" und klicke auf Abschicken
Then die Daten des Vereins wurden erfolgreich gespeichert

Scenario: Anlegen eines neuen Sportlers
And When Ich klicke auf Meine Sportler, Neuen Sportler anlegen und gebe Vorname "Test", Nachname "Sportler", Geburt "01-01-1990" ein und klicke auf Abschicken
Then der Sportler wurde erfolgreich angelegt

Scenario: Anlegen eines neuen Sportlers mit Fehler
And When Ich klicke auf Meine Sportler, Neuen Sportler anlegen und gebe Vorname "Test", Nachname "Sportler", Geburt "01.01.1990" ein und klicke auf Abschicken
Then eine Fehlermeldung erscheint

Scenario: Anlegen eines neuen Sportlers mit Fehler
And When Ich klicke auf Meine Sportler, Neuen Sportler anlegen und gebe Vorname "Test", Nachname "Sportler", Geburt "30-02-1990" ein und klicke auf Abschicken
Then eine Fehlermeldung erscheint

Scenario: Anmelden des Sportler zur Veranstaltung
And When Ich klicke auf Events, wähle die Veranstaltung Cafe Benno Musik Abend aus, Registrierung, Sportler, Neue Einzelmeldung, Sportler: Sportler Test und Kategorie: Sitzplatz (18-98) und klicke auf Abschicken. 
Then der Sportler wurde zur Veranstaltung angemeldet