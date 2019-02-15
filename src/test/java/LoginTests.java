import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void successfulLoginTests() throws InterruptedException {///appeared after  Thread.sleep(1000);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pikhterova_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        WebElement putEmail = driver.findElement(By.xpath("//input[@id = \"login-email\"]"));
        putEmail.sendKeys("vvizbor5@gmail.com");

        WebElement putPassword = driver.findElement(By.xpath("//input[@id = \"login-password\"]"));
        putPassword.sendKeys("TYpochek5_" + Keys.ENTER);

        Thread.sleep(1000);



        WebElement getName = driver.findElement(By.xpath("//span[@class = \"t-16 t-black t-bold\"]"));

        if (getName.getText().contains("Varvara")) {
            System.out.println("searchTerm found");
        } else {
            System.out.println("searchTerm not found");
        }


        driver.close();


    }


}
