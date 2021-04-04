package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.BestSellersCartPage;
import pages.BestSellersPage;
import pages.BestSellersProductPage;

public class BestSellersTest extends BaseTest{
    @Test
    public void examTest() throws InterruptedException {
        BestSellersPage homepage = new BestSellersPage(driver);
        homepage.chooseBestSellerProduct();

        BestSellersProductPage productPage = new BestSellersProductPage(driver);
        productPage.addProductToBasket();

        String quantity = "4";
        BestSellersCartPage summaryPart = new BestSellersCartPage(driver);
        summaryPart.summary(quantity);

        summaryPart.onePeacePrice = summaryPart.onePeacePrice.replace("$", "");
        summaryPart.totalPriceField = summaryPart.totalPriceField.replace("$","");

        double quantity1 = 4.00;
        double unitPrice = Double.parseDouble(summaryPart.onePeacePrice);
        double totalPrice = Double.parseDouble(summaryPart.totalPriceField);

        System.out.println("quantity is: "+quantity1+ ", one units price is: "+unitPrice+ ", total price is: "+totalPrice+", total price is quantity * one units price: "+quantity1*unitPrice);
        Assert.assertEquals(totalPrice, quantity1*unitPrice, 0.01);

        Thread.sleep(4000);
    }


}