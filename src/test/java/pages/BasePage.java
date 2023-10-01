package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }



    public void clickOnWebElement(By byElement) {
        driver.findElement(byElement).click();
    }

    public void enterText(By byElement, String input) {
        driver.findElement(byElement).sendKeys(input);
    }

    public String getWebElementText(By byElement) {
        return driver.findElement(byElement).getText();
    }

    public void waitForElement(By byElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
    }

    public void waitForElementTobeVisible(By byElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public void moveToTheElement(By byElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(byElement)).build().perform();
    }




}
