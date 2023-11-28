package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;



public class DriverWeb {
    private static WebDriver driver;
    private DriverWeb() {
        // Private constructor to prevent instantiation from outside
    }
    public static WebDriver getWebDriver() {
        if (driver == null) {
            String desiredBrowser = ConfigReader.getProperty("browser");
            switch (desiredBrowser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "headless-chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}