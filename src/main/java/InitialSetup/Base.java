package InitialSetup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    private WebDriver driver;
    public Properties prop;
    public WebDriver initDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\data.properties");
        prop.load(fis);
//        String browser = System.getProperty("browser");
        String browser = prop.getProperty("browser");
        if(browser.contains("chrome")){
            System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if(browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        }
        else if(browser.contains("firefox")){
            System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            if(browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new FirefoxDriver(options);
        }
        else if(browser.contains("edge")){
            System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            if(browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new EdgeDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return driver;
    }
    public String getScreenshotPath(String testname, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dst = ".\\Reports\\Screenshots\\" + testname +".png";
        FileUtils.copyFile(src, new File(dst));
        return dst;
    }
}
