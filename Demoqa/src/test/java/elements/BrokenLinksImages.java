package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinksImages {
    WebDriver driver;
    By validImage = By.cssSelector("img:nth-child(2)");
    By brokenImage = By.cssSelector(".col-md-6 > div:nth-child(2)");
    By validLink = By.linkText("Click Here for Valid Link");
    By brokenLink = By.linkText("Click Here for Broken Link");

    public BrokenLinksImages(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getValidImage() {
        return driver.findElement(validImage);
    }
    public WebElement getBrokenImage() {
        return driver.findElement(brokenImage);
    }
    public WebElement getValidLink() {
        return driver.findElement(validLink);
    }
    public WebElement getBrokenLink() {
        return driver.findElement(brokenLink);
    }
    public void clickValidLink() {
        getValidLink().click();
    }
    public void clickBrokenLink() {
        getBrokenLink().click();
    }
}
