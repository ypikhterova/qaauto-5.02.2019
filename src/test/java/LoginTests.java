import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void afterMethod(){
        driver.quit();
    }


    @Test (priority = 1)
    public void successfulLoginTests() throws InterruptedException {///appeared after  Thread.sleep(1000);



        WebElement putEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
      putEmailField.sendKeys("vvizbor5@gmail.com");
        //putEmailField.sendKeys("johndoeseleniumtest@gmail.com");

        WebElement putPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        putPasswordField.sendKeys("TYpochek5_" + Keys.ENTER);
        //putPasswordField.sendKeys("johndoepassword" + Keys.ENTER);

        Thread.sleep(1000);


        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        Assert.assertTrue(profileMenuItem.isDisplayed(), "profileMenuItem is not displayed on Home page");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page is incorrect");




    }
@Test (priority = 2)
    public void LoginWrongEmail() throws InterruptedException {
    WebElement putEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
    putEmailField.sendKeys("vvizbor51@gmail.com");

    WebElement putPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
    putPasswordField.sendKeys("TYpochek5_" + Keys.ENTER);

    Thread.sleep(1000);


    WebElement wrongEmailMessage = driver.findElement(By.xpath("//div[@id=\"error-for-username\"]"));



    Assert.assertEquals(wrongEmailMessage.getText(), "Hmm, we don't recognize that email. Please try again.", "Email is incorrect");

}

    @Test (priority = 3)
    public void LoginInvalidEmail() throws InterruptedException {

        WebElement putEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        putEmailField.sendKeys("vvizborgmail.com");

        WebElement putPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        putPasswordField.sendKeys("TYpochek5_" + Keys.ENTER);

        Thread.sleep(1000);


        WebElement invalidEmailMessage = driver.findElement(By.xpath("//div[@id=\"error-for-username\"]"));



        Assert.assertEquals(invalidEmailMessage.getText(), "Please enter a valid email address.", "Email is invalid");

    }


    @Test (priority = 4)
    public void LoginWrongPassword() throws InterruptedException {

        WebElement putEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        putEmailField.sendKeys("vvizbor5@gmail.com");

        WebElement putPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        putPasswordField.sendKeys("TYpochek51_" + Keys.ENTER);

        Thread.sleep(1000);


        WebElement invalidPasswordMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));


        Assert.assertEquals(invalidPasswordMessage.getText(), "Hmm, that's not the right password. Please try again or request a new one.", "Password is incorrect");

    }


}
