import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by julia on 15.04.2017.
 */
public class HW1 {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir")+"/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",property);
        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());

        driver.register( new EventHandler());

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement input_email = driver.findElement(By.name("email"));
        input_email.sendKeys("webinar.test@gmail.com");
        WebElement input_pass = driver.findElement(By.name("passwd"));
        input_pass.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement btn = driver.findElement(By.name("submitLogin"));
        btn.click();
        WebDriverWait wait1 = new WebDriverWait(driver,10);

        //enter the catalog
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement catalog = driver.findElement(By.id("subtab-AdminCatalog"));
        Actions builder = new Actions(driver);
        builder.moveToElement(catalog).build().perform();

        //enter the category
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("subtab-AdminCategories")));
        WebElement subcatalog = driver.findElement(By.id("subtab-AdminCategories"));
        subcatalog.click();

        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Добавить категорию']")));
        List<WebElement> arrayBeforeSort = driver.findElements(By.xpath("//i[@class='icon-caret-down']"));

        WebElement btnAdd = driver.findElement(By.xpath("//div[text()='Добавить категорию']"));
        btnAdd.click();

        //enter the text to the input
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.className("copy2friendlyUrl")));
        WebElement input = driver.findElement(By.className("copy2friendlyUrl"));
        input.sendKeys("Тест");

        //save the changes
        WebElement btnSave = driver.findElement(By.id("category_form_submit_btn"));
        btnSave.click();

        //find the save text
        WebElement msq = driver.findElement(By.xpath("//div[@class='alert alert-success']"));

        //sort
        WebElement sort = driver.findElement(By.xpath("//i[@class='icon-caret-down']"));
        sort.click();

        //find the list
        wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@class='pointer']")));
        List<WebElement> arrayAfterSort = driver.findElements(By.xpath("//i[@class='icon-caret-down']"));

        if (arrayAfterSort.size()>arrayBeforeSort.size()) {
            //find my element of list
            System.out.print("The element is found");
        }
        else
        {
            System.out.println("The element is not found");
        }
        driver.quit();
    }
}
