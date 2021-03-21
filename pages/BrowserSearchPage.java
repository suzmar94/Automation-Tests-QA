package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserSearchPage extends BaseHelper {

    @FindBy(name = "q")
    WebElement searchBox;
    @FindBy(name = "btnK")
    WebElement searchButton;


    WebDriver driver;

    public BrowserSearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToPage()
    {
        driver.get("https://www.google.com/");
    }

    private void searchField()
    {
        searchBox.sendKeys("Comtrade");
    }

    private void searchButton()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        searchButton.click();
    }

    public void searchingWordComtrade()
    {
        navigateToPage();
        searchField();
        searchButton();
    }
}
