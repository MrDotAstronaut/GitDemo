package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Login")
    private WebElement login;
    @FindBy(linkText = "Register")
    private WebElement register;
    @FindBy(css = "div[class='text-center'] h2")
    private WebElement header;
    @FindBy(css = ".nav")
    private WebElement nav;
    @FindBy(xpath = "//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']//h3")
    private WebElement banner;
    public LoginPage loginBtn() {
        login.click();
        LoginPage lp = new LoginPage(driver);
        return lp;
    }
    public WebElement registerBtn() {
        return register;
    }
    public WebElement headerTtl(){
        return header;
    }
    public WebElement navBar(){
        return nav;
    }
    public WebElement bannerTtl(){
        return banner;
    }
}
