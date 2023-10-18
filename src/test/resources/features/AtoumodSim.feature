@web
Feature: Sim

  @PageD'accueil
  Scenario: Page d'accueil
    Given Aller sur le site Atoumod
    When Afficher la page d'accueil du SIM
    And Vérifier la présence du widget RI

  @AllerSimple
  Scenario: Vérifier la page Aller-Simple
    Given Aller sur le site Atoumod
    When Cliquer sur la combobox et choisir Aller simple
    And  Choisir une origine
    And  Choisir une destination Sim



