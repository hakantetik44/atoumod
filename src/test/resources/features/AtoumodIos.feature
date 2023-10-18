@smokeIos
Feature:Atoumod Mobil Testing with Appium Ios

  @EcranDaccueilIos
  Scenario: Vérification de toutes les fonctions sur page d'accueil!
    Given Afficher et Vérifier la page daccueil
    When Cliquer sur les trois points
    And Vérifier la disponibilité à proximité
    And Consulter la visibilité de barre donglets
    And Consulter l'écran Menu (Ios)
    And Vérifier l'entrée Paramètres
    And Consulter Placeholder du champ Rechercher...
    And Au clic, une animation permet de montrer à lutilisateur que la map sagrandit plein écran pour pouvoir naviguer à l'intérieur.
    And Au clic Itineraire pour ma position, on est redirigé sur la home avec le champ Arrivée du widget RI renseigné
    And Cliquer sur Ajouter une étape
    And Vérifier la présentation du bouton Rechercher
    And Vérifier les Horaises des lignes
    And Consulter section Acheter un titre pour la suite des tests
    And Vérifiez si vous avez été redirigé vers Atoumod M-ticket


  @AllerSimpleIos
  Scenario: Vérifier la page Aller-Simple
    Given Cliquer sur aller simple
    When  Entrer une address
    Then Sélectionner une destination
    And Si l'utilisateur a déjà effectué des recherches, ses sélections précédentes affiché dans une liste sous le champ de recherche.
    And Effectuer une recherche pour Aller-Simple
    And Vérifier la différence entre les heures de départ et d'arrivée RI
    And Vérifier les transports de l'heure précédente
    And Afficher les transports de l'heure suivante et vérifier les suggestions pour Aller-Simple
    And Cliquer sur licone fleche haut fleche bas pour changer le point de départ et la destination
    And L'utilisateur peut aussi cliquer sur Ma position pour Depart
    And L'utilisateur peut aussi cliquer sur Ma position pour Arriver


  @AllerRetourIos
  Scenario: Vérifier la page Aller-Retour
    Given Sélectionner aller retour
    When Cliquer sur le bouton calendrier pour Aller
    Then Cliquer sur le calendrier pour Aller-Retour
    And Cliquer sur licône flèche haut flèche bas pour changer départ et la destination
    And Faire une recherche pour Aller-Retour
    And Cliquer sur le calendrier sur le bouton Retour et sélectionner une date et ou une heure.
    And Cliquer le bouton Horaires & perturbations


  @AllerSimpleRésultatsIos
  Scenario:Consulter les résultats pour Aller Simple
    Given Cliquer sur aller simple
    When Entrer une address
    Then Sélectionner une destination
    And  Effectuer une recherche pour Aller-Simple
    And  Vérifier la présence des émissions CO2
    And  Vérifier la différence entre les heures de départ et d'arrivée RI
    And  Cliquer sur un résultat dans le Transports en commun
    And  Consulter les émissions de CO² et vérifier le texte
    And  Cliquer sur les étapes Voir les étapes
    And  Cliquer sur le bouton Voir le recapitulatif
    And  Vérifier les résultats de la section Vélo
    And  Vérifier la différence entre les heures de départ et darrivée pour loption Vélo
    And  Vérifier les étapes Voir les étapes pour Vélo
    And  Choisir le résultat Voiture
    And  Vérifier le résultat Marche



  @AllerRetourRésultatsIos
  Scenario:Consulter les résultats pour Aller Retour
    Given Sélectionner aller retour
    When Vérifier les résultats de recherche d'itinéraire
    Then Consulter les résultats Transports en commun de l'aller
    And  Sélectionner un des résultats Transports en commun pour l'aller
    And  Cliquer sur Voir les étapes
    And  Cliquer sur Choisir un retour et Consulter les résultats Transports en commun pour le Trajet retour
    And  Sélectionner un des résultats Transports en commun pour le retour
    And  Consulter les émissions de CO² et vérifier le texte
    And  Cliquer sur les étapes Voir les étapes
    And  Cliquer sur Voir le recapitulatif pour l'Aller-Retour


  @HorairesDesLignesIos
  Scenario: Consulter les Horaires des Lignes
    Given Sur la page d'accueil, cliquer sur l'illustration Horaires des lignes
    When L'utilisateur arrive sur un écran de recherche permettant d'entrer un numéro de ligne
    Then Saisir un numéro de ligne
    And  Choisir une ligne
    And Changer le terminus déjà sélectionné
    And Choissir un arrêt sur la ligne  dans la liste du thermomètre
    And Afficher les prochains passages à l'arrêt et Cliquer sur le bouton Tous les horaires
    And Consulter tous les passages du jour à l'arrêt et Cliquer sur Voir tout

  @AutourDeVousIos
  Scenario: Consulter la carte ios
    Given Afficher et Vérifier la page daccueil
    When Consulter l'écran d'accueil
    And Vérifier la disponibilité à proximité
    And Consulter Placeholder du champ Rechercher...
    And Naviguer à travers la carte.
    And Agrandir et Réduire la carte
    And Recentrer la localisation géographique
    And Aller dans le champ de recherche d'adresse
    And Choisir un point de mobilité sur la carte (arrêt de bus, de train, de métro de tram : picto sur fond bleu)
    And Cliquer sur la croix
    And Choisir un point d'intérêt sur la carte
    And Cliquer sur le bouton Itinéraire sur le détail d'un POI

  @AcheterUnTitreIos
  Scenario:Consulter Acheter un titre
    When Vérifier la présence de l'entrée Acheter un titre dans la tabbar et cliquer
    And Consulter l'écran Acheter un titre





































