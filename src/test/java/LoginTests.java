import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod


    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pikhterova_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @DataProvider
    public Object[][] ValidData() {
        return new Object[][]{
                {"vvizbor5@gmail.com", "TYpochek5_"},
                {"vVIZBOR5@gmail.com", "TYpochek5_"},
                {" vvizbor5@gmail.com ", "TYpochek5_"}

        };
    }

    @Test(dataProvider = "ValidData", priority = 1)


    public void successfulLoginTests(String userEmail, String userPassword) throws InterruptedException {


        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login(userEmail, userPassword);

        Thread.sleep(1000);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");


    }

    @DataProvider
    public Object[][] TestData() {
        return new Object[][]{
                {"vvizbor51@gmail.com", "TYpochek5_", "Hmm, we don't recognize that email. Please try again.", "", "Wrong validation message text for incorrect email"},
                {"vVIZBOR5gmail.com", "TYpochek5_", "Please enter a valid email address.", "", "Wrong validation message text for invalid email"},
                {" vvizbor5@gmail.com ", "TYpochek51_", "", "Hmm, that's not the right password. Please try again or request a new one.", "Wrong validation message text for incorrect password"}

        };
    }

    @Test(dataProvider = "TestData", priority = 2)
    public void LoginWrongEmail(String userEmail, String userPassword, String expectedEmailMessage, String expectedPasswordMessage, String errorMessage) throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(userEmail, userPassword);


        Thread.sleep(1000);

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);


        Assert.assertEquals(loginSubmitPage.wrongEmailMessage.getText(), expectedEmailMessage, errorMessage);
        Assert.assertEquals(loginSubmitPage.invalidPasswordMessage.getText(), expectedPasswordMessage, errorMessage);


    }


}
