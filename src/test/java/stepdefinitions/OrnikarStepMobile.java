package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePageAndroid;
import pages.OrnikarPage;

import static utils.DriverMobile.getDriver;

public class OrnikarStepMobile  extends BasePageAndroid {
    OrnikarPage ornikarPage = new OrnikarPage();



    @Given("L'utilisateur accède à la page daccueil dOrnikar")
    public void lUtilisateurAccèdeÀLaPageDaccueilDOrnikar() {
        getDriver();
        OrnikarPage.btnAccepterCookies.click();
        OrnikarPage.btnDejaCompte.click();

    }


    @When("Se connecte à mon compte")
    public void seConnecteÀMonCompte() throws InterruptedException {
        System.out.println();
        OrnikarPage.btnEmail.sendKeys("fildisili88@gmail.com");
        OrnikarPage.btnMotDePasse.sendKeys("Xgc88343....");

        OrnikarPage.btnConnecte.click();
    }

    @Then("Confirmer que la connexion a réussi")
    public void confirmerQueLaConnexionARéussi() {
        Assert.assertTrue(OrnikarPage.btnAccueil.isDisplayed());
        System.out.println(OrnikarPage.btnAccueil.getText());
    }


    @When("Passer l'ongle {string}")
    public void passerLOngle(String arg0) throws InterruptedException {
        OrnikarPage.btnAccueil.click();
        OrnikarPage.btnFermerVideo.click();

    }








    @Then("Cliquer le bouton {string}")
    public void cliquerLeBouton(String arg0) throws InterruptedException {

    }










    @Then("Sélectionne le type de permis que je souhaite obtenir")
    public void sélectionneLeTypeDePermisQueJeSouhaiteObtenir() {
    }

    @When("S'inscrire au cours choisi")
    public void sInscrireAuCoursChoisi() {
    }

    @Then("Rediriger vers la page de paiement")
    public void redirigerVersLaPageDePaiement() {
    }

    @And("Confirmer qu'il a été redirigé vers la page de paiement")
    public void confirmerQuIlAÉtéRedirigéVersLaPageDePaiement() {
    }

    @When("Entrer mes informations de paiement et choisir ma méthode de paiement préférée")
    public void entrerMesInformationsDePaiementEtChoisirMaMéthodeDePaiementPréférée() {
    }

    @Then("S'assurer que le paiement a été effectué avec succès")
    public void sAssurerQueLePaiementAÉtéEffectuéAvecSuccès() {
    }

    @And("Confirmer qu{string}affiche")
    public void confirmerQuUnMessageDeConfirmationSAffiche() {
    }



}
