import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseTest {


    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        HomePage homePage = landingPage.login("vvizbor5@gmail.com", "TYpochek5_");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
        SearchPage searchPage = homePage.search("HR");
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded");
        Assert.assertEquals(searchPage.getSearchResulCount(), 10, "Search result count is wrong");

        List<String> searchResultList = searchPage.getSearchResultsList();

        for (String searchResult : searchResultList){
            Assert.assertTrue(searchResult.contains(searchTerm), "Search term 'HR' not found in searchResult");
        }


        Assert.assertTrue(searchPage.isResultContainText(), "Search result doesn't contain search term");
    }


}



