package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RadioButton {
    WebDriver driver;
    By yesButton = By.id("yesRadio");
    By impressiveButton = By.id("impressiveRadio");
    By noButton = By.id("noRadio");
    By message = By.className("text-success");

    public RadioButton(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getYesButton() {
        return driver.findElement(yesButton);
    }
    public WebElement getImpressiveButton() {
        return driver.findElement(impressiveButton);
    }
    public WebElement getNoButton() {
        return driver.findElement(noButton);
    }
    public WebElement getMessage() {
        return driver.findElement(message);
    }

    public void clickYesButton() {
        Actions action = new Actions(driver);
        action.moveToElement(getYesButton()).click().perform();
    }
    public void clickImpressiveButton() {
        Actions action = new Actions(driver);
        action.moveToElement(getImpressiveButton()).click().perform();
    }
    public void clickNoButton() {
        Actions action = new Actions(driver);
        action.moveToElement(getNoButton()).click().perform();
    }
}
