import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by julia on 15.04.2017.
 */
public class EventHandler implements WebDriverEventListener{

    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
System.out.println("Trying to navigate to the site");
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Succesfull navigate to" + webDriver.getTitle());
    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
System.out.println("looking for an element: "+by);
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
System.out.println("found element: " + by);
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
System.out.println("Should click " + webElement.getText());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Clicked successfull");
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {

    }
}
