package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooSearchPage extends BaseHelper {

    @FindBy(name = "p")
    WebElement searchBox;
    @FindBy(id = "ybar-search")
    WebElement searchButton;

    WebDriver driver;
    public YahooSearchPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToYahooPage (){
        driver.get("https://www.yahoo.com/");
    }
    private void searchField(){
        searchBox.sendKeys("Comtrade");
    }
    private void clickOnButton(){
        searchButton.click();
    }

    public void yahooSearchingWord(){
        navigateToYahooPage();
        searchField();
        clickOnButton();

    }
}
