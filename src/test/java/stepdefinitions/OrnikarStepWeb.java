package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.OrnikarPage;
import pages.OrnikarWebPage;
import utils.ConfigReader;

import static utils.DriverMobile.getDriver;
import static utils.DriverWeb.getWebDriver;

public class OrnikarStepWeb {
    OrnikarWebPage ornikarWebPage=new OrnikarWebPage();




    @Given("l'utilisateur est connecté à Ornikar")
    public void lUtilisateurEstConnectéÀOrnikar() {
        getWebDriver().get(ConfigReader.getProperty("ornikarUrl"));
    }

    @When("l'utilisateur se trouve sur la page daccueil")
    public void lUtilisateurSeTrouveSurLaPageDaccueil() {
    }

    @Given("Cliquer sur Assurance Auto")
    public void cliquerSurAssuranceAuto() {

    }



}
