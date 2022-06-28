package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {

    public WebDriver driver;
    By homeToggle = By.cssSelector(".rct-icon-expand-close");
    By doxToggle = By.cssSelector(".rct-node:nth-child(2) .rct-collapse > .rct-icon");
    By officeBox = By.cssSelector(".rct-node-collapsed:nth-child(2) .rct-checkbox > .rct-icon");
    By plus = By.cssSelector(".rct-icon-expand-all");
    By minus = By.cssSelector(".rct-icon-collapse-all > path");
    By result = By.id("result");

    public CheckBox(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getHomeToggle() {
        return driver.findElement(homeToggle);
    }
    public WebElement getPlus() {
        return driver.findElement(plus);
    }
    public WebElement getMinus() {
        return driver.findElement(minus);
    }
    public WebElement getArrowDown() {
        List<WebElement> svgList = driver.findElements(By.tagName("svg"));
        return svgList.get(47);
    }
    public WebElement getDoxToggle() {
        return driver.findElement(doxToggle);
    }
    public WebElement getOfficeBox() {
        return driver.findElement(officeBox);
    }
    public WebElement getResult() {
        return driver.findElement(result);
    }
    public void clickHomeToggle() {
        getHomeToggle().click();
    }
    public void clickPlus() {
        getPlus().click();
    }
}
