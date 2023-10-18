package stepdefinitions;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.Allpages;
import pages.BasePageAndroid;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static utils.DriverMobile.getDriver;



public class PageStepDefsAndroid extends BasePageAndroid {

    private static final Logger LOG = LoggerFactory.getLogger(PageStepDefsAndroid.class);
    Allpages atoumod = new Allpages();

    Actions actions = new Actions(getDriver());
    TouchAction action = new TouchAction((PerformsTouchActions) getDriver());


    @Given("Aller à la page AtouMod")
    public void allerÀLaPageAtouMod() {
        getDriver();

    }


    @Given("Afficher et Vérifier la page d'accueil")
    public void afficherEtVérifierLaPageDAccueil() throws InterruptedException {

        try {

            if (atoumod.btnAutoriser.isDisplayed()) {
                atoumod.btnAutoriser.click();

                TimeUnit.SECONDS.sleep(3);
            }
        } catch (NoSuchElementException e) {

        }


        String textTraj = "Trajet";
        assertTrue(atoumod.textTrajet.getText().contains(textTraj));


        assertTrue(atoumod.placeAdresseDe.isDisplayed());

        assertTrue(atoumod.placeAdresseA.isDisplayed());

        scrollDown(getDriver());

        assertTrue(atoumod.getTextAutourDeVous.isDisplayed());


    }


    @When("Cliquer sur les trois points et ajouter une étape")
    public void cliquerSurLesTroisPointsEtAjouterUneEtape() throws InterruptedException {

        atoumod.leBoutonTroisPoints.click();
        Thread.sleep(2000);
        atoumod.getLeBoutonAjouterUneEtape.click();
        atoumod.autoriserAtoumodStaning.click();
        getDriver().navigate().back();
        atoumod.rechercherUneAdresse.sendKeys("Saint-Pierre-du-Vauvray");
        atoumod.mairieStPierreDuVauvray.click();


    }


    @And("Vérifier la visibilité de barre donglets")
    public void andVérifierLaVisibilitéDeBarreDonglets() {

        assertTrue(atoumod.getAccueil.isDisplayed());
        atoumod.getAccueil.click();
        assertTrue(atoumod.getTicketing.isDisplayed());
        atoumod.getTicketing.click();

    }

    @And("Consulter l'écran Menu")
    public void consulterLÉcranMenu() {

        atoumod.getMenu.click();

        String expectedTextBonjour = "Bonjour !";
        assertTrue(atoumod.getTextBonjour.getText().contains(expectedTextBonjour));
        atoumod.getParametres.click();

        String expectedTextParametresEtInformations = "Paramètres et informations";

        assertTrue(atoumod.getTextParametresEtInformations.getText().contains(expectedTextParametresEtInformations));

        //TODO: Verifier la version

          atoumod.btnRetour.click();

        atoumod.getAccueil.click();


    }

    @And("Consulter l'entrée Paramètres")
    public void consulterLEntréeParamètres() {

    }


    @And("Vérifier la présence du Autour de vous")
    public void vérifierLaPrésenceDuAutourDeVous() throws InterruptedException {

        assertTrue(atoumod.getTextAutourDeVous.isDisplayed());


        atoumod.getMap.click();
        Thread.sleep(2000);


       atoumod.getTextRechercher1.click();

        atoumod.rechercherUneAdresse.sendKeys("Rouen Rive-Droite");
        assertTrue(atoumod.rouenRiveDroite.isDisplayed());
        atoumod.rechercherUneAdresse.clear();
        atoumod.rechercherUneAdresse.sendKeys("Gare de Caen");
        assertTrue(atoumod.GaredeCaen.isDisplayed());
        atoumod.GaredeCaen.click();

        Thread.sleep(2000);


        atoumod.iconBus.click();

        String laGareCaenExpectedText = "Gare de Caen";


        assertTrue(atoumod.laGareCaenFavori.getText().contains(laGareCaenExpectedText));


    }


    @And("Au clic, une animation permet de montrer à lutilisateur que la map sagrandit full screen pour pouvoir naviguer à l'intérieur.")
    public void auClicUneAnimationPermetDeMontrerÀLutilisateurQueLaMapSagranditFullScreenPourPouvoirNaviguerÀLIntérieur() throws InterruptedException {


        atoumod.map.click();
        atoumod.rechercherUneAdresse.clear();

        atoumod.rechercherUneAdresse.sendKeys("Collége Jacques Daviel");

        atoumod.getMesnilEnOuche.click();

        action.tap(ElementOption.element(atoumod.getCarteGoogleIcon)).perform();
        action.tap(ElementOption.element(atoumod.getCarteGoogleIcon)).perform();


        Thread.sleep(3000);


        //


        // Driver.getAppiumDriver().navigate().back();
    }

    @And("Au clic Itineraire, on est redirigé sur la home avec le champ Arrivée du widget RI renseigné")
    public void auClicItineraireOnEstRedirigéSurLaHomeAvecLeChampArrivéeDuWidgetRIRenseigné() throws InterruptedException {

        atoumod.getBtnItinéraire.click();
        String textCollégeJacquesDaviel = "Collége Jacques Daviel";
        System.out.println(atoumod.getBtnItineraireBtnAller);


        atoumod.allerSimple.click();

        atoumod.allerSimple.click();

        // assertTrue(atoumod.getBtnItineraireBtnAller.getText().contains(textCollégeJacquesDaviel));
        //assertTrue(atoumod.getCollégeJacquesDaviel.isDisplayed());


        atoumod.getDe.click();
        atoumod.rechercherUneAdresse.sendKeys("Gare de Caen");
        Thread.sleep(2000);
        assertTrue(atoumod.GaredeCaen.isDisplayed());

        atoumod.GaredeCaen.click();


    }


    @Given("Choisir aller simple")
    public void choisirAllerSimple() throws InterruptedException {

        try {

            if (atoumod.btnAutoriser.isDisplayed()) {
                atoumod.btnAutoriser.click();

                TimeUnit.SECONDS.sleep(3);
            }
        } catch (NoSuchElementException e) {

        }


        // assertTrue(atoumod.allerSimple.isDisplayed());


        actions.doubleClick(atoumod.allerSimple).click();


    }

    @When("Saisir une address")
    public void saisirUneAddress() throws InterruptedException {
        Thread.sleep(2000);
         atoumod.getDe.click();
        if (atoumod.autoriserAtoumodStaning.isDisplayed()) {

            atoumod.autoriserAtoumodStaning.click();
        }


        atoumod.rechercherUneAdresse.sendKeys("Gare de Caen");

        assertTrue(atoumod.btnGareDeCaen.isEnabled());

        atoumod.btnGareDeCaen.click();


    }


    @And("Choisir une destination")
    public void choisirUneDestination() throws InterruptedException {
        atoumod.placeAdresseA.click();
        atoumod.rechercherUneAdresse.sendKeys("Caen-Calvaire Saint-Pierre");

        String expectedTextPlaceA = "Caen-Calvaire Saint-Pierre";

        Assert.assertTrue(atoumod.btnCalvaireStPierre.getText().contains(expectedTextPlaceA));

        atoumod.btnCalvaireStPierre.click();


    }


    @And("Cliquer sur le bouton options trajet")
    public void cliquerSurLeBoutonOptionsTrajet() {

        atoumod.Filtre.click();

    }

