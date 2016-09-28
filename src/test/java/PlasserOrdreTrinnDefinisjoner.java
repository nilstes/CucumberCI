
import cucumber.api.PendingException;
import cucumber.api.java.da.Når;
import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Så;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author nilstes
 */
public class PlasserOrdreTrinnDefinisjoner {
    
    private WebDriver driver = new HtmlUnitDriver();
    
    @Gitt("^at en bruker putter (\\d+) varer i handlekurven$")
    public void at_en_bruker_putter_varer_i_handlekurven(int arg1) throws Throwable {
        driver.get("http://localhost:8080/cuke"); 
       
        Thread.sleep(2000); // Disse bruker vi kun for å kunne observere testen 
        WebElement element = driver.findElement(By.id("add-item")); 
        element.click(); 
        Thread.sleep(1000); 
        element = driver.findElement(By.id("go-to-cart")); 
        element.click();
    }

    @Når("^brukeren trykker på bestill-knappen$")
    public void brukeren_trykker_på_bestill_knappen() throws Throwable {
        Thread.sleep(2000); 
        WebElement element = driver.findElement(By.id("place-order"));
        element.click();   
    }

    @Så("^skal det opprettes en ordre$")
    public void skal_det_opprettes_en_ordre() throws Throwable {
        Thread.sleep(2000); 
        assert(driver.findElement(By.id("order-confirmation")) != null);    
    }

    @Så("^ordren skal legges til i ordrehistorikken$")
    public void ordren_skal_legges_til_i_ordrehistorikken() throws Throwable {
        WebElement element = driver.findElement(By.id("view-history")); 
        element.click(); 
        assert(driver.findElement(By.xpath("//li[contains(text(), \"Ordre 3\")]")) != null); 
        Thread.sleep(2000); 
        driver.close();
    }
}
