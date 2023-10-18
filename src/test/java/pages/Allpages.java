package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverMobile.getDriver;


public class Allpages {

    public Allpages() {

        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

    }



    @FindBy(xpath = "//android.widget.TextView[@text='Trajet']")
    public WebElement textTrajet;

    @FindBy(xpath = "(//android.widget.TextView[@text='Adresse, arrêt gare…'])[1]")
    public WebElement placeAdresseDe;
    @FindBy(xpath = "(//android.widget.TextView[@text='Adresse, arrêt gare…'])[1]")
    public WebElement placeAdresseA;
    @FindBy(xpath = "//android.widget.TextView[@text='Autour de vous']")
    public WebElement getTextAutourDeVous;

    @FindBy(xpath = "//android.view.View[@content-desc=\"options\"]")
    public WebElement leBoutonTroisPoints;


    @FindBy(xpath = "//android.widget.Button")
    public WebElement getLeBoutonAjouterUneEtape;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement autoriserAtoumodStaning;

    @AndroidFindBy(uiAutomator = "text(\"Aller simple\")")
    public WebElement allerSimple;

    @FindBy(xpath = "//android.widget.TextView[@text='Aller-simple']")
    public WebElement textAllerSimple;
    @FindBy(xpath = "(//android.widget.Button)[4]")
    public WebElement textRetour;
    @FindBy(xpath = "//android.widget.TextView[@text='Aller-retour']")
    public WebElement textAllerRetour;


