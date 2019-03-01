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


    public <T> T login (String userEmail, String userPassword, Class <T> expectedPage){
        putEmailField.sendKeys(userEmail);
        putPasswordField.sendKeys(userPassword + Keys.ENTER);
        return PageFactory.initElements(driver, expectedPage);
    }

    public <T> T login (String userEmail, String userPassword){
        putEmailField.sendKeys(userEmail);
        putPasswordField.sendKeys(userPassword + Keys.ENTER);
        if (driver.getCurrentUrl().contains("/feed")) {
            return (T) new HomePage(driver);
                    //PageFactory.initElements(driver, HomePage.class);
        } else {return (T) new LoginSubmitPage(driver);}
    }


    public Object login2(String userEmail, String userPassword) {

        putEmailField.sendKeys(userEmail);
        putPasswordField.sendKeys(userPassword + Keys.ENTER);
        return driver.getCurrentUrl().contains("/feed") ? new HomePage(driver) : new LoginSubmitPage(driver);
    }

    public boolean isPageLoaded() {
       return putEmailField.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
               && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}
