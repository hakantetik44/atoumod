package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverMobile.getDriver;

public class OrnikarWebPage {
    public OrnikarWebPage(){

        PageFactory.initElements(getDriver(),this);
    }


    @FindBy(xpath = "//button[@id='assuranceAutoButton']")
    public WebElement assuranceAutoButton;


}