package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static utils.DriverMobile.getDriver;



public class BasePageIos {

    public static final Logger LOG = LoggerFactory.getLogger(BasePageIos.class);

    TouchAction touchAction = new TouchAction((PerformsTouchActions) getDriver());

    private org.openqa.selenium.WebDriver driver;


    public BasePageIos() throws MalformedURLException {

    }




    /*  public void scrollFromButtomToUp(AppiumDriver<WebElement> driver) throws InterruptedException {
  
          Dimension dimension = driver.manage().window().getSize();
          int start_x = (int) (dimension.width * 0.5);
          int start_y = (int) (dimension.height * 0.8);
          int end_x = (int) (dimension.width * 0.5);
          int end_y = (int) (dimension.height * 0.5);
  
          TouchAction touch = new TouchAction(driver);
          touch.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();
          Thread.sleep(3000);
  
      }
  
  */
  /*  public void scrollFromUpToButtom(AppiumDriver<WebElement> driver) throws InterruptedException, MalformedURLException {

        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.2);
        int start_y = (int) (dimension.height * 0.2);
        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.5);

        TouchAction touch = new TouchAction(getDriver());
        touch.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();
        Thread.sleep(3000);
    }

*/
    public void scrollDown(AppiumDriver driver) throws InterruptedException {

        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.5);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();
        Thread.sleep(3000);
    }

    public void scrollHalfway(AppiumDriver driver) throws InterruptedException {

        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.5);

        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.25);

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();
        Thread.sleep(3000);
    }


    public void scrollToBottom(AppiumDriver driver) throws InterruptedException {
        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(start_x, end_y))
                .release()
                .perform();
        Thread.sleep(3000);
    }

    public static void scrollToTop(AppiumDriver driver) throws InterruptedException {
        Dimension dimension = getDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.2);
        int end_y = (int) (dimension.height * 0.8);

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(start_x, end_y))
                .release()
                .perform();

    }


    public void tapOnElement(int x, int y) throws MalformedURLException {

        String currentWindowHandle = driver.getWindowHandle();


        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        touchAction = new TouchAction((PerformsTouchActions) getDriver());
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    public int extractHours(String text) {
        String[] parts = text.split("[^\\d]");
        if (parts.length > 0) {
            return Integer.parseInt(parts[0]);
        }
        return 0;
    }


    public int extractMinutes(String text) {
        String[] parts = text.split("[^\\d]");
        if (parts.length > 1) {
            return Integer.parseInt(parts[1]);
        }
        return 0;
    }


    public void performTapActionOnPoin(int x, int y) throws MalformedURLException {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) getDriver());
        PointOption point = PointOption.point(x, y);
        touchAction.tap(point).perform();

    }


    public void performSwipe(int x, int y) throws MalformedURLException {
        Dimension dimension = getDriver().manage().window().getSize();

        int start_x = (int) (dimension.width * 0.5);
        int start_y = x;

        int end_x = (int) (dimension.width * 0.2);
        int end_y = y;

        TouchAction touch = new TouchAction((PerformsTouchActions) getDriver());
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();
    }

    public void contrôleHorlogePriview() throws MalformedURLException, InterruptedException {
        // Trouver l'élément de l'heure de départ
        List<WebElement> departureElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
        WebElement departureElement = null;
        for (WebElement element : departureElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d{2}:\\d{2}")) {
                departureElement = element;
                break;
            }
        }

        // Trouver l'élément de l'heure d'arrivée
        List<WebElement> arrivalElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
        WebElement arrivalElement = null;
        for (WebElement element : arrivalElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d{2}:\\d{2}") && !label.equals(departureElement.getAttribute("label"))) {
                arrivalElement = element;
                break;
            }
        }

