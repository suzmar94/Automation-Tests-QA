package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappLoginPage extends BaseHelper {

    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(className = "radius")
    WebElement loginButton;

    WebDriver driver;

    public HerokuappLoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private void navigateToPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    private void usernameField(String username) {
        usernameField.sendKeys(username);
    }

    private void passwordField(String password) {
        passwordField.sendKeys(password);
    }

    private void clickOnLoginButton() {
        loginButton.click();
    }

    public void loginField(String user, String pass) {

        navigateToPage();
        usernameField(user);
        passwordField(pass);
        clickOnLoginButton();

    }
}