    @And("Cliquer sur licone origine et la destination")
    public void cliquerSurLIconeFlecheHautFlecheBasPourChangerLOrigineEtLaDestination() {
        atoumod.textRetour.click();


    }

    @And("Cliquer sur licone fleche haut fleche bas pour changer lorigine et la destination")
    public void cliquerSurLiconeFlecheHautFlecheBasPourChangerLorigineEtLaDestination() {


    }

    @Given("Choisir aller retour")
    public void choisirAllerRetour() throws InterruptedException {

        try {

            if (atoumod.btnAutoriser.isDisplayed()) {
                atoumod.btnAutoriser.click();

                TimeUnit.SECONDS.sleep(3);
            }
        } catch (NoSuchElementException e) {


        }
        Thread.sleep(3000);
        atoumod.allerSimple.click();

        assertTrue(atoumod.textAllerRetour.isEnabled());

        atoumod.textAllerRetour.click();

        atoumod.placeAdresseDe.click();
        if (atoumod.autoriserAtoumodStaning.isDisplayed()) {
            atoumod.autoriserAtoumodStaning.click();
        }
        atoumod.rechercherUneAdresse.sendKeys("Rouen Rive-Droite");
        atoumod.getRouenRiveDroite.click();
        atoumod.placeAdresseA.click();
        atoumod.rechercherUneAdresse.sendKeys("Saint-Pierre-du-Vauvray");
        atoumod.getMairieStPierreDuVauvray.click();

    }


    @When("Cliquer sur le calendrier pour Aller")
    public void cliquerSurLeCalendrierPourAller() {


        assertTrue(atoumod.leBtnCalenderirRetour.isEnabled());

        atoumod.leBtnCalenderirRetour.click();

        assertTrue(atoumod.leBtnValider.isEnabled());

        atoumod.leBtnValider.click();

    }

    @Then("Cliquer le calendrier pour Aller-Retour")
    public void cliquerLeCalendrierPourAllerRetour() throws InterruptedException {

        // actions.doubleClick(atoumod.textAllerRetour).perform();
        assertTrue(atoumod.textAllerRetour.isEnabled());


        // Double-click on the element


        //atoumod.textAllerRetour.click();

        //assertTrue(atoumod.leBtnCalenderirRetour.isEnabled());

        atoumod.leBtnCalenderirRetour.click();


        List<WebElement> dates = getDriver().findElements(By.className("android.view.View"));


        Random rand = new Random();
        int index = rand.nextInt(dates.size());


        dates.get(index).click();

        assertTrue(atoumod.leBtnValider.isEnabled());

        atoumod.leBtnValider.click();
        atoumod.getMairieStPierreDuVauvray.click();
       // atoumod.getMairieStPierreDuVauvray.clear();


        atoumod.rechercherUneAdresse.sendKeys("Gare du Caen");
        Thread.sleep(3000);

        atoumod.GaredeCaen.click();


    }

    @And("Cliquer sur licône flèche haut flèche bas pour changer l'origine et la destination")
    public void cliquerSurLicôneFlècheHautFlècheBasPourChangerLOrigineEtLaDestination() {

        atoumod.btnInverser.click();
    }


    @And("Faire une recherche")
    public void faireUneRecherche() {

        String expectedTextRechercher = "Rechercher";

        assertTrue(atoumod.btnRechercher.getText().contains(expectedTextRechercher));

        atoumod.btnRechercher.click();

        if (atoumod.getTextTransportCommun.isDisplayed() || atoumod.getTextSuggetions.isDisplayed()) {
            assertTrue(true);
        } else {
            fail("les texts pas visible");
        }
        //assertTrue(atoumod.getTextTransportCommun.isDisplayed());
        // Assert.assertTrue(atoumod.getTextSuggetions.isDisplayed());

        atoumod.fleshRetour.click();
    }

    @And("Cliquer sur le calendrier sur le bouton Retour et sélectionner une date et ou une heure. Pas de sélection par défaut.")
    public void cliquerSurLeCalendrierSurLeBoutonRetourEtSélectionnerUneDateEtOuUneHeurePasDeSélectionParDéfaut() {

        atoumod.leBtnCalenderirRetour.click();

        List<WebElement> dates = getDriver().findElements(By.className("android.widget.TextView"));

        for (WebElement jour : dates) {
            if (jour.getText().equals("30")) { //Le 30 de chaque mois est sélectionné !
                jour.click();

            }
        }

        atoumod.leBtnValider.click();


    }


    @And("Positionner les champs inversés !")
    public void positionnerLesChampsInversés() {

        atoumod.fleshRetour.click();


    }

    @And("Cliquer le bouton Horaires des lignes")
    public void cliquerLeBoutonHorairesDesLignes() throws InterruptedException {

        scrollDown(getDriver());


        assertTrue(atoumod.HorairesEtPerturbations.isDisplayed());

        atoumod.HorairesEtPerturbations.click();

        atoumod.fleshRetour.click();

        getDriver();


    }

    @And("Ajouter une étape")
    public void ajouterUneÉtape() throws InterruptedException {


        atoumod.leBoutonTroisPoints.click();

        assertTrue(atoumod.getLeBoutonAjouterUneEtape.isEnabled());

        atoumod.getLeBoutonAjouterUneEtape.click();

        atoumod.rechercherUneAdresse.sendKeys("Rouen Rive-Droite");

        atoumod.getRouenRiveDroite.click();
        Thread.sleep(2000);



    }

    @And("Vérifier l'affichage du bouton Rechercher")
    public void vérifierLAffichageDuBoutonRechercherEtCliquer() throws InterruptedException {

        scrollDown(getDriver());
        atoumod.btnRechercher.isEnabled();

        atoumod.btnRechercher.click();
        atoumod.fleshRetour.click();


    }

    @And("Vérifier Horaises des lignes")
    public void vérifierHoraisesDesLignes() {

        assertTrue(atoumod.getTextHoraires.isDisplayed());

    }


    @And("Saisir les adresses pour Aller-Retour")
    public void saisirLesAdressesPourAllerRetour() throws InterruptedException {


        atoumod.getDe.click();

        atoumod.rechercherUneAdresse.sendKeys("Gare d");
        atoumod.getGareDeLisieux.click();


        atoumod.getA.click();
        atoumod.rechercherUneAdresse.sendKeys("Gare du Caen");
        atoumod.GaredeCaen.click();


    }

    @And("Cliquer le calendrier pour Retour")
    public void cliquerLeCalendrierPourRetour() throws InterruptedException {


        assertTrue(atoumod.textAllerRetour.isEnabled());

        actions.doubleClick(atoumod.textAllerRetour).click();

        assertTrue(atoumod.leBtnCalenderirRetour.isEnabled());

        atoumod.leBtnCalenderirRetour.click();

        Thread.sleep(2000);


        List<WebElement> dates = getDriver().findElements(By.className("android.view.View"));


        Random rand = new Random();
        int index = rand.nextInt(dates.size());


        dates.get(index).click();

        assertTrue(atoumod.leBtnValider.isEnabled());

        atoumod.leBtnValider.click();


    }


