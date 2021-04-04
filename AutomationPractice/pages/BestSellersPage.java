package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BestSellersPage extends BaseHelper {
    @FindBy(className = "blockbestsellers")
    WebElement bestSellersButton;
    @FindBy(id = "blockbestsellers")
    WebElement wholeLIst;



    WebDriver driver;

    public BestSellersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToPage() {
        driver.get("http://automationpractice.com/index.php");
    }
    private void clickOnBSButton() {
        bestSellersButton.click();
    }
    private void chooseThirdArticle() {
        wdWait.until(ExpectedConditions.visibilityOf(wholeLIst));
        List<WebElement> products = wholeLIst.findElements(By.tagName("li"));
        System.out.println("Products found:"+products.size());
        WebElement thirdProduct = products.get(2);
        WebElement moreButton = thirdProduct.findElement(By.className("lnk_view"));
        //prvi argument mi daj koji navedem posle navodnika zato se stavlja[0]
        js.executeScript("arguments[0].click();", moreButton);
    }

    public void chooseBestSellerProduct() {
        navigateToPage();
        clickOnBSButton();
        chooseThirdArticle();

    }

}