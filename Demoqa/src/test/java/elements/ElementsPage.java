package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage {
    WebDriver driver;
    By textBox = By.id("item-0");
    By checkBox = By.id("item-1");
    By radioButton = By.id("item-2");
    By webTables = By.id("item-3");
    By buttons = By.id("item-4");
    By links = By.id("item-5");
    By brokenLinksImages = By.id("item-6");
    By uploadDownload = By.id("item-7");
    By dynamicProperties = By.id("item-8");

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getTextBox() {
        return driver.findElement(textBox);
    }
    public WebElement getCheckBox() {
        return driver.findElement(checkBox);
    }
    public WebElement getRadioButton() {
        return driver.findElement(radioButton);
    }
    public WebElement getWebTables() {
        return driver.findElement(webTables);
    }
    public WebElement getButtons() {
        return driver.findElement(buttons);
    }
    public WebElement getLinks() {
        return driver.findElement(links);
    }
    public WebElement getBrokenLinksImages() {
        return driver.findElement(brokenLinksImages);
    }
    public WebElement getUploadDownload() {
        return driver.findElement(uploadDownload);
    }
    public WebElement getDynamicProperties() {
        return driver.findElement(dynamicProperties);
    }
    public void goToTextBox() {
        getTextBox().click();
    }
    public void goToCheckBox() {
        getCheckBox().click();
    }
    public void goToRadioButton() {
        getRadioButton().click();
    }
    public void goToWebTables() {
        getWebTables().click();
    }
    public void goToButtons() {
        getButtons().click();
    }
    public void goToLinks() {
        getLinks().click();
    }
    public void goToBrokenLinksImages() {
        getBrokenLinksImages().click();
    }
    public void goToUploadDownload() {
        getUploadDownload().click();
    }
    public void goToDynamicProperties() {
        getDynamicProperties().click();
    }
}
