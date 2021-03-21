package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BrowserSearchPage;
import pages.HerokuappLoginPage;

public class BrowserSearchTest extends BaseTest
{
    @Test
    public void googleSearchTest() throws InterruptedException
    {

        //mora page da se "uveze" pa pravimo objekat
        BrowserSearchPage searchPage = new BrowserSearchPage(driver);
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
        //Otici na Yahoo homepage
        driver.get("https://www.yahoo.com/");

        //Upisati "Comtrade" u polje za pretragu
        WebElement searchBox = driver.findElement(By.name("p"));
        searchBox.sendKeys("Comtrade");

        //Kliknuti na "Yahoo search" lupu
        WebElement searchButton;
        searchButton = driver.findElement(By.id("ybar-search"));
        searchButton.click();

        //Proveriti da postoji pojam "Comtrade" na stranici sa rezultatima
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
        WebElement searchResults = driver.findElement(By.id("results"));
        Assert.assertTrue("Search term is not found",
                searchResults.getText().contains("Comtrade"));

        //sleep ostavljen zbog vizuelne potvrde
        Thread.sleep(4000);

    }


}
