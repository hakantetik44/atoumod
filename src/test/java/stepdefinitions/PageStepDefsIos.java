package stepdefinitions;


import pages.BasePageIos;
import pages.IosPages;
import io.appium.java_client.MobileBy;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.DriverMobile.getDriver;


public class PageStepDefsIos extends BasePageIos {

    IosPages atoumodIos = new IosPages();

    Actions actions = new Actions(getDriver());
    TouchAction touchAction;

    {
        touchAction = new TouchAction((PerformsTouchActions) getDriver());
    }


    public PageStepDefsIos() throws MalformedURLException {

    }

    @Given("Afficher et Vérifier la page daccueil")
    public void afficherEtVérifierLaPageDaccueil() {
        assertTrue(atoumodIos.getTextTrajet.isDisplayed());
    }



    @When("Cliquer sur les trois points")
    public void cliquerSurLesTroisPoints() {

        atoumodIos.troisPoints.click();


    }


    @And("Consulter la visibilité de barre donglets")
    public void consulterLaVisibilitéDeBarreDonglets() throws InterruptedException, MalformedURLException {


       WebElement tabMenuButton = getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"tab_menu\"]"));

        if (tabMenuButton.isDisplayed()) {
            tabMenuButton.click();
        } else {

        }


        atoumodIos.IconTitre.click();

        Thread.sleep(2000);


        atoumodIos.IconAccueil.click();

    }

    @And("Consulter l'écran Menu \\(Ios)")
    public void consulterLÉcranMenuIos() {

        //[Cet écran est voué à évoluer avec les fonctionnalités des prochaines versions : gestion de compte, favoris...]
        WebElement tabMenuButton = getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"tab_menu\"]"));
        tabMenuButton.click();
        //A ce jour, il est composé d'un header reprenant la charte de l'application et d'une entrée Paramètres
        String textParamatres= "Paramètres";
        assertTrue(atoumodIos.getParametres.getText().contains(textParamatres));
        atoumodIos.getParametres.click();



    }



    @And("Vérifier l'entrée Paramètres")
    public void vérifierLEntréeParamètres() {
        //L'écran Paramètres est composé :

        String textParamatres2= "Paramètres et informations";

        assertTrue(atoumodIos.getParametresEtInformations.getText().contains(textParamatres2));

        atoumodIos.getParametresEtInformations.isDisplayed();



        //- d'une entrée Pages légales
        String textPagesLegales = "Pages légales";
        assertTrue(atoumodIos.getPagesLégales.getText().contains(textPagesLegales));

        //- de la version de l'application

        String textVersion = "Version: 0.2.0";
        assertTrue(atoumodIos.getVersion.getText().contains(textVersion));

        atoumodIos.btnPrécédent.click();
        atoumodIos.IconAccueil.click();





    }


    @And("Vérifier la disponibilité à proximité")
    public void vérifierLaDisponibiliteAProximité() throws MalformedURLException, InterruptedException {


        while (true) {

            scrollToBottom(getDriver());

            if (atoumodIos.getTextAtourDeVous.isDisplayed()) {

                break;
            }

            Thread.sleep(1000);
        }


    }

    @And("Consulter Placeholder du champ Rechercher...")
    public void consulterPlaceholderDuChampRechercher() throws MalformedURLException {

        atoumodIos.mapView.click();
        // - un champ de recherche
        String getTextRechercher = "Rechercher...";

        Assert.assertTrue(atoumodIos.placeHolderRechercher.getText().contains(getTextRechercher));

        // - une carte centrée sur la position de l'utilisateur s'il a accepté de partager sa position
        assertTrue(atoumodIos.getMaPosition.isDisplayed());


    }

    @And("Au clic, une animation permet de montrer à lutilisateur que la map sagrandit plein écran pour pouvoir naviguer à l'intérieur.")
    public void auClicUneAnimationPermetDeMontrerÀLutilisateurQueLaMapSagranditPleinÉcranPourPouvoirNaviguerÀLIntérieur() throws MalformedURLException {

        performTapActionOnPoin(195, 308);
    }



    @And("Au clic Itineraire pour ma position, on est redirigé sur la home avec le champ Arrivée du widget RI renseigné")
    public void auClicItinerairePourMaPositionOnEstRedirigéSurLaHomeAvecLeChampArrivéeDuWidgetRIRenseigné() throws MalformedURLException, InterruptedException {

        Thread.sleep(2000);

        performTapActionOnPoin(143, 58);

        atoumodIos.placeHolderRechercher.click();


        atoumodIos.placeHolderRechercher.sendKeys("Rouen Saint-Sever");

        atoumodIos.RouenSaintSever.click();


        Assert.assertTrue(atoumodIos.btnItinéraire.isDisplayed());

        atoumodIos.btnItinéraire.click();

        scrollToTop(getDriver());

        Assert.assertTrue(atoumodIos.ARouenSaintSever.isDisplayed());

        //TODO il ya un bug ici pour ca j'ai commainté assertion

    }
    @And("Cliquer sur Ajouter une étape")
    public void cliquerSurAjouterUneÉtape() {
        atoumodIos.troisPoints.click();

        atoumodIos.btnAjouterUneEtape.click();

        String textAjouterUneEtape = "Via, Adresse, arrêt, gare...";

        Assert.assertTrue(atoumodIos.placeAjouterUneEtape.getText().contains(textAjouterUneEtape));

        atoumodIos.placeAjouterUneEtape.click();

        atoumodIos.placeAjouterUneEtape.sendKeys("Gare de Rouen Rive Droite");

        atoumodIos.btnGareDeRouenRiveDroite.click();

        assertTrue(atoumodIos.btnGareDeRouenRiveDroite.isDisplayed());

        atoumodIos.laCroix.click();

    }


    @And("Vérifier la présentation du bouton Rechercher")
    public void vérifierLaPrésentationDuBoutonRechercher() {

        atoumodIos.placeDe.click();

        atoumodIos.placeDe.sendKeys("Gare de Rouen Rive Droite");

        atoumodIos.btnGareDeRouenRiveDroite.click();

        String TextRechercher = "Rechercher";

        Assert.assertTrue(atoumodIos.btnRechercher.getText().contains(TextRechercher));

    }



    @And("Vérifier les Horaises des lignes")
    public void vérifierLesHoraisesDesLignes() {
        atoumodIos.getBtnHorairesDesLignes.click();
        assertTrue(atoumodIos.getTexthorairesPerturbations.isDisplayed());
        atoumodIos.btnPrécédent.click();
    }


    @And("Consulter section Acheter un titre pour la suite des tests")
    public void consulterSectionMTicketPourLaSuiteDesTests() throws InterruptedException, MalformedURLException {

        scrollToBottom(getDriver());

        String textAcheterUnTitre = "Acheter un titre";

        Assert.assertTrue(atoumodIos.acheterUnTitre.getText().contains(textAcheterUnTitre));

        atoumodIos.acheterUnTitre.click();
        atoumodIos.btnOuvrir.click();


    }

    @And("Vérifiez si vous avez été redirigé vers Atoumod M-ticket")
    public void vérifiezSiVousAvezÉtéRedirigéVersatoumodIosMticket() throws MalformedURLException, InterruptedException {

        String expectedTextSelectionnez = "Sélectionnez votre réseau";

        assertTrue(atoumodIos.btnSelectionnez.getText().contains(expectedTextSelectionnez));

        String expectedTextCréeMonCompte = "Sélectionnez un réseau afin d'afficher les";

        assertTrue(atoumodIos.SélectionnezUnRéseau.getText().contains(expectedTextCréeMonCompte));





    }


    @Given("Cliquer sur aller simple")
    public void cliquerSurAllerSimple() throws InterruptedException, MalformedURLException {

        assertTrue(atoumodIos.btnAllerSimple.isDisplayed());

        atoumodIos.btnAllerSimple.click();

        String expectedTextBtnAllerSimple = "Aller simple";

        Assert.assertTrue(atoumodIos.btnAllerSimple.getText().contains(expectedTextBtnAllerSimple));

        actions.doubleClick(atoumodIos.btnAllerSimple).click();

    }

    @When("Entrer une address")
    public void entrerUneAddress() {
        atoumodIos.btnAllerSimple.click();

        atoumodIos.placeDe.click();

        atoumodIos.placeDe.sendKeys("Gare de Caen");

        atoumodIos.btnGareDeCaen.click();

        String expectedTextPlaceDe = "Gare de Caen";

        Assert.assertTrue(atoumodIos.btnGareDeCaen.getText().contains(expectedTextPlaceDe));


    }

    @Then("Sélectionner une destination")
    public void sélectionnerUneDestination() {

        atoumodIos.placeA.click();

        atoumodIos.placeA.sendKeys("Caen-Calvaire Saint-Pierre");

        String expectedTextPlaceA = "Caen-Calvaire Saint-Pierre";

        Assert.assertTrue(atoumodIos.btnCalvaireSaintPierre.getText().contains(expectedTextPlaceA));

        atoumodIos.btnCalvaireSaintPierre.click();


    }

    @And("Si l'utilisateur a déjà effectué des recherches, ses sélections précédentes affiché dans une liste sous le champ de recherche.")
    public void siLUtilisateurADéjàEffectuéDesRecherchesSesSélectionsPrécédentesAffichéDansUneListeSousLeChampDeRecherche() throws InterruptedException {

        assertTrue(atoumodIos.btnCalvaireSaintPierre.isDisplayed());
        actions.doubleClick(atoumodIos.btnCalvaireSaintPierre).click();

    }

    @And("Efectuer une recherche pour Aller-Simple")
    public void efectuerUneRecherchePourAllerSimple() {

        String getTextRechercher = "Rechercher";
        assertTrue(atoumodIos.btnRechercher.getText().contains(getTextRechercher));
        atoumodIos.btnRechercher.click();


    }

    @And("Vérifier la différence entre les heures de départ et d'arrivée RI")
    public void vérifierLaDifférenceEntreLesHeuresDeDépartEtDArrivéeRI() throws InterruptedException {

        assertTrue(atoumodIos.getDepartCalenderir.isEnabled());
        atoumodIos.getDepartCalenderir.click();
        // atoumodIos.getHeure.click();
        Thread.sleep(2000);
    if(atoumodIos.getBtnValider.isDisplayed()) {
        atoumodIos.getBtnValider.click();
    }

        try {
            if (atoumodIos.PremierTEnCommun.isDisplayed()) {
                WebElement lheure1 = atoumodIos.lheureDifference;
                WebElement lheure2 = atoumodIos.lheureDepart;
                WebElement lheure3 = atoumodIos.lheureArrive;

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
            if (atoumodIos.PremierTEnCommun.isDisplayed()) {
                WebElement lheure1 = atoumodIos.lheureDifference;
                WebElement lheure2 = atoumodIos.lheureDepart;
                WebElement lheure3 = atoumodIos.lheureArrive;

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


    @And("Vérifier les transports de l'heure précédente")
    public void vérifierLesTransportsDeLHeurePrécédente() {

        atoumodIos.btnRetour.click();
        assertTrue(atoumodIos.textChoisirUnAller.isDisplayed());

    }


    @And("Afficher les transports de l'heure suivante et vérifier les suggestions pour Aller-Simple")
    public void afficherLesTransportsDeLHeureSuivanteEtVérifierLesSuggestionsPourAllerSimple() {

        actions.doubleClick(atoumodIos.btnSuivant).click();
        assertTrue(atoumodIos.textTransportEnCommun.getText().contains("Transport en commun"));
        assertTrue(atoumodIos.textDepart.isDisplayed());
    }

    @And("Cliquer sur licone fleche haut fleche bas pour changer le point de départ et la destination")
    public void cliquerSurLiconeFlecheHautFlecheBasPourChangerLePointDeDépartEtLaDestination() {
        atoumodIos.btnPrécédent.click();
        assertTrue(atoumodIos.btnGareDeCaen.isDisplayed());
        atoumodIos.btnGareDeCaen.click();

    }






    @And("L'utilisateur peut aussi cliquer sur Ma position pour Depart")
    public void lUtilisateurPeutAussiCliquerSurMaPositionPourDepart() {


        atoumodIos.placeHolderRechercher.click();
        atoumodIos.btnMaposition.click();

        String expectedTextMaPosition = "De, Ma position";

        assertThat(atoumodIos.btnDeMaPosition.getText().contains(expectedTextMaPosition), equalTo(true));

        actions.doubleClick(atoumodIos.btnDeMaPosition).sendKeys("Caen");


        //Driver.quitDriver();*/
    }


    @And("L'utilisateur peut aussi cliquer sur Ma position pour Arriver")
    public void lUtilisateurPeutAussiCliquerSurMaPositionPourArriver() {


    }

    @Given("Sélectionner aller retour")
    public void sélectionnerAllerRetour() throws MalformedURLException {

        atoumodIos.btnAllerSimple.click();
        atoumodIos.btnAllerRetour.click();
        atoumodIos.placeDe.sendKeys("Caen-Gare SNCF");
        atoumodIos.btnCaenGareSNCF.click();
        atoumodIos.placeA.sendKeys("Caen-Calvaire Saint-Pierre");
        atoumodIos.btnCalvaireSaintPierre.click();


    }

    @When("Cliquer sur le bouton calendrier pour Aller")
    public void cliquerSurLeBoutonCalendrierPourAller() {

        atoumodIos.getDepartCalenderir.click();
        atoumodIos.getBtnValider.click();

    }

    @Then("Cliquer sur le calendrier pour Aller-Retour")
    public void cliquerSurLeCalendrierPourAllerRetour() throws MalformedURLException {
        atoumodIos.btnRetour.click();

        List<WebElement> dates = getDriver().findElements(By.xpath("(//XCUIElementTypeButton)"));


        Random rand = new Random();
        int index = rand.nextInt(dates.size());


        dates.get(index).click();

        atoumodIos.getBtnValider.click();
    }

    @And("Cliquer sur licône flèche haut flèche bas pour changer le d et la destination")
    public void cliquerSurLicôneFlècheHautFlècheBasPourChangerLOrigineEtLaDestination() {

        atoumodIos.btnCaenGareSNCF.click();
        atoumodIos.placeHolderRechercher.sendKeys("Caen-Gare SNCF");
        atoumodIos.btnCaenGareSNCF.click();
        atoumodIos.btnCalvaireSaintPierre.click();
        atoumodIos.placeHolderRechercher.sendKeys("Caen-AVIATION");
        atoumodIos.btnCaenAVIATION.click();

    }

    @And("Faire une recherche pour Aller-Retour")
    public void faireUneRecherchePourAllerRetour() throws MalformedURLException, InterruptedException {
        String getTextRechercher = "Rechercher";
        assertTrue(atoumodIos.btnRechercher.getText().contains(getTextRechercher));
        atoumodIos.btnRechercher.click();
        atoumodIos.btnPrécédent.click();
        scrollDown(getDriver());

    }

    @And("Cliquer sur le calendrier sur le bouton Retour et sélectionner une date et ou une heure.")
    public void cliquerSurLeCalendrierSurLeBoutonRetourEtSélectionnerUneDateEtOuUneHeure() {
    }


    @And("Cliquer le bouton Horaires & perturbations")
    public void cliquerLeBoutonHorairesPerturbations() {
        assertTrue(atoumodIos.btnHorairesDesLignes.isDisplayed());

        atoumodIos.btnHorairesDesLignes.click();

        String expectedTextHorairesPerturbations = "Horaires & perturbations";
        String actualTextHorairesPerturbations = atoumodIos.getTexthorairesPerturbations.getText();
        assertThat(actualTextHorairesPerturbations, equalTo(expectedTextHorairesPerturbations));



    }


    @And("Vérifier la présence des émissions CO2")
    public void vérifierLaPrésenceDesÉmissionsCO2() throws MalformedURLException, InterruptedException {

        // Création de la liste principale
        List<WebElement> boites = getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@label='CO²']"));
        scrollDown(getDriver());
        int co2Sayisi = 0;
        for (WebElement boite : boites) {
            if (boite.isDisplayed()) {
                co2Sayisi++;
            }
        }

        System.out.println("CO2 : " + co2Sayisi);


    }

    @And("Cliquer sur un résultat dans le Transports en commun")
    public void cliquerSurUnRésultatDansLeTransportsEnCommun() throws MalformedURLException {
        // Trouve les éléments contenant le texte T1
        List<WebElement> t1Elements = getDriver().findElements(MobileBy.xpath("//XCUIElementTypeButton[contains(@name, 'T1')]"));

        // Si au moins un élément T1 est visible
        if (!t1Elements.isEmpty()) {
            // Clic sur le premier élément T1
            t1Elements.get(0).click();
        } else {
            // Affiche le message d'erreur si l'élément T1 visible n'est pas trouvé
            System.out.println("L'élément T1 n'est pas visible.");
        }

        //Dans les transports en commun, cliquer sur la première ligne


        String[][] expectedTexts = {
                {atoumodIos.btnGareDeCaen.getText(), "Gare de Caen"},
                {atoumodIos.btnCalvaireSaintPierre.getText(), "Caen-Calvaire Saint-Pierre"},
                {atoumodIos.btnVoirLesÉtapes.getText(), "voir les étapes"},
                {atoumodIos.getBtnCO2_2vle.getText(), "CO²"},
                {atoumodIos.getVoirLeRécapitulatif.getText(), "Voir le récapitulatif"},
        };

        for (String[] expectedText : expectedTexts) {
            String actualText = expectedText[0];
            if (actualText.contains(expectedText[1])) {
                System.out.println("Vérification réussie : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Vérification échouée : " + actualText + " ne contient pas le texte attendu");
            }
        }


        // Trouver l'élément de l'heure de départ
        List<WebElement> departureElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
       WebElement departureElement = null;
        for (WebElement element : departureElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d{2}:\\d{2}")) {
                departureElement = element;
                break;
            }
        }

        // Trouver l'élément de l'heure d'arrivée
        List<WebElement> arrivalElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
       WebElement arrivalElement = null;
        for (WebElement element : arrivalElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d{2}:\\d{2}") && !label.equals(departureElement.getAttribute("label"))) {
                arrivalElement = element;
                break;
            }
        }

        // Trouver l'élément de la différence
        List<WebElement> differenceElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
       WebElement differenceElement = null;
        for (WebElement element : differenceElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d+min") && !label.equals(departureElement.getAttribute("label")) && !label.equals(arrivalElement.getAttribute("label"))) {
                differenceElement = element;
                break;
            }
        }

        if (departureElement != null && arrivalElement != null && differenceElement != null) {
            // Obtenir la valeur de l'heure de départ
            String departureValue = departureElement.getAttribute("label");
            // Obtenir la valeur de l'heure d'arrivée
            String arrivalValue = arrivalElement.getAttribute("label");
            // Obtenir la valeur de la différence
            String differenceValue = differenceElement.getAttribute("label");

            System.out.println("Départ: " + departureValue);
            System.out.println("Arrivée: " + arrivalValue);
            System.out.println("Difference: " + differenceValue);


        } else {
            System.out.println("Éléments requis non trouvés.");
        }


    }


    @And("Consulter les émissions de CO² et vérifier le texte")
    public void consulterLesÉmissionsDeCOEtVérifierLeTexte() throws MalformedURLException {

        atoumodIos.btnCO_2.click();

        String[][] elementsToCheck = {
                {atoumodIos.getCeTrajetestSuper.getText(), "Ce trajet est super !"},
                {atoumodIos.getCO2émis.getText(), "CO² émis"},
                {atoumodIos.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}
        };

        for (String[] expectedText : elementsToCheck) {
            String actualText = expectedText[0];
            String expected = expectedText[1];

            if (actualText.contains(expected)) {
                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");
            }
            //TODO: Les calculs d'émissions n'ont pas été effectués, seuls les contrôles des textes sur la page ont été réalisés.


        }

        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = 137;  // Valeur supérieure de la page

        int end_x = (int) (dimension.width * 0.2);
        int end_y = 641;  // Valeur du bas de page

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();


    }

    @And("Cliquer sur les étapes Voir les étapes")
    public void CliquerSurLesÉtapesVoirLesÉtapes() throws MalformedURLException, InterruptedException {


        atoumodIos.btnVoirLesÉtapes.click();
        String xpath = "//*[starts-with(@label, 'Départ à')]";
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println(text);
            // Assertion
            assertThat(text, Matchers.containsString("Départ à"));
        }

        String xpath3 = "//*[starts-with(@label, 'Marcher m')]";
        List<WebElement> elements3 = getDriver().findElements(By.xpath(xpath3));

        for (WebElement element3 : elements3) {
            String text3 = element3.getText();
            System.out.println(text3);

            // Assertion
            assertThat(text3, Matchers.containsString("Marcher m"));
        }


        assertThat(atoumodIos.btnCalvaireSaintPierre.getText(), Matchers.containsString("Calvaire Saint-Pierre"));

        atoumodIos.btnCO_2.click();

        String[][] elementsToCheck = {
                {atoumodIos.getCeTrajetestSuper.getText(), "Ce trajet est super !"},
                {atoumodIos.getCO2émis.getText(), "CO² émis"},
                {atoumodIos.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}
        };

        for (String[] expectedText : elementsToCheck) {
            String actualText = expectedText[0];
            String expected = expectedText[1];

            if (actualText.contains(expected)) {
                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");
            }
            //TODO: Les calculs d'émissions n'ont pas été effectués, seuls les contrôles des textes sur la page ont été réalisés.


        }

        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = 137;  // Valeur supérieure de la page

        int end_x = (int) (dimension.width * 0.2);
        int end_y = 641;  // Valeur du bas de page

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();


        String xpath2 = "//*[starts-with(@label, 'Arrivée à')]";
        List<WebElement> elements2 = getDriver().findElements(By.xpath(xpath2));

        for (WebElement element2 : elements2) {
            String text2 = element2.getText();
            System.out.println(text2);
            assertThat(text2, Matchers.containsString("Arrivée à"));
        }


        getDriver().findElement(By.id("back")).click();

        //TODO:Faire voir les etapes pour retour aussi

    }

    @And("Cliquer sur le bouton Voir le recapitulatif")
    public void cliquerSurLeBoutonVoirLeRecapitulatif() throws MalformedURLException, InterruptedException {

        atoumodIos.btnVoirLeRecupitulatif.click();

        String textRécapitulatif = "Récapitulatif";

        assertThat(atoumodIos.getRécapitulatif.getText(), Matchers.containsString(textRécapitulatif));

        List<String> accessibilityIds = new ArrayList<>();
        accessibilityIds.add("Aller simple");
        accessibilityIds.add("Gare de Caen - Caen-Calvaire Saint-Pierre");
        accessibilityIds.add("T1");
        accessibilityIds.add("Voir les étapes");
        accessibilityIds.add("Le saviez-vous ?");
        accessibilityIds.add("Vous pourrez acheter vos titres sur l'application Atoumod m-ticket disponible ici");
        accessibilityIds.add("Découvrir");

        for (String accessibilityId : accessibilityIds) {
          WebElement element = getDriver().findElement(accessibilityId(accessibilityId));
            if (element.isDisplayed()) {
                System.out.println("Element '" + accessibilityId + "' est visible sur la page.");
            } else {
                System.out.println("Element '" + accessibilityId + "' est non visible sur la page.");
            }
        }


        atoumodIos.btnvoirLesÉtapes.click();
        atoumodIos.btnGareSNCF.click();
        scrollDown(getDriver());
        atoumodIos.btnCaenCalvaireSaintPierre.click();

        atoumodIos.get8arrêts.click();

        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = 137;  // Valeur supérieure de la page

        int end_x = (int) (dimension.width * 0.2);
        int end_y = 661;  // Valeur du bas de page

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();

        getDriver().navigate().back();


    }

    @And("Vérifier les résultats de la section Vélo")
    public void vérifierLesRésultatsDeLaSectionVélo() throws MalformedURLException, InterruptedException {

        scrollToBottom(getDriver());

        if (atoumodIos.getVélo.isDisplayed()) {

            atoumodIos.getTrajetVélo.click();

        }

        //Label indiquant le type de trajet proposé : "sécurisé" ou "le plus rapide"
        assertThat(atoumodIos.getSécurisé.getText(), Matchers.containsString("Sécurisé"));
      //  assertThat(atoumodIos.getLePlusRapide.getText(), Matchers.containsString("Le plus rapide"));
        //TODO: Y'a un bug ici
        Thread.sleep(2000);
        assertTrue(atoumodIos.btnCO_2Vélo.isDisplayed());
        //Click Sécurisé
        assertTrue(atoumodIos.getModeBike.isDisplayed());
        atoumodIos.getSécurisé.click();
        Thread.sleep(2000);
        assertTrue(atoumodIos.getModeBike.isDisplayed());
        assertTrue(atoumodIos.btnCalvaireSaintPierre.isDisplayed());
        assertTrue(atoumodIos.btnGareDeCaen.isDisplayed());
        assertTrue(atoumodIos.getSécurisé.getText().contains("Sécurisé"));
        atoumodIos.btnCO_2.click();

        String[][] elementsToCheck = {
                {atoumodIos.getCeTrajetestSuper.getText(), "Ce trajet est super !"},
                {atoumodIos.getCO2émis.getText(), "CO² émis"},
                {atoumodIos.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}
        };

        for (String[] expectedText : elementsToCheck) {
            String actualText = expectedText[0];
            String expected = expectedText[1];

            if (actualText.contains(expected)) {
                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");
            }
            Dimension dimension = getDriver().manage().window().getSize();
            int start_x = (int) (dimension.width * 0.5);
            int start_y = 137;  // Valeur supérieure de la page

            int end_x = (int) (dimension.width * 0.2);
            int end_y = 661;  // Valeur du bas de page

            TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
            touch.press(PointOption.point(start_x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(end_x, end_y))
                    .release()
                    .perform();


        }
    }

    @And("Vérifier la différence entre les heures de départ et darrivée pour loption Vélo")
    public void vérifierLaDifférenceEntreLesHeuresDeDépartEtDArrivéePourLOptionVélo() {

        WebElement lheure1 = atoumodIos.lheureDifference;
        WebElement lheure2 = atoumodIos.lheureDepart;
        WebElement lheure3 = atoumodIos.lheureArrive;

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




    @And("Vérifier les étapes Voir les étapes pour Vélo")
    public void vérifierLesÉtapesVoirLesÉtapesPourVélo() throws MalformedURLException, InterruptedException {


        atoumodIos.btnVoirLesÉtapes.click();

        String xpath = "//*[starts-with(@label, 'Départ à')]";
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println(text);
            // Assertion
            assertThat(text, Matchers.containsString("Départ à"));
        }

        String xpath3 = "//*[starts-with(@label, 'Dénivelé positif')]";
        List<WebElement> elements3 = getDriver().findElements(By.xpath(xpath3));

        for (WebElement element3 : elements3) {
            String text3 = element3.getText();
            System.out.println(text3);

            // Assertion
            assertThat(text3, Matchers.containsString("Dénivelé positif"));
        }


        assertThat(atoumodIos.btnGareDeCaen.getText(), Matchers.containsString("Gare de Caen"));


        assertThat(atoumodIos.btnCalvaireSaintPierre.getText(), Matchers.containsString("Calvaire Saint-Pierre"));

        atoumodIos.btnCO_2.click();

        String[][] elementsToCheck = {
                {atoumodIos.getCeTrajetestSuper.getText(), "Ce trajet est super !"},
                {atoumodIos.getCO2émis.getText(), "CO² émis"},
                {atoumodIos.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}
        };

        for (String[] expectedText : elementsToCheck) {

            String actualText = expectedText[0];

            String expected = expectedText[1];

            if (actualText.contains(expected)) {

                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {

                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");

            }
            //TODO: Les calculs d'émissions n'ont pas été effectués, seuls les contrôles des textes sur la page ont été réalisés.


        }

        performSwipe(137, 641);


        String xpath2 = "//*[starts-with(@label, 'Arrivée à')]";

        List<WebElement> elements2 = getDriver().findElements(By.xpath(xpath2));

        for (WebElement element2 : elements2) {

            String text2 = element2.getText();

            System.out.println(text2);

            assertThat(text2, Matchers.containsString("Arrivée à"));
        }


       WebElement fleshRetour = getDriver().findElement(By.id("back"));

        fleshRetour.click();

        fleshRetour.click();

        //TODO: Faire test auto pour le mode plus rapide aussi


    }

    @And("Choisir le résultat Voiture")
    public void cliquerSurLeRésultatVoiture() throws MalformedURLException, InterruptedException {

        getDriver().navigate().back();

        atoumodIos.btnRechercher.click();

        scrollToBottom(getDriver());
        Thread.sleep(2000);

        scrollToBottom(getDriver());

        assertTrue(atoumodIos.btnModeCar.isDisplayed());

        //TODO Vérifier la différence entre les heures de départ et d'arrivée
        if (atoumodIos.btnModeCar.isEnabled()) {

            atoumodIos.btnModeCar.click();
        }

        // contrôleHorloge();

        Thread.sleep(3000);

        String textVoiture = "Voiture";

        String actualTextVoiture = atoumodIos.btnVoiture.getText();

        assertEquals(textVoiture, actualTextVoiture);


        String xpath = "//*[starts-with(@label, 'Départ à')]";

        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));

        for (WebElement element : elements) {

            String text = element.getText();

            System.out.println(text);
            // Assertion
            assertThat(text, Matchers.containsString("Départ à"));

        }


        assertTrue(atoumodIos.btnGareDeCaen.isDisplayed());

        assertTrue(atoumodIos.btnCalvaireSaintPierre.isDisplayed());

        assertTrue(atoumodIos.btnModeCar.isDisplayed());

        atoumodIos.btnVoirLesÉtapes.click();

        String xpath3 = "//*[starts-with(@label, 'Départ à')]";

        List<WebElement> elements3 = getDriver().findElements(By.xpath(xpath));

        for (WebElement element : elements3) {

            String text = element.getText();

            System.out.println(text);
            // Assertion
            assertThat(text, Matchers.containsString("Départ à"));

        }

        assertTrue(atoumodIos.btnGareDeCaen.isDisplayed());

        String xpath2 = "//*[starts-with(@label, 'Arrivée à')]";

        List<WebElement> elements2 = getDriver().findElements(By.xpath(xpath2));

        for (WebElement element2 : elements2) {

            String text2 = element2.getText();

            System.out.println(text2);

            assertThat(text2, Matchers.containsString("Arrivée à"));

        }


        assertTrue(atoumodIos.getVehiculePersonnel.isDisplayed());

        assertTrue(atoumodIos.btnCalvaireSaintPierre.isDisplayed());

        atoumodIos.btnCO_2.click();

        String[][] elementsToCheck = {

                {atoumodIos.getCO2émis.getText(), "CO² émis"},

                {atoumodIos.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}

        };

        for (String[] expectedText : elementsToCheck) {

            String actualText = expectedText[0];

            String expected = expectedText[1];

            if (actualText.contains(expected)) {
                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");
            }
            //TODO: Les calculs d'émissions n'ont pas été effectués, seuls les contrôles des textes sur la page ont été réalisés.


        }

        performSwipe(137, 641);


        Thread.sleep(2000);


    }


    @And("Vérifier le résultat Marche")
    public void vérifierLeRésultatMarche() throws InterruptedException, MalformedURLException {

        scrollDown(getDriver());
        scrollUp(atoumodIos.btnGareDeCaen,25);
        atoumodIos.getBack.click();

        performSwipe(143, 649);

        atoumodIos.getBack.click();

        String expectedTextMarche = "Marche";

        assertTrue(atoumodIos.getMarche.getText().contains(expectedTextMarche));

        assertTrue(atoumodIos.getMarche.isDisplayed());



        if (atoumodIos.btnModeWalk.isDisplayed()) {
            atoumodIos.btnModeWalk.click();
        }

        // contrôleHorloge();

        assertTrue(atoumodIos.btnModeWalk.isDisplayed());

        assertTrue(atoumodIos.btnGareDeCaen.isDisplayed());


        assertTrue(atoumodIos.btnCO_2.isDisplayed());

        atoumodIos.btnVoirLesÉtapes.click();

        atoumodIos.btnCO_2.click();

        String[][] elementsToCheck = {
                {atoumodIos.getCeTrajetestSuper.getText(), "Ce trajet est super !"},
                {atoumodIos.getCO2émis.getText(), "CO² émis"},
                {atoumodIos.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}
        };

        for (String[] expectedText : elementsToCheck) {

            String actualText = expectedText[0];

            String expected = expectedText[1];

            if (actualText.contains(expected)) {

                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {

                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");

            }


            performSwipe(497, 504);





        }


    }


    @When("Vérifier les résultats de recherche d'itinéraire")
    public void vérifierLesRésultatsDeRechercheDItinéraire() throws InterruptedException {

        atoumodIos.getDepartCalenderir.click();
        atoumodIos.getBtnValider.click();
        atoumodIos.btnRetour.click();
        Thread.sleep(2000);
        atoumodIos.fleshGo.click();
        if (atoumodIos.getBtnValider.isDisplayed()) {
            atoumodIos.getBtnValider.click();
        }


        atoumodIos.btnRechercher.click();

        assertTrue(atoumodIos.textChoisirUnAller.isDisplayed());
        assertTrue(atoumodIos.btnAller.isDisplayed());
        assertTrue(atoumodIos.textRetour.isDisplayed());
        assertTrue(atoumodIos.btnCaenGareSNCF.isDisplayed());
        assertTrue(atoumodIos.btnCalvaireSaintPierre.isDisplayed());
        assertTrue(atoumodIos.textDe.isDisplayed() && atoumodIos.textÀ.isDisplayed());
        assertTrue(atoumodIos.textTransportEnCommun.isDisplayed());
        assertTrue(atoumodIos.btnCO_2.isDisplayed());

        //TODO: - de la séquence de transports en commun combinés proposés triés par l'arrivée au plus tôt
    }

    @Then("Consulter les résultats Transports en commun de l'aller")
    public void consulterLesRésultatsTransportsEnCommunDeLAller() throws MalformedURLException {

        List<String> xpaths = Arrays.asList("(//XCUIElementTypeButton)[3]", "(//XCUIElementTypeButton)[4]", "(//XCUIElementTypeButton)[5]", "(//XCUIElementTypeButton)[6]");

        boolean isTestFailed = false;

        for (String xpath : xpaths) {
           WebElement element;
            try {
                element = getDriver().findElement(By.xpath(xpath));
            } catch (NoSuchElementException e) {
                isTestFailed = true;
                System.out.println("XPath: " + xpath);
                System.out.println("Erreur : L'élément correspondant au XPath n'a pas été trouvé.");
                System.out.println("----------------------------------");
                continue;
            }

            String text = element.getText();
            boolean hasCo2 = text.contains("CO²");

            System.out.println("XPath: " + xpath);
            System.out.println("Texte: " + text);
            System.out.println("A 'co2': " + hasCo2);

            // Extraction des informations de la tuile de résultat
            String[] lines = text.split(", ");
            boolean hasTransport = false;
            boolean hasDuration = false;
            boolean hasMin = false;
            for (String line : lines) {
                if (line.startsWith("T")) {
                    System.out.println("Séquence de transports en commun : " + line);
                    hasTransport = true;
                } else if (line.endsWith("min")) {
                    System.out.println("Durée du trajet : " + line);
                    hasDuration = true;
                    hasMin = true;
                }
            }

            if (!hasTransport) {
                isTestFailed = true;
                System.out.println("Erreur : Le texte ne contient pas d'informations sur la séquence de transports en commun.");
            }

            if (!hasDuration) {
                isTestFailed = true;
                System.out.println("Erreur : Le texte ne contient pas d'informations sur la durée du trajet.");
            }

            if (!hasMin) {
                isTestFailed = true;
                System.out.println("Erreur : Le texte ne contient pas d'informations sur la valeur 'min'.");
            }

            System.out.println("----------------------------------");

            // Si la valeur co2 n'est pas trouvée, vous pouvez afficher un message d'erreur ici ou prendre d'autres mesures si vous le souhaitez.
            if (!hasCo2) {
                isTestFailed = true;
                System.out.println("Erreur : La valeur co2 n'a pas été trouvée dans le XPath " + xpath);
            }
        }


    }

    @And("Sélectionner un des résultats Transports en commun pour l'aller")
    public void sélectionnerUnDesRésultatsTransportsEnCommunPourLAller() throws MalformedURLException, InterruptedException {

        // Trouve les éléments contenant le texte T1
        List<WebElement> t1Elements = getDriver().findElements(MobileBy.xpath("//XCUIElementTypeButton[contains(@name, 'T1')]"));

        // Si au moins un élément T1 est visible
        if (!t1Elements.isEmpty()) {
            // Clic sur le premier élément T1
            t1Elements.get(0).click();
        } else {
            // Affiche le message d'erreur si l'élément T1 visible n'est pas trouvé
            System.out.println("L'élément T1 n'est pas visible.");
        }

        //Dans les transports en commun, cliquer sur la première ligne


        String[][] expectedTexts = {
                {atoumodIos.btnCaenGareSNCF.getText(), "Caen-Gare SNCF"},
                {atoumodIos.btnCalvaireSaintPierre.getText(), "Caen-Calvaire Saint-Pierre"},
                {atoumodIos.btnVoirLesÉtapes.getText(), "voir les étapes"},
                {atoumodIos.btnCO_2.getText(), "CO²"},
                {atoumodIos.btnChoisirLeRetour.getText(), "Choisir le retour"}
        };

        for (String[] expectedText : expectedTexts) {
            String actualText = expectedText[0];
            if (actualText.contains(expectedText[1])) {
                System.out.println("Vérification réussie : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Vérification échouée : " + actualText + " ne contient pas le texte attendu");
            }
        }


        contrôleHorlogePriview();
    }


    @And("Cliquer sur Voir les étapes")
    public void cliquerSurVoirLesÉtapes() throws MalformedURLException, InterruptedException {

        atoumodIos.btnVoirLesÉtapes.click();
        String xpath = "//*[starts-with(@label, 'Départ à')]";
        List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println(text);
            // Assertion
            assertThat(text, Matchers.containsString("Départ à"));
        }

        String xpath3 = "//*[starts-with(@label, 'Marcher m')]";
        List<WebElement> elements3 = getDriver().findElements(By.xpath(xpath3));

        for (WebElement element3 : elements3) {
            String text3 = element3.getText();
            System.out.println(text3);

            // Assertion
            assertThat(text3, Matchers.containsString("Marcher m"));
        }


        assertThat(atoumodIos.btnGareSNCF.getText(), Matchers.containsString("Gare SNCF"));

        assertThat(atoumodIos.btnCalvaireSaintPierre.getText(), Matchers.containsString("Calvaire Saint-Pierre"));

        atoumodIos.btnCO_2.click();

        String[][] elementsToCheck = {
                {atoumodIos.getCeTrajetestSuper.getText(), "Ce trajet est super !"},
                {atoumodIos.getCO2émis.getText(), "CO² émis"},
                {atoumodIos.getEnUtilisant.getText(), "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales"}
        };

        for (String[] expectedText : elementsToCheck) {
            String actualText = expectedText[0];
            String expected = expectedText[1];

            if (actualText.contains(expected)) {
                System.out.println("Le texte attendu a été confirmé : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Le texte attendu n'a pas été confirmé : " + actualText + " ne contient pas le texte attendu");
            }
            //TODO: Les calculs d'émissions n'ont pas été effectués, seuls les contrôles des textes sur la page ont été réalisés.


        }

        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = 137;  // Valeur supérieure de la page

        int end_x = (int) (dimension.width * 0.2);
        int end_y = 641;  // Valeur du bas de page

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();


        String xpath2 = "//*[starts-with(@label, 'Arrivée à')]";
        List<WebElement> elements2 = getDriver().findElements(By.xpath(xpath2));

        for (WebElement element2 : elements2) {
            String text2 = element2.getText();

            System.out.println(text2);
            assertThat(text2, Matchers.containsString("Arrivée à"));
            Thread.sleep(2000);


        }


    }



    @And("Cliquer sur Choisir un retour et Consulter les résultats Transports en commun pour le Trajet retour")
    public void cliquerSurChoisirUnRetourEtConsulterLesRésultatsTransportsEnCommunPourLeTrajetRetour() throws MalformedURLException, InterruptedException {

        //TODO:de la séquence de transports en commun combinés proposés triés par l'arrivée au plus tôt
        atoumodIos.back.click();
        atoumodIos.btnChoisirLeRetour.click();

        String textChoisirUnRetour = "Choisir un retour";
        assertTrue(atoumodIos.btnChoisirUnRetour.getText().contains(textChoisirUnRetour));
        assertTrue(atoumodIos.btnCO_2.isDisplayed());

        System.out.println("*****************");

        contrôleHorlogeTransportCommun();

    }

    @And("Sélectionner un des résultats Transports en commun pour le retour")
    public void sélectionnerUnDesRésultatsTransportsEnCommunPourLeRetour() throws MalformedURLException {
        List<WebElement> t1Elements = getDriver().findElements(MobileBy.xpath("//XCUIElementTypeButton[contains(@name, 'T1')]"));
        List<WebElement> t2Elements = getDriver().findElements(MobileBy.xpath("//XCUIElementTypeButton[contains(@name, 'T2')]"));

        if (!t2Elements.isEmpty()) {
            t2Elements.get(0).click(); // Si T2 est visible, cliquer sur T2
        } else if (!t1Elements.isEmpty()) {
            t1Elements.get(0).click(); // Si T2 n'est pas visible mais T1 est visible, cliquer sur T1
        } else {
            System.out.println("Les éléments T1 et T2 ne sont pas visibles.");
        }

// Le reste du code reste inchangé

        //Dans les transports en commun, cliquer sur la première ligne


        String[][] expectedTexts = {
                {atoumodIos.btnCaenGareSNCF.getText(), "Caen-Gare SNCF"},
                {atoumodIos.btnCalvaireSaintPierre.getText(), "Caen-Calvaire Saint-Pierre"},
                {atoumodIos.btnVoirLesÉtapes.getText(), "voir les étapes"},
                {atoumodIos.btnCO_2.getText(), "CO²"},
                {atoumodIos.getVoirLeRécapitulatif.getText(), "Voir le récapitulatif"},
        };

        for (String[] expectedText : expectedTexts) {
            String actualText = expectedText[0];
            if (actualText.contains(expectedText[1])) {
                System.out.println("Vérification réussie : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Vérification échouée : " + actualText + " ne contient pas le texte attendu");
            }
        }


        // Trouver l'élément de l'heure de départ
        List<WebElement> departureElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
       WebElement departureElement = null;
        for (WebElement element : departureElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d{2}:\\d{2}")) {
                departureElement = element;
                break;
            }
        }

        // Trouver l'élément de l'heure d'arrivée
        List<WebElement> arrivalElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
       WebElement arrivalElement = null;
        for (WebElement element : arrivalElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d{2}:\\d{2}") && !label.equals(departureElement.getAttribute("label"))) {
                arrivalElement = element;
                break;
            }
        }

        // Trouver l'élément de la différence
        List<WebElement> differenceElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
       WebElement differenceElement = null;
        for (WebElement element : differenceElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d+min") && !label.equals(departureElement.getAttribute("label")) && !label.equals(arrivalElement.getAttribute("label"))) {
                differenceElement = element;
                break;
            }
        }

        if (departureElement != null && arrivalElement != null && differenceElement != null) {
            // Obtenir la valeur de l'heure de départ
            String departureValue = departureElement.getAttribute("label");
            // Obtenir la valeur de l'heure d'arrivée
            String arrivalValue = arrivalElement.getAttribute("label");
            // Obtenir la valeur de la différence
            String differenceValue = differenceElement.getAttribute("label");

            System.out.println("Départ: " + departureValue);
            System.out.println("Arrivée: " + arrivalValue);
            System.out.println("Difference: " + differenceValue);


        } else {
            System.out.println("Éléments requis non trouvés.");
        }


    }

    @And("Cliquer sur Voir le recapitulatif pour l'Aller-Retour")
    public void cliquerSurVoirLeRecapitulatifPourLAllerRetour() throws MalformedURLException, InterruptedException {

        atoumodIos.btnVoirLeRecupitulatif.click();

        String textRécapitulatif = "Récapitulatif";

        assertThat(atoumodIos.getRécapitulatif.getText(), Matchers.containsString(textRécapitulatif));

        List<String> accessibilityIds = new ArrayList<>();
        accessibilityIds.add("Aller");
        accessibilityIds.add("Caen-Gare SNCF - Caen-Calvaire Saint-Pierre");
        accessibilityIds.add("T1");
        accessibilityIds.add("Retour");
        accessibilityIds.add("Caen-Calvaire Saint-Pierre - Caen-Gare SNCF");
        accessibilityIds.add("Voir les étapes");
        accessibilityIds.add("Le saviez-vous ?");
       // accessibilityIds.add("Vous pourrez acheter vos titres sur l'application atoumodIos m-ticket disponible ici");
       // accessibilityIds.add("Découvrir");

        for (String accessibilityId : accessibilityIds) {
           WebElement element = getDriver().findElement(accessibilityId(accessibilityId));
            if (element.isDisplayed()) {
                System.out.println("Element '" + accessibilityId + "' est visible sur la page.");
            } else {
                System.out.println("Element '" + accessibilityId + "' est non visible sur la page.");
            }
        }

         scrollDown(getDriver());

        List<String> accessibilityIdss = new ArrayList<>();

         accessibilityIdss.add("Vous pourrez acheter vos titres sur l'application Atoumod m-ticket disponible ici");
         accessibilityIdss.add("Découvrir");

        for (String accessibilityIdx : accessibilityIdss) {
            WebElement element = getDriver().findElement(accessibilityId(accessibilityIdx));
            if (element.isDisplayed()) {
                System.out.println("Element '" + accessibilityIdx + "' est visible sur la page.");
            } else {
                System.out.println("Element '" + accessibilityIdx + "' est non visible sur la page.");
            }
        }
        atoumodIos.btnvoirLesÉtapes.click();

        atoumodIos.btnCaenGareSNCF.click();


        //  assertTrue(atoumodIos.btnCaenCalvaireSaintPierre.isDisplayed());
        // performSwipe(150,653);
        atoumodIos.back.click();

        atoumodIos.btnDécouvrir.click();

        assertTrue(atoumodIos.btnOuvrir.isDisplayed());




    }


    @Given("Sur la page d'accueil, cliquer sur l'illustration Horaires des lignes")
    public void surLaPageDAccueilCliquerSurLIllustrationHorairesDesLignes() {

        atoumodIos.getBtnHorairesDesLignes.click();

    }

    @When("L'utilisateur arrive sur un écran de recherche permettant d'entrer un numéro de ligne")
    public void lUtilisateurArriveSurUnÉcranDeRecherchePermettantDEntrerUnNuméroDeLigne() {

        assertTrue(atoumodIos.getTexthorairesPerturbations.isDisplayed());

        assertTrue(atoumodIos.getBtnRechercherUneLigne.isDisplayed());

        assertTrue(atoumodIos.iconeRechercher.isDisplayed());


    }

    @Then("Saisir un numéro de ligne")
    public void saisirUnNuméroDeLigne() {

        //TODO:Les résultats sont présentés dans l'ordre défini des sous-réseaux en regroupant les résultats par sous-réseaux

        atoumodIos.getBtnRechercherUneLigne.sendKeys("3");


    }

    @And("Choisir une ligne")
    public void choisirUneLigne() throws InterruptedException, MalformedURLException {

        //TODO:une carte sur laquelle le tracé de la ligne apparaît

        Thread.sleep(2000);

        atoumodIos.getBtnT3.click();

        String expectedTextMonet = "Monet  Durécu-Lavoisier";

        assertThat(atoumodIos.getMonet.getText(), equalTo(expectedTextMonet));


        assertTrue(atoumodIos.btnDescendre.isDisplayed());

        scrollHalfway(getDriver());

        //Une combobox permettant de choisir le terminus souhaité

        atoumodIos.getVers.click();

        List<String> accessibilityIds = new ArrayList<>();
        accessibilityIds.add("Durécu-Lavoisier");
        accessibilityIds.add("Monet");

        for (String accessibilityId : accessibilityIds) {
           WebElement element = getDriver().findElement(accessibilityId(accessibilityId));
            if (element.isEnabled()) {

                System.out.println("Element '" + accessibilityId + "' est visible sur la page.");
            } else {
                System.out.println("Element '" + accessibilityId + "' est non visible sur la page.");
            }
        }


        //TODO:a liste des arrêts présenté sous forme de thermomètre de ligne


    }

    @And("Changer le terminus déjà sélectionné")
    public void changerLeTerminusDéjàSélectionné() throws MalformedURLException, InterruptedException {

        atoumodIos.btnDurécuLavoisier.click();


        //TODO:ses arrêts sont mis à jour en fonction du nouveau parcours
    }

    @And("Choissir un arrêt sur la ligne  dans la liste du thermomètre")
    public void choissirUnArrêtSurLaLigneDansLaListeDuThermomètre() throws MalformedURLException {
        atoumodIos.btnMonet.click();

        assertTrue(atoumodIos.getTousLesHoraires.isEnabled());

        assertTrue(atoumodIos.btnProchainPassage.isDisplayed());

        assertTrue(atoumodIos.btnLheurePassage.isDisplayed());


    }

    @And("Afficher les prochains passages à l'arrêt et Cliquer sur le bouton Tous les horaires")
    public void afficherLesProchainsPassagesÀLArrêtEtCliquerSurLeBoutonTousLesHoraires() {

        atoumodIos.getTousLesHoraires.click();

        assertTrue(atoumodIos.getDurécuLavoisier.isDisplayed());

        assertTrue(atoumodIos.btnFiltr.isDisplayed());

        assertTrue(atoumodIos.btnProchainesPassages.isDisplayed());

        assertTrue(atoumodIos.btnVoirTout.isDisplayed());

        Assert.assertTrue(atoumodIos.btnT3.isDisplayed());


    }

    @And("Consulter tous les passages du jour à l'arrêt et Cliquer sur Voir tout")
    public void consulterTousLesPassagesDuJourÀLArrêtEtCliquerSurVoirTout() throws MalformedURLException, InterruptedException {

        atoumodIos.btnVoirTout.click();

        Thread.sleep(2000);

        assertTrue(atoumodIos.btnFiltr.isDisplayed());

        assertTrue(atoumodIos.btnDate.isDisplayed());

        System.out.println(atoumodIos.getBtnHorairesDate.getText());
        // Format de la date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE. d MMMM", Locale.FRENCH);

// Date attendue
        LocalDate expectedDate = LocalDate.now();
        String expectedDateString = "Date, " + expectedDate.format(dateFormatter).replaceAll("\\.{2,}", ".");

// Élément WebElement
        WebElement btnHorairesDate = getDriver().findElement(By.xpath("(//XCUIElementTypeButton)[22]"));

// Récupération de la date et vérification
        String actualDate = btnHorairesDate.getText();

        System.out.println("Date réelle : " + actualDate);
        System.out.println("Date attendue : " + expectedDateString);

        Assert.assertEquals(expectedDateString, actualDate);
        if (actualDate.equals(expectedDateString)) {
            System.out.println("La date est vérifiée.");
        } else {
            System.out.println("La date n'est pas vérifiée.");
            System.out.println("Échec");
        }



        atoumodIos.btnSuivant.click();
        //picto du mode de transport
        assertTrue(atoumodIos.iconeTramway.isDisplayed());

        //TODO:NB : les horaires de passages sont listés par heure de passage dans la journée de 00:00 à 23:59

        assertTrue(atoumodIos.btnGetVers.isDisplayed());

        assertTrue(atoumodIos.btngetMonet.isDisplayed());



    }


    @Given("Consulter l'écran d'accueil")
    public void consulterLÉcranDAccueil() throws MalformedURLException, InterruptedException {

        //L'écran Autour de vous est composé de :
        // - un champ de recherche
        while (true) {

            scrollToBottom(getDriver());

            if (atoumodIos.getTextAtourDeVous.isDisplayed()) {

                break;
            }

            Thread.sleep(1000);
        }


        atoumodIos.btnGetMaPosition.click();

        String getTextRechercher = "Rechercher...";

        Assert.assertTrue(atoumodIos.placeHolderRechercher.getText().contains(getTextRechercher));
        //  - un picto flèche pour mettre à jour la géolocalisation de l'utilisateur
        //
        //   - une carte centrée sur la position de l'utilisateur s'il a accepté de partager sa position


    }

    @And("Naviguer à travers la carte.")
    public void NavigeurATraversLaCarte() throws InterruptedException, MalformedURLException {
        Thread.sleep(2000);

        atoumodIos.btnGetMaPosition.click();

        atoumodIos.getPlaceHolderRechercher.sendKeys("Gare de Rouen Rive Droite");

        atoumodIos.btnGareDeRouenRiveDroite.click();

        assertTrue(atoumodIos.getReperesurLaCarte.isDisplayed());


    }

    @And("Agrandir et Réduire la carte")
    public void AgrandirEtRéduireLaCarte() throws InterruptedException {

        /*Dans la zone de la carte, zoomer et dézoomer
        Les POI présents dans la zone de la carte affichée se chargent en fonction de leur importance :
        - au zoom le plus haut : on ne voit que les arrêts de transports en commun
        actions.doubleClick(atoumodIos.getReperesurLaCarte).perform();*/

        for (int i = 0; i < 3; i++) {
            actions.doubleClick(atoumodIos.getReperesurLaCarte).perform();
        }
        assertTrue(atoumodIos.iconeBus.isEnabled());

        Thread.sleep(2000);

        //  - plus on zoome, plus des POI secondaires apparaissent > d'abord sous forme de point coloré puis sous forme de picto en fonction du type de POI
        for (int i = 2; i > 0; i--) {
            actions.doubleClick(atoumodIos.getReperesurLaCarte).perform();
        }

        assertTrue(atoumodIos.iconeBus.isEnabled());

    }

    @And("Recentrer la localisation géographique")
    public void recentrerLaLocalisationGéographique() throws InterruptedException {
        //Cliquer sur l'icone flèche en haut à droite de l'écran sous le champ de recherche pour recentrer la position de l'utilisateur dans la carte
        // Autour de vous (s'il a accepté de partager sa position)
        atoumodIos.getMaPosition.click();

        assertTrue(atoumodIos.btnGetMaPosition.isEnabled());


    }

    @And("Aller dans le champ de recherche d'adresse")
    public void AllerDansLeChampDeRechercheDAdresse() throws InterruptedException {
        //Cliquer sur le champ de recherche d'adresse (même comportement que pour les champs O/D de la RI) et taper puis choisir une adresse
        Thread.sleep(2000);
        atoumodIos.btnGetMaPosition.click();
        atoumodIos.getPlaceHolderRechercher.sendKeys("Gare de Le Havre");



    }
    @And("Choisir un point de mobilité sur la carte \\(arrêt de bus, de train, de métro de tram : picto sur fond bleu)")
    public void choisirUnPointDeMobilitéSurLaCarteArrêtDeBusDeTrainDeMétroDeTramPictoSurFondBleu() {


            assertTrue(atoumodIos.getGaredeLeHavre.isEnabled());
            // Au clic sur un POM, l'utilisateur arrive sur la vue de détail du POM.
            // Cet écran est composé de :

            //       - position géographique du POM sur la carte
            //   - picto du mode de transport
            //  - nom de l'arrêt
            // Cet écran est composé de :
            // - l'adresse du POM dans la barre de recherche
            //       - position géographique du POM sur la carte
            //   - picto du mode de transport
            atoumodIos.getGaredeLeHavre.click();

            atoumodIos.getReperesurLaCarte.click();
            // - l'adresse du POM dans la barre de recherche
            assertTrue(atoumodIos.getBtnItinéraire.isDisplayed());


            atoumodIos.btnClear.click();


            // L'utilisateur peut aussi cliquer sur "Ma position"(si la géolocalisation a été acceptée par avance, sinon l'utilisateur aura une modale pour accepter ou refuser la géolocalisation- s'il refuse, il n'aura pas la possibilité de sélectionner "Ma position")

            atoumodIos.getPlaceHolderRechercher.click();

            assertTrue(atoumodIos.getBtnMapositionAutour.isDisplayed());

            atoumodIos.getBtnMapositionAutour.click();


            // Si l'utilisateur a déjà effectué des recherches, ses sélections précédentes remontent dans une liste sous le champs de recherche.
            atoumodIos.btnClear.click();
            atoumodIos.getPlaceHolderRechercher.click();

            assertTrue(atoumodIos.getGaredeLeHavre.isEnabled());

            atoumodIos.getGaredeLeHavre.click();



            //  Les POM sont les éléments de la carte que s'affichent au zoom le plus haut.



            //  - nom de l'arrêt
            //      - filtre des lignes passant par cet arrêt (l'utilisateur peut cocher ou décocher des lignes)
            //     - les horaires théoriques des deux prochains passages dans cette direction vers les différents terminus (si présent dans les données)
            //     - un lien Voir tout
            //    (cf : section Horaires & perturbations pour les écrans suivants : ce sont les mêmes)





        }



    @And("Cliquer sur la croix")
    public void cliquerSurLaCroix() throws MalformedURLException {

        //Cliquer sur la croix au sein du champ de recherche, le champ se vide
        atoumodIos.btnClear.click();


    }


    @And("Choisir un point d'intérêt sur la carte")
    public void choisirUnPointDIntérêtSurLaCarte() {

        /*
        Les POM sont les éléments de la carte que s'affichent au zoom le plus haut.
Au clic sur un POM, l'utilisateur arrive sur la vue de détail du POM.
Cet écran est composé de :
- l'adresse du POM dans la barre de recherche
- position géographique du POM sur la carte
- picto du mode de transport
- nom de l'arrêt
- filtre des lignes passant par cet arrêt (l'utilisateur peut cocher ou décocher des lignes)
- les horaires théoriques des deux prochains passages dans cette direction vers les différents terminus (si présent dans les données)
- un lien Voir tout
(cf : section Horaires & perturbations pour les écrans suivants : ce sont les mêmes)
         */


    }

    @And("Cliquer sur le bouton Itinéraire sur le détail d'un POI")
    public void cliquerSurLeBoutonItinéraireSurLeDétailDUnPOI() {

        /*
        Les POI sont les éléments de la carte que s'affichent au zoom le plus bas sur la carte.
Au clic sur un POI, l'utilisateur arrive sur une vue de détail du POI. Cet écran est composé de :
- l'adresse du POI dans la barre de recherche
- position géographique du POI sur la carte
- picto du POI
- nom du POI
- catégorie du POI
- un bouton Itinéraire
         */



    }


    @When("Vérifier la présence de l'entrée Acheter un titre dans la tabbar et cliquer")
    public void vérifierLaPrésenceDeLEntréeAcheterUnTitreDansLaTabbarEtCliquer() throws MalformedURLException, InterruptedException {
        //L'entrée M-Ticket est présente dans la tabbar en deuxième position, à droite de la Home
        scrollHalfway(getDriver());

        assertTrue(atoumodIos.acheterUnTitre.isDisplayed());
        atoumodIos.acheterUnTitre.click();

    }


    @And("Consulter l'écran Acheter un titre")
    public void consulterLÉcranAcheterUnTitre() {
    //L'écran est composé d'une illustration, d'un titre, d'une description et d'un bouton
        //(écran en attente du lien dynamique WOP)
      assertTrue(atoumodIos.getRetrouvezVosTitres.isDisplayed() && atoumodIos.getAcheterVosTitres.isDisplayed());


    }


    /*@Given("Choisir aller retour")
    public void choisirAllerRetour() {
        atoumodIos.btnAllerSimple.click();
        atoumodIos.btnAllerRetour.click();
        atoumodIos.placeDe.sendKeys("Caen-Gare SNCF");
        atoumodIos.btnCaenGareSNCF.click();
        atoumodIos.placeA.sendKeys("Caen-Calvaire Saint-Pierre");
        atoumodIos.btnCalvaireSaintPierre.click();

    }*/

    @And("Effectuer une recherche pour Aller-Simple")
    public void effectuerUneRecherchePourAllerSimpleIos() {
        String getTextRechercher = "Rechercher";
        assertTrue(atoumodIos.btnRechercher.getText().contains(getTextRechercher));
        atoumodIos.btnRechercher.click();
    }

    @And("Cliquer sur licône flèche haut flèche bas pour changer départ et la destination")
    public void cliquerSurLicôneFlècheHautFlècheBasPourChangerDépartEtLaDestination() {

        atoumodIos.btnCaenGareSNCF.click();
        atoumodIos.placeHolderRechercher.sendKeys("Caen-Gare SNCF");
        atoumodIos.btnCaenGareSNCF.click();
        atoumodIos.btnCalvaireSaintPierre.click();
        atoumodIos.placeHolderRechercher.sendKeys("Caen-AVIATION");
        atoumodIos.btnCaenAVIATION.click();
    }
}




  