    @AndroidFindBy(uiAutomator = "text(\"Horaires des lignes\")")
    public WebElement HorairesEtPerturbations;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Retour\"]")
    public WebElement fleshRetour;

    @FindBy(xpath = "//android.widget.TextView[@text='Retour']")
    public WebElement getLeBtnCalenderirRetour;

    @FindBy(xpath = "(//android.widget.Button)[1]")
    public WebElement btnAller;


    @FindBy(xpath = "//android.widget.TextView[@text='Valider']")
    public WebElement leBtnValider;

    @FindBy(xpath = "//android.widget.TextView[@text='Retour']")
    public WebElement leBtnCalenderirRetour;

    @FindBy(className = "android.widget.EditText")
    public WebElement rechercherUneAdresse;

    @FindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement map;

    @FindBy(xpath = "//android.widget.TextView[@text='Rouen Rive-Droite']")
    public WebElement rouenRiveDroite;

    @FindBy(xpath = "//android.widget.TextView[@text='Gare de Caen']")
    public WebElement btnGareDeCaen;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Gare de Caen vers Caen-Calvaire Saint-Pierre\"]")
    public WebElement btnCaenEtSaibtnCaenEtSaintPierrentPierre;

    @FindBy(xpath = "(//android.view.View)[20]")
    public WebElement btnGareDeCaenindex;

    @FindBy(xpath = "//android.widget.TextView[@text='Caen-Calvaire Saint-Pierre']")
    public WebElement btnCalvaireStPierre;

    @FindBy(xpath = "(//android.view.View)[21]")
    public WebElement btnCalvaireStPierreIndex;



 @AndroidFindBy(uiAutomator = "text(\"voir les étapes\")")
    public WebElement btnVoirLesEtapes;

    @FindBy(xpath = "//android.widget.TextView[@text='CO2']")
    public WebElement btnCO2;

    @FindBy(xpath = "(//android.widget.Button)[3]")
    public WebElement btnCO21;


    @FindBy(xpath = "(//android.widget.Button)[2]")
    public WebElement btnCO2_2;


    @FindBy(xpath = "(//android.view.View)[11]")
    public WebElement PremierTEnCommun;


    @FindBy(xpath = "(//android.view.View)[3]")
    public WebElement getCeTrajetestSuper;

    @FindBy(xpath = "//android.widget.TextView[@text='Ce trajet est super !']")
    public WebElement getCeTrajetestSuper2;

    @FindBy(xpath = "//android.widget.TextView[@text='CO2 émis']")
    public WebElement getCO2émis;

    @FindBy(xpath = "//android.widget.TextView[@text='En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales']")
    public WebElement getEnUtilisant;


    @FindBy(xpath = "//android.widget.TextView[@text='Saint-Pierre-du-Vauvray']")
    public WebElement mairieStPierreDuVauvray;

    @FindBy(xpath = "//android.widget.TextView[@text='Gare de Caen']")
    public WebElement GaredeCaen;



    @FindBy(xpath = "//android.widget.TextView[@text='Gare de Caen']")
    public WebElement laGareCaenFavori;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Carte Google\"]")
    public WebElement carteGoogle;

    @FindBy(xpath = "//android.widget.TextView[@text='Rouen Rive-Droite']")
    public WebElement getRouenRiveDroite;

    @AndroidFindBy(uiAutomator = "text(\"Rechercher\")")
    public WebElement btnRechercher;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Intervertir le départ et l'arrivée\"]")
    public WebElement btnInverser;

    @FindBy(xpath = "//android.widget.TextView[@text='Lab Suggestions Atoumod']")
    public WebElement getTextSuggetions;

    @FindBy(xpath = "//android.widget.TextView[@text='Transport en commun']")
    public WebElement getTextTransportCommun;

    @FindBy(xpath = "//android.widget.TextView[@text='Saint-Pierre-du-Vauvray']")
    public WebElement getMairieStPierreDuVauvray;

    @FindBy(xpath = "//android.widget.TextView[@text='Gare de Lisieux']")
    public WebElement getGareDeLisieux;

    @FindBy(xpath = "(//android.widget.TextView)[11]")
    public WebElement lheureDepart;


    @FindBy(xpath = "(//android.widget.TextView)[12]")
    public WebElement lheureArrriver;

    @FindBy(xpath = "(//android.widget.TextView)[10]")
    public WebElement lheureDiffrence;

    @FindBy(xpath = "//android.widget.TextView[@text='Voiture']")
    public WebElement getTextVoiture;

    @FindBy(xpath = "//android.widget.TextView[@text='Vélo']")
    public WebElement getTextVélo;


    @FindBy(xpath = "//android.widget.TextView[@text='Voir les trajets']")
    public WebElement getTextVoirlestrajets;

    @AndroidFindBy(xpath = "(//android.widget.Button)[6]")
    public WebElement LaCroix;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Next Journey\"]")
    public WebElement getFleshSuivant;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Previous journey\"]")
    public WebElement getFleshPrecedent;


    @FindBy(xpath = "//android.widget.TextView[@text='Acheter un titre']")
    public WebElement MTicket;

    @FindBy(xpath = "//android.widget.TextView[@text='Collége Jacques Daviel']")
    public WebElement getCollégeJacquesDaviel;

    @FindBy(xpath = "//android.widget.TextView[@text='Mesnil-en-Ouche']")
    public WebElement getMesnilEnOuche;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Carte Google\"]/android.view.View[1]")
    public WebElement getCarteGoogleIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Itinéraire']")
    public WebElement getBtnItinéraire;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]")
    public WebElement getBtnItineraireBtnAller;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Autoriser']")
    public WebElement btnAutoriser;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Ouvrir l'app Atoumod M-Ticket\"]")
    public WebElement btnOuvrirApp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Je crée mon compte']")
    public WebElement btnCréerMonCompte;


    @AndroidFindBy(accessibility = "Accueil")
    public WebElement getAccueil;

    @AndroidFindBy(accessibility= "Ticketing")
    public WebElement getTicketing;

    @AndroidFindBy(accessibility="Mon compte")
    public WebElement getMenu;

    @AndroidFindBy(uiAutomator = "text(\"Paramètres\")")
    public WebElement getParametres;

    @AndroidFindBy(uiAutomator = "text(\"Bonjour !\")")
    public WebElement getTextBonjour;

    @AndroidFindBy(uiAutomator = "text(\"Paramètres et informations\")")
    public WebElement getTextParametresEtInformations;

    @AndroidFindBy(accessibility = "Retour")
    public WebElement btnRetour;

    @AndroidFindBy(uiAutomator = "text(\"Rechercher...\")")
    public WebElement getTextRechercher;

    @AndroidFindBy(xpath = "(//android.view.View)[9]")
    public  WebElement getTextRechercher1;


    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    public WebElement getMap;


    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Carte Google\"]/android.view.View[4]")
    public  WebElement iconBus;

   @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Bus\"]")
   public  WebElement iconeBus;


    @AndroidFindBy(uiAutomator = "text(\"Horaires des lignes\")")
    public WebElement getTextHoraires;

    @AndroidFindBy(uiAutomator = "text(\"De\")")
    public WebElement getDe;

    @AndroidFindBy(uiAutomator = "text(\"À\")")
    public WebElement getA;





    @AndroidFindBy(uiAutomator = "text(\"8 arrêts\")")
    public WebElement getDeparts;



    @AndroidFindBy(uiAutomator = "text(\"Voir le récapitulatif\")")
    public WebElement getVoirLeRecapitulatif;

    @AndroidFindBy(uiAutomator = "text(\"Découvrir ces services\")")
    public WebElement getDécouvrir;

    @AndroidFindBy(uiAutomator = "text(\"Voir les étapes\")")
    public WebElement btnVoirLesEtapes2;

    @AndroidFindBy(accessibility ="Tramway")
    public WebElement iconTramway;

    @AndroidFindBy(accessibility ="Métro")
    public WebElement iconMétro;

    @AndroidFindBy(accessibility ="Vélo")
    public WebElement iconVélo;

    @AndroidFindBy(uiAutomator = "text(\"Voir les trajets à vélo\")")
    public WebElement getGetTextVoirlestrajetsVélo;

    @AndroidFindBy(uiAutomator = "text(\"Sécurisé\")")
    public WebElement getSécurisé;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[8]")
    public WebElement getHeureTouslesHoraires;

    @AndroidFindBy(accessibility = "Voiture")
    public WebElement iconVoiture;

    @AndroidFindBy(uiAutomator = "text(\"Marche\")")
    public WebElement getMarche;

    @AndroidFindBy(accessibility = "Marche")
    public WebElement iconMarche;

    @AndroidFindBy(accessibility = "Train")
    public WebElement iconTrain;

    @AndroidFindBy(uiAutomator = "Gare S.N.C.F. Val-de-Reuil")
    public WebElement btnGareSNCFValDeReuil;

    @AndroidFindBy(uiAutomator = "text(\"Attendre < 1 min\")")
    public WebElement get1minAtt;

    @AndroidFindBy(uiAutomator = "text(\"CO2\")")
    public WebElement getCO2;

    @AndroidFindBy(uiAutomator = "text(\"Choisir un retour\")")
    public WebElement getChoisirUnRetour;

    @AndroidFindBy(uiAutomator = "text(\"Voir le récapitulatif\")")
    public WebElement getGetVoirLeRecapitulatif;


    @AndroidFindBy(uiAutomator = "text(\"Horaires & perturbations\")")
    public WebElement Horaires_Perturbations;


    @AndroidFindBy(uiAutomator = "text(\"Rechercher une ligne\")")
    public WebElement RechercherUneLigne;

    @AndroidFindBy(uiAutomator = "text(\"Monet  Durécu-Lavoisier\")")
    public WebElement getMonetDurécuLavoisier;
    @AndroidFindBy(uiAutomator = "text(\"Monet\")")
    public WebElement getMonet;

    @AndroidFindBy(uiAutomator = "text(\"Durécu-Lavoisier\")")
    public WebElement getDurécuLavoisier;

    @AndroidFindBy(uiAutomator = "text(\"Prochain passage\")")
    public WebElement getProchainPassage;

    @AndroidFindBy(uiAutomator = "text(\"Tous les horaires\")")
    public WebElement getTouslesHoraires;

    @AndroidFindBy(xpath = "(//android.view.View)[12]")
    public WebElement getMairieDeDarnétal;

    @AndroidFindBy(xpath = "(//android.view.View)[13]")
    public WebElement IconHandicap;

    @AndroidFindBy(xpath = "(//android.view.View)[7]")
    public WebElement getLaFléche;

    @AndroidFindBy(accessibility = "Pissarro. ")
    public  WebElement getIconTramwayPissaro;

    @AndroidFindBy(uiAutomator = "text(\"Horaires théoriques\")")
    public WebElement getHorairesThéoriques;

    @AndroidFindBy(uiAutomator = "text(\"T3\")")
    public WebElement getT3;

    @AndroidFindBy(uiAutomator = "text(\"FILTRER\")")
    public WebElement getFiltrer;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[2]")
    public WebElement getVers;

    @AndroidFindBy(uiAutomator = "text(\"Voir tout\")")
    public WebElement getVoirTout;

    @AndroidFindBy(xpath = "(//android.widget.Button)[3]")
    public WebElement getFleshButton;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    public WebElement getFleshButtonBack;

    @AndroidFindBy(uiAutomator = "text(\"Date\")")
    public WebElement getVoirDate;

    @AndroidFindBy(xpath = "(//android.widget.TextView)[5]")
    public  WebElement getVoirDateText;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    public WebElement btnGeolocation;

    @AndroidFindBy(uiAutomator = "text(\"Voir tous les horaires\")")
    public WebElement getVoirTousLesHoiraires;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    public WebElement laCroix;

    @AndroidFindBy(xpath = "(//android.view.View)[6]")
    public WebElement pointDInteret;


    @AndroidFindBy(uiAutomator = "text(\"Itinéraire\")")
    public WebElement getItineraire;

    @AndroidFindBy(uiAutomator = "text(\"Le plus rapide\")")
    public WebElement getLePlusRapide;

    @AndroidFindBy(uiAutomator = "text(\"Moins de marche\")")
    public WebElement getMoinsDeMarche;


    @AndroidFindBy(uiAutomator = "text(\"Moins de correspondances\")")
    public WebElement getMoinsDeCorrespondances;

    @AndroidFindBy(uiAutomator = "text(\"Réduite\")")
    public WebElement getReduite;
    @AndroidFindBy(uiAutomator = "text(\"Rapide\")")
    public WebElement getRapide;
    @AndroidFindBy(uiAutomator = "text(\"Normale\")")
    public WebElement getNormale;

    @AndroidFindBy(uiAutomator = "text(\"Intermédiaire\")")
    public WebElement getIntermediare;
    @AndroidFindBy(uiAutomator = "text(\"Débutant\")")
    public WebElement getDebutant;
    @AndroidFindBy(uiAutomator = "text(\"Expérimenté\")")
    public WebElement getExpérimenté;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Bus\"]")
    public WebElement getBusTransport;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Tramway\"]")
    public WebElement getTramwayTransport;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Train\"]")
    public WebElement getTrainTransport;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Métro\"]")
    public WebElement getMétroTransport;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Vélo\"]")
    public WebElement getVéloTransport;


    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Voiture\"]")
    public WebElement getVoitureTransport;

    @AndroidFindBy(accessibility = "Filtre")
    public WebElement Filtre;


















}
