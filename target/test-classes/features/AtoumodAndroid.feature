@smokeAndroid
Feature:Atoumod Mobil Testing with Appium Android

  @EcranDaccueilAndroid
  Scenario: Vérification de toutes les fonctions sur la Homepage!
    Given Afficher et Vérifier la page d'accueil
    When Cliquer sur les trois points et ajouter une étape
    And  Vérifier la visibilité de barre donglets
    And Consulter l'écran Menu
    And Consulter l'entrée Paramètres
    Then Vérifier la présence du Autour de vous
    And Au clic, une animation permet de montrer à lutilisateur que la map sagrandit full screen pour pouvoir naviguer à l'intérieur.
    And Au clic Itineraire, on est redirigé sur la home avec le champ Arrivée du widget RI renseigné
    And Ajouter une étape
    And Vérifier l'affichage du bouton Rechercher
    And Vérifier Horaises des lignes
    And Voir section Acheter un titre pour la suite des tests
    And Vérifiez que vous êtes bien redirigé vers la page Acheter un titre

  @AllerSimple
  Scenario: Vérifier la page Aller-Simple
    Given Choisir aller simple
    When Saisir une address
    Then Choisir une destination
    And Si l'utilisateur a déjà effectué des recherches, ses sélections précédentes remontent dans une liste sous le champ de recherche.
    And Faire une recherche pour Aller-Simple
    And Vérifier la différence entre les heures de départ et d'arrivée
    And Afficher les transports de l'heure précédente
    And Afficher les transports de l'heure suivante et vérifier les suggestions
    And Cliquer sur licone fleche haut fleche bas pour changer lorigine et la destination

  @AllerRetour
  Scenario: Vérifier la page Aller-Retour
    Given Choisir aller retour
    When Cliquer sur le calendrier pour Aller
    Then Cliquer le calendrier pour Aller-Retour
    And Cliquer sur licône flèche haut flèche bas pour changer l'origine et la destination
    And Faire une recherche
    And Cliquer sur le calendrier sur le bouton Retour et sélectionner une date et ou une heure. Pas de sélection par défaut.
    And Cliquer le bouton Horaires des lignes

  @AllerSimpleRésultats
  Scenario: Vérification de la page Results pour Aller-simple
    Given Choisir aller simple
    When Saisir une address
    Then Choisir une destination
    And  Faire une recherche pour Aller-Simple
    And  Vérifier la différence entre les heures de départ et d'arrivée
    And  Vérifier la présence des émissions de CO2
    And  Cliquer sur un résultat Transports en commun
    And  Cliquer sur les émissions de CO² et vérifier le texte
    And  Afficher les étapes Voir les étapes
    And  Cliquer sur Voir le recapitulatif
    And  Consulter les résultats de la section Vélo
    And  Vérifier la différence entre les heures de départ et d'arrivée pour Vélo
    And  Afficher les étapes Voir les étapes pour Vélo
    And  Cliquer sur le résultat Voiture
    And  Consulter le résultat Marche

  @AllerSimpleOptionsDitinéraire
  Scenario: Vérification de l'options d'itinéraire pour Aller-simple
    Given Choisir aller simple
    When Saisir une address
    Then Choisir une destination
    And  Cliquer sur le bouton options trajet
    And  Vérifier la page options d'itinéraire
    And  Vérifier tous les types de trajets
    And  Vérifier la vitesse de marche
    And  Vérifier le niveau de cyclisme
    And  Cliquer les modes de transports
    And Sélectionner uniquement le mode bus
    And Cliquer sur le bouton Rechercher
    And Vérifier que le mode bus est visible.





  @AllerRetourRésultats
  Scenario:Consulter les résultats pour Aller Retour
    Given Choisir aller retour
    When Cliquer sur le calendrier pour Aller
    And  Consulter les résultats de recherche d'itinéraire
    And  Afficher les étapes Voir les étapes pour Aller-retour
    And  Cliquer sur les émissions de CO² et vérifier le texte pour Aller-retour
    And  Cliquer sur Choisir un retour et Consulter les résultats Transports en commun pour le retoura
    And  Choisir un des résultats Transports en commun pour le retour
    And  Cliquer sur Voir le recapitulatif pour Aller-Retour

  @HorairesDesLignes
  Scenario: Consulter les Horaires des Lignes
    Given Sur la home, cliquer sur l'illustration Horaires des lignes
    When L'utilisateur arrive sur un écran de recherche permettant de saisir un numéro de ligne
    Then Renseigner un numéro de ligne
    And  Sélectionner une ligne
    And  Changer le terminus
    And Sélectionner un arrêt sur la ligne  dans la liste du thermomètre
    And Afficher les prochains passages à l'arrêt et Cliquer sur Tous les horaires
    And Afficher tous les passages du jour à l'arrêt et Cliquer sur Voir tout

  @AutourDeVous
  Scenario: Consulter la carte
    Given Afficher et Vérifier la page d'accueil
    When Consulter l'écran
    And Consulter la présence du Autour de vous
    And Vérifier Placeholder du champ Rechercher...
    And Se déplacer sur la carte
    And Zoomer et Dézoomer sur la carte
    And Recentrer la géolocalisation
    And Cliquer sur le champ Recherche d'adresse
    And Sélectionner un point de mobilité sur la carte (arrêt de bus, de train, de métro de tram : picto sur fond bleu)
    And Cliquer sur la croix dans le champ de recherche
    And Sélectionner un point d'intérêt sur la carte
    And Cliquer sur Itinéraire sur le détail d'un POI






























