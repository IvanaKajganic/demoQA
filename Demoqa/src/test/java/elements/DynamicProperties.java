package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicProperties {
    WebDriver driver;
    By enableAfter5 = By.id("enableAfter");
    By colorChange = By.id("colorChange");
    By visibleAfter5 = By.id("visibleAfter");

    public DynamicProperties(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getEnableAfter5() {
        return driver.findElement(enableAfter5);
    }
    public WebElement getColorChange() {
        return driver.findElement(colorChange);
    }
    public WebElement getVisibleAfter5() {
        return driver.findElement(visibleAfter5);
    }
    public void clickEnableAfter5(){
        getEnableAfter5().click();
    }
    public void clickColorChange() {
        getColorChange().click();
    }
    public void clickVisibleAfter5() {
        getVisibleAfter5().click();
    }
}