    @And("Calculer la différence de temps entre Départ et arrivée")
    public void calculerLaDifférenceDeTempsEntreDépartEtArrivée() {


        Assert.assertTrue(
                atoumod.getTextTransportCommun.isDisplayed()
                        || atoumod.getTextSuggetions.isDisplayed()
                        || atoumod.getTextVoiture.isDisplayed()
                        || atoumod.getTextVélo.isDisplayed()
        );

    }


    @And("Cliquer dans le Vélo sur le Voir les trajets")
    public void cliquerDansLeVéloSurLeVoirLesTrajets() {

        if (atoumod.getTextVoirlestrajets.isEnabled()) {
            atoumod.getTextVoirlestrajets.click();
        }


    }

    @And("Saisir les adresses pour aller-Retour")
    public void saisirLesAdressesPourallerRetour() {


    }

    @And("Voir section Acheter un titre pour la suite des tests")
    public void voirSectionAcheterUnTitrePourLaSuiteDesTests() throws InterruptedException {
        assertTrue(atoumod.MTicket.isEnabled());
        atoumod.MTicket.click();

        atoumod.btnOuvrirApp.click();

    }

    @And("Vérifiez que vous êtes bien redirigé vers la page Acheter un titre")
    public void vérifiezQueVousÊtesBienRedirigéVersLaPageAcheterUnTitre() {

        String textCreeMonCompte = "Je crée mon compte";

        assertThat(textCreeMonCompte.contains(atoumod.btnCréerMonCompte.getText()), is(true));
        getDriver().navigate().back();


    }


    @And("Afficher les transports de l'heure précédente")
    public void afficherLesTransportsDeLHeurePrécédente() {


    }

    @And("Afficher les transports de l'heure suivante et vérifier les suggestions")
    public void afficherLesTransportsDeLHeureSuivanteEtVérifierLesSuggestions() {
        atoumod.getFleshSuivant.click();

        atoumod.fleshRetour.click();
    }

    @And("Faire une recherche pour Aller-Simple")
    public void faireUneRecherchePourAllerSimple() {


        String expectedTextRechercher = "Rechercher";

        assertTrue(atoumod.btnRechercher.getText().contains(expectedTextRechercher));

        atoumod.btnRechercher.click();


        if (atoumod.getTextTransportCommun.isDisplayed() || atoumod.getTextSuggetions.isDisplayed()) {
            assertTrue(true);
        } else {
            fail("les texts pas visible");
        }

        //Assert.assertTrue(atoumod.getTextTransportCommun.isDisplayed());

        //assertTrue(atoumod.getTextSuggetions.isDisplayed());


    }

    @And("Si l'utilisateur a déjà effectué des recherches, ses sélections précédentes remontent dans une liste sous le champ de recherche.")
    public void siLUtilisateurADéjàEffectuéDesRecherchesSesSélectionsPrécédentesRemontentDansUneListeSousLeChampDeRecherche() throws InterruptedException {

        atoumod.getA.click();
        Thread.sleep(2000);
        atoumod.btnCalvaireStPierre.click();
        assertTrue(atoumod.btnCalvaireStPierre.isDisplayed());


    }


    @And("Vérifier la différence entre les heures de départ et d'arrivée")
    public void vérifierLaDifférenceEntreLesHeuresDeDépartEtDArrivée() throws InterruptedException {
        Thread.sleep(3000);

/*
        try {
            if (atoumod.PremierTEnCommun.isDisplayed()) {
                WebElement lheure1 = atoumod.lheureDiffrence;
                WebElement lheure2 = atoumod.lheureDepart;
                WebElement lheure3 = atoumod.lheureArrriver;

                String lheure2Text = lheure2.getText();
                String lheure3Text = lheure3.getText();

                int lheure2Hours = extractHours(lheure2Text);
                int lheure2Minutes = extractMinutes(lheure2Text);
                int lheure3Hours = extractHours(lheure3Text);
                int lheure3Minutes = extractMinutes(lheure3Text);

                int lheure1Hours = lheure3Hours - lheure2Hours;
                int lheure1Minutes = lheure3Minutes - lheure2Minutes;

                if (lheure1Minutes < 0) {
                    lheure1Hours--;
                    lheure1Minutes += 60;
                }

                String expectedValue = lheure1Minutes + "min";
                String actualValue = lheure1.getText();

                // Vérifier l'égalité
                if (expectedValue.equals(actualValue)) {
                    // Si égal, passer directement
                    assertEquals(expectedValue, actualValue);
                } else {
                    // Si l'égalité n'est pas vérifiée, soustraire une minute et vérifier à nouveau
                    lheure1Minutes--;
                    expectedValue = lheure1Minutes + "min";
                    assertEquals(expectedValue, actualValue);
                }

                LOG.info("lheure1Hours = " + lheure1Hours);
                System.out.println("actualValue = " + actualValue + " expectedValue = " + expectedValue);
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (atoumod.PremierTEnCommun.isDisplayed()) {
                WebElement lheure1 = atoumod.lheureDiffrence;
                WebElement lheure2 = atoumod.lheureDepart;
                WebElement lheure3 = atoumod.lheureArrriver;

                String lheure2Text = lheure2.getText();
                String lheure3Text = lheure3.getText();

                int lheure2Hours = extractHours(lheure2Text);
                int lheure2Minutes = extractMinutes(lheure2Text);
                int lheure3Hours = extractHours(lheure3Text);
                int lheure3Minutes = extractMinutes(lheure3Text);

                int lheure1Hours = lheure3Hours - lheure2Hours;
                int lheure1Minutes = lheure3Minutes - lheure2Minutes;

                if (lheure1Minutes < 0) {
                    lheure1Hours--;
                    lheure1Minutes += 60;
                }

                String expectedValue = lheure1Minutes + "min";
                String actualValue = lheure1.getText();

                // Vérifier l'égalité
                if (expectedValue.equals(actualValue)) {
                    // Si égal, passer directement
                    assertEquals(expectedValue, actualValue);
                } else {
                    // Si l'égalité n'est pas vérifiée, soustraire une minute et vérifier à nouveau
                    lheure1Minutes--;
                    expectedValue = lheure1Minutes + "min";
                    assertEquals(expectedValue, actualValue);


                }

                LOG.info("lheure1Hours = " + lheure1Hours + "actualValue  = " + actualValue + " expected" + expectedValue);

            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
*/

    }

    @And("Vérifier la présence des émissions de CO{int}")
    public void vérifierLaPrésenceDesÉmissionsDeCO(int arg0) throws InterruptedException {

// Création de la liste principale
        List<WebElement> boites = getDriver().findElements(By.xpath("//android.widget.TextView[@text='CO2']"));
        scrollDown(getDriver());
        int co2Sayisi = boites.size();
        for (WebElement boite : boites) {
            if (boite.isDisplayed()) {
                co2Sayisi++;
            }
        }


        System.out.println("CO2 : " + co2Sayisi);

    }


