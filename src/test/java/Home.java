import InitialSetup.Base;
import ObjectRepository.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;

public class Home extends Base {
    public WebDriver driver;
    HomePage hp;
    private static Logger log = LogManager.getLogger(Login.class.getName());
    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        log.info("Initialized Driver.");
    }
    @Test
    public void VerifyHeader(){
        log.debug("Verifying Header Title within page.");
        Assert.assertEquals(hp.headerTtl().getText(), "FEATURED COURSES");
        log.info("Header Title verified.");
        log.debug("Checking if navbar is displayed.");
        Assert.assertTrue(hp.navBar().isDisplayed());
        log.info("Navbar is available.");
        //TestingGIT - John Thomas
        //TestingGIT - Francis Xavier
        //Under Maintainance
        //Sucky on my dicky like a little bitchy
    }
    @Test
    public void VerifyBanner() throws InterruptedException {
        log.debug("Opening URl");
        driver.get(prop.getProperty("url"));
        log.info("URL opened successfully.");
        hp = new HomePage(driver);
        log.info("HomePage object created.");
        Thread.sleep(5000);
        Assert.assertEquals(hp.bannerTtl().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
    }
    @AfterTest
    public void close(){
        log.debug("Driver quit started.");
        driver.quit();
        log.info("Driver has been quit.");
    }
}
