package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GoogleSearchPage;
import pages.YahooSearchPage;

public class BrowserSearchTest extends BaseTest {
    @Test
    public void googleSearchTest() throws InterruptedException {

        //mora page da se "uveze" pa pravimo objekat
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.searchingWordComtrade();

        //Proveriti da postoji pojam "Comtrade" na stranici sa rezultatima
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));
        WebElement searchResults = driver.findElement(By.id("rcnt"));
        Assert.assertTrue("Search term is not found",
                searchResults.getText().contains("Comtrade"));

        //sleep ostavljen zbog vizuelne potvrde
        Thread.sleep(4000);
    }

    @Test
    public void yahooSearchTest() throws InterruptedException {

        YahooSearchPage searchYahoo = new YahooSearchPage(driver);
        searchYahoo.yahooSearchingWord();

        //Proveriti da postoji pojam "Comtrade" na stranici sa rezultatima
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
        WebElement searchResults = driver.findElement(By.id("results"));
        Assert.assertTrue("Message if test fails:",
                searchResults.getText().contains("Comtrade"));

        //sleep ostavljen zbog vizuelne potvrde
        Thread.sleep(4000);

    }


}
