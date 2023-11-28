@Mobile
Feature: Inscription à un Cours sur Ornikar

  Scenario: Inscription à un Cours
    Given L'utilisateur accède à la page daccueil dOrnikar
    When Se connecte à mon compte
    Then Confirmer que la connexion a réussi
    When Passer l'ongle "Accueil"
    Then Cliquer le bouton "Découvrir"


    Then Sélectionne le type de permis que je souhaite obtenir
    When S'inscrire au cours choisi
    Then Rediriger vers la page de paiement
    And Confirmer qu'il a été redirigé vers la page de paiement
    When Entrer mes informations de paiement et choisir ma méthode de paiement préférée
    Then S'assurer que le paiement a été effectué avec succès
    And Confirmer qu'un message de confirmation s'affiche
