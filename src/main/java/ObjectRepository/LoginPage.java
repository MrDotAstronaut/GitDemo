package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user_email")
    private WebElement email;
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(css = ".btn")
    private WebElement submit;
    @FindBy(css = ".link-below-button")
    private WebElement fgtpwd;
    public WebElement emailFld(){
        return email;
    }
    public WebElement passwordFld(){
        return password;
    }
    public WebElement submitBtn(){
        return submit;
    }
    public ResetPwd fgtpwdBtn(){
        fgtpwd.click();
        return new ResetPwd(driver);
    }
}
