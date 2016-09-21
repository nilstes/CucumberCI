# language: no
Egenskap: Plasser ordre
 
Scenario: Trykk bestill 
  Gitt at en bruker putter 3 varer i handlekurven 
    Når brukeren trykker på bestill-knappen
    Så skal det opprettes en ordre
    Og ordren skal legges til i ordrehistorikken

