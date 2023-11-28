package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverWeb.getWebDriver;

public class SimPages {

    public SimPages() {
        PageFactory.initElements(getWebDriver(), this);

    }

    @FindBy(xpath = "//h2[normalize-space()='Horaires']")
    public WebElement btnHoraires;

    @FindBy(xpath = "//h2[normalize-space()='Itinéraire']")
    public WebElement txtHoraires;

    @FindBy(xpath = "//h2[normalize-space()='Infos trafic']")
    public WebElement txtInfos;

    @FindBy(xpath = "//h2[normalize-space()='Lignes']")
    public WebElement txtLignes;

    @FindBy(xpath = "//span[normalize-space()='Aller simple']")
    public WebElement btnAllerSimple;

    @FindBy(xpath = "//*[@id=\"is-TripType-Select-Choice-List\"]/li[2]")
    public WebElement btnAllerRetour;

    @FindBy(xpath = "//div[normalize-space()='De']")
    public WebElement txtDe;

    @FindBy(xpath = "//div[normalize-space()='À']")
    public WebElement txtÀ;

    @FindBy(xpath = "//input[@id='is-Journey-Arrival']")
    public WebElement txtÀPlace;

    @FindBy(xpath = "//div[normalize-space()='Départ']")
    public WebElement btnDépart;

    @FindBy(xpath = "(//input[@placeholder='arrêt, adresse, lieu...'])[1]")
    public WebElement placeHolderDe;

    @FindBy(xpath = "(//input[@placeholder='arrêt, adresse, lieu...'])[2]")
    public WebElement placeHolderÀ;

    @FindBy(xpath = "//label[normalize-space()='Retour']")
    public WebElement btnRetour;

    @FindBy(xpath = "//label[normalize-space()='Aller']")
    public WebElement btnAller;

    @FindBy(xpath = "//div[normalize-space()='Ma position']")
    public WebElement getMaPosition;

    @FindBy(xpath = "(//button[@class='is-Close'])[2]")
    public  WebElement getClose;

    @FindBy(xpath = "//div[normalize-space()='Gare de Caen']")
    public WebElement getGareDeCaen;

    @FindBy(xpath = "//div[normalize-space()='Chemin Vert']")
    public WebElement getCheminVert;

    @FindBy(css = "#is-Journey-Departure-ResetButton > i")
    public WebElement getLaCroixDansPlacaHolder;

    @FindBy(xpath = "//*[@id=\"is-Map\"]/div[1]/div[4]/div[2]/button")
    public WebElement getArrivée;

    @AndroidFindBy(accessibility = "Filtre")
    public WebElement getFiltre;


}







