package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class BestSellersProductPage extends BaseHelper {

    @FindBy(id="group_1")
    WebElement selectMenu;
    @FindBy(id = "color_8")
    WebElement whiteColor;
    @FindBy(id="add_to_cart")
    WebElement addToCartButton;

    WebDriver driver;

    public BestSellersProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void chooseSize() {
        Select selector = new Select(selectMenu);
        selector.selectByValue("3");
    }
    private void chooseWhiteColor() {
//        List<WebElement> colors = whiteColor.findElements(By.tagName("li"));
//        WebElement whiteColor = colors.get(0);
//        whiteColor.click();
        whiteColor.click();
    }
    private void addTOCartBtn(){
        js.executeScript("arguments[0].scrollIntoView();", addToCartButton);
        addToCartButton.click();
    }
    private void proceedToCheckOut() {
        wdWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2"),
                "Product successfully added to your shopping cart"));
        WebElement proceedToCheckOut = driver.findElement(By.className("button-medium"));
        js.executeScript("arguments[0].click();", proceedToCheckOut);
    }

    public void addProductToBasket(){
        chooseSize();
        chooseWhiteColor();
        addTOCartBtn();
        proceedToCheckOut();

    }
}