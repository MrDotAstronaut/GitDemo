import InitialSetup.Base;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ResetPwd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;

public class Login extends Base {
    public WebDriver driver;
    private static Logger log = LogManager.getLogger(Login.class.getName());
    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "jonax4@yahoo.com";
        data[0][1] = "Abcd1234";
        data[1][0] = "laduu@yahoo.com";
        data[1][1] = "1234Abcd";
        return data;
    }
    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        log.info("Initialized Driver.");
    }
    @Test(dataProvider = "getData")
    public void Demo1(String email, String password) throws IOException, InterruptedException {
        log.debug("Opening URl");
        driver.get(prop.getProperty("url"));
        log.info("URL opened successfully.");
        HomePage hp = new HomePage(driver);
        log.debug("Clicking on login button.");
        LoginPage lp = hp.loginBtn();
        log.info("Successfully navigated to login page.");
        log.debug("Inputting email.");
        lp.emailFld().sendKeys(email);
        log.info("Email has been inputted.");
        log.debug("Inputting password.");
        lp.passwordFld().sendKeys(password);
        log.debug("Password has been inputted.");
        log.debug("Clicking on the submit button.");
        lp.submitBtn().click();
        log.info("Submitted successfully.");
        ResetPwd rp = lp.fgtpwdBtn();
        log.debug("Inputting email.");
        rp.emailfgtFld().sendKeys("jonax4@yahoo..com");
        log.info("Email has been inputted.");
        log.debug("Inputting password.");
        rp.submitfgtBtn().click();
        log.info("Password has been inputted.");
    }
    @AfterTest
    public void close(){
        log.debug("Driver quit started.");
        driver.quit();
        log.info("Driver has been quit.");
    }
}