// Trouver l'élément de la différence
        List<WebElement> differenceElements = getDriver().findElements(MobileBy.className("XCUIElementTypeStaticText"));
        WebElement differenceElement = null;
        for (WebElement element : differenceElements) {
            String label = element.getAttribute("label");
            if (label != null && label.matches("\\d+min") && !label.equals(departureElement.getAttribute("label")) && !label.equals(arrivalElement.getAttribute("label"))) {
                differenceElement = element;
                break;
            }
        }

        if (departureElement != null && arrivalElement != null && differenceElement != null) {
            // Obtenir la valeur de l'heure de départ
            String departureValue = departureElement.getAttribute("label");
            // Obtenir la valeur de l'heure d'arrivée
            String arrivalValue = arrivalElement.getAttribute("label");
            // Obtenir la valeur de la différence
            String differenceValue = differenceElement.getAttribute("label");

            System.out.println("Départ: " + departureValue);
            System.out.println("Arrivée: " + arrivalValue);
            System.out.println("Difference: " + differenceValue);

            // Effectuer le calcul de la différence
            String[] departureParts = departureValue.split(":");
            String[] arrivalParts = arrivalValue.split(":");
            int departureHour = Integer.parseInt(departureParts[0]);
            int departureMinute = Integer.parseInt(departureParts[1]);
            int arrivalHour = Integer.parseInt(arrivalParts[0]);
            int arrivalMinute = Integer.parseInt(arrivalParts[1]);

            int differenceHour = arrivalHour - departureHour;
            int differenceMinute = arrivalMinute - departureMinute;
            if (differenceMinute < 0) {
                differenceHour--;
                differenceMinute += 60;
            }

            System.out.println("Arrivée - Départ = " + differenceHour + "h " + differenceMinute + "min");

            // Verifier la difference
            int calculatedDifference = differenceHour * 60 + differenceMinute;
            String[] differenceParts = differenceValue.split("min");
            int actualDifference = Integer.parseInt(differenceParts[0].trim());

            if (calculatedDifference == actualDifference) {
                System.out.println("Le calcul de la différence est correct : " + calculatedDifference + " min");
            } else {
                System.out.println("Le calcul de la différence est incorrect. La valeur attendue est : " + actualDifference + " min, mais le calcul a donné : " + calculatedDifference + " min");
            }
        }
    }


    public void contrôleHorlogeTransportCommun() throws MalformedURLException, InterruptedException {


        // Trouver l'élément de l'heure de départ
        AppiumDriver driver = getDriver();


        List<WebElement> departureElements = driver.findElements(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value MATCHES '\\\\d{2}:\\\\d{2}'"));
        WebElement departureElement = departureElements.get(0); // Assumptions: there is only one departure element, and it's the first element

        // Trouver l'élément de l'heure d'arrivée
        List<WebElement> arrivalElements = driver.findElements(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value MATCHES '\\\\d{2}:\\\\d{2}' AND value != '" + departureElement.getAttribute("value") + "'"));
        WebElement arrivalElement = arrivalElements.get(0); // Assumptions: there is only one arrival element, and it's the first element

        // Trouver l'élément de la différence
        List<WebElement> differenceElements = driver.findElements(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value MATCHES '\\\\d+min' AND value != '" + departureElement.getAttribute("value") + "' AND value != '" + arrivalElement.getAttribute("value") + "'"));
        WebElement differenceElement = differenceElements.get(0); // Assumptions: there is only one difference element, and it's the first element

        if (departureElement != null && arrivalElement != null && differenceElement != null) {
            // Obtenir la valeur de l'heure de départ
            String departureValue = departureElement.getAttribute("value");
            // Obtenir la valeur de l'heure d'arrivée
            String arrivalValue = arrivalElement.getAttribute("value");
            // Obtenir la valeur de la différence
            String differenceValue = differenceElement.getAttribute("value");

            System.out.println("Départ: " + departureValue);
            System.out.println("Arrivée: " + arrivalValue);
            System.out.println("Difference: " + differenceValue);

            // Effectuer le calcul de la différence
            String[] departureParts = departureValue.split(":");
            String[] arrivalParts = arrivalValue.split(":");
            int departureHour = Integer.parseInt(departureParts[0]);
            int departureMinute = Integer.parseInt(departureParts[1]);
            int arrivalHour = Integer.parseInt(arrivalParts[0]);
            int arrivalMinute = Integer.parseInt(arrivalParts[1]);

            int differenceHour = arrivalHour - departureHour;
            int differenceMinute = arrivalMinute - departureMinute;
            if (differenceMinute < 0) {
                differenceHour--;
                differenceMinute += 60;
            }

            // Vérifier la différence
            int calculatedDifference = differenceHour * 60 + differenceMinute;
            String[] differenceParts = differenceValue.split("min");
            int actualDifference = Integer.parseInt(differenceParts[0].trim());

            if (calculatedDifference == actualDifference) {
                System.out.println("Le calcul de la différence est correct : " + calculatedDifference + " min");
            } else {
                System.out.println("Le calcul de la différence est incorrect. La valeur attendue est : " + actualDifference + " min, mais le calcul a donné : " + calculatedDifference + " min");
            }
        } else {
            System.out.println("Départ, Arrivée ou Difference pas trouvée.");
        }

    }



    private static int calculateOffsetForUpAndDownScroll(int scrollAmount) {
        Dimension dimension = getDriver().manage().window().getSize();
        return ((scrollAmount * dimension.height) / 100);
    }

    public static void scrollUp(WebElement element, int scrollPercentage) {
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(element)
                .moveByOffset(0, (calculateOffsetForUpAndDownScroll(scrollPercentage)))
                .release()
                .perform();

    }
}