package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;


import utils.ConfigReader;
import utils.DriverMobile;
import utils.DriverWeb;


import java.net.MalformedURLException;

import static utils.DriverMobile.quitDriver;


public class Hooks {
    private static AppiumDriver appiumDriver;
    private static WebDriver webDriver;

    public static AppiumDriver getDriver() {
        return appiumDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    @Before("@Mobile")
    public void setUpMobile() throws MalformedURLException, InterruptedException {
        getDriver();
    }

    @Before("@webOrnikar")
    public void setUpWeb() throws InterruptedException {

    }


    @After("@smokeAndroid")
    public void tearDownMobile(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot;
            WebDriver driver = DriverMobile.getDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                screenshot = new byte[0];
            }
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        quitDriver();
    }

    @After("@web")
    public void tearDownWeb(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot;
            WebDriver driver = DriverWeb.getWebDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                screenshot = new byte[0];
            }
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        // quitWebDriver();
    }
}









