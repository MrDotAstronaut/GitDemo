package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPwd {
    private WebDriver driver;
    public ResetPwd(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "user_email")
    private WebElement emailfgt;
    @FindBy (xpath = "//input[@name='commit']")
    private WebElement submitfgt;
    public WebElement emailfgtFld(){
        return emailfgt;
    }
    public WebElement submitfgtBtn(){
        return submitfgt;
    }
}
