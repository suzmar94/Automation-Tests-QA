package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserTest extends BaseTest
{
    @Test
    public void googleSearchTest() throws InterruptedException
    {
        //Otici na Google homepage
        driver.get("https://www.google.com/");

        //Upisati "Comtrade" u polje za pretragu
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Comtrade");

        //Kliknuti na "Google search" dugme
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        //Proveriti da postoji pojam "Comtrade" na stranici sa rezultatima
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));
        WebElement searchResults = driver.findElement(By.id("rcnt"));
        Assert.assertTrue("Search term is not found",
                searchResults.getText().contains("Comtrade"));

        //sleep ostavljen zbog vizuelne potvrde
        Thread.sleep(4000);
    }

    @Test
    public void yahooSearchTest() {

    }

}
