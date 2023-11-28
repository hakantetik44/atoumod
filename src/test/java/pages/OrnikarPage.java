package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverMobile.getDriver;

public class OrnikarPage {
    public OrnikarPage(){
        PageFactory.initElements(getDriver(),this);

    }

    @FindBy(xpath = "//android.widget.Button[@text='Accepter les cookies']")
    public static WebElement btnAccepterCookies;

    @FindBy(xpath = "//android.widget.TextView[@text=\"J'ai déjà un compte\"]\n")
    public static WebElement btnDejaCompte;

    @FindBy(xpath = "(//android.widget.EditText[@package='com.ornikar.learning'])[1]")
    public static WebElement btnEmail;

    @FindBy(xpath = "(//android.widget.EditText[@package='com.ornikar.learning'])[2]")
    public static WebElement btnMotDePasse;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Je me connecte\"]")
    public static WebElement btnConnecte;

    @FindBy(xpath = "//android.widget.FrameLayout[@package='com.ornikar.learning']")
    public static WebElement textReactivezVotreAbonnement;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Accueil\"]")
    public static WebElement btnAccueil;

    @FindBy(xpath = "(//android.widget.Button[@package='com.ornikar.learning'])[3]")
    public static WebElement btnFermerVideo;

    @FindBy(xpath = "//android.widget.Button[@text='Découvrir']")
    public static WebElement btnDecouvrir;
    //ya da boyle yaz ?
    //   @AndroidFindBy(uiAutomator = "text(\"Découvrir\")")
    //   public WebElement btnDécouvrir;


    @FindBy(xpath = "//android.widget.TextView[@text='Préparer mon examen du code']")
    public static WebElement textMesRevisions;









}
