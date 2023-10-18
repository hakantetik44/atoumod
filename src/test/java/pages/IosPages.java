package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.time.Duration;

import static utils.DriverMobile.getDriver;


public class IosPages  {
    public IosPages() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(25)), this);
    }



    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Autoriser lorsque l’app est active\"]")
    public WebElement autotiser;

    @iOSXCUITFindBy(accessibility = "autoriserAppActiveButton")
    public WebElement autoriserButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Autoriser une fois'")
    public WebElement autoriserButton1;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Trajet\"]")
    public WebElement getTextTrajet;


    @iOSXCUITFindBy(iOSNsPredicate = "label == \"options\" AND name == \"options\" AND type == \"XCUIElementTypeImage\"")
    public WebElement troisPoints;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"De, Adresse, arrêt, gare...\"]")
    public WebElement deSearch;

    @iOSXCUITFindBy(accessibility = "Barre de défilement horizontale, 1 page")
    public WebElement getTextTrajetAccesPmr;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Autour de vous\"`]")
    public WebElement getTextAtourDeVous;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"AnnotationContainer\"])[2]")
    public WebElement map;
    @iOSXCUITFindBy(accessibility = "MapView")
    public WebElement mapView;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"AnnotationContainer\"`][2]")
    public WebElement mapView2;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Rouen\"`][2]")
    public WebElement btnRouen;


    @iOSXCUITFindBy(accessibility = "Rechercher...")
    public WebElement placeHolderRechercher;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Rechercher...\"]")
    public WebElement getPlaceHolderRechercher;

    @iOSXCUITFindBy(accessibility = "Caen-CITE U LEBISEY")
    public WebElement getCaenCiteULebisey;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Repère sur la carte\"]")
    public WebElement getGr;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Itinéraire\" AND name == \"Itinéraire\" AND value == \"Itinéraire\"")
    public WebElement btnItinéraire;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Itinéraire\"]")
    public  WebElement getBtnItinéraire;

    @iOSXCUITFindBy(accessibility = "Ajouter une étape")
    public WebElement btnAjouterUneEtape;

    @iOSXCUITFindBy(accessibility = "Via, Adresse, arrêt, gare...")
    public WebElement placeAjouterUneEtape;

    @iOSXCUITFindBy(accessibility = "ST SAMSON: route de rouen")
    public WebElement getStSamsonRouteDeRouen;

    @iOSXCUITFindBy(accessibility = "Fermer")
    public WebElement laCroix;

    @iOSXCUITFindBy(accessibility = "De, Adresse, arrêt, gare...")
    public WebElement placeDe;

    @iOSXCUITFindBy(accessibility = "À, Adresse, arrêt, gare...")
    public WebElement placeA;


    @iOSXCUITFindBy(accessibility = "Rechercher")
    public WebElement btnRechercher;

    @iOSXCUITFindBy(accessibility = "Aller simple")
    public WebElement btnAllerSimple;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Aller simple\"])[2]")
    public WebElement allerSimpleChoix;

    @iOSXCUITFindBy(accessibility = "Aller-retour")
    public WebElement btnAllerRetour;


    @iOSXCUITFindBy(accessibility = "Acheter un titre")
    public WebElement acheterUnTitre;



    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"AnnotationContainer\"])[2]")
    public WebElement btnOuvrirLapp;

    @iOSXCUITFindBy(accessibility = "Ouvrir l'app")
    public WebElement btnOuvrir;


    @iOSXCUITFindBy(accessibility = "Sélectionnez un réseau afin d'afficher les")
    public WebElement SélectionnezUnRéseau ;

    @iOSXCUITFindBy(accessibility = "Sélectionnez votre réseau")
    public WebElement btnSelectionnez;

    @iOSXCUITFindBy(accessibility = "Gare de Caen")
    public WebElement btnGareDeCaen;

    @iOSXCUITFindBy(accessibility = "Gare de Carenten")
    public WebElement getLeGareCarenten;

    @iOSXCUITFindBy(accessibility = "Caen-Calvaire Saint-Pierre")
    public WebElement btnCalvaireSaintPierre;

    @iOSXCUITFindBy(accessibility = "Départ")
    public WebElement getDepartCalenderir;

    @iOSXCUITFindBy(accessibility = "Valider")
    public WebElement getBtnValider;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[38]")
    public WebElement getHeure;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[23]")
    public WebElement getMinute;

    @iOSXCUITFindBy(accessibility = "AUTOCAR")
    public WebElement getAutoCar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[12]")
    public WebElement lheureDifference;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[13]")
    public WebElement lheureDepart;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[14]")
    public WebElement lheureArrive;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[8])[1]")
    public WebElement lheureArrive2;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[15]")
    public WebElement lheureDepart2;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[14]")
    public WebElement lheureDifference2;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[6]")
    public WebElement PremierTEnCommun;

    @iOSXCUITFindBy(accessibility = "Retour")
    public WebElement btnRetour;

    @iOSXCUITFindBy(accessibility = "Suivant")
    public WebElement btnSuivant;


    @iOSXCUITFindBy(accessibility = "Transport en commun")
    public WebElement textTransportEnCommun;

    @iOSXCUITFindBy(accessibility = "Départ")
    public WebElement textDepart;

    @iOSXCUITFindBy(accessibility = "Choisir un aller")
    public WebElement textChoisirUnAller;

    @iOSXCUITFindBy(accessibility = "Précédent")
    public WebElement btnPrécédent;

    @iOSXCUITFindBy(accessibility = "Caen-Gare SNCF")
    public WebElement btnCaenGareSNCF;

    @iOSXCUITFindBy(accessibility = "Gare SNCF")
    public WebElement btnGareSNCF;

    @iOSXCUITFindBy(accessibility = "Réinitialiser")
    public WebElement btnRéinitialiser;

    @iOSXCUITFindBy(accessibility = "Caen-AVIATION")
    public WebElement btnCaenAVIATION;

    @iOSXCUITFindBy(accessibility = "Horaires des lignes")
    public WebElement btnHorairesDesLignes;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Horaires & perturbations\"`]")
    public WebElement getTexthorairesPerturbations;


    @iOSXCUITFindBy(accessibility = "Récents")
    public WebElement getTextRecents;

    @iOSXCUITFindBy(accessibility = "location_fill")
    public WebElement btnMaposition;

    @iOSXCUITFindBy(accessibility = "De, Ma position")
    public WebElement btnDeMaPosition;

    @iOSXCUITFindBy(accessibility = "À, Caen-Calvaire Saint-Pierre")
    public WebElement textACaenCalvaireSaintPierre;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@label='CO²'])[1]")
    public WebElement btnCO2_1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"voir les étapes\"]")
    public WebElement btnVoirLesÉtapes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Voir les étapes\"]")
    public WebElement btnvoirLesÉtapes;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"CO²\"`][8]")
    public WebElement getBtnCO2_2vle;

    @iOSXCUITFindBy(accessibility = "Voir le récapitulatif")
    public WebElement getVoirLeRécapitulatif;

    @iOSXCUITFindBy(accessibility = "Ce trajet est super !")
    public WebElement getCeTrajetestSuper;

    @iOSXCUITFindBy(accessibility = "CO² émis")
    public WebElement getCO2émis;

    @iOSXCUITFindBy(accessibility = "-94,01 % CO²")
    public WebElement getCO2émis1;

    @iOSXCUITFindBy(accessibility = "・soit 49 g co² sur ce trajet")
    public WebElement getCO2émis2;

    @iOSXCUITFindBy(accessibility = "・et 818 g co² pour le même trajet en voiture")
    public WebElement getCO2émis3;

    @iOSXCUITFindBy(accessibility = "En utilisant quotidiennement de nouvelles solutions pour vos déplacements votre démarche durable permet de réduire les émissions globales")

    public WebElement getEnUtilisant;

    @iOSXCUITFindBy(accessibility = "CO²")
    public WebElement btnCO_2;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"CO²\"])[6]")
    public WebElement btnCO_2Vélo;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"CO²\"])[10]")
    public WebElement btnCO_2Vélo2;



    @iOSXCUITFindBy(accessibility = "Voir le récapitulatif")
    public WebElement btnVoirLeRecupitulatif;

    @iOSXCUITFindBy(accessibility = "Calvaire Saint-Pierre")
    public WebElement getCalvaireSaintPierre;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Récapitulatif\"]")
    public WebElement getRécapitulatif;


    @iOSXCUITFindBy(xpath = "/XCUIElementTypeButton[contains(@name, 'T1')]")
    public WebElement getT1Button;

    @iOSXCUITFindBy(accessibility = "Caen-Calvaire Saint-Pierre")
    public WebElement btnCaencAENStPierre;

    @iOSXCUITFindBy(accessibility = "Gare de Caen - Caen-Calvaire Saint-Pierre")
    public WebElement btnCaenCalvaireSaintPierre;


    @iOSXCUITFindBy(accessibility = "Arrivée à")
    public WebElement getArrivéeà;

    @iOSXCUITFindBy(accessibility = "Départ à")
    public WebElement getDépartà;


    @iOSXCUITFindBy(accessibility = "8 arrêts")
    public WebElement get8arrêts;

    @iOSXCUITFindBy(accessibility = "Quai de Juillet, Résistance Saint-Jean, Bernières, Saint-Pierre, Château Quatrans, Place de la Mare, Université, CROUS-SUAPS, 16min")
    public WebElement text8arrêts;


    @iOSXCUITFindBy(accessibility = "Marcher m")
    public WebElement getMarcher;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name, \"Marcher\")]")
    public WebElement getMarcherKm;

    @iOSXCUITFindBy(accessibility = "Vélo")
    public WebElement getVélo;

    @iOSXCUITFindBy(accessibility = "Voir les trajets à vélo")
    public WebElement getTrajetVélo;

    @iOSXCUITFindBy(accessibility = "Sécurisé")
    public WebElement getSécurisé;


    @iOSXCUITFindBy(accessibility = "Le plus rapide")
    public WebElement getLePlusRapide;

    @iOSXCUITFindBy(accessibility= "mode_bike")
    public WebElement getModeBike;

    @iOSXCUITFindBy(accessibility = "Aménagement des voies")
    public WebElement getAménagement;


    @iOSXCUITFindBy(accessibility = "Voiture")
    public WebElement btnVoiture;


    @iOSXCUITFindBy(accessibility = "mode_car")
    public WebElement btnModeCar;

    @iOSXCUITFindBy(accessibility = "Véhicule personnel")
    public WebElement getVehiculePersonnel;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    public WebElement getBack;

    @iOSXCUITFindBy(accessibility = "Marche")
    public WebElement getMarche;

    @iOSXCUITFindBy(accessibility = "mode_walk")
    public WebElement btnModeWalk;

    @iOSXCUITFindBy(accessibility = "Gare de Rouen Rive Droite")
    public WebElement btnGareDeRouenRiveDroite;

    @iOSXCUITFindBy(accessibility = "back")
    public WebElement back;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
    public WebElement fleshGo;


    @iOSXCUITFindBy(accessibility = "Aller")
    public WebElement btnAller;

    @iOSXCUITFindBy(accessibility = "Retour")
    public WebElement textRetour;

    @iOSXCUITFindBy(accessibility = "De")
    public WebElement textDe;

    @iOSXCUITFindBy(accessibility = "À")
    public WebElement textÀ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Atoumod QA\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]")
    public WebElement IconAccueil;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Atoumod QA\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    public WebElement IconTitre;

    @iOSXCUITFindBy(accessibility = "tab_menu")
    public WebElement IconParametres;


    @iOSXCUITFindBy(accessibility = "Horaires des lignes")
    public WebElement getBtnHorairesDesLignes;






    @iOSXCUITFindBy(accessibility = "Choisir le retour")
    public WebElement btnChoisirLeRetour;



    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Choisir un retour\"]")
    public WebElement btnChoisirUnRetour;


    @iOSXCUITFindBy(accessibility = "Rouen Saint-Sever")
    public WebElement RouenSaintSever;

    @iOSXCUITFindBy(accessibility = "À, Rouen Saint-Sever, Rouen")
    public WebElement ARouenSaintSever;

    @iOSXCUITFindBy(accessibility = "Découvrir")
    public WebElement btnDécouvrir;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Rechercher une ligne\"")
    public WebElement getBtnRechercherUneLigne;

    @iOSXCUITFindBy(accessibility = "Rechercher")
    public WebElement iconeRechercher;

    @iOSXCUITFindBy(accessibility = "T3")
    public WebElement getBtnT3;

    @iOSXCUITFindBy(accessibility = "3")
    public WebElement btn3;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"T3\"`][2]")
    public WebElement btnT3;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Monet  Durécu-Lavoisier\"])[2]")
    public WebElement getMonet;

    @iOSXCUITFindBy(accessibility = "Vers")
    public WebElement getVers;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Monet\"]")
    public WebElement btnMonet;

    @iOSXCUITFindBy(accessibility = "Descendre")

    public WebElement btnDescendre;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Durécu-Lavoisier\"])[2]")
    public WebElement btnDurécuLavoisier;


    @iOSXCUITFindBy(accessibility= "Durécu-Lavoisier")
    public WebElement getDurécuLavoisier;


    @iOSXCUITFindBy(accessibility = "Tous les horaires")
    public WebElement getTousLesHoraires;
    @iOSXCUITFindBy(accessibility = "Prochain passage")
    public WebElement btnProchainPassage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[18]")
    public WebElement btnLheurePassage;

    @iOSXCUITFindBy(accessibility = "FILTRER")
    public WebElement btnFiltr;

    @iOSXCUITFindBy(accessibility = "Prochains passages")
    public WebElement btnProchainesPassages;

    @iOSXCUITFindBy(accessibility = "Voir tout")
    public WebElement btnVoirTout;

    @iOSXCUITFindBy(accessibility = "Date")
    public WebElement btnDate;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[22]")
    public WebElement getBtnHorairesDate;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"mode_tramway\"])[2]")
    public WebElement iconeTramway;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Repère sur la carte\"`][6]")
    public WebElement iconeBus;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Monet\"])[2]")
    public WebElement btngetMonet;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Vers\"])[2]")
    public WebElement btnGetVers;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Ma position\"])[4]")
    public WebElement btnGetMaPosition;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"location_outline\"")
    public WebElement  getMaPosition;

    @iOSXCUITFindBy(accessibility = "Repère sur la carte")
    public WebElement getReperesurLaCarte;

    @iOSXCUITFindBy(accessibility = "Gare de Le Havre")
    public WebElement getGaredeLeHavre;

    @iOSXCUITFindBy(accessibility = "clear")
    public WebElement btnClear;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ma position\"]")
    public WebElement getBtnMapositionAutour;

    @iOSXCUITFindBy(accessibility = "Retrouvez vos titres de transport sur l'app dédiée Atoumod M-ticket")
    public WebElement getRetrouvezVosTitres;

    @iOSXCUITFindBy(accessibility = "Acheter vos titres")

    public WebElement getAcheterVosTitres;


    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[@name=\"Paramètres\"]")

    public WebElement getParametres;


    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Paramètres et informations\"")
    public WebElement getParametresEtInformations;

    @iOSXCUITFindBy(accessibility = "Pages légales")
    public WebElement getPagesLégales;


    @iOSXCUITFindBy(accessibility = "Version: 0.2.0")
    public WebElement getVersion;









}









