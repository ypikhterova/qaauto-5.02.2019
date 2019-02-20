import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod


    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pikhterova_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @Test(priority = 1)
    public void successfulLoginTests() throws InterruptedException {///appeared after  Thread.sleep(1000);


        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("vvizbor5@gmail.com", "TYpochek5_");

        Thread.sleep(1000);

        HomePage homePage = new HomePage(driver);


    }

    @Test(priority = 2)
    public void LoginWrongEmail() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("vvizbor51@gmail.com", "TYpochek5_");


        Thread.sleep(1000);


        WebElement wrongEmailMessage = driver.findElement(By.xpath("//div[@id=\"error-for-username\"]"));


        Assert.assertEquals(wrongEmailMessage.getText(), "Hmm, we don't recognize that email. Please try again.", "Wrong validation message text for incorrect email");

    }

    @Test(priority = 3)
    public void LoginInvalidEmail() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("vvizbor5gmail.com", "TYpochek5_");

        Thread.sleep(1000);


        WebElement invalidEmailMessage = driver.findElement(By.xpath("//div[@id=\"error-for-username\"]"));


        Assert.assertEquals(invalidEmailMessage.getText(), "Please enter a valid email address.", "Wrong validation message text for invalid email");

    }


    @Test(priority = 4)
    public void LoginWrongPassword() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("vvizbor5@gmail.com", "TYpochek51_");

        Thread.sleep(1000);


        WebElement invalidPasswordMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));


        Assert.assertEquals(invalidPasswordMessage.getText(), "Hmm, that's not the right password. Please try again or request a new one.", "Wrong validation message text for incorrect password");

    }


}
