package bookStoreApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStore {
    WebDriver driver;
    By books = By.className("mr-2");
    By footers = By.id("addNewRecordButton");
    public BookStore(WebDriver driver) {
        this.driver = driver;
    }
    public List<WebElement> footerButtons() {
        return driver.findElements(footers);
    }
    public WebElement getBackToBookStore() {
        return footerButtons().get(0);
    }
    public WebElement getAddToYourCollection() {
        return footerButtons().get(1);
    }
    public List<WebElement> getBookTitles() {
        return driver.findElements(books);
    }
    public void selectBookTitle(String title) {
        driver.findElement(By.linkText(title)).click();
    }
    public void clickBackToBookStore() {
        getBackToBookStore().click();
    }
    public void clickAddToYourCollection() {
        getAddToYourCollection().click();
    }
}
