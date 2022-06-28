package bookStoreApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BookStoreAppPage {
    WebDriver driver;
    By loginOption = By.cssSelector(".show #item-0 > .text");
    By bookstore = By.id("item-2");
    By profile = By.id("item-3");
    By bookStoreAPI = By.cssSelector(".show #item-4 > .text");

    public BookStoreAppPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLoginOption() {
        return driver.findElement(loginOption);
    }
    public WebElement getBookstore() {
        return driver.findElement(bookstore);
    }
    public WebElement getProfile() {
        return driver.findElement(profile);
    }
    public WebElement getBookStoreAPI() {
        return driver.findElement(bookStoreAPI);
    }
    public void clickLoginOption() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getLoginOption()).click().perform();
    }
    public void clickBookStore() {
        getBookstore().click();
    }
    public void clickProfile() {
        getProfile().click();
    }
    public void clickBookStoreAPI() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getBookStoreAPI()).click().perform();
    }
}
