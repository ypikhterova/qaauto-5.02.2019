import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


        @DataProvider
    public Object[][] ValidData() {
        return new Object[][]{
                {"vvizbor5@gmail.com", "TYpochek5_"},
                {"vVIZBOR5@gmail.com", "TYpochek5_"},
                {" vvizbor5@gmail.com ", "TYpochek5_"}
        };
    }

    @Test(dataProvider = "ValidData", priority = 1)
    public void successfulLoginTests(String userEmail,
                                     String userPassword) throws InterruptedException {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        HomePage homePage=  landingPage.login(userEmail, userPassword, HomePage.class);

        Thread.sleep(1000);

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
    public void LoginWrongEmail(String userEmail,
                                String userPassword,
                                String expectedEmailMessage,
                                String expectedPasswordMessage,
                                String errorMessage) throws InterruptedException {
        LoginSubmitPage loginSubmitPage = landingPage.login(userEmail, userPassword);
        Thread.sleep(1000);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login submit page is not loaded");

        Assert.assertEquals(loginSubmitPage.getUserEmailValidationText(), expectedEmailMessage, errorMessage);
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationText(), expectedPasswordMessage, errorMessage);


    }


}