    @And("Cliquer sur un résultat Transports en commun")
    public void cliquerSurUnRésultatTransportsEnCommun() {

        {
            // Trouve les éléments contenant le texte T1
            List<WebElement> tramElements = getDriver().findElements(By.xpath("//android.view.View[@content-desc=\"Tramway\"]"));

            // Si au moins un élément T1 est visible
            if (!tramElements.isEmpty()) {
                // Clic sur le premier élément T1
                tramElements.get(0).click();
            } else {
                // Affiche le message d'erreur si l'élément T1 visible n'est pas trouvé
                System.out.println("Le picto bus n'est pas visible.");
            }

            //Dans les transports en commun, cliquer sur la première ligne


            String[][] expectedTexts = {
                    {atoumod.btnGareDeCaenindex.getText(), "Gare de Caen"},
                    {atoumod.btnCalvaireStPierreIndex.getText(), "Caen-Calvaire Saint-Pierre"},
                    {atoumod.btnVoirLesEtapes.getText(), "voir les étapes"},
                    {atoumod.btnCO21.getText(), "CO²"},
                    {atoumod.getVoirLeRecapitulatif.getText(), "Voir le récapitulatif"},
            };

            for (String[] expectedText : expectedTexts) {
                String actualText = expectedText[0];
                if (actualText.contains(expectedText[1])) {
                    System.out.println("Vérification réussie : " + actualText + " contient le texte attendu");
                } else {
                    System.out.println("Vérification échouée : " + actualText + " ne contient pas le texte attendu");
                }
            }


            try {
                if (atoumod.PremierTEnCommun.isDisplayed()) {
                    WebElement lheure1 = getDriver().findElement(By.xpath("(//android.widget.TextView)[9]"));
                    WebElement lheure2 = getDriver().findElement(By.xpath("(//android.widget.TextView)[7]"));
                    WebElement lheure3 = getDriver().findElement(By.xpath("(//android.widget.TextView)[8]"));

                    String lheure2Text = lheure2.getText();
                    String lheure3Text = lheure3.getText();

                    int lheure2Hours = extractHours(lheure2Text);
                    int lheure2Minutes = extractMinutes(lheure2Text);
                    int lheure3Hours = extractHours(lheure3Text);
                    int lheure3Minutes = extractMinutes(lheure3Text);

                    int lheure1Hours = lheure3Hours - lheure2Hours;
                    int lheure1Minutes = lheure3Minutes - lheure2Minutes;

                    if (lheure1Minutes < 0) {
                        lheure1Hours--;
                        lheure1Minutes += 60;
                    }

                    String expectedValue = lheure1Minutes + "min";
                    String actualValue = lheure1.getText();

                    // Vérifier l'égalité
                    if (expectedValue.equals(actualValue)) {
                        // Si égal, passer directement
                        assertEquals(expectedValue, actualValue);
                    } else {
                        // Si l'égalité n'est pas vérifiée, soustraire une minute et vérifier à nouveau
                        lheure1Minutes--;
                        expectedValue = lheure1Minutes + "min";
                        assertEquals(expectedValue, actualValue);
                    }

                    LOG.info("lheure1Hours = " + lheure1Hours);
                    System.out.println("actualValue = " + actualValue + " expectedValue = " + expectedValue);
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
            try {
                if (atoumod.PremierTEnCommun.isDisplayed()) {
                    WebElement lheure1 = atoumod.lheureDiffrence;
                    WebElement lheure2 = atoumod.lheureDepart;
                    WebElement lheure3 = atoumod.lheureArrriver;

                    String lheure2Text = lheure2.getText();
                    String lheure3Text = lheure3.getText();

                    int lheure2Hours = extractHours(lheure2Text);
                    int lheure2Minutes = extractMinutes(lheure2Text);
                    int lheure3Hours = extractHours(lheure3Text);
                    int lheure3Minutes = extractMinutes(lheure3Text);

                    int lheure1Hours = lheure3Hours - lheure2Hours;
                    int lheure1Minutes = lheure3Minutes - lheure2Minutes;

                    if (lheure1Minutes < 0) {
                        lheure1Hours--;
                        lheure1Minutes += 60;
                    }

                    String expectedValue = lheure1Minutes + "min";
                    String actualValue = lheure1.getText();

                    // Vérifier l'égalité
                    if (expectedValue.equals(actualValue)) {
                        // Si égal, passer directement
                        assertEquals(expectedValue, actualValue);
                    } else {
                        // Si l'égalité n'est pas vérifiée, soustraire une minute et vérifier à nouveau
                        lheure1Minutes--;
                        expectedValue = lheure1Minutes + "min";
                        assertEquals(expectedValue, actualValue);


                    }

                    LOG.info("lheure1Hours = " + lheure1Hours + "actualValue  = " + actualValue + " expected" + expectedValue);

                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }


        }


    }

    @And("Cliquer sur les émissions de CO² et vérifier le texte")
    public void cliquerSurLesÉmissionsDeCOEtVérifierLeTexte() {
        atoumod.btnCO21.click();

        String[][] elementsToCheck = {
                {atoumod.getCO2émis.getText(), "CO2 émis"},
                {atoumod.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}
        };


        for (String[] expectedText : elementsToCheck) {
            String actualText = expectedText[0];
            String expected = expectedText[1];

            if (actualText.contains(expected)) {
                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");
            }
            //TODO: Les calculs d'émissions n'ont pas ét


        }
    }

    @And("Afficher les étapes Voir les étapes")
    public void afficherLesÉtapesVoirLesÉtapes() throws InterruptedException, MalformedURLException {

        atoumod.btnRetour.click();

        atoumod.btnVoirLesEtapes.click();
        Thread.sleep(2000);

        scrollUp(atoumod.btnGareDeCaenindex, -20);


        List<WebElement> elementList = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify = {"Départ à", "Marcher"};

        for (String text : textsToVerify) {
            boolean isTextFound = false;
            for (WebElement element : elementList) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }

        Thread.sleep(2000);

        scrollUp(atoumod.btnCO21, 12);

        Thread.sleep(2000);

        atoumod.btnRetour.click();

       // assertTrue(atoumod.iconTramway.isDisplayed());


    }

    @And("Cliquer sur Voir le recapitulatif")
    public void cliquerSurVoirLeRecapitulatif() throws InterruptedException {

        atoumod.getVoirLeRecapitulatif.click();


        Thread.sleep(2000);


        List<WebElement> elementList2 = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify2 = {"Récapitulatif", "Aller", "Voir les étapes", "Le saviez-vous ?", "Que vous soyez un utilisateur ponctuel ou régulier des réseaux de transports de la région, Atoumod met à votre disposition deux services pour vous simplifier l’accès aux différents réseaux et vous assurer de voyager en règle.", "Découvrir ces services"};

        for (String text2 : textsToVerify2) {
            boolean isTextFound = false;
            for (WebElement element2 : elementList2) {
                String elementText2 = element2.getText();
                if (elementText2.contains(text2)) {
                    System.out.println(text2 + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text2 + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text2 + "' n'est pas trouvé dans l'élément !");

            }
        }

        atoumod.getDécouvrir.click();
        atoumod.btnOuvrirApp.click();

        String textCreeMonCompte = "Je crée mon compte";

        assertThat(textCreeMonCompte.contains(atoumod.btnCréerMonCompte.getText()), is(true));

        getDriver().navigate().back();

        atoumod.btnRetour.click();

        atoumod.btnVoirLesEtapes2.click();

        scrollUp(atoumod.btnCO21, -10);


        List<WebElement> elementList = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify = {"Départ à", "Marcher"};

        for (String text : textsToVerify) {
            boolean isTextFound = false;
            for (WebElement element : elementList) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {
                System.out.println(text + " Le text non visible.");
                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");
            }
        }


      //  atoumod.getDeparts.click();

        scrollUp(atoumod.btnCO21, 20);

        atoumod.btnRetour.click();

        Thread.sleep(1000);

        atoumod.btnRetour.click();

        Thread.sleep(1000);

        atoumod.btnRetour.click();


    }

    @And("Consulter les résultats de la section Vélo")
    public void consulterLesRésultatsDeLaSectionVélo() throws InterruptedException {

        scrollUp(atoumod.btnCO21, -30);

        assertTrue(atoumod.getTextVélo.isDisplayed());

        atoumod.getTextVélo.click();

        assertTrue(atoumod.iconVélo.isDisplayed());

        atoumod.getGetTextVoirlestrajetsVélo.click();

        Thread.sleep(2000);


    }

    @And("Vérifier la différence entre les heures de départ et d'arrivée pour Vélo")
    public void vérifierLaDifférenceEntreLesHeuresDeDépartEtDArrivéePourVélo() throws MalformedURLException, InterruptedException {





        /*   try {
            WebElement lheure1 = getDriver().findElement(By.xpath("(//android.widget.TextView)[15]"));
            WebElement lheure2 = getDriver().findElement(By.xpath("(//android.widget.TextView)[16]"));
            WebElement lheure3 = getDriver().findElement(By.xpath("(//android.widget.TextView)[17]"));



            String heure1Text = lheure1.getText().trim();
            String heure2Text = lheure2.getText().trim();
            String heure3Text = lheure3.getText().trim();

            // Metin içerip içermediğini kontrol edin
            if (heure1Text.isEmpty() || heure2Text.isEmpty() || heure3Text.isEmpty()) {
                throw new RuntimeException("Saat değerleri alınamadı veya boş!");
            }

            // Saat ve dakika bileşenlerini ayrıştırarak alın
            int heure1 = parseTimeToMinutes(heure1Text);
            int heure2 = parseTimeToMinutes(heure2Text);
            int heure3 = parseTimeToMinutes(heure3Text);

            // İşlemi gerçekleştirin ve sonucu doğrulayın
            int result = heure2 - heure3;
            assert result == heure1 : "lheure1 = lheure2 - lheure3 ifadesi doğrulanamadı!";

            // Sonucu terminalde yazdır
            System.out.println("Actual: " + result);
            System.out.println("Expected: " + heure1);


        } finally {

        }*/

        //TODO:FAIRE
    }


    @And("Afficher les étapes Voir les étapes pour Vélo")
    public void afficherLesÉtapesVoirLesÉtapesPourVélo() throws InterruptedException {

        atoumod.getSécurisé.click();

        Thread.sleep(1000);

        assertTrue(atoumod.iconVélo.isDisplayed());

        assertTrue(atoumod.btnGareDeCaenindex.isDisplayed());

       // assertTrue(atoumod.laGareCaenFavori.isDisplayed());
        assertTrue(atoumod.btnCO21.isDisplayed());


        atoumod.btnVoirLesEtapes.click();

        scrollUp(atoumod.btnGareDeCaen, -10);


        List<WebElement> elementList = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify = {"Départ à", "Aménagement des voies", " % aménagées", "24 % non aménagées", "Dénivelé", "positif", "Arrivée à"};

        for (String text : textsToVerify) {
            boolean isTextFound = false;
            for (WebElement element : elementList) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {
                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");
            }
        }


        scrollUp(atoumod.iconVélo, 20);
        Thread.sleep(2000);

        atoumod.btnRetour.click();

        atoumod.btnRetour.click();

        //TODO:FAIRE le plus rapide


    }

    @And("Cliquer sur le résultat Voiture")
    public void cliquerSurLeRésultatVoiture() throws InterruptedException {

        atoumod.getTextVoiture.click();

        if (atoumod.iconVoiture.isDisplayed()) {

            atoumod.iconVoiture.click();

        }
        Thread.sleep(2000);
        atoumod.iconVoiture.isDisplayed();

        assertTrue(atoumod.btnGareDeCaenindex.isDisplayed());

       // assertTrue(atoumod.laGareCaenFavori.isDisplayed());

        assertTrue(atoumod.btnCO21.isDisplayed());


        try {
            if (atoumod.btnCO21.isDisplayed()) {
                WebElement lheure1 = getDriver().findElement(By.xpath("(//android.widget.TextView)[8]"));
                WebElement lheure2 = getDriver().findElement(By.xpath("(//android.widget.TextView)[7]"));
                WebElement lheure3 = getDriver().findElement(By.xpath("(//android.widget.TextView)[6]"));

                String lheure2Text = lheure2.getText();
                String lheure3Text = lheure3.getText();

                int lheure2Hours = extractHours(lheure2Text);
                int lheure2Minutes = extractMinutes(lheure2Text);
                int lheure3Hours = extractHours(lheure3Text);
                int lheure3Minutes = extractMinutes(lheure3Text);

                int lheure1Hours = lheure3Hours - lheure2Hours;
                int lheure1Minutes = lheure3Minutes - lheure2Minutes;

                if (lheure1Minutes < 0) {
                    lheure1Hours--;
                    lheure1Minutes += 60;
                }

                String expectedValue = lheure1Minutes + "min";
                String actualValue = lheure1.getText();

                // Vérifier l'égalité
                if (expectedValue.equals(actualValue)) {
                    // Si égal, passer directement
                    assertEquals(expectedValue, actualValue);
                } else {
                    // Si l'égalité n'est pas vérifiée, soustraire une minute et vérifier à nouveau
                    lheure1Minutes--;
                    expectedValue = lheure1Minutes + "min";
                    assertEquals(expectedValue, actualValue);
                }


                System.out.println("ActualValue = " + actualValue);
                System.out.println("ExpectedValue = " + expectedValue);
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


        atoumod.btnVoirLesEtapes.click();


        scrollUp(atoumod.btnCO2, -10);


        List<WebElement> elementList2 = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify2 = {"Départ à", "Gare de Caen", "Voiture", "Rouler 3,79km", "Arrivée à", "Caen-Calvaire Saint-Pierre", "CO2"};

        for (String text : textsToVerify2) {
            boolean isTextFound = false;
            for (WebElement element : elementList2) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }

        scrollUp(atoumod.btnCO2, 20);

        atoumod.btnRetour.click();

        Thread.sleep(2000);

        atoumod.btnRetour.click();

        scrollUp(atoumod.iconVoiture, -20);


    }

    @And("Consulter le résultat Marche")
    public void consulterLeRésultatMarche() throws InterruptedException {

        assertTrue(atoumod.getMarche.isDisplayed());

        if (atoumod.iconMarche.isDisplayed()) {
            atoumod.iconMarche.click();
        }
        System.out.println(atoumod.btnCaenEtSaibtnCaenEtSaintPierrentPierre.getText());
        assertTrue(atoumod.btnCaenEtSaibtnCaenEtSaintPierrentPierre.isDisplayed());





        assertTrue(atoumod.btnCO21.isDisplayed());

        try {
            if (atoumod.btnCO2.isDisplayed()) {
                WebElement lheure1 = getDriver().findElement(By.xpath("(//android.widget.TextView)[8]"));
                WebElement lheure2 = getDriver().findElement(By.xpath("(//android.widget.TextView)[6]"));
                WebElement lheure3 = getDriver().findElement(By.xpath("(//android.widget.TextView)[7]"));

                String lheure2Text = lheure2.getText();
                String lheure3Text = lheure3.getText();

                int lheure2Hours = extractHours(lheure2Text);
                int lheure2Minutes = extractMinutes(lheure2Text);
                int lheure3Hours = extractHours(lheure3Text);
                int lheure3Minutes = extractMinutes(lheure3Text);

                int lheure1Hours = lheure3Hours - lheure2Hours;
                int lheure1Minutes = lheure3Minutes - lheure2Minutes;

                if (lheure1Minutes < 0) {
                    lheure1Hours--;
                    lheure1Minutes += 60;
                }

                String expectedValue = lheure1Minutes + "min";
                String actualValue = lheure1.getText();

                // Vérifier l'égalité
                if (expectedValue.equals(actualValue)) {
                    // Si égal, passer directement
                    assertEquals(expectedValue, actualValue);
                } else {
                    // Si l'égalité n'est pas vérifiée, soustraire une minute et vérifier à nouveau
                    lheure1Minutes--;
                    expectedValue = lheure1Minutes + "min";
                    assertEquals(expectedValue, actualValue);
                }


                System.out.println("ActualValue = " + actualValue);
                System.out.println("ExpectedValue = " + expectedValue);
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


        atoumod.btnVoirLesEtapes.click();


        scrollUp(atoumod.btnGareDeCaen, -10);


        List<WebElement> elementList2 = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify2 = {"Départ à", "Gare de Caen", "Marcher 3,36km", "Arrivée à", "Caen-Calvaire Saint-Pierre"};

        for (String text : textsToVerify2) {
            boolean isTextFound = false;
            for (WebElement element : elementList2) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }

        scrollUp(atoumod.btnGareDeCaen, 20);

        atoumod.btnRetour.click();

        Thread.sleep(2000);

        atoumod.btnRetour.click();


    }

    @And("Consulter les résultats de recherche d'itinéraire")
    public void consulterLesRésultatsDeRechercheDItinéraire() throws InterruptedException {
        atoumod.btnRechercher.click();
        atoumod.iconTrain.click();

        assertTrue(atoumod.btnCO21.isDisplayed());


        atoumod.btnVoirLesEtapes.click();


        scrollUp(atoumod.btnCO21, -20);

        assertTrue(atoumod.iconTrain.isDisplayed());


        List<WebElement> elementList2 = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify2 = {"Gare de Rouen Rive Droite", "Marcher 105m"};

        for (String text : textsToVerify2) {
            boolean isTextFound = false;
            for (WebElement element : elementList2) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }
        Thread.sleep(2000);

        scrollUp(atoumod.iconTrain, 10);

        atoumod.btnRetour.click();

        Thread.sleep(2000);

    }


    @And("Afficher les étapes Voir les étapes pour Aller-retour")
    public void afficherLesÉtapesVoirLesÉtapesPourAllerRetour() throws InterruptedException {


        atoumod.btnVoirLesEtapes.click();

        scrollUp(atoumod.btnCO21, -10);


        List<WebElement> elementList = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify = {"Départ à", "Descendre à"};

        for (String text : textsToVerify) {
            boolean isTextFound = false;
            for (WebElement element : elementList) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }


        Thread.sleep(2000);
        scrollUp(atoumod.iconTrain, 10);


    }

    @And("Cliquer sur les émissions de CO² et vérifier le texte pour Aller-retour")
    public void cliquerSurLesÉmissionsDeCOEtVérifierLeTextePourAllerRetour() throws InterruptedException {
        Thread.sleep(2000);
       atoumod.btnCO2_2.click();

        String[][] elementsToCheck = {

                {atoumod.getCeTrajetestSuper2.getText(), "Ce trajet est super !"},

                {atoumod.getCO2émis.getText(), "CO2 émis"},

                {atoumod.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}

        };

        for (String[] expectedText : elementsToCheck) {
            String actualText = expectedText[0];
            String expected = expectedText[1];

            if (actualText.contains(expected)) {
                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");
            }
            //TODO: Les calculs d'émissions n'ont pas éte

            atoumod.btnRetour.click();


        }

    }

    @And("Cliquer sur Choisir un retour et Consulter les résultats Transports en commun pour le retoura")
    public void cliquerSurChoisirUnRetourEtConsulterLesRésultatsTransportsEnCommunPourLeRetoura() throws InterruptedException {
        atoumod.iconTrain.click();
        atoumod.getChoisirUnRetour.click();
        Thread.sleep(2000);
        List<WebElement> elementList3 = getDriver().findElements(By.className("android.widget.TextView"));
        // Parcourons la liste pour valider les textes
        String[] textsToVerify2 = {"Transport en commun", "Choisir un retour", "Départ", "Retour", "À"};

        for (String text : textsToVerify2) {
            boolean isTextFound = false;
            for (WebElement element : elementList3) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }

    }

    @And("Choisir un des résultats Transports en commun pour le retour")
    public void choisirUnDesRésultatsTransportsEnCommunPourLeRetour() throws InterruptedException {

        assertTrue(atoumod.iconTrain.isDisplayed());
        assertTrue(atoumod.btnCO2_2.isDisplayed());


    }

    @And("Cliquer sur Voir le recapitulatif pour Aller-Retour")
    public void cliquerSurVoirLeRecapitulatifPourAllerRetour() throws InterruptedException {
        atoumod.btnCO21.click();
        atoumod.getVoirLeRecapitulatif.click();
    scrollUp(atoumod.iconTrain,-15);

        List<WebElement> elementList3 = getDriver().findElements(By.className("android.widget.TextView"));
        // Parcourons la liste pour valider les textes
        String[] textsToVerify2 = {"Récapitulatif", "Voir les étapes", "Le saviez-vous ?", "Que vous soyez un utilisateur ponctuel ou régulier des réseaux de transports de la région, Atoumod met à votre disposition deux services pour vous simplifier l’accès aux différents réseaux et vous assurer de voyager en règle.", "Découvrir ces services"};

        for (String text : textsToVerify2) {
            boolean isTextFound = false;
            for (WebElement element : elementList3) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {

                System.out.println(text + " Le text non visible.");

                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");

            }
        }


        scrollUp(atoumod.btnVoirLesEtapes2, -10);
        Thread.sleep(2000);

        atoumod.getDécouvrir.click();
        atoumod.btnOuvrirApp.click();
        String textCreeMonCompte = "Je crée mon compte";

        assertThat(textCreeMonCompte.contains(atoumod.btnCréerMonCompte.getText()), is(true));

        getDriver().navigate().back();
        atoumod.btnRetour.click();

        atoumod.btnVoirLesEtapes2.click();

        scrollUp(atoumod.btnCO21, -10);


        List<WebElement> elementList = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify = {"Départ à", "Marcher"};

        for (String text : textsToVerify) {
            boolean isTextFound = false;
            for (WebElement element : elementList) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {
                System.out.println(text + " Le text non visible.");
                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");
            }
        }

        Thread.sleep(1000);
        // atoumod.getDeparts.click();

        scrollUp(atoumod.iconTrain, 15);

        atoumod.btnRetour.click();

        Thread.sleep(1000);

        atoumod.btnRetour.click();




    }


    @Given("Sur la home, cliquer sur l'illustration Horaires des lignes")
    public void surLaHomeCliquerSurLIllustrationHorairesDesLignes() {



        try {

            if (atoumod.btnAutoriser.isDisplayed()) {
                atoumod.btnAutoriser.click();

                TimeUnit.SECONDS.sleep(3);
            }
        } catch (NoSuchElementException | InterruptedException e) {


        }
        scrollUp(atoumod.textTrajet,-15);
        if (atoumod.HorairesEtPerturbations.isDisplayed()) {
            atoumod.HorairesEtPerturbations.click();
        }
        ;


    }

    @When("L'utilisateur arrive sur un écran de recherche permettant de saisir un numéro de ligne")
    public void lUtilisateurArriveSurUnÉcranDeRecherchePermettantDeSaisirUnNuméroDeLigne() {

        assertTrue(atoumod.Horaires_Perturbations.isDisplayed());

        assertTrue(atoumod.RechercherUneLigne.isDisplayed());
    }

    @Then("Renseigner un numéro de ligne")
    public void renseignerUnNuméroDeLigne() {

        atoumod.rechercherUneAdresse.sendKeys("3");

    }

    @And("Sélectionner une ligne")
    public void sélectionnerUneLigne() {

        atoumod.getMonetDurécuLavoisier.click();

        scrollUp(atoumod.getMonetDurécuLavoisier, -10);

    }

    @And("Changer le terminus")
    public void changerLeTerminus() throws InterruptedException {

        atoumod.getVers.click();

        assertTrue(atoumod.getDurécuLavoisier.isDisplayed());

        Thread.sleep(2000);

        atoumod.getDurécuLavoisier.click();


    }

    @And("Sélectionner un arrêt sur la ligne  dans la liste du thermomètre")
    public void sélectionnerUnArrêtSurLaLigneDansLaListeDuThermomètre() throws InterruptedException {
        if (atoumod.getMonet.isDisplayed()) {
         atoumod.getMonet.click();
        }

        Thread.sleep(2000);
       atoumod.getDurécuLavoisier.click();


        assertTrue(atoumod.getProchainPassage.isDisplayed());
        assertTrue(atoumod.getTouslesHoraires.isDisplayed());
        assertTrue(atoumod.getHeureTouslesHoraires.isDisplayed());
        System.out.println("Heure Tous les Horaires :  " + atoumod.getHeureTouslesHoraires.getText());

        Thread.sleep(2000);


        scrollDown(getDriver());


        atoumod.getMairieDeDarnétal.click();




        


        //scrollUp(atoumod.getMonetDurécuLavoisier, 10);


    }

    @And("Afficher les prochains passages à l'arrêt et Cliquer sur Tous les horaires")
    public void afficherLesProchainsPassagesÀLArrêtEtCliquerSurTousLesHoraires() {


        // Au clic sur Tous les horaires, l'utilisateur accède à la vue de détail d'un arrêt pré-filtrée sur la ligne qu'il consultait (conservation du contexte de navigation).  Cet écran est composé de :
        atoumod.getTouslesHoraires.click();



        //position géographique de l'arrêt sur la carte
        atoumod.iconTramway.click();

        assertTrue(atoumod.getHorairesThéoriques.isDisplayed());
        scrollUp(atoumod.getHorairesThéoriques,-10);

        assertTrue(atoumod.getT3.isDisplayed());

        assertTrue(atoumod.getFiltrer.isDisplayed());
        //picto du mode de transport
        assertTrue(atoumod.iconTramway.isDisplayed());








    }

    @And("Afficher tous les passages du jour à l'arrêt et Cliquer sur Voir tout")
    public void afficherTousLesPassagesDuJourÀLArrêtEtCliquerSurVoirTout() {

        atoumod.getVoirTout.click();

        atoumod.getFleshButton.click();

        atoumod.getFleshButtonBack.click();

        assertTrue(atoumod.getVoirDate.isDisplayed());


        WebElement dateElement = atoumod.getVoirDateText;
        String actualDate = dateElement.getText();

        String datePattern = "\\b(\\p{L}+)\\s+(\\d{1,2})\\s+(\\p{L}+\\b)";

        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(actualDate);

        if (matcher.find()) {
            String dayOfWeek = matcher.group(1);
            String dayOfMonth = matcher.group(2);
            String month = matcher.group(3);

            String dayNumber = frDayMap.get(dayOfWeek);

            if (dayNumber != null) {
                String formattedDate = getFormattedDate(dayOfWeek, dayOfMonth, month);
                System.out.println("Date réelle : " + formattedDate);

                String expectedDate = getExpectedDate(dayOfWeek, dayOfMonth, month);
                System.out.println("Date attendue : " + expectedDate);

                assertEquals("La date n'est pas correcte.", expectedDate, formattedDate);
            } else {
                System.out.println("Numéro de jour manquant : " + dayOfWeek);
            }
        } else {
            System.out.println(actualDate);
        }

// ...

// ...

        assertTrue(atoumod.getT3.isDisplayed());
        assertTrue(atoumod.getMairieDeDarnétal.isDisplayed());

        

    }


    @When("Consulter l'écran")
    public void consulterLÉcran() {


        assertTrue(atoumod.getTextAutourDeVous.isDisplayed());



    }


    @And("Consulter la présence du Autour de vous")
    public void consulterLaPrésenceDuAutourDeVous() throws InterruptedException {

        atoumod.getMap.click();
        atoumod.autoriserAtoumodStaning.click();


    }

    @And("Vérifier Placeholder du champ Rechercher...")
    public void vérifierPlaceholderDuChampRechercher() {

        atoumod.getTextRechercher1.click();
    }

    @And("Se déplacer sur la carte")
    public void seDéplacerSurLaCarte() throws InterruptedException {
        atoumod.rechercherUneAdresse.sendKeys("Rouen Rive-Droite");
        assertTrue(atoumod.rouenRiveDroite.isDisplayed());
        atoumod.rechercherUneAdresse.clear();


        atoumod.rechercherUneAdresse.sendKeys("Gare de Caen");

        assertTrue(atoumod.GaredeCaen.isDisplayed());


        atoumod.GaredeCaen.click();

        Thread.sleep(2000);




    }

    @And("Zoomer et Dézoomer sur la carte")
    public void zoomerEtDézoomerSurLaCarte() throws InterruptedException, MalformedURLException {
       performSwipe(400,200);
    }

    @And("Recentrer la géolocalisation")
    public void recentrerLaGéolocalisation() {
        atoumod.btnGeolocation.click();

    }

    @And("Cliquer sur le champ Recherche d'adresse")
    public void cliquerSurLeChampRechercheDAdresse() throws InterruptedException {

        atoumod.getTextRechercher1.click();

        atoumod.rechercherUneAdresse.sendKeys("Gare de Caen");

       // assertTrue(atoumod.GaredeCaen.isDisplayed());
        Thread.sleep(2000);

        atoumod.GaredeCaen.click();



        atoumod.iconBus.click();

        String laGareCaenExpectedText = "Gare de Caen";


        assertTrue(atoumod.laGareCaenFavori.getText().contains(laGareCaenExpectedText));
    }

    @And("Sélectionner un point de mobilité sur la carte \\(arrêt de bus, de train, de métro de tram : picto sur fond bleu)")
    public void sélectionnerUnPointDeMobilitéSurLaCarteArrêtDeBusDeTrainDeMétroDeTramPictoSurFondBleu() {

        assertTrue(atoumod.btnGareDeCaen.isDisplayed());
        assertTrue(atoumod.getFiltrer.isDisplayed());
        assertTrue(atoumod.iconTrain.isDisplayed());

       // assertTrue(atoumod.getVoirTousLesHoiraires.isDisplayed());








    }

    @And("Cliquer sur la croix dans le champ de recherche")
    public void cliquerSurLaCroixDansLeChampDeRecherche() {
        atoumod.laCroix.click();
    }

    @And("Sélectionner un point d'intérêt sur la carte")
    public void sélectionnerUnPointDIntérêtSurLaCarte() throws InterruptedException {
       Thread.sleep(2000);
        atoumod.pointDInteret.click();
        assertTrue(atoumod.getItineraire.isDisplayed());

    }


    @And("Cliquer sur Itinéraire sur le détail d'un POI")
    public void cliquerSurItinéraireSurLeDétailDUnPOI() {

    }


    @And("Vérifier la page options d'itinéraire")
    public void vérifierLaPageOptionsDItinéraire() {

        List<WebElement> elementList = getDriver().findElements(By.className("android.widget.TextView"));

        // Parcourons la liste pour valider les textes
        String[] textsToVerify = {"Options d'itinéraire","Critères voyageur", "Trajet", "Vitesse de marche", "Niveau de cyclisme", "Transports publics","Autres Mobilités"};

        for (String text : textsToVerify) {
            boolean isTextFound = false;
            for (WebElement element : elementList) {
                String elementText = element.getText();
                if (elementText.contains(text)) {
                    System.out.println(text + " Le text visible.");
                    isTextFound = true;
                    break;
                }
            }
            if (!isTextFound) {
                System.out.println(text + " Le text non visible.");
                Assert.fail("Erreur : Le texte '" + text + "' n'est pas trouvé dans l'élément !");
            }
        }


        String commonXPath = "//android.widget.CheckBox[@content-desc='%s']";

         // Parcourons la liste pour valider les textes
        String[] textsToVerify2 = {"Train", "Bus", "Tramway", "Métro", "Vélo", "Voiture"};

        for (String text2 : textsToVerify2) {
            boolean isTextFound = false;
            String dynamicXPath = String.format(commonXPath, text2);
            List<WebElement> elements = getDriver().findElements(By.xpath(dynamicXPath));

            for (WebElement element : elements) {
                element.getText();
                System.out.println(text2 + " Le texte est visible.");
                isTextFound = true;
                break;
            }

            if (!isTextFound) {
                System.out.println(text2 + " Le texte n'est pas visible.");
                Assert.fail("Erreur : Le texte '" + text2 + "' n'est pas trouvé dans l'élément !");
            }
        }

    }

    @And("Vérifier tous les types de trajets")
    public void vérifierTousLesTypesDeTrajets() throws InterruptedException {
        //> le type de trajet souhaité (le plus rapide, le moins de marche ou le moins de correspondance)
        List<WebElement> elementsToClick = Arrays.asList(
                atoumod.getLePlusRapide,
                atoumod.getMoinsDeMarche,
                atoumod.getMoinsDeMarche,
                atoumod.getMoinsDeCorrespondances,
                atoumod.getMoinsDeCorrespondances,
                atoumod.getLePlusRapide
        );

        for (WebElement element : elementsToClick) {
            element.click();

        }


    }

    @And("Vérifier la vitesse de marche")
    public void vérifierLaVitesseDeMarche() {

        List<WebElement> elementsToClick = Arrays.asList(
                atoumod.getNormale,
                atoumod.getReduite,
                atoumod.getReduite,
                atoumod.getRapide,
                atoumod.getRapide,
                atoumod.getNormale

        );

        for (WebElement element : elementsToClick) {
            element.click();

        }



    }

    @And("Vérifier le niveau de cyclisme")
    public void vérifierLeNiveauDeCyclisme() {
        List<WebElement> elementsToClick = Arrays.asList(
                atoumod.getIntermediare,
                atoumod.getDebutant,
                atoumod.getDebutant,
                atoumod.getExpérimenté,
                atoumod.getExpérimenté,
                atoumod.getIntermediare
        );

        for (WebElement element : elementsToClick) {
            element.click();


    }









}

    @And("Cliquer les modes de transports")
    public void cliquerLesModesDeTransports() {
        List<WebElement> transportCheckBoxes = Arrays.asList(
                atoumod.getTrainTransport,
                atoumod.getBusTransport,
                atoumod.getTramwayTransport,
                atoumod.getMétroTransport,
                atoumod.getVéloTransport,
                atoumod.getVoitureTransport
        );

        for (WebElement element : transportCheckBoxes) {
            element.click();

        }



    }


    @And("Sélectionner uniquement le mode bus")
    public void sélectionnerUniquementLeModeBus() {

        List<WebElement> transportCheckBoxes2 = Arrays.asList(
                atoumod.getTrainTransport,
                atoumod.getTramwayTransport,
                atoumod.getMétroTransport,
                atoumod.getVéloTransport,
                atoumod.getVoitureTransport
        );

        for (WebElement element : transportCheckBoxes2) {
            element.click();

        }

        atoumod.btnRetour.click();
    }


    @And("Cliquer sur le bouton Rechercher")
    public void cliquerSurLeBoutonRechercher() {
        atoumod.btnRechercher.click();
        atoumod.iconeBus.isDisplayed();
    }

    @And("Vérifier que le mode bus est visible.")
    public void vérifierQueLeModeBusEstVisible() {


        // Essayez de trouver l'élément "bus"
        WebElement busElement;
        try {
            busElement = atoumod.iconeBus;
        } catch (NoSuchElementException e) {
            busElement = null; // Si l'élément "bus" n'est pas trouvé, marquez-le comme null
        }

        // Vérifiez si l'élément "bus" est visible
        boolean isBusDisplayed = (busElement != null) && busElement.isDisplayed();

        // Vérifiez que les autres options de transport ne sont pas visibles
        try {
            // Essayez de trouver les autres options de transport et déclenchez une erreur s'ils sont trouvés
            Assert.assertFalse("Train ne doit pas être visible.", atoumod.iconTrain.isDisplayed());
            Assert.assertFalse("Tramway ne doit pas être visible.", atoumod.iconTramway.isDisplayed());
            Assert.assertFalse("Métro ne doit pas être visible.", atoumod.iconMétro.isDisplayed());
            Assert.assertFalse("Vélo ne doit pas être visible.", atoumod.iconVélo.isDisplayed());
            Assert.assertFalse("Voiture ne doit pas être visible.", atoumod.iconVoiture.isDisplayed());

        } catch (NoSuchElementException e) {
            // Si les autres options de transport ne sont pas trouvées (ne sont pas visibles), considérez-les comme réussies
        }

        // Vérifiez que seule l'option "bus" est visible et que les autres ne le sont pas
        Assert.assertTrue("Seul Bus doit être visible.", isBusDisplayed);
        System.out.println("Seul Bus doit être visible = " + isBusDisplayed);
    }


}



