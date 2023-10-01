package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaceBookLoginPage extends BasePage{

    By usernameByElement = By.xpath("//input[@id='email']");
    By passwordByElement = By.xpath("//input[@type='password']");
    By loginButtonByElement = By.xpath("//button[@name='login']");
    By loginErrorMessageByElement = By.xpath("//input[@id='email']//parent::div//div[2]");

    WebDriver driver;
    public FaceBookLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterUsername(String input) {
       enterText(usernameByElement, input);
    }

    public void enterPassword(String password) {
        enterText( passwordByElement, password);
    }

    public void clickOnLoginButton() {
        clickOnWebElement(loginButtonByElement);
    }

    public String getLoginErrorMessage() {
        waitForElement(loginErrorMessageByElement);
        return getWebElementText(loginErrorMessageByElement);
    }
}
