import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pikhterova_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        String searchTerm = "Selenium";
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm + Keys.ENTER);
        //searchField.submit();
        //searchField.sendKeys(Keys.ENTER);


        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class = 'g']"));
        System.out.println("number of results " + searchResultElements.size());

        //For each web element in searchResultElements print text
        //condidtion, you get into loop. {loop body inside}
        for (WebElement searchResultElement : searchResultElements) {

            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElementText);
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("searchTerm found");
            } else {
                System.out.println("searchTerm not found");
            }
        }

        for (WebElement element : searchResultElements) {
            System.out.println(element.getText());
            if (element.getText().contains("wikipedia")) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }



        driver.close();
    }
}

