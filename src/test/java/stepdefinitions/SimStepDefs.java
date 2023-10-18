package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.SimPages;
import utils.ConfigReader;


import static org.junit.Assert.assertTrue;
import static utils.DriverSim.getWebDriver;
import static utils.ReusableMethods.sleep;
import static utils.ReusableMethods.waitForVisibility;


public class SimStepDefs {

    SimPages sim = new SimPages();
    Actions actions = new Actions(getWebDriver());


    @Given("Aller sur le site Atoumod")
    public void allerSurLeSiteAtoumod() throws InterruptedException {
        //options.addArguments("--headless");
        getWebDriver().get(ConfigReader.getProperty("urlSIM"));
        Thread.sleep(3000);


    }


    @When("Afficher la page d'accueil du SIM")
    public void afficherLaPageDAccueilDuSIM() throws InterruptedException {
        Thread.sleep(3000);

        String[][] expectedTexts = {
                {sim.txtHoraires.getText(), "Itinéraire"},
                {sim.btnHoraires.getText(), "Horaires"},
                {sim.txtInfos.getText(), "Infos trafic"},
                {sim.txtLignes.getText(), "Lignes"},
                {sim.btnAllerSimple.getText(), "Aller simple"},
                {sim.txtDe.getText(), "De"},
                {sim.txtÀ.getText(), "À"},
                {sim.btnDépart.getText(), "Départ"},
                {sim.placeHolderDe.getText(), "arrêt, adresse, lieu..."},
                {sim.placeHolderÀ.getText(), "arrêt, adresse, lieu..."}


        };

        for (String[] expectedText : expectedTexts) {
            String actualText = expectedText[0];
            if (actualText.contains(expectedText[1])) {
                System.out.println("Vérification réussie : " + actualText + " contient le texte attendu");
            } else {
                System.out.println("Vérification échouée : " + actualText + " ne contient pas le texte attendu");
            }
        }

    }

    @And("Vérifier la présence du widget RI")
    public void vérifierLaPrésenceDuWidgetRI() throws InterruptedException {
        sim.btnAllerSimple.click();

        Thread.sleep(2000);

        if (sim.btnAllerRetour.isEnabled()) {

            String expectedTextAllerRetour = "Aller-retour";

            assertTrue(sim.btnAllerRetour.getText().contains(expectedTextAllerRetour));

            System.out.println(sim.btnAllerRetour.getText());

            sim.btnAllerRetour.click();
        }


        assertTrue(sim.btnAller.getText().contains("Aller"));

        assertTrue(sim.btnRetour.getText().contains("Retour"));


    }

    @When("Cliquer sur la combobox et choisir Aller simple")
    public void cliquerSurLaComboboxEtChoisirAllerSimple() {
        sim.btnAllerSimple.click();

        assertTrue(sim.btnAllerRetour.isEnabled());

    }


    @And("Choisir une origine")
    public void choisirUneOrigine() throws InterruptedException {
        sim.btnAllerSimple.click();
        //Cliquer sur le champ origine correspondant au "De" et taper une adresse pour ensuite la sélectionner.

        sim.txtDe.click();

        sim.placeHolderDe.sendKeys("Gare de Caen");

        sim.getLaCroixDansPlacaHolder.click();
        //

        sim.placeHolderDe.click();

        // L'utilisateur peut aussi cliquer sur "Ma position" si sa géolocalisation est activée ou visualiser ses recherches récentes

        sim.getMaPosition.click();
        getWebDriver().navigate().refresh();


    }

    @And("Choisir une destination Sim")
    public void choisirUneDestinationSim() throws InterruptedException {


        sim.placeHolderDe.sendKeys("Gare de Caen");
        sim.getGareDeCaen.click();
        sim.txtÀPlace.sendKeys("Chemin Vert");
        sim.getCheminVert.click();
        Thread.sleep(2000);
        assertTrue(sim.getArrivée.getText().contains("arrivéé"));

    }
}