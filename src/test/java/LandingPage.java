import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;
    @FindBy(xpath = "//input[@id = 'login-email']")
    private WebElement putEmailField;

    @FindBy(xpath = "//input[@id = 'login-password']")
    private WebElement putPasswordField;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Object login(String userEmail, String userPassword) {

        putEmailField.sendKeys(userEmail);
        putPasswordField.sendKeys(userPassword + Keys.ENTER);
        return driver.getCurrentUrl().contains("/feed") ? new HomePage(driver) : new LoginSubmitPage(driver);
    }
        //homePage.isPageLoaded() == true

    public boolean isPageLoaded() {
       return putEmailField.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
               && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}
