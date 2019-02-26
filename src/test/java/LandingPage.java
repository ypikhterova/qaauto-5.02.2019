import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    private WebElement putEmailField;
    private WebElement putPasswordField;
//class constructor
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        putEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        putPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
    }


    public void login(String userEmail, String userPassword) {
        putEmailField.sendKeys(userEmail);
        putPasswordField.sendKeys(userPassword + Keys.ENTER);
    }

    public boolean isPageLoaded() {
       return putEmailField.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
               && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }
}
