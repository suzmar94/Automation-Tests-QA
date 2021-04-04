package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HerokuappLoginPage;

public class HerokuAppLoginTest extends BaseTest {

    @Test
    public void loggingInWIthValidCredentials() throws InterruptedException {

        //mora page da se "uveze" pa pravimo objekat
        HerokuappLoginPage loginPage = new HerokuappLoginPage(driver);
        loginPage.loginField("tomsmith", "SuperSecretPassword!");

        //validacija
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));
        WebElement messagio = driver.findElement(By.id("flash-messages"));
        Assert.assertTrue("",messagio.getText().contains("You logged into a secure area!"));

        WebElement logout = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        Assert.assertTrue("message if fails:",
                logout.getText().contains("Logout"));

        Thread.sleep(4000);

    }

    @Test
    public void wrongUsernameTest() throws InterruptedException {

        HerokuappLoginPage loginPage = new HerokuappLoginPage(driver);
        loginPage.loginField("a A", "SuperSecretPassword!");


        //validacija
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        WebElement login = driver.findElement(By.id("flash"));
        Assert.assertTrue("message if fails",
                login.getText().contains("Your username is invalid!"));

        Thread.sleep(4000);

    }

    }