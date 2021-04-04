package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BestSellersCartPage extends BaseHelper {

    public String onePeacePrice;
    public String totalPriceField;

    @FindBy(className="cart_quantity_input")
    WebElement valueField;
    @FindBy (id = "product_price_2_12_0")
    WebElement unitPrice;
    @FindBy (id = "total_product_price_2_12_0")
    WebElement totalPrice;


    WebDriver driver;

    public BestSellersCartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void valueField(){
        valueField.click();
    }
    private void addQuantity(String number) {
        valueField.sendKeys(number);
    }
    private void catchOneUnitPrice(){

        onePeacePrice = unitPrice.getText();
        System.out.println("Price of one piece is:"+unitPrice.getText());
    }
    private void catchTotalPrice(){
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("total_product_price_2_12_0"), "$27.00"));
        System.out.println("Total price is:"+totalPrice.getText());
        totalPriceField = totalPrice.getText();

    }

    public void summary(String quantity){
        valueField();
        addQuantity(quantity);
        catchOneUnitPrice();
        catchTotalPrice();
    }

}