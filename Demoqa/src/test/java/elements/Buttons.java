package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Buttons {
    WebDriver driver;
    By doubleClickButton = By.id("doubleClickBtn");
    By rightClickButton = By.id("rightClickBtn");
    By clickMeButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");
    By doubleClickMessage = By.id("doubleClickMessage");
    By rightClickMessage = By.id("rightClickMessage");
    By clickMeMessage = By.id("dynamicClickMessage");

    public Buttons(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getDoubleClickButton() {
        return driver.findElement(doubleClickButton);
    }
    public WebElement getRightClickButton() {
        return driver.findElement(rightClickButton);
    }
    public WebElement getClickMeButton () {
        return driver.findElement(clickMeButton);
    }
    public WebElement getDoubleClickMessage() {
        return driver.findElement(doubleClickMessage);
    }
    public WebElement getRightClickMessage() {
        return driver.findElement(rightClickMessage);
    }
    public WebElement getClickMeMessage() {
        return driver.findElement(clickMeMessage);
    }
    public void executeDoubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(getDoubleClickButton()).perform();
    }
    public void executeRightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(getRightClickButton()).perform();
    }
    public void executeDynamicClick() {
        Actions actions = new Actions(driver);
        actions.click(getClickMeButton()).perform();
    }
}
