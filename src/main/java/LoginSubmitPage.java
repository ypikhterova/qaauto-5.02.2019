import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {

    private WebDriver driver;
    public WebElement wrongEmailMessage;
    public WebElement invalidPasswordMessage;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        wrongEmailMessage = driver.findElement(By.xpath("//div[@id=\"error-for-username\"]"));
        invalidPasswordMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));

    }



}
