import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSubmitPage {

    private WebDriver driver;

    @FindBy (xpath = "//div[@id=\"error-for-username\"]")
    private WebElement getUserEmailValidationText;

    @FindBy(xpath = "//div[@id='error-for-password']")
    private WebElement getUserPasswordValidationText;

    @FindBy(xpath = "//form[@class='login__form']")
    private WebElement loginForm;

    public boolean  isPageLoaded(){return loginForm.isDisplayed()
            && driver.getCurrentUrl().contains("/login-submit")
            && driver.getTitle().contains("Sign In to LinkedIn")
            ;}


    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



   public String getUserEmailValidationText() {return getUserEmailValidationText.getText();}
   public String getUserPasswordValidationText() {return getUserPasswordValidationText.getText() ;}
}
