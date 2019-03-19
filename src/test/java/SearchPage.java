import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='search-result search-result__occluded-item ember-view']")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//h3[contains (@class, 'search-results__total')]")
    private WebElement resultsTotall;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resultsTotall.isDisplayed()
                && driver.getCurrentUrl().contains("/search")
                && driver.getTitle().contains("Search");
    }

    public int getSearchResulCount () { return searchResultElements.size();}


    public boolean isResultContainText() {
        String searchTerm = "HR";
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                    return true;
                }
                    }

        return false;
    }


}